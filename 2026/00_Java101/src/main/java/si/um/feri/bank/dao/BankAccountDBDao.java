package si.um.feri.bank.dao;

import si.um.feri.bank.vao.BankAccount;
import si.um.feri.bank.vao.Person;
import si.um.feri.bank.vao.Transaction;
import si.um.feri.bank.vao.PremiumBankAccount;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class BankAccountDBDao implements BankAccountDao {

    Logger log=Logger.getLogger(this.getClass().getName());

    static final String DB_URL = "jdbc:h2:mem:testdb";
    static final String USER = "sa";
    static final String PASS = "";

    public BankAccountDBDao() throws Exception {
        this(false);
    }

    public BankAccountDBDao(boolean dropTables) throws Exception {
        DriverManager.registerDriver(new org.h2.Driver());
        try {
            if (dropTables) dropTables();
        } catch (Exception e) {
            log.info("Tables not dropped");
        }
        createTables();
    }

    private Connection conn;

    private Connection getConnection() throws SQLException {
        if (conn==null || conn.isClosed())
            conn=DriverManager.getConnection(DB_URL,USER,PASS);
        return conn;
    }

    void dropTables() throws Exception {
        getConnection().createStatement().execute("drop table person");
        getConnection().createStatement().execute("drop table bankaccount");
        getConnection().createStatement().execute("drop table transakcija");
    }

    void createTables() throws Exception {
        getConnection().createStatement().execute(
                "create table if not exists person(" +
                        "id int auto_increment, " +
                        "personname varchar, " +
                        "personsurname varchar)");
        getConnection().createStatement().execute(
                "create table if not exists bankaccount(" +
                        "iban varchar, " +
                        "opened timestamp, " +
                        "accowner int, " +
                        "balance decimal, " +
                        "allowed_limit decimal, " +
                        "isactive boolean, " +
                        "ispremium boolean)");
        getConnection().createStatement().execute(
                "create table if not exists transakcija(" +
                        "id int auto_increment, " +
                        "source varchar, " +
                        "dest varchar, " +
                        "amount decimal, " +
                        "timeofoccurance timestamp, " +
                        "trans_type int, " +
                        "purpose varchar)");
    }

    public Person findPerson(int id) {
        log.info("Searching "+id);
        Person ret = null;
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from person where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ret = new Person(rs.getString("personname"), rs.getString("personsurname"));
                ret.setId(rs.getInt("id"));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public Person savePerson(Person o) {
        log.info("Saving "+o);
        Connection conn=null;
        try {
            conn=getConnection();
            if (findPerson(o.getId()) != null) {
                PreparedStatement ps = conn.prepareStatement("update person set personname=? , personsurname=? where id=?");
                ps.setString(1, o.getName());
                ps.setString(2, o.getSurname());
                ps.setInt(3, o.getId());
                ps.executeUpdate();
            } else {
                PreparedStatement ps = conn.prepareStatement("insert into person(personname , personsurname) values (?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, o.getName());
                ps.setString(2, o.getSurname());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    o.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    public boolean bankAccountExists(String iban) {
        log.info("Finding "+iban);
        boolean ret = false;
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from bankaccount where iban=?");
            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ret=true;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public BankAccount findBankAccount(String iban, boolean  sTransakcijami) {
        log.info("Searching "+iban);
        BankAccount ret = null;
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from bankaccount where iban=?");
            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                if (rs.getBoolean("ispremium")) {
                    ret=new PremiumBankAccount(iban);
                    ((PremiumBankAccount)ret).setAllowedLimit(rs.getDouble("allowed_limit"));
                }
                else ret = new BankAccount(iban);
                ret.setOpened(rs.getTimestamp("opened").toLocalDateTime());
                ret.setActive(rs.getBoolean("isactive"));
                ret.setOwner(findPerson(rs.getInt("accowner")));
                ret.setCurrentBalance(rs.getBigDecimal("balance"));
                if (sTransakcijami) ret.setTransactions(getAllTransactions(iban));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    public void saveBankAccount(BankAccount br) throws BankAccountAlreadyExistException, IbanMissingException {
        log.info("Saving "+br);
        if (br.getIban()==null || br.getIban().isEmpty()) throw new IbanMissingException();
        if (bankAccountExists(br.getIban())) throw new BankAccountAlreadyExistException();

        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into bankaccount(iban,opened,accowner,balance,allowed_limit,isactive,ispremium) values (?,?,?,?,?,?,?)");
            ps.setString(1, br.getIban());
            ps.setTimestamp(2, Timestamp.valueOf(br.getOpened()));
            ps.setInt(3,br.getOwner().getId());
            ps.setBigDecimal(4,br.getCurrentBalance());
            ps.setBoolean(6,br.isActive());
            if (br instanceof PremiumBankAccount) {
                ps.setBoolean(7,true);
                ps.setDouble(5,((PremiumBankAccount)br).getAllowedLimit());
            } else {
                ps.setBoolean(7,false);
                ps.setDouble(5,-1.0);
            }
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveTransaction(Transaction t) {
        log.info("Saving "+t);
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into transakcija(source,dest,amount,purpose,timeofoccurance,trans_type) values (?,?,?,?,?,?)");
            ps.setString(1, t.getSource().getIban());
            ps.setString(2, t.getDestination().getIban());
            ps.setBigDecimal(3, t.getAmount());
            ps.setString(4, t.getPurpose());
            ps.setTimestamp(5,Timestamp.valueOf(t.getTimeStamp()));
            ps.setInt(6,t.getTransType().getValue());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getAllTransactions(String iban) {
        log.info("Searching for transactions "+iban);
        List<Transaction> ret = new ArrayList<>();
        Connection conn=null;
        try {
            conn=getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from transakcija where (source=?) or (dest=?)");
            ps.setString(1, iban);
            ps.setString(2, iban);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Transaction t=new Transaction(
                        findBankAccount(rs.getString("source"),false),
                        findBankAccount(rs.getString("dest"),false),
                        rs.getBigDecimal("amount"),
                        rs.getString("purpose")
                );
                t.setTimeStamp(rs.getTimestamp("timeofoccurance").toLocalDateTime());
                int trans_type=rs.getInt("trans_type");
                for (Transaction.TransactionType tt : Transaction.TransactionType.values()) {
                    if (tt.getValue()==trans_type)
                        t.setTransType(tt);
                }
                ret.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public Map<String, BankAccount> getAll() {
        log.info("Returning all accounts");
        Map<String, BankAccount> ret = new HashMap<>();
        try {
            ResultSet rs = getConnection().createStatement().executeQuery("select * from bankaccount");
            while (rs.next()) {
                ret.put(rs.getString("iban"), findBankAccount(rs.getString("iban"),true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public BankAccount find(String iban) {
        log.info("Searching for "+iban);
        return findBankAccount(iban,true);
    }

    @Override
    public void save(BankAccount br) throws BankAccountAlreadyExistException, IbanMissingException {
        log.info("Saving "+br);
        saveBankAccount(br);
    }

}
