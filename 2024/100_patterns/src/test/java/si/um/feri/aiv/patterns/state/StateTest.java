package si.um.feri.aiv.patterns.state;

import org.junit.Test;
import si.um.feri.aiv.patterns.state.stanja.DobroPocutjeOsebe;
import si.um.feri.aiv.patterns.state.stanja.SlaboPocutjeOsebe;

public class StateTest {

    @Test
    public void dobroPocutjeTest() {
        Oseba peterKlepec=new Oseba("Peter","Klepec");
        peterKlepec.setTrenutnoPocutje(new DobroPocutjeOsebe());
        peterKlepec.ravnajGledeNaPocutje();
    }

    @Test
    public void slaboPocutjeTest() {
        Oseba martinKrpan=new Oseba("Martin","Krpan");
        martinKrpan.setTrenutnoPocutje(new SlaboPocutjeOsebe());
        martinKrpan.ravnajGledeNaPocutje();
    }

}
