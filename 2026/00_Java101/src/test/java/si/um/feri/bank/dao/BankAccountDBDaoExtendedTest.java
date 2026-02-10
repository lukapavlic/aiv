package si.um.feri.bank.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import si.um.feri.bank.vao.BankAccount;
import si.um.feri.bank.vao.Person;
import si.um.feri.bank.vao.PremiumBankAccount;
import si.um.feri.bank.vao.Transaction;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountDBDaoExtendedTest {

    private BankAccountDBDao dao;

    @BeforeEach
    void setUp() throws Exception {
        dao = new BankAccountDBDao(true);
    }

    @Test
    void saveAndFindPersonWorks() {
        Person p = new Person("Janez", "Novak");
        dao.savePerson(p);
        assertTrue(p.getId() > 0);
        Person loaded = dao.findPerson(p.getId());
        assertEquals("Janez", loaded.getName());
        assertEquals("Novak", loaded.getSurname());
    }

    @Test
    void saveAndLoadBankAccountWithOwner() throws Exception {
        Person p = dao.savePerson(new Person("Ana", "Kovač"));
        BankAccount acc = new BankAccount("SI56-DB-1");
        acc.setOwner(p);
        acc.setCurrentBalance(BigDecimal.valueOf(100));
        dao.save(acc);
        BankAccount loaded = dao.find("SI56-DB-1");
        assertNotNull(loaded);
        assertEquals("Ana", loaded.getOwner().getName());
        assertEquals(BigDecimal.valueOf(100), loaded.getCurrentBalance());
    }

    @Test
    void premiumAccountIsStoredAndLoadedCorrectly() throws Exception {
        Person p = dao.savePerson(new Person("Miha", "Premium"));
        PremiumBankAccount acc = new PremiumBankAccount("SI56-PREM-1");
        acc.setOwner(p);
        acc.setCurrentBalance(BigDecimal.valueOf(500));
        acc.setAllowedLimit(2000);
        dao.save(acc);
        PremiumBankAccount loaded = (PremiumBankAccount) dao.find("SI56-PREM-1");
        assertEquals(2000, loaded.getAllowedLimit());
        assertTrue(loaded instanceof PremiumBankAccount);
    }

    @Test
    void transactionIsPersistedAndLoaded() throws Exception {
        Person p = dao.savePerson(new Person("Tina", "Test"));
        BankAccount src = new BankAccount("SI56-SRC");
        src.setOwner(p);
        src.setCurrentBalance(BigDecimal.valueOf(1000));
        BankAccount dst = new BankAccount("SI56-DST");
        dst.setOwner(p);
        dst.setCurrentBalance(BigDecimal.ZERO);
        dao.save(src);
        dao.save(dst);
        Transaction t = new Transaction(src, dst, BigDecimal.valueOf(200), "Transfer");
        dao.saveTransaction(t);
        List<Transaction> tx = dao.getAllTransactions("SI56-SRC");
        assertEquals(1, tx.size());
        assertEquals(BigDecimal.valueOf(200), tx.get(0).getAmount());
    }

}
