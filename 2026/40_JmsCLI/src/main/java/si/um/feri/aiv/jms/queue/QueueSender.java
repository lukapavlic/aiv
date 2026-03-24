package si.um.feri.aiv.jms.queue;

import jakarta.jms.*;
import si.um.feri.aiv.jms.InitialContextFactory;
import javax.naming.InitialContext;

public class QueueSender {

	public static void main(String[] args) throws Exception {
		
		InitialContext ctx = InitialContextFactory.getInitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		//QueueConnection cnn = factory.createQueueConnection("guest","guest");
		QueueConnection cnn = factory.createQueueConnection();
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		jakarta.jms.QueueSender sender = session.createSender(queue);

		sender.send(session.createTextMessage("Ojla!"));
		sender.send(session.createTextMessage("Again."));
		sender.send(session.createTextMessage("And again :)."));
		
		Message m=session.createTextMessage("Nonpersistent message");
		sender.send(m,DeliveryMode.NON_PERSISTENT,3,2000);

		m=session.createTextMessage("Persistent message");
		sender.send(m,DeliveryMode.PERSISTENT,3,10000);

		session.close();
		
	}

}