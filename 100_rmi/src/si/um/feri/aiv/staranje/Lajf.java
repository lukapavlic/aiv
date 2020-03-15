package si.um.feri.aiv.staranje;

public class Lajf {

	void postaraj(Oseba o) {
		o.setStarost(o.getStarost()+1);
	}
	
	public static void main(String[] args) {
		
		Oseba peterKlepec=new Oseba("Peter Klepec", 10);
		System.out.println(peterKlepec);
		
		Lajf lajf=new Lajf();
		lajf.postaraj(peterKlepec);
		
		System.out.println(peterKlepec);
		
	}
	
	
}
