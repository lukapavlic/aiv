package si.um.feri.cli.example2;

import si.um.feri.cli.MyInitialContextFactory;
import si.um.feri.aiv.example2.*;

public class CmtEjbTest {

	public static void main(String[] args) throws Exception {
		
		CmtEjb ejb=(CmtEjb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/CmtEjbBean!si.um.feri.aiv.example2.CmtEjb");
		
		ejb.newPerson();
		
//		ejb.twoNewPeople();

//		ejb.justKiddin();
		
	}

}
