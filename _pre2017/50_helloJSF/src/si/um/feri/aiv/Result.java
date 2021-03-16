package si.um.feri.aiv;

public class Result {

	public Result() {
		this("",0);
	}
	
	public Result(String calc, int val) {
		this.calc = calc;
		this.val = val;
	}

	private String calc;
	
	private int val;

	public String getCalc() {
		return calc;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}
	
}
