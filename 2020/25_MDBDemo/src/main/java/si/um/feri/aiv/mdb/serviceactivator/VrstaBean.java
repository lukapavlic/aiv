package si.um.feri.aiv.mdb.serviceactivator;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class VrstaBean implements MessageListener {

	Logger log=LoggerFactory.getLogger(VrstaBean.class);
	
	@EJB
	Zrno ejb;
	
	public void onMessage(Message message) {
		log.info("[VrstaBean] Prejeto Sporocilo! "+message);
		if (message instanceof TextMessage) {
			TextMessage tm = (TextMessage) message;
			try {
				log.info(tm.getText());
				
				if (tm.getText().equals("DAJMO!"))
					ejb.metoda();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
