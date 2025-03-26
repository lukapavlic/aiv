package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("kalkulator")
@SessionScoped
public class Calculator implements Serializable {

    private int a=8;
    private int b;
    private int rezultat;

    public void sestej(){
        System.out.println("sestej "+a+" "+b);
        rezultat=a+b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getRezultat() {
        return rezultat;
    }

    public void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }
}
