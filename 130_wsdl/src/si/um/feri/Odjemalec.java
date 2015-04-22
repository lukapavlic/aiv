package si.um.feri;

import si.um.feri.gen.Kalkulator;
import si.um.feri.gen.KalkulatorService;

public class Odjemalec {

	public static void main(String[] args) {

		Kalkulator kalk=new KalkulatorService().getKalkulatorPort();
		
		System.out.println(kalk.sestej(10,3));
		System.out.println(kalk.odstej(10,3));
		System.out.println(kalk.mnozi(10,3));
		System.out.println(kalk.deli(10,3));
		
		System.out.println(kalk.obdelaj(10,3));
		
	}

}
