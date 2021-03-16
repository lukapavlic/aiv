package si.um.feri.aiv.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class AIVMessageDriven implements MessageListener {

	Logger log=LoggerFactory.getLogger(AIVMessageDriven.class);

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage tm = (TextMessage) message;
			try {
				log.info("[AIVMessageDriven] SPOROCILO: "+tm.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			log.info("Prispelo je neznano sporocilo.");
		}
	}

}
