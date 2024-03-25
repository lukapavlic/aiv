package si.um.feri.aiv.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Student {

	//Primer demonstrira situacijo, ko želimo na en objekt vezati opazovalce za različne tipe dogodkov
	//Zato lahko imamo več "registriraj" metod, ali pa pri edini metodi s parametrom določimo tip dogodkov
	
	Logger log=Logger.getLogger(Student.class.getName());
	
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
