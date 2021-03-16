package si.um.feri.aiv;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;

@ManagedBean(name = "kalk")
@SessionScoped
public class Calculator {

	private List<Result> history=new ArrayList<Result>();
	
	private int a;

	private int b;

	private int res;
	
	private Result resultToAdd=new Result();

	public void add() {
		res = a + b;
		history.add(new Result(a + " + " + b, res));
	}
	
	public void removeFromHistory(long id) {
		for (Iterator<Result> it = history.iterator(); it.hasNext();) {
			if (it.next().getId()==id) {
				it.remove();
				return;
			}
		}
	}
	
	public void addNewResult() {
		history.add(resultToAdd);
		resultToAdd=new Result();
	}
	
	public String manualAdd() {
		addNewResult();
		return "addAgain";
	}
	
	public String manualAddAndView() {
		addNewResult();
		return "ok";
	}
	
	//binding case
	private HtmlDataTable table;
	
	public void removeFromTable() {		
		Result r=(Result)table.getRowData();
		history.remove(r);
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

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}

	public Result getResultToAdd() {
		return resultToAdd;
	}

	public void setResultToAdd(Result resultToAdd) {
		this.resultToAdd = resultToAdd;
	}
	
}
