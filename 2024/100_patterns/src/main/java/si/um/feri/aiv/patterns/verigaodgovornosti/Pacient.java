package si.um.feri.aiv.patterns.verigaodgovornosti;

public class Pacient {

     public enum Tezava{ZLOMLJENA_NOGA,GLAVOBOL,ZOBOBOL,BOLECA_USESA,OPILEK_V_OCESU};

    public Pacient(Tezava kajJeNarobe) {
        this.kajJeNarobe = kajJeNarobe;
    }

    private Tezava kajJeNarobe;

    public Tezava getKajJeNarobe() {
        return kajJeNarobe;
    }

    public void setKajJeNarobe(Tezava kajJeNarobe) {
        this.kajJeNarobe = kajJeNarobe;
    }

}
