package si.um.feri.aiv.jms;

import javax.jms.Message;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;

public class PrejemnikTema {

	public static void main(String[] args) throws Exception {

		InitialContext ctx = new InitialContext();
		Topic topic = (Topic) ctx.lookup("jms/topic/test");
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		TopicConnection cnn = factory.createTopicConnection("guest","guest");
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
