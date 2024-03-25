package si.um.feri.aiv.patterns.state.stanja;

import si.um.feri.aiv.patterns.state.Oseba;

public class SlaboPocutjeOsebe implements PocutjeOsebe {

    @Override
    public void izvajajAktivnost(Oseba oseba) {
        oseba.sprehajajSe();
    }

    @Override
    public String toString() {
        return "slabo počutje";
    }

}
