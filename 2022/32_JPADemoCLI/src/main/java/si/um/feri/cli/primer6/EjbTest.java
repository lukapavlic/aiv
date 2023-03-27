package si.um.feri.cli.primer6;

import si.um.feri.cli.MyInitialContextFactory;
import si.um.feri.aiv.primer6.*;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=(Ejb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/ejbSest!si.um.feri.aiv.primer6.Ejb");
		
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
