package si.um.feri.aiv;

import javax.naming.InitialContext;
import java.util.Properties;

public class Program {

    public static void main(String[] args) throws Exception {
        Properties props=new Properties();
        props.put("java.naming.factory.initial","org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put("java.naming.provider.url","http-remoting://127.0.0.1:8080");
        props.put("jboss.naming.client.ejb.context","true");
        props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
        InitialContext ctx=new InitialContext(props);

        EchoServer c = (EchoServer) ctx.lookup("EmptySampleEjb/GreetingServerBean!si.um.feri.aiv.EchoServer");

        for (int i=0;i<1000;i++)
         System.out.println(c.echo("Luke Skywalker"));





    }

}
