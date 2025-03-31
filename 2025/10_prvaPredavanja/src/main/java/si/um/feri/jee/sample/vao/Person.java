package si.um.feri.jee.sample.vao;

import lombok.Data;

@Data
public class Person {

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    private String firstName;

    private String lastName;

    private int age;

}
