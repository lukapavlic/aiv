package si.um.feri.aiv.jsf.mail;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.ejb.MailSenderEjb;

@Named("mailSender")
@SessionScoped
public class MailSenderBean implements Serializable {

	Logger log=Logger.getLogger(MailSenderBean.class.toString());
	
	private static final long serialVersionUID = 4671068915774343475L;

	@EJB
	MailSenderEjb ejb;
	
	public void send(String to) throws Exception {
		ejb.send(to);
	}
	
}
