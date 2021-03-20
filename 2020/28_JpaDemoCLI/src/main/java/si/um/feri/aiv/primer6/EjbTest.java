package si.um.feri.aiv.primer6;

import javax.naming.InitialContext;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=InitialContext.doLookup("JpaDemo/ejbSest!si.um.feri.aiv.primer6.Ejb");
		
		ejb.shrani(new OcenaKnjige(5,"Matiček se ženi"));
		ejb.shrani(new OcenaKnjigeSKomentarjem(5,"Poezije","Odlično"));

		System.out.println("--------------");
		for (OcenaKnjige ok : ejb.vrniVse())
			System.out.println(ok);

		System.out.println("--------------");
		for (OcenaKnjigeSKomentarjem ok : ejb.vrniVseSKomentarjem())
			System.out.println(ok);

	}

}
