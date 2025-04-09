package si.um.feri.banka.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class BankAccount {

    @Id
    private String iban;

    @ManyToOne
    private Person owner;

    protected BigDecimal currentBalance;

    boolean active;

    public BankAccount(String iban, Person owner, BigDecimal currentBalance, boolean active) {
        this.iban = iban;
        this.owner = owner;
        this.currentBalance = currentBalance;
        this.active = active;
    }

}
