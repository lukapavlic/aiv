package si.um.feri.aiv.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/topic/test"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") 
//		,@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
		})
public class AIVMessageDrivenTopic implements MessageListener {

	public void onMessage(Message message) {

		if (message instanceof TextMessage) {
			TextMessage tm = (TextMessage) message;
			try {
				System.out.println("[AIVMessageDrivenTopic] SPOROÈILO: "+tm.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Tema: Prispelo je neznano sporoèilo.");
		}
	}

}
