package si.um.feri.bank.vao;

import lombok.Data;
import si.um.feri.bank.Rich;
import java.io.Serializable;
import java.util.logging.Logger;

@Data
public class Person implements Rich, Serializable {

    transient Logger log=Logger.getLogger(this.getClass().getName());

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private int id;

    private String name;

    private String surname;

    @Override
    public void donate(String purpose, double amount) {
        log.info("No can do!");
    }

}
