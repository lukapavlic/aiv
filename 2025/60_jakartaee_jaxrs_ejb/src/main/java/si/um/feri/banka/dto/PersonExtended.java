package si.um.feri.banka.dto;

import lombok.Data;
import si.um.feri.banka.vao.BankAccount;
import si.um.feri.banka.vao.Person;
import jakarta.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;
import java.util.List;

@Data
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

}
