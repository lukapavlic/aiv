package si.um.feri.banka.dao;

import si.um.feri.banka.vao.BankAccount;
import si.um.feri.banka.vao.Person;
import java.util.Collection;
import java.util.List;

public interface Dao {

    Collection<Person> getAllPeople();

    Collection<BankAccount> getAllBankAccounts();

    Person findPerson(String email);

    BankAccount findBankAccount(String iban);

    List<BankAccount> findBankAccountOwner(String email);

    void save(BankAccount br) throws Exception;

    Person save(Person os) throws Exception;

}
