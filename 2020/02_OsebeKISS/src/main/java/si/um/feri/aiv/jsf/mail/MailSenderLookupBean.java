package si.um.feri.aiv.jsf.mail;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("mailSenderLookupBean")
@SessionScoped
public class MailSenderLookupBean implements Serializable {

	Logger log = LoggerFactory.getLogger(MailSenderLookupBean.class);

	private static final long serialVersionUID = 4671068915774343475L;

	final String MAIL_REPLY_TO="****";
	
	public void send(String to) throws Exception {
		log.info("Pošiljam email (mailSenderLookupBean):" + to);

		Session session = (Session)new InitialContext().lookup("java:jboss/mail/UMMail");
		
		Message message = new MimeMessage(session);
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setReplyTo(InternetAddress.parse(MAIL_REPLY_TO));
		message.setSubject("Naslov sporočila");
		message.setContent("Iz KISS rešitve.", "text/plain");
		Transport.send(message);
	}

}
