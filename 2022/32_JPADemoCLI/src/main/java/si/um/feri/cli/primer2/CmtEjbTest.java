package si.um.feri.cli.primer2;

import si.um.feri.cli.MyInitialContextFactory;
import si.um.feri.aiv.primer2.*;

public class CmtEjbTest {

	public static void main(String[] args) throws Exception {
		
		CmtEjb ejb=(CmtEjb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/CmtEjbBean!si.um.feri.aiv.primer2.CmtEjb");
		
		ejb.novaOseba();
		
//		ejb.dveNoviOsebi();
//
//		ejb.smoSeSamoHecali();
		
	}

}
