package si.um.feri.aiv.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Student {

	//Primer demonstrira situacijo, ko želimo na en objekt vezati opazovalce za razliène tipe dogodkov
	//Zato lahko imamo veè "registriraj" metod, ali pa pri edini metodi s parametrom doloèimo tip dogodkov
	
	Logger log=LoggerFactory.getLogger(Student.class);
	
	private List<Opazovalec> opazovalciHrana=new ArrayList<>();
	private List<Opazovalec> opazovalciPijaca=new ArrayList<>();
	public void registrirajOpazovalcaZaHrano(Opazovalec o) {
		opazovalciHrana.add(o);
	}
	public void registrirajOpazovalcaZaPijaco(Opazovalec o) {
		opazovalciPijaca.add(o);
	}
	protected void obvestiVseOpazovalceZaHrano() {
		for (Opazovalec o:opazovalciHrana)
			o.akcija();
	}
	protected void obvestiVseOpazovalceZaPijaco() {
		for (Opazovalec o:opazovalciPijaca)
			o.akcija();
	}
	
	public void najejSe() {
		log.info("Kako je bilo dobro...");
		obvestiVseOpazovalceZaHrano();
	}
	
	public void pojdiNaZabavo() {
		log.info("Tooo, še spiiijemo pa greeeeemo....");
		obvestiVseOpazovalceZaPijaco();
	}
	
	public void stricImaAbrahama() {
		log.info("Vse najboljše, stric.");
		obvestiVseOpazovalceZaHrano();
		obvestiVseOpazovalceZaPijaco();
	}
	
}
