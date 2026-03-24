package si.um.feri.aiv.jms.queue;

import jakarta.jms.*;
import si.um.feri.aiv.jms.InitialContextFactory;
import javax.naming.InitialContext;

public class QueueReceiverNonBlocking implements MessageListener {

	@Override
	public void onMessage(Message m) {
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
	}

	InitialContext ctx;
	QueueConnectionFactory factory;
	Queue queue;
	QueueConnection cnn;
	QueueSession session;
	jakarta.jms.QueueReceiver qr;

	QueueReceiverNonBlocking() throws Exception {
		ctx = InitialContextFactory.getInitialContext();
		factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		queue = (Queue) ctx.lookup("jms/queue/test");
		//cnn = factory.createQueueConnection("guest", "guest");
		cnn = factory.createQueueConnection();
		session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		qr = session.createReceiver(queue);
		qr.setMessageListener(this);
	}

	public void acceptMessage() throws Exception {
		cnn.start();
	}

	public void stopAccepting() throws Exception {
		session.close();
		cnn.stop();
		cnn.close();
	}

	public static void main(String[] args) throws Exception {
		QueueReceiverNonBlocking p=new QueueReceiverNonBlocking();
		p.acceptMessage();
		Thread.sleep(60_000);
		p.stopAccepting();
	}

}
