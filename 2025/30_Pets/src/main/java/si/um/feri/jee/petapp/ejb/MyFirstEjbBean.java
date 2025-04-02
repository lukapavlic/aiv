package si.um.feri.jee.petapp.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class MyFirstEjbBean implements MyFirstEjb {

    public String sayHello(String myName) {
        System.out.println("I am just sayin' Hello.");
        return "Hello "+myName;
    }

}