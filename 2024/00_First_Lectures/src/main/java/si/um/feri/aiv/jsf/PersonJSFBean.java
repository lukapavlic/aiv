package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.PersonDao;
import si.um.feri.aiv.dao.PersonMemoryDao;
import si.um.feri.aiv.vao.Person;

@Named("demo")
@SessionScoped
public class PersonJSFBean implements Serializable {

	private static final long serialVersionUID = -8979220536758073133L;

	Logger log=Logger.getLogger(PersonJSFBean.class.toString());

	private PersonDao dao=new PersonMemoryDao();
	
	private Person selectedPerson=new Person();
	
	private String selectedEmail;
	
	public List<Person> getAllPeople() throws Exception {
		return dao.getAll();
	}
	
	public String savePerson() throws Exception {
		dao.save(selectedPerson);
		return "all";
	}
	
	public void deletePerson(Person o) throws Exception {
		dao.delete(o.getEmail());
	}

	public void setSelectedEmail(String email) throws Exception {
		selectedEmail =email;
		selectedPerson =dao.find(email);
		if(selectedPerson ==null) selectedPerson =new Person();
	}
	
	public String getSelectedEmail() {
		return selectedEmail;
	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}
	
}
