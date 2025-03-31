package si.um.feri.jee.sample.dao;

import si.um.feri.jee.sample.vao.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonDao {

    private List<Person> people= Collections.synchronizedList(new ArrayList<>());

    private PersonDao() {
        people.add(new Person("John", "Doe", 18));
        people.add(new Person("Jack", "Bee", 28));
        people.add(new Person("Mary", "Boe", 22));
    }

    private static PersonDao instance = new PersonDao();

    public static PersonDao getInstance() {
        return instance;
    }

    public List<Person> getPeople() {
        return people;
    }

}
