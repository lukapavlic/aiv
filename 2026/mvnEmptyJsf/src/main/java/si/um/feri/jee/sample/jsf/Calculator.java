package si.um.feri.jee.sample.jsf;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import lombok.Data;
import java.io.Serializable;
import java.util.logging.Logger;

@Named("calc")
@SessionScoped
@Data
public class Calculator implements Serializable {

    Logger log=Logger.getLogger(this.getClass().getName());

    int firstNumber=5;

    int secondNumber=6;

    int result;

    public String whereToGo() {
        return "page";
    }

    public void add() {
        log.info("adding");
        result = firstNumber + secondNumber;
    }

    public void setFirstNumber(int firstNumber) {
        log.info("setFirstNumber: "+ firstNumber);
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(int secondNumber) {
        log.info("setSecondNumber: "+ secondNumber);
        this.secondNumber = secondNumber;
    }

}
