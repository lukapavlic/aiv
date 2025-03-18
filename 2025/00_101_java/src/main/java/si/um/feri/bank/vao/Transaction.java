package si.um.feri.bank.vao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    public TransactionType getTransType() {
        return transType;
    }

    public void setTransType(TransactionType transType) {
        this.transType = transType;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BankAccount getSource() {
        return source;
    }

    public void setSource(BankAccount source) {
        this.source = source;
    }

    public BankAccount getDestination() {
        return destination;
    }

    public void setDestination(BankAccount destination) {
        this.destination = destination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

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
