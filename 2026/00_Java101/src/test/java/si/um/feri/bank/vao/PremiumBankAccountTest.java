package si.um.feri.bank.vao;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PremiumBankAccountTest {

    @Test
    void donateWithdrawsMoney() {
        PremiumBankAccount acc = new PremiumBankAccount("SI56-999");
        acc.depositMoney(BigDecimal.valueOf(100));
        acc.donate("Charity", 30);
        assertEquals(BigDecimal.valueOf(70), acc.getCurrentBalance());
        assertEquals(2, acc.getTransactions().size());
    }

    @Test
    void allowedLimitCanBeChanged() {
        PremiumBankAccount acc = new PremiumBankAccount("SI56-999");
        acc.setAllowedLimit(5000);
        assertEquals(5000, acc.getAllowedLimit());
    }

}
