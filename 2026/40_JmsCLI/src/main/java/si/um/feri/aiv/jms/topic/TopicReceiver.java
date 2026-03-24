package si.um.feri.aiv.jms.topic;

import jakarta.jms.*;
import si.um.feri.aiv.jms.InitialContextFactory;
import javax.naming.InitialContext;

public class TopicReceiver {

	public static void main(String[] args) throws Exception {

		InitialContext ctx = InitialContextFactory.getInitialContext();
		Topic topic = (Topic) ctx.lookup("jms/topic/test");
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
//		TopicConnection cnn = factory.createTopicConnection("guest","guest");
		TopicConnection cnn = factory.createTopicConnection();
		TopicSession session = cnn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		cnn.start();
		TopicSubscriber ts = session.createSubscriber(topic);
		
		Message m = ts.receive();
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
