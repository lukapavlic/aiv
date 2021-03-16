package si.um.feri.aiv.mdb.serviceactivator;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/test"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class VrstaBean implements MessageListener {

	@EJB
	Zrno ejb;
	
	public void onMessage(Message message) {
		System.out.println("[VrstaBean] Prejeto Sporoèilo! "+message);
		if (message instanceof TextMessage) {
			TextMessage tm = (TextMessage) message;
			try {
				System.out.println(tm.getText());
				
				if (tm.getText().equals("DAJMO!"))
					ejb.metoda();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
