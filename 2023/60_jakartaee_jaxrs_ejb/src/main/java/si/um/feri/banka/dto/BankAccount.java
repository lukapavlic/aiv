package si.um.feri.banka.dto;

import si.um.feri.banka.vao.Person;
import java.math.BigDecimal;

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

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getComitent_name() {
        return comitent_name;
    }

    public void setComitent_name(String comitent_name) {
        this.comitent_name = comitent_name;
    }

    public String getComitent_surname() {
        return comitent_surname;
    }

    public void setComitent_surname(String comitent_surname) {
        this.comitent_surname = comitent_surname;
    }

    public String getComitent_email() {
        return comitent_email;
    }

    public void setComitent_email(String comitent_email) {
        this.comitent_email = comitent_email;
    }

    public BigDecimal getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(BigDecimal current_balance) {
        this.current_balance = current_balance;
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
                ", comitent_name='" + comitent_name + '\'' +
                ", comitent_surname='" + comitent_surname + '\'' +
                ", comitent_email='" + comitent_email + '\'' +
                ", current_balance=" + current_balance +
                ", active=" + active +
                '}';
    }

}
