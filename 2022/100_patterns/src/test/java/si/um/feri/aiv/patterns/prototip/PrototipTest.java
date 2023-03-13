package si.um.feri.aiv.patterns.prototip;

import org.junit.Assert;
import org.junit.Test;

public class PrototipTest {

	@Test
	public void testOsebaShallow() throws Exception {
		
		System.out.println("----------------- SHALLOW COPY ------------------------");
		
		OsebaShallow o1=new OsebaShallow("Peter","Klepec","peter@gmail.com");
		o1.getKontakti().add(new Kontakt("051 051 051"));
		o1.getKontakti().add(new Kontakt("#ostaniDoma"));
		
		OsebaShallow o2=(OsebaShallow)o1.clone();
		
		System.out.println("Original:");
		System.out.println(o1);
		
		System.out.println("Kopija:");
		System.out.println(o2);
		
		//objekt OsebaShallow je skopiran
		Assert.assertNotEquals(o1, o2);
		
		//povezani objekti NISO kopije
		Assert.assertEquals(o1.getKontakti().get(0),o2.getKontakti().get(0));
		Assert.assertEquals(o1.getKontakti().get(1),o2.getKontakti().get(1));
	}
	
	@Test
	public void testOsebaDeep() throws Exception {
		
		System.out.println("----------------- DEEP COPY ------------------------");
		
		OsebaDeep o1=new OsebaDeep("Peter","Klepec","peter@gmail.com");
		o1.getKontakti().add(new Kontakt("051 051 051"));
		o1.getKontakti().add(new Kontakt("#ostaniDoma"));
		
		OsebaDeep o2=(OsebaDeep)o1.clone();
		
		System.out.println("Original:");
		System.out.println(o1);
		
		System.out.println("Kopija:");
		System.out.println(o2);
		
		//objekt OsebaShallow je skopiran
		Assert.assertNotEquals(o1, o2);
		
		//tudi povezani objekti so kopije
		Assert.assertNotEquals(o1.getKontakti().get(0),o2.getKontakti().get(0));
		Assert.assertNotEquals(o1.getKontakti().get(1),o2.getKontakti().get(1));
		
	}
	
}
