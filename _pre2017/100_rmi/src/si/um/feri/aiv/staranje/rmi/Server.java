package si.um.feri.aiv.staranje.rmi;

import java.rmi.Naming;

public class Server {

	public static void main(String[] args) throws Exception {
		Lajf c=new LajfBean();
		Naming.bind("//localhost/lajf", c);
	}
	
}
