package si.um.feri.aiv.patterns.singleton;

import static org.junit.Assert.*;
import org.junit.Test;

public class SinglePostarLazyTest {

	@Test
	public void test() {
		SinglePostarLazy mirko=SinglePostarLazy.getInstance();
		SinglePostarLazy marko=SinglePostarLazy.getInstance();
		mirko.prinesiPosto();
		marko.prinesiPosto();
		//mirko in marko sta isti poštar!!!
		assertEquals(mirko, marko);
	}

}
