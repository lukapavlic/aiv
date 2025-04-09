package si.um.feri.cli.example2;

import si.um.feri.aiv.example2.*;
import si.um.feri.cli.MyInitialContextFactory;

public class BmtEjbTest {

	public static void main(String[] args) throws Exception {
		
		BmtEjb ejb=(BmtEjb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/BmtEjbBean!si.um.feri.aiv.example2.BmtEjb");
		
		ejb.letsDoIt();
		
	}

}
