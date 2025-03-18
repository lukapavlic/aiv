package si.um.feri.bank.vao;

import si.um.feri.bank.Rich;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class BankAccount implements Rich, Serializable {

    public BankAccount() {
        System.out.println("Opening a new bank account.");
        currentBalance =new BigDecimal(0.0d);
        active =true;
    }

    public BankAccount(String iban) {
        this();
        System.out.println("Opening a new bank account with iban:"+iban);
        this.iban=iban;
    }

    private String iban;

    private LocalDateTime opened =LocalDateTime.now();

    private Person owner;

    protected BigDecimal currentBalance;

    boolean active;

    private List<Transaction> transactions =new ArrayList<>();

    public BigDecimal depositMoney(BigDecimal amount) {
        Transaction t=new Transaction(null,this,amount,"Unspecified");
        transactions.add(t);
        currentBalance = currentBalance.add(amount);
        return currentBalance;
    }

    public BigDecimal withdrawMoney(BigDecimal znesek) {
        return withdrawMoney(znesek, "Unspecified");
    }

    public BigDecimal withdrawMoney(BigDecimal amount, String purpose) {
        Transaction t=new Transaction(this,null,amount,purpose);
        transactions.add(t);
        currentBalance = currentBalance.subtract(amount);
        return currentBalance;
    }

    @Override
    public void donate(String purpose, double amount) {
        System.out.println("Not now...");
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public LocalDateTime getOpened() {
        return opened;
    }

    public void setOpened(LocalDateTime opened) {
        this.opened = opened;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("BankAccount{" +
                "iban='" + iban + '\'' +
                ", opened=" + opened +
                ", owner=" + owner +
                ", currentBalance=" + currentBalance +
                ", active=" + active +
                '}');
        for (Iterator i = transactions.iterator(); i.hasNext();) {
            Transaction t=(Transaction)i.next();
            sb.append("\n\t- ");
            sb.append(t.toString());
        }
        return sb.toString();
    }

}
