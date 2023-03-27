package si.um.feri.cli.primer2;

import si.um.feri.aiv.primer2.*;
import si.um.feri.cli.MyInitialContextFactory;

public class BmtEjbTest {

	public static void main(String[] args) throws Exception {
		
		BmtEjb ejb=(BmtEjb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/BmtEjbBean!si.um.feri.aiv.primer2.BmtEjb");
		
		ejb.noPaDajmo();
		
	}

}
