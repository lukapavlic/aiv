package si.um.feri.bank.vao;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Transaction implements Serializable {

    public enum TransactionType {
        WITHDRAW(0), DEPOSIT(1), TRANSFER(2);
        int value;
        TransactionType(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }

    public Transaction(BankAccount source, BankAccount destination, BigDecimal amount, String purpose) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        this.purpose =purpose;
    }

    private LocalDateTime timeStamp =LocalDateTime.now();

    private BankAccount source;

    private BankAccount destination;

    private BigDecimal amount;

    private String purpose;

    private TransactionType transType = TransactionType.TRANSFER;

    @Override
    public String toString() {
        return "Transaction{" +
                "timeStamp=" + timeStamp +
                ", amount=" + amount +
                ", purpose='" + purpose + '\'' +
                ", transType=" + transType +
                '}';
    }

}
