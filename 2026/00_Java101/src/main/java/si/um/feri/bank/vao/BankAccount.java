package si.um.feri.bank.vao;

import lombok.Getter;
import lombok.Setter;
import si.um.feri.bank.Rich;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

@Getter
@Setter
public class BankAccount implements Rich, Serializable {

    transient Logger log=Logger.getLogger(this.getClass().getName());

    public BankAccount() {
        log.info("Opening a new bank account.");
        currentBalance =new BigDecimal(0.0d);
        active =true;
    }

    public BankAccount(String iban) {
        this();
        log.info("Opening a new bank account with iban:"+iban);
        this.iban=iban;
    }

    private String iban;

    private LocalDateTime opened = LocalDateTime.now();

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
        log.info("Not donating...");
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
