package si.um.feri.bank.dao;

public class BankAccountDBDaoTest extends BankAccountDaoTest {

    @Override
    protected BankAccountDao createDao() {
        try {
            return new BankAccountDBDao(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
