package si.um.feri.aiv.calc;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculation implements Serializable {

	private static final long serialVersionUID = -3889051342666301623L;

	public Calculation() {
		
	}
	
	public Calculation(String calc, double result) {
		this.calc = calc;
		this.result = result;
	}

	private int id;
	
	private String calc;
	
	private double result;
	
	@Override
	public String toString() {
		return calc + " = " + result + " (id: "+id+")";
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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
