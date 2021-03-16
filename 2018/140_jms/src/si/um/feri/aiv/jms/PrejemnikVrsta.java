package si.um.feri.aiv.jms;

import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class PrejemnikVrsta {

	public static void main(String[] args) throws Exception {

		InitialContext ctx = new InitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		QueueConnection cnn = factory.createQueueConnection("guest", "guest");
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		cnn.start();
		QueueReceiver qr = session.createReceiver(queue);

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
