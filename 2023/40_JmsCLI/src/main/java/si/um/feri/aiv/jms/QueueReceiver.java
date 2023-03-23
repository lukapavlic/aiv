package si.um.feri.aiv.jms;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class QueueReceiver {

	public static void main(String[] args) throws Exception {

		InitialContext ctx = InitialContextFactory.getInitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		//QueueConnection cnn = factory.createQueueConnection("guest", "guest");
		QueueConnection cnn = factory.createQueueConnection();
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		cnn.start();
		javax.jms.QueueReceiver qr = session.createReceiver(queue);

		Message m = qr.receive();
		if (m instanceof TextMessage) {
			TextMessage t = (TextMessage) m;
			try {
				System.out.println(t.getText());
			} catch (Exception e) {
				System.out.println(m);
			}
		} else {
			System.out.println(m);
		}

		session.close();
		cnn.stop();
		cnn.close();

	}

}
