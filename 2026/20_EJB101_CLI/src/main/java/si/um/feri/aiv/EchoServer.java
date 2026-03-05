package si.um.feri.aiv;

import jakarta.ejb.Remote;

@Remote
public interface EchoServer {

    String echo(String myName);

}
