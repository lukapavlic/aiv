package si.um.feri.aiv.mdb;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.jms.*;

@Stateless
@LocalBean
public class GnjaviDalje {

    @Resource(lookup = "java:/ConnectionFactory")
    ConnectionFactory factory;

    @Resource(lookup = "java:/jms/queue/test3")
    Destination destination;

    public void dajmo(String sporocilo) throws Exception {
        try (JMSContext ctx=factory.createContext()) {
            JMSProducer producer=ctx.createProducer();
            Message m=ctx.createMapMessage();
            m.setStringProperty("prop","value");
            producer.send(destination,m);
        }
    }

}
