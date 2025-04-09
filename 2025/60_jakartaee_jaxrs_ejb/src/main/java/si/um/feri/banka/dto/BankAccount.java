package si.um.feri.banka.dto;

import lombok.Data;
import si.um.feri.banka.vao.Person;
import java.math.BigDecimal;

@Data
public class BankAccount {

    public BankAccount(si.um.feri.banka.vao.BankAccount br) {
        this.iban=br.getIban();
        this.comitent_email =br.getOwner().getEmail();
        this.comitent_name =br.getOwner().getName();
        this.comitent_surname =br.getOwner().getSurname();
        this.active =br.isActive();
        this.current_balance =br.getCurrentBalance();
    }

    public si.um.feri.banka.vao.BankAccount asVao() {
        si.um.feri.banka.vao.BankAccount ret=new si.um.feri.banka.vao.BankAccount();
        Person o=new Person(getComitent_email(), getComitent_name(), getComitent_surname());
        ret.setOwner(o);
        ret.setIban(getIban());
        ret.setActive(isActive());
        ret.setCurrentBalance(getCurrent_balance());
        return ret;
    }

    private String iban;
    private String comitent_name;
    private String comitent_surname;
    private String comitent_email;
    protected BigDecimal current_balance;
    boolean active;

}
