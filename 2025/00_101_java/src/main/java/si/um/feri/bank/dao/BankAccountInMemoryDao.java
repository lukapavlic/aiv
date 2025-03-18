package si.um.feri.bank.dao;

import si.um.feri.bank.vao.BankAccount;
import java.util.HashMap;
import java.util.Map;

public class BankAccountInMemoryDao implements BankAccountDao {

    private Map<String, BankAccount> accounts=new HashMap<>();

    @Override
    public Map<String, BankAccount> getAll() {
        return accounts;
    }

    public void save(BankAccount br) throws BankAccountAlreadyExistException, IbanMissingException {
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new IbanMissingException();
        if (accounts.get(br.getIban())!=null)
            throw new BankAccountAlreadyExistException();

        accounts.put(br.getIban(),br);
    }

    public BankAccount find(String iban) {
        if (iban==null || iban.isEmpty())
            return null;
        return accounts.get(iban);
    }

}
