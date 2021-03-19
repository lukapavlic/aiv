package si.um.feri.aiv.jsf.mail;

import java.io.Serializable;
import java.util.Properties;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("mailSenderOldSchool")
@SessionScoped
public class MailSenderOldSchoolBean implements Serializable {

	Logger log = LoggerFactory.getLogger(MailSenderOldSchoolBean.class);

	private static final long serialVersionUID = 4671068915774343475L;

	final String MAIL_FROM="****";
	final String MAIL_PASSWORD="****";
	
	public void send(String to) throws Exception {
		log.info("Pošiljam email (Old School):" + to);

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.startssl.enable", "true");
		prop.put("mail.smtp.host", "mail.um.si");
		prop.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(MAIL_FROM, MAIL_PASSWORD);
		    }
		});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(MAIL_FROM));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setReplyTo(InternetAddress.parse(MAIL_FROM));
		message.setSubject("Naslov sporočila");
		message.setContent("Iz KISS rešitve.", "text/plain");
		Transport.send(message);
	}

}
