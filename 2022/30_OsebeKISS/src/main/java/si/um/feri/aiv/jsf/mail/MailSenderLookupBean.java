package si.um.feri.aiv.jsf.mail;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Named("mailSenderLookupBean")
@SessionScoped
public class MailSenderLookupBean implements Serializable {

	Logger log = Logger.getLogger(MailSenderLookupBean.class.toString());

	private static final long serialVersionUID = 4671068915774343475L;

	final String MAIL_REPLY_TO="ime.priimek@um.si";
	
	public void send(String to) throws Exception {
		log.info("Pošiljam email (mailSenderLookupBean):" + to);

		Session session = (Session)new InitialContext().lookup("java:jboss/mail/UMMail");
		
		Message message = new MimeMessage(session);
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setReplyTo(InternetAddress.parse(MAIL_REPLY_TO));
		message.setSubject("Naslov sporocila");
		message.setContent("Iz KISS resitve.", "text/plain");
		Transport.send(message);
	}

}
