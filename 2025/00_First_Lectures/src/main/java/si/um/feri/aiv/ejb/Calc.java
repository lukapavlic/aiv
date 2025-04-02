package si.um.feri.aiv.ejb;

import jakarta.ejb.Local;

@Local
public interface Calc {

    int add(int a, int b);

}
