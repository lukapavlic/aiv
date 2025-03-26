package si.um.feri.aiv;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@SessionScoped
@Named("calc")
@Data
public class Calculator implements Serializable {

    private int first;

    private int second;

    private int result;

    public void add() {
        result = first + second;
    }

}
