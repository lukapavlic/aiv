package si.um.feri.aiv.jsf.mail;

import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Named("mailSenderOldSchool")
@SessionScoped
public class MailSenderOldSchoolBean implements Serializable {

	Logger log = Logger.getLogger(MailSenderOldSchoolBean.class.toString());

	private static final long serialVersionUID = 4671068915774343475L;

	final String MAIL_FROM="ime.priimek@um.si";
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
		message.setSubject("Naslov sporocila");
		message.setContent("Iz KISS resitve.", "text/plain");
		Transport.send(message);
	}

}
