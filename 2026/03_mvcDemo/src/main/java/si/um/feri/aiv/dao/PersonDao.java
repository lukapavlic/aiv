package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import si.um.feri.aiv.Person;

/**
 * Dummy DB
 */
public class PersonDao {
	
	private static List<Person> people=Collections.synchronizedList(new ArrayList<Person>());
	
	public void save(Person o) throws Exception {
		people.add(o);
	}
	
	public Person findPerson(int id) throws Exception {
		for (Person o: people)
			if (o.getId()==id) 
				return o;
		return null;
	}
	
	public List<Person> getAll() throws Exception {
		return people;
	}

}
