package si.um.feri.aiv.jms;

import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

public class QueueSender {

	public static void main(String[] args) throws Exception {
		
		InitialContext ctx = InitialContextFactory.getInitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		//QueueConnection cnn = factory.createQueueConnection("guest","guest");
		QueueConnection cnn = factory.createQueueConnection();
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		javax.jms.QueueSender sender = session.createSender(queue);

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
