package si.um.feri.aiv.ejb;

import jakarta.ejb.Remote;

@Remote
public interface CalculatorRemote {

	double add(double a, double b);

	double mul(double a, double b);
	
	double getHistory();

	Calculation getLastCalculation();

}