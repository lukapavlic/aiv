package si.um.feri.aiv.patterns.state.stanja;

import si.um.feri.aiv.patterns.state.Oseba;

public class DobroPocutjeOsebe implements PocutjeOsebe {

    @Override
    public void izvajajAktivnost(Oseba oseba) {
        oseba.prepevaj();
        oseba.plesi();
    }

    @Override
    public String toString() {
        return "dobro počutje";
    }


}
