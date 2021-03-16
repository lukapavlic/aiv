package si.um.feri.aiv.patterns.singleton;

import static org.junit.Assert.*;
import org.junit.Test;

public class PostarTest {

	@Test
	public void test() {
		Postar mirko=new Postar();
		Postar marko=new Postar();
		mirko.prinesiPosto();
		marko.prinesiPosto();
		assertNotEquals(mirko, marko);
	}

}
