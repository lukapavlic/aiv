package si.um.feri.jee.sample.jsf;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("sample")
@SessionScoped
public class SampleJSFBean implements Serializable {

	private static final long serialVersionUID = 8921711242052520843L;

	Logger log=Logger.getLogger(this.getClass().getName());

	private String sayHi="I am sample.";

	public String getSayHi() {
		return sayHi;
	}

	public void setSayHi(String sayHi) {
		this.sayHi = sayHi;
	}

	public void action() {
		log.info("Action!");
	}
	
}
