package si.um.feri.aiv.jms;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class InitialContextFactory {

    public static InitialContext getInitialContext() throws NamingException {
        Properties props=new Properties();
        props.put("java.naming.factory.initial","org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put("java.naming.provider.url","http-remoting://127.0.0.1:8080");
        return new InitialContext(props);
    }

}
