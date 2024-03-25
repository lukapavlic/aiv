package si.um.feri.cli.one2many;

import si.um.feri.aiv.one2many.Contact;
import si.um.feri.aiv.one2many.Ejb;
import si.um.feri.aiv.one2many.Person;
import si.um.feri.cli.MyInitialContextFactory;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=(Ejb)MyInitialContextFactory.getInitialContext().lookup("JPAAdvancedDemo/EjbBean!si.um.feri.aiv.one2many.Ejb");
		
		Person o=new Person("Martin","Krpan","martin@krpan.si");
		o.getContacts().add(new Contact("telefon","051 051 051"));
		o.getContacts().add(new Contact("email","email"));
		o=ejb.save(o);
		
		System.out.println(o.getId());

		ejb.doIt(o.getId());

		Person o2=ejb.find(o.getId());
		System.out.println(o2);
		for (Contact k :o2.getContacts())
			System.out.println(k);
		
	}

}
