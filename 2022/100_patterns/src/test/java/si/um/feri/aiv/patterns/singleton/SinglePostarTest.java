package si.um.feri.aiv.patterns.singleton;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SinglePostarTest {

	@Test
	public void test() {
		SinglePostar mirko=SinglePostar.getInstance();
		SinglePostar marko=SinglePostar.getInstance();
		mirko.prinesiPosto();
		marko.prinesiPosto();
		//mirko in marko sta isti poštar!!!
		assertEquals(mirko, marko);
	}

}
