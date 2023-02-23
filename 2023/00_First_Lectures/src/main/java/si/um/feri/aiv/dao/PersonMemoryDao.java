package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import si.um.feri.aiv.vao.Person;

public class PersonMemoryDao implements PersonDao {

	Logger log=Logger.getLogger(PersonMemoryDao.class.toString());
	
	private List<Person> people=Collections.synchronizedList(new ArrayList<Person>());

	@Override
	public List<Person> getAll() {
		log.info("DAO: get all");
		return people;
	}
	
	@Override
	public Person find(String email)  {
		log.info("DAO: finding "+email);
		for (Person o : people)
			if (o.getEmail().equals(email))
				return o;
		return null;
	}
	
	@Override
	public void save(Person o)  {
		log.info("DAO: saving "+o);
		if(find(o.getEmail())!=null) {
			log.info("DAO: editing "+o);
			delete(o.getEmail());
		}
		people.add(o);
	}
	
	@Override
	public void delete(String email) {
		log.info("DAO: deleting "+email);
		for (Iterator<Person> i = people.iterator(); i.hasNext();) {
			if (i.next().getEmail().equals(email))
				i.remove();
		}
	}
	
}