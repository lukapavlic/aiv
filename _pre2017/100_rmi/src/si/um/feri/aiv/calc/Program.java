package si.um.feri.aiv.calc;

public class Program {

	public static void main(String[] args) {
		
		Calculator c=new Calculator();
		
		System.out.println(c.add(4, 5));
		
		System.out.println(c.getHistory());
		
		System.out.println(c.getLastCalculation());
		
		for (int i=0;i<10;i++) {
			System.out.println(c.add(c.getHistory(), 1));
		}
		
	}
	
}
