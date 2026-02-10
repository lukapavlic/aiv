package si.um.feri.bank.dao;

public class BankAccountInFileDaoTest extends BankAccountDaoTest {

    @Override
    protected BankAccountDao createDao() {
        return new BankAccountInFileDao(true);
    }

}
