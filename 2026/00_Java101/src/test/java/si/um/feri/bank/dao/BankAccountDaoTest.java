package si.um.feri.bank.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import si.um.feri.bank.vao.BankAccount;
import si.um.feri.bank.vao.Person;
import static org.junit.jupiter.api.Assertions.*;

public abstract class BankAccountDaoTest {

    private BankAccountDao dao;

    protected abstract BankAccountDao createDao();

    @BeforeEach
    void setUp() {
        dao = createDao();
    }

    @Test
    void saveShouldStoreAccount() throws Exception {
        BankAccount acc = new BankAccount("SI56-123");
        acc.setOwner(new Person("",""));
        dao.save(acc);
        assertEquals(acc.getIban(), dao.find("SI56-123").getIban());
        assertEquals(1, dao.getAll().size());
    }

    @Test
    void saveWithoutIbanThrowsException() {
        BankAccount acc = new BankAccount();
        assertThrows(BankAccountDao.IbanMissingException.class, () -> dao.save(acc));
    }

    @Test
    void saveDuplicateIbanThrowsException() throws Exception {
        BankAccount acc1 = new BankAccount("SI56-123");
        acc1.setOwner(new Person("",""));
        BankAccount acc2 = new BankAccount("SI56-123");
        acc2.setOwner(new Person("",""));
        dao.save(acc1);
        assertThrows(BankAccountDao.BankAccountAlreadyExistException.class, () -> dao.save(acc2));
    }

    @Test
    void findReturnsNullForUnknownIban() {
        assertNull(dao.find("SI99-999"));
    }

    @Test
    void findReturnsNullForNullOrEmptyIban() {
        assertNull(dao.find(null));
        assertNull(dao.find(""));
    }

}
