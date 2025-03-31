package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.PersonDao;
import si.um.feri.jee.sample.vao.Person;

import java.io.Serializable;
import java.util.List;

@Named("people")
@SessionScoped
public class PeopleJsfBean implements Serializable {

    public List<Person> getPeople() {
        return PersonDao.getInstance().getPeople();
    }

}
