package si.um.feri.aiv.patterns.verigaodgovornosti.veriga;

import si.um.feri.aiv.patterns.verigaodgovornosti.Pacient;

public class Oftalmolog implements Zdravnik {

    public Oftalmolog() {
    }

    public Oftalmolog(Zdravnik naslednji) {
        this.naslednji = naslednji;
    }

    private Zdravnik naslednji;

    @Override
    public void pozdravi(Pacient pacient) {
        if (Pacient.Tezava.OPILEK_V_OCESU.equals(pacient.getKajJeNarobe())) {
            System.out.println("Prišli ste na pravo mesto. Poglejte sem.");
            return;
        }
        if (naslednji!=null) naslednji.pozdravi(pacient);
    }

}
