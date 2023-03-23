package si.um.feri.banka.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class BankAccount {

    @Id
    private String iban;

    @ManyToOne
    private Person owner;

    protected BigDecimal currentBalance;

    boolean active;

    public BankAccount() {
    }

    public BankAccount(String iban, Person owner, BigDecimal currentBalance, boolean active) {
        this.iban = iban;
        this.owner = owner;
        this.currentBalance = currentBalance;
        this.active = active;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "iban='" + iban + '\'' +
                ", owner=" + owner +
                ", currentBalance=" + currentBalance +
                ", active=" + active +
                '}';
    }

}
