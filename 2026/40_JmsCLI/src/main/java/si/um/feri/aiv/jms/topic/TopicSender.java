package si.um.feri.aiv.jms.topic;

import jakarta.jms.*;
import si.um.feri.aiv.jms.InitialContextFactory;
import javax.naming.InitialContext;

public class TopicSender {

	public static void main(String[] args) throws Exception {
		
		InitialContext ctx = InitialContextFactory.getInitialContext();
		Topic topic = (Topic) ctx.lookup("jms/topic/test");
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		//TopicConnection cnn = factory.createTopicConnection("guest","guest");
		TopicConnection cnn = factory.createTopicConnection();
		TopicSession session = cnn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		TopicPublisher publ = session.createPublisher(topic);

		publ.publish(session.createTextMessage("Ojla!"));
		publ.publish(session.createTextMessage("Again."));
		publ.publish(session.createTextMessage("And again :)."));
		
		Message m=session.createTextMessage("Non-persistent message");
		publ.publish(m,DeliveryMode.NON_PERSISTENT,3,2000);

		m=session.createTextMessage("Persistent message");
		publ.publish(m,DeliveryMode.PERSISTENT,3,10000);

		session.close();
		
	}

}
