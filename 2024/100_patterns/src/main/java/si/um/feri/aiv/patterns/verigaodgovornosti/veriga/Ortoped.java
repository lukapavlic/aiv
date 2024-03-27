package si.um.feri.aiv.patterns.verigaodgovornosti.veriga;

import si.um.feri.aiv.patterns.verigaodgovornosti.Pacient;

public class Ortoped implements Zdravnik {

    public Ortoped(Zdravnik naslednji) {
        this.naslednji = naslednji;
    }

    private Zdravnik naslednji;

    @Override
    public void pozdravi(Pacient pacient) {
        if (Pacient.Tezava.ZLOMLJENA_NOGA.equals(pacient.getKajJeNarobe())) {
            System.out.println("Prišli ste na pravo mesto. Mavec in bergle.");
        }
        if (naslednji!=null) naslednji.pozdravi(pacient);
    }

}
