package si.um.feri.aiv.ejb;

import java.io.Serializable;

public class Calculation implements Serializable {

	private static final long serialVersionUID = -3889051342666301623L;

	public Calculation() {
	}

	public Calculation(String calc, double result) {
		this.calc = calc;
		this.result = result;
	}

	private String calc;

	private double result;

	@Override
	public String toString() {
		return calc + " = " + result;
	}

	public String getCalc() {
		return calc;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

}
