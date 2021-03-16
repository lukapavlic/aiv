package si.um.feri.aiv.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="osebe")
public class Osebe {

	public Osebe() {
	}
	
	public Osebe(List<Oseba> osebe) {
		super();
		this.osebe = osebe;
	}

	private List<Oseba> osebe;

	@XmlElement(name="oseba")
	public List<Oseba> getOsebe() {
		return osebe;
	}

	public void setOsebe(List<Oseba> osebe) {
		this.osebe = osebe;
	}
	
}
