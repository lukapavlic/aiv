package si.um.feri.aiv.mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/topic/test"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
		//,@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
		})
public class AIVMessageDrivenTopic implements MessageListener {

	Logger log=Logger.getLogger(AIVMessageDrivenTopic.class.toString());

	public void onMessage(Message message) {

		if (message instanceof TextMessage) {
			TextMessage tm = (TextMessage) message;
			try {
				log.info("[AIVMessageDrivenTopic] Message: "+tm.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			log.info("[AIVMessageDrivenTopic] Unknown message");
		}
	}

}
