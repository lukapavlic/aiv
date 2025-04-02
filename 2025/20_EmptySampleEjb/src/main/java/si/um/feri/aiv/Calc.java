package si.um.feri.aiv;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import si.um.feri.aiv.ejb.Calculation;

//@Remote
@Local
public interface Calc {

	double add(double a, double b);

	double sub(double a, double b);

	double mul(double a, double b);

	double div(double a, double b);

	double getHistory();

	Calculation getLastCalculation();

}