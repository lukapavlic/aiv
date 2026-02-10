package si.um.feri.bank.dao;

import si.um.feri.bank.vao.BankAccount;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BankAccountInMemoryDao implements BankAccountDao {

    Logger log=Logger.getLogger(this.getClass().getName());

    private Map<String, BankAccount> accounts=new HashMap<>();

    @Override
    public Map<String, BankAccount> getAll() {
        log.info("Returning all accounts");
        return accounts;
    }

    public void save(BankAccount br) throws BankAccountAlreadyExistException, IbanMissingException {
        log.info("Saving "+br);
        if (br.getIban()==null || br.getIban().isEmpty())
            throw new IbanMissingException();
        if (accounts.get(br.getIban())!=null)
            throw new BankAccountAlreadyExistException();

        accounts.put(br.getIban(),br);
    }

    public BankAccount find(String iban) {
        log.info("Searching for "+iban);
        if (iban==null || iban.isEmpty())
            return null;
        return accounts.get(iban);
    }

}
