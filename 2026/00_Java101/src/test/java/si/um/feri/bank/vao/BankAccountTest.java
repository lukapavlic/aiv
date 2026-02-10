package si.um.feri.bank.vao;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void newAccountHasZeroBalanceAndIsActive() {
        BankAccount acc = new BankAccount("SI56-111");
        assertEquals(BigDecimal.ZERO, acc.getCurrentBalance());
        assertTrue(acc.isActive());
    }

    @Test
    void depositIncreasesBalance() {
        BankAccount acc = new BankAccount("SI56-111");
        acc.depositMoney(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), acc.getCurrentBalance());
        assertEquals(1, acc.getTransactions().size());
    }

    @Test
    void withdrawDecreasesBalance() {
        BankAccount acc = new BankAccount("SI56-111");
        acc.depositMoney(BigDecimal.valueOf(200));
        acc.withdrawMoney(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(150), acc.getCurrentBalance());
        assertEquals(2, acc.getTransactions().size());
    }

}
