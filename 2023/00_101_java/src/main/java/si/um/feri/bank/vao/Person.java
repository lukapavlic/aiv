package si.um.feri.bank.vao;

import si.um.feri.bank.Rich;
import java.io.Serializable;
import java.util.Objects;

public class Person implements Rich, Serializable {

    public Person() {
    }

    public Person(String ime, String priimek) {
        this.name = ime;
        this.surname = priimek;
    }

    private int id;

    private String name;

    private String surname;

    @Override
    public void donate(String purpose, double amount) {
        System.out.println("No can do!");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person oseba = (Person) o;
        return Objects.equals(name, oseba.name) && Objects.equals(surname, oseba.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

}
