package si.um.feri.aiv.patterns.verigaodgovornosti.veriga;

import si.um.feri.aiv.patterns.verigaodgovornosti.Pacient;

public class Zobozdravnik implements Zdravnik {

    public Zobozdravnik(Zdravnik naslednji) {
        this.naslednji = naslednji;
    }

    public Zobozdravnik() {
    }

    private Zdravnik naslednji;

    @Override
    public void pozdravi(Pacient pacient) {
        if (Pacient.Tezava.ZOBOBOL.equals(pacient.getKajJeNarobe())) {
            System.out.println("Prišli ste na pravo mesto. Plomba.");
            return;
        }
        if (naslednji!=null) naslednji.pozdravi(pacient);
    }

}
