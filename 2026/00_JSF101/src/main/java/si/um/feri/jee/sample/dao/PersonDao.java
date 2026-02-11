package si.um.feri.jee.sample.dao;

import jakarta.enterprise.context.ApplicationScoped;
import si.um.feri.jee.sample.vao.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class PersonDao {

    private List<Person> people= Collections.synchronizedList(new ArrayList<>());

    public PersonDao() {
        people.add(new Person("John", "Doe", 18));
        people.add(new Person("Jack", "Bee", 28));
        people.add(new Person("Mary", "Boe", 22));
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person p) {
        people.add(p);
    }

}
