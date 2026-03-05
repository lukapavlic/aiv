package si.um.feri.aiv;

import jakarta.ejb.Stateless;

@Stateless
public class GreetingServerBean implements EchoServer {

    public String echo(String myName) {
        System.out.println("ServerBean: " + myName);
        return "Hello, "+myName;
    }

}
