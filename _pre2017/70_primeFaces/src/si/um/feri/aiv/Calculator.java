package si.um.feri.aiv;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "kalk")
@SessionScoped
public class Calculator {

	private List<Result> history=new ArrayList<Result>();
	
	private int a;

	private int b;

	private int res;

	public void add() {
		res = a + b;
		history.add(new Result(a + " + " + b, res));
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public List<Result> getHistory() {
		return history;
	}

}
