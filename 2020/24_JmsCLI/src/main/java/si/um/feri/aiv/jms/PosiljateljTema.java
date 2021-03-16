package si.um.feri.aiv.jms;

import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.InitialContext;

public class PosiljateljTema {

	public static void main(String[] args) throws Exception {
		
		InitialContext ctx = new InitialContext();
		Topic topic = (Topic) ctx.lookup("jms/topic/test");
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		TopicConnection cnn = factory.createTopicConnection("guest","guest");
		TopicSession session = cnn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
		TopicPublisher publ = session.createPublisher(topic);

		publ.publish(session.createTextMessage("Ojla!"));
		publ.publish(session.createTextMessage("Pa spet."));
		publ.publish(session.createTextMessage("Pa se enkrat :)."));
		
		//sporocilo, ki ni trajno
		Message m=session.createTextMessage("NETRAJNO SPOROCILO");
		publ.publish(m,DeliveryMode.NON_PERSISTENT,3,2000);

		//sporocilo, ki je trajno
		m=session.createTextMessage("TRAJNO SPOROCILO");
		publ.publish(m,DeliveryMode.PERSISTENT,3,10000);

		session.close();
		
	}

}
