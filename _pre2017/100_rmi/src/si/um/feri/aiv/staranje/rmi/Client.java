package si.um.feri.aiv.staranje.rmi;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) throws Exception {
		
		Oseba peterKlepec=new Oseba("Peter Klepec", 10);
		System.out.println(peterKlepec);
		
		Lajf lajf=(Lajf)Naming.lookup("//localhost/lajf");
		lajf.postaraj(peterKlepec);
		
		System.out.println(peterKlepec);
		
	}
	
	
}
