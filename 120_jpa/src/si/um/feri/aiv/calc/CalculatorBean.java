package si.um.feri.aiv.calc;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CalculatorBean implements Calculator {

	@PersistenceContext
	private EntityManager em;
	
	public double add(double a, double b) {
		System.out.println("Calc -> add");
		em.persist(new Calculation(a + " + " + b,a+b));
		return a+b;
	}
	
	public double sub(double a, double b) {
		System.out.println("Calc -> sub");
		em.persist(new Calculation(a + " - " + b,a-b));
		return a-b;
	}
	
	public double mul(double a, double b) {
		System.out.println("Calc -> mul");
		em.persist(new Calculation(a + " * " + b,a*b));
		return a*b;
	}
	
	public double div(double a, double b) {
		System.out.println("Calc -> div");
		em.persist(new Calculation(a + " / " + b,a/b));
		return a/b;
	}
	
	@Override
	public void demo() {
		System.out.println("ejb");

		Oseba o=new Oseba("Mojca","Pokrajculja");
		System.out.println(o);
		em.persist(o);
		System.out.println(o);
		
		o.setIme("Martin");
		
		List osebe=em.createQuery("select o from Oseba o").getResultList();
		
		for (Object os :osebe) {
			System.out.println(os);
		}		
	}
	
}
