package si.um.feri.jee.petapp.ejb;

import jakarta.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class MyFirstEjbBean implements MyFirstEjb {

    Logger log=Logger.getLogger(this.getClass().getName());

    public String sayHello(String myName) {
        log.info("I am just sayin' Hello.");
        return "Hello "+myName;
    }

}