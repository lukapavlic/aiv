package si.um.feri.bank.dao;

import si.um.feri.bank.Constants;
import si.um.feri.bank.vao.BankAccount;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankAccountInFileDao implements BankAccountDao {

    Logger log=Logger.getLogger(this.getClass().getName());

    public BankAccountInFileDao() {
        this(false);
    }

    public BankAccountInFileDao(boolean eraseData) {
        if (eraseData) save(new HashMap<String, BankAccount>());
    }

    @Override
    public Map<String, BankAccount> getAll() {
        log.info("Returning all accounts");
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(Constants.FILE_STORAGE));
            Map<String, BankAccount> ret =  (Map<String, BankAccount>)ois.readObject();
            ois.close();
            return ret;
        } catch (Exception e) {
            log.log(Level.WARNING,"File not found -> empty list;" + e.getClass().getName());
        }
        return new HashMap<String, BankAccount>();
    }

    private void save(Map<String, BankAccount> br) {
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(Constants.FILE_STORAGE));
            oos.writeObject(br);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(BankAccount br) throws BankAccountAlreadyExistException, IbanMissingException {
        log.info("Saving "+br);
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new IbanMissingException();
        if (getAll().get(br.getIban())!=null)
            throw new BankAccountAlreadyExistException();
        Map<String, BankAccount> racuni= getAll();
        racuni.put(br.getIban(),br);
        save(racuni);
    }

    public BankAccount find(String iban) {
        log.info("Searching for "+iban);
        if (iban==null || iban.isEmpty())
            return null;
        return getAll().get(iban);
    }

}
