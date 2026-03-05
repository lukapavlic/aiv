package si.um.feri.aiv.ejb;

import lombok.Data;
import java.io.Serializable;

@Data
public class Calculation implements Serializable {

	public Calculation(String calc, double result) {
		this.calc = calc;
		this.result = result;
	}

	private String calc;

	private double result;

}
