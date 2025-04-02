package si.um.feri.aiv.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class CalcBean implements Calc {

    public int add(int a, int b) {
        System.out.println("Adding " + a + " and " + b);
        return a + b;
    }

}
