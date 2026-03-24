package si.um.feri.cli;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MyInitialContextFactory {

    private static InitialContext ctx=null;
    public static InitialContext getInitialContext() throws NamingException {
        if (ctx!=null) return ctx;

        Properties props=new Properties();
        props.put("java.naming.factory.initial","org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put("java.naming.provider.url","http-remoting://127.0.0.1:8080");
        props.put("jboss.naming.client.ejb.context","true");
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        InitialContext ctx=new InitialContext(props);

        return ctx;

    }

}
