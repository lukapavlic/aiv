package si.um.feri.aiv.rest;

import si.um.feri.aiv.vao.Oseba;

public class Demo  {

	public static void main(String[] args) {
		
		OsebeProxy client=new RestClient().osebeRest();
		
		System.out.println(client.vrniVseOsebe());
		System.out.println(client.vrniOsebo("mojca@pravljice.si"));
		
		Oseba o=new Oseba("email@gmail.com","Nova","Oseba");
		client.dodajOsebo(o);
		System.out.println(client.vrniVseOsebe());

		o.setPriimek("Nov priimek");
		client.spremeniOsebo(o.getEmail(), o);
		System.out.println(client.vrniVseOsebe());
		
		client.spremeniOsebo(o.getEmail(), o);
		System.out.println(client.izbrisiOsebo(o.getEmail()).getStatus());
		System.out.println(client.vrniVseOsebe());
	
	}

}
