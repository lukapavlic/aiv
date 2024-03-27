package si.um.feri.aiv.patterns.verigaodgovornosti;

import org.junit.Test;
import si.um.feri.aiv.patterns.verigaodgovornosti.veriga.*;

public class Bolnisnica {

    @Test
    public void bolnisnica() {
        Zdravnik zdravniki=
              new DruzinskiZdravnik(
              new Oftalmolog(
              new ORL(
              new Ortoped(
              new Zobozdravnik(null)
          ))));

        zdravniki.pozdravi(new Pacient(Pacient.Tezava.ZLOMLJENA_NOGA));
        zdravniki.pozdravi(new Pacient(Pacient.Tezava.GLAVOBOL));
        zdravniki.pozdravi(new Pacient(Pacient.Tezava.ZOBOBOL));
        zdravniki.pozdravi(new Pacient(Pacient.Tezava.BOLECA_USESA));
        zdravniki.pozdravi(new Pacient(Pacient.Tezava.OPILEK_V_OCESU));
    }

}
