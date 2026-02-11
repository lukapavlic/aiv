package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import si.um.feri.jee.sample.dao.PersonDao;
import si.um.feri.jee.sample.vao.Person;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Named("people")
@SessionScoped
public class PeopleJsfBean implements Serializable {

    Logger log=Logger.getLogger(this.getClass().getName());

    @Inject
    private PersonDao dao;

    private Person personOnUi=new Person("","",20);;

    public void addPersonFromUi() {
        log.info("Adding: "+personOnUi);
        dao.addPerson(personOnUi);
        personOnUi=new Person("","",20);
    }

    public List<Person> getAllPeople() {
        List<Person> ret=dao.getPeople();
        log.info("All people: "+ret);
        return ret;
    }

    public Person getPersonOnUi() {
        return personOnUi;
    }

    public void setPersonOnUi(Person personOnUi) {
        this.personOnUi = personOnUi;
    }

}
