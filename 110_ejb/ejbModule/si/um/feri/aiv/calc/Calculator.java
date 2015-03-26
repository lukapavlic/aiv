package si.um.feri.aiv.calc;

import javax.ejb.Remote;

@Remote
public interface Calculator {

	double add(double a, double b);

	double sub(double a, double b);

	double mul(double a, double b);

	double div(double a, double b);

	double getHistory();

	Calculation getLastCalculation();

}