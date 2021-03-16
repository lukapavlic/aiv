package si.um.feri.aiv.patterns.observer;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.observer.observers.Kafeterija;
import si.um.feri.aiv.patterns.observer.observers.Lekarna;
import si.um.feri.aiv.patterns.observer.observers.Policija;
import si.um.feri.aiv.patterns.observer.observers.Tehtnica;

public class StudentTest {
	
	Logger log=LoggerFactory.getLogger(StudentTest.class);
	
	private Student mirko;
	private Student zvonko; 
	
	@Before
	public void preTest() {
		log.info("- - - Vzpostavljam test - - -");
		mirko=new Student();
		zvonko=new Student();
		
		mirko.registrirajOpazovalcaZaHrano(new Kafeterija());
		mirko.registrirajOpazovalcaZaHrano(new Tehtnica());
		mirko.registrirajOpazovalcaZaPijaco(new Policija());
		
		zvonko.registrirajOpazovalcaZaHrano(new Tehtnica());
		zvonko.registrirajOpazovalcaZaPijaco(new Lekarna());
		zvonko.registrirajOpazovalcaZaPijaco(new Opazovalec() {
			public void akcija() {
				log.info("A že SPET?!?");
			}
		});
	}
	
	@Test
	public void mirkoIzZabaveNaZabavoTest() {
		mirko.pojdiNaZabavo();
		mirko.stricImaAbrahama();
	}
	
	@Test
	public void zvonkoLacenPoZabaviTest() {
		zvonko.pojdiNaZabavo();
		zvonko.najejSe();
	}
	
	@Test
	public void mirkoInZvonkoSkupnoKosiloTest() {
		mirko.najejSe();
		zvonko.najejSe();
	}
	
}
