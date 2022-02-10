package si.um.feri.aiv.jsf.mail;

import java.io.Serializable;
import java.util.logging.Logger;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Named("mailSender")
@SessionScoped
public class MailSenderBean implements Serializable {

	Logger log=Logger.getLogger(MailSenderBean.class.toString());
	
	private static final long serialVersionUID = 4671068915774343475L;
	
	/*
		<mail-session name="UMMail" debug="true" jndi-name="java:jboss/mail/UMMail" from="----">
			<smtp-server outbound-socket-binding-ref="mail-smtp-um" ssl="true" username="----" password="----"/>
		</mail-session>
		    
		<outbound-socket-binding name="mail-smtp-um">
			<remote-destination host="mail.um.si" port="587"/>
		</outbound-socket-binding>
	 */
	
	//@Resource(mappedName = "java:jboss/mail/UMMail")
	private Session mySession;

	public void send(String to) throws Exception {
		
		log.info("Pošiljam email:"+to);
		
		Message message = new MimeMessage(mySession);
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Pošta");
		message.setContent("Iz KISS rešitve.", "text/plain");
		Transport.send(message);
	}
	
}
