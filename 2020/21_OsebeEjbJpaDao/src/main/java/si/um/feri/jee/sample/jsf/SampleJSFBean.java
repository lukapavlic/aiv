package si.um.feri.jee.sample.jsf;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("sample")
@SessionScoped
public class SampleJSFBean implements Serializable {

	private static final long serialVersionUID = 8921711242052520843L;

	private String sayHi="I am sample.";

	public String getSayHi() {
		return sayHi;
	}

	public void setSayHi(String sayHi) {
		this.sayHi = sayHi;
	}
	
}
