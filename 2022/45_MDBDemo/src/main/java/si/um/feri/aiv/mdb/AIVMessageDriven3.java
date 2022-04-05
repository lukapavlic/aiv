package si.um.feri.aiv.mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.*;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test3"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class AIVMessageDriven3 implements MessageListener {

	Logger log=Logger.getLogger(AIVMessageDriven3.class.toString());

	public void onMessage(Message message) {
		if (message instanceof MapMessage) {
			MapMessage mm = (MapMessage) message;
			log.info(mm+"");
		} else {
			log.info("Prispelo je neznano sporocilo.");
		}
	}

}
