package si.um.feri.bank.dao;

import si.um.feri.bank.Constants;
import si.um.feri.bank.vao.BankAccount;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class BankAccountInFileDao implements BankAccountDao {

    @Override
    public Map<String, BankAccount> getAll() {
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(Constants.FILE_STORAGE));
            Map<String, BankAccount> ret =  (Map<String, BankAccount>)ois.readObject();
            ois.close();
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
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
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new IbanMissingException();
        Map<String, BankAccount> racuni= getAll();
        racuni.put(br.getIban(),br);
        save(racuni);
    }

    public BankAccount find(String iban) {
        if (iban==null || iban.isEmpty())
            return null;
        return getAll().get(iban);
    }

}
