package si.um.feri.jee.petapp.ejb;

import jakarta.ejb.Local;

@Local
public interface MyFirstEjb {

    String sayHello(String myName);

}
