package si.um.feri.aiv.patterns.verigaodgovornosti.veriga;

import si.um.feri.aiv.patterns.verigaodgovornosti.Pacient;

public class ORL implements Zdravnik {

    public ORL() {
    }

    public ORL(Zdravnik naslednji) {
        this.naslednji = naslednji;
    }

    private Zdravnik naslednji;

    @Override
    public void pozdravi(Pacient pacient) {
        if (Pacient.Tezava.BOLECA_USESA.equals(pacient.getKajJeNarobe())) {
            System.out.println("Prišli ste na pravo mesto. Kapljice za v uho.");
            return;
        }
        if (naslednji!=null) naslednji.pozdravi(pacient);
    }

}
