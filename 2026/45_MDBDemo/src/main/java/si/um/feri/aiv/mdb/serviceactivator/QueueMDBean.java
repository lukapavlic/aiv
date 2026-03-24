package si.um.feri.aiv.mdb.serviceactivator;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.EJB;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test2"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue") })
public class QueueMDBean implements MessageListener {

	Logger log=Logger.getLogger(QueueMDBean.class.toString());

	@EJB
	LazyOne ejb;

	public void onMessage(Message message) {
		log.info("[QueueMDBean] MSG Received! "+message);
		if (message instanceof TextMessage) {
			TextMessage tm = (TextMessage) message;
			try {
				log.info(tm.getText());
				if (tm.getText().equals("GO!"))
					ejb.slowMethod();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
