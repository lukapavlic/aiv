package si.um.feri.cli.o2mbothsides;

import si.um.feri.aiv.o2mbothsides.Contact1M;
import si.um.feri.aiv.o2mbothsides.Ejb1M;
import si.um.feri.aiv.o2mbothsides.Person1M;
import si.um.feri.cli.MyInitialContextFactory;

public class EjbTest {

    public static void main(String[] args) throws Exception {

        Ejb1M ejb=(Ejb1M) MyInitialContextFactory.getInitialContext().lookup("JPAAdvancedDemo/EjbBean1M!si.um.feri.aiv.o2mbothsides.Ejb1M");

        Person1M o=new Person1M("Martin","Krpan","martin@krpan.si");
        o.getContacts().add(new Contact1M("telefon","051 051 051",o));
        o.getContacts().add(new Contact1M("email","email",o));
        o=ejb.save(o);

        System.out.println(o.getId());

        ejb.doIt();

    }

}
