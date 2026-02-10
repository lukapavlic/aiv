package si.um.feri.bank.dao;

public class BankAccountInMemoryDaoTest extends BankAccountDaoTest {

    @Override
    protected BankAccountDao createDao() {
        return new BankAccountInMemoryDao();
    }

}
