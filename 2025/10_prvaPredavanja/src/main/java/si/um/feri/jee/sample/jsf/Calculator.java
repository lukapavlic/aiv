package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named("kalkulator")
//@SessionScoped
//@ApplicationScoped
@RequestScoped
public class Calculator implements Serializable {

    private int a=8;
    private int b;
    private int rezultat;

    public void sestej(){
        System.out.println("sestej "+a+" "+b);
        rezultat=a+b;
    }

}
