package si.um.feri.aiv.primer2;

import javax.naming.InitialContext;

public class BmtEjbTest {

	public static void main(String[] args) throws Exception {
		
		BmtEjb ejb=InitialContext.doLookup("JpaDemo/BmtEjbBean!si.um.feri.aiv.primer2.BmtEjb");
		
		ejb.noPaDajmo();
		
	}

}
