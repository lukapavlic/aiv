package si.um.feri.aiv.jms;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.naming.InitialContext;

public class PosiljateljVrstaSimplifiedAPI {

	public static void main(String[] args) throws Exception {
		
		InitialContext ictx = InitialContextFactory.getInitialContext();
		Destination destination = (Destination) ictx.lookup("jms/queue/test");
		ConnectionFactory factory = (ConnectionFactory) ictx.lookup("jms/RemoteConnectionFactory");
		JMSContext ctx=factory.createContext();
		JMSProducer producer=ctx.createProducer();

		producer.send(destination,"Ojla!");
		producer.send(destination,"Pa spet.");
		producer.send(destination,"Pa se enkrat :).");
		
		//sporocilo, ki ni trajno
		Message m=ctx.createTextMessage("NETRAJNO SPOROCILO");
		m.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
		m.setJMSPriority(3);
		m.setJMSExpiration(2000);
		producer.send(destination,m);
		
		//sporocilo, ki je trajno
		m=ctx.createTextMessage("TRAJNO SPOROCILO");
		m.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
		m.setJMSPriority(3);
		m.setJMSExpiration(10000);
		producer.send(destination,m);

		ctx.close();
		
	}

}
