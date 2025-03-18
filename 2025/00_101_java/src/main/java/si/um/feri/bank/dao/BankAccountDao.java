package si.um.feri.bank.dao;

import si.um.feri.bank.vao.BankAccount;
import java.util.Map;

public interface BankAccountDao {

    class BankAccountAlreadyExistException extends Exception {}

    class IbanMissingException extends Exception {}

    Map<String, BankAccount> getAll();

    BankAccount find(String iban);

    void save(BankAccount br) throws BankAccountAlreadyExistException, IbanMissingException;

}
