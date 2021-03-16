package si.um.feri.aiv.calc;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pravljica {

	private int id;
	
	List<Oseba> junaki;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToMany
	public List<Oseba> getJunaki() {
		return junaki;
	}

	public void setJunaki(List<Oseba> junaki) {
		this.junaki = junaki;
	}
	
}
