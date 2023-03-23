package si.um.feri.aiv.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.TextMessage;
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
	QueueReceiver qr;

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

	public void prejemajSporocila() throws Exception {
		cnn.start();
	}

	public void konecPrejemanja() throws Exception {
		session.close();
		cnn.stop();
		cnn.close();
	}

	public static void main(String[] args) throws Exception {
		QueueReceiverNonBlocking p=new QueueReceiverNonBlocking();
		p.prejemajSporocila();
		Thread.sleep(60_000);
		p.konecPrejemanja();
	}

}
