package si.um.feri.banka.dto;

import si.um.feri.banka.vao.BankAccount;
import si.um.feri.banka.vao.Person;
import jakarta.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;
import java.util.List;

public class PersonExtended {

    public PersonExtended(Person o, List<BankAccount> racuni) {
        this.email=o.getEmail();
        this.name =o.getName();
        this.surname =o.getSurname();
        for (BankAccount br:racuni)
            this.accounts.add(br.getIban());
    }

    private String email;

    private String name;

    private String surname;

    @JsonbProperty("accounts")
    private List<String> accounts=new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

}
