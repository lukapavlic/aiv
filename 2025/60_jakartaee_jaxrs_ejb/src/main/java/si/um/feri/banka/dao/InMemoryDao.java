package si.um.feri.banka.dao;

import si.um.feri.banka.vao.BankAccount;
import si.um.feri.banka.vao.Person;
import java.math.BigDecimal;
import java.util.*;

public class InMemoryDao implements Dao {

    private static InMemoryDao _inst=new InMemoryDao();

    private InMemoryDao() {
        Person o= null;
        try {
            o = save(new Person("peter.klepec@gmail.com","Peter","Klepec"));
            BankAccount br=new BankAccount("123-123-123",o,new BigDecimal(0),true);
            BankAccount br2=new BankAccount("789-789-789",o,new BigDecimal(0),false);
            save(br);
            save(br2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InMemoryDao getInstance() {
        return _inst;
    }

    private Map<String, BankAccount> accuonts=Collections.synchronizedMap(new HashMap<>());

    private Map<String, Person> people=Collections.synchronizedMap(new HashMap<>());

    @Override
    public Collection<Person> getAllPeople() {
        return people.values();
    }

    @Override
    public Collection<BankAccount> getAllBankAccounts() {
        return accuonts.values();
    }

    @Override
    public Person findPerson(String email) {
        return people.get(email);
    }

    @Override
    public BankAccount findBankAccount(String iban) {
        return accuonts.get(iban);
    }

    @Override
    public List<BankAccount> findBankAccountOwner(String email) {
        List<BankAccount> ret=new ArrayList<>();
        for (BankAccount br: accuonts.values()) {
            if (br.getOwner().getEmail().equals(email))
                ret.add(br);
        }
        return ret;
    }

    @Override
    public void save(BankAccount br) throws Exception {
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new Exception("Missing IBAN");
        if (br.getOwner()==null)
            throw new Exception("Missing owner");
        save(br.getOwner());
        accuonts.put(br.getIban(),br);
    }

    @Override
    public Person save(Person os) throws Exception {
        if (os.getEmail()==null || os.getEmail().isEmpty())
            throw new Exception("Missing email");
        if (findPerson(os.getEmail())==null)
            os.setId(System.nanoTime());
        people.put(os.getEmail(),os);
        return os;
    }

}
