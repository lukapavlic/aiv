package si.um.feri.banka;

import lombok.Data;

@Data
public class Person {

    private String email;

    private String name;

    private String surname;

    public Person(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
