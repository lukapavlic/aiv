package si.um.feri.aiv.patterns.iterator.iteratorji;

public interface Iterator<E> {

	E naprej() throws SmoZeNaKoncuKolekcijeException;
	boolean jeKonec();
	
}
