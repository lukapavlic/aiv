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
public class VrstaBean implements MessageListener {

	Logger log=Logger.getLogger(VrstaBean.class.toString());

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
