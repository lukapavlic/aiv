package si.um.feri.aiv.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class MailSenderEjb {

    Logger log=Logger.getLogger(MailSenderEjb.class.toString());

    private static final long serialVersionUID = 4671068915774343475L;

    @Resource(mappedName = "java:jboss/mail/UMMail")
    private Session mySession;

    @Asynchronous
    public void send(String to) throws Exception {
        log.info("Pošiljam email:"+to);

        Message message = new MimeMessage(mySession);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Posta");
        message.setContent("Iz KISS resitve.", "text/plain");
        Transport.send(message);
    }

}
