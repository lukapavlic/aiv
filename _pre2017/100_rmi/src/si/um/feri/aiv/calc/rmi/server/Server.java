package si.um.feri.aiv.calc.rmi.server;

import java.rmi.Naming;

public class Server {

	public static void main(String[] args) throws Exception {
		Calculator c=new Calculator();
		Naming.bind("//localhost/calc", c);
	}
	
}
