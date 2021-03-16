package si.um.feri.aiv.ejb;

import javax.ejb.Local;

@Local
public interface CalculatorLocal {

	double add(double a, double b);

	double sub(double a, double b);

	double mul(double a, double b);

	double div(double a, double b);

	double getHistory();

	Calculation getLastCalculation();

}