package si.um.feri.aiv;

import javax.ejb.Remote;

import si.um.feri.aiv.ejb.Calculation;

@Remote
public interface Calc {

	double add(double a, double b);

	double sub(double a, double b);

	double mul(double a, double b);

	double div(double a, double b);

	double getHistory();

	Calculation getLastCalculation();

}