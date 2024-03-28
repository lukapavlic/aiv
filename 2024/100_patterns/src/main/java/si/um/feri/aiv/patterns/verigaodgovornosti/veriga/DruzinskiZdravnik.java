package si.um.feri.aiv.patterns.verigaodgovornosti.veriga;

import si.um.feri.aiv.patterns.verigaodgovornosti.Pacient;

public class DruzinskiZdravnik implements Zdravnik {

    public DruzinskiZdravnik() {
    }

    public DruzinskiZdravnik(Zdravnik naslednji) {
        this.naslednji = naslednji;
    }

    private Zdravnik naslednji;

    @Override
    public void pozdravi(Pacient pacient) {
        if (Pacient.Tezava.GLAVOBOL.equals(pacient.getKajJeNarobe())) {
            System.out.println("Prišli ste na pravo mesto. Lekadol in počivanje.");
            return;
        }
        if (naslednji!=null) naslednji.pozdravi(pacient);
    }

}
