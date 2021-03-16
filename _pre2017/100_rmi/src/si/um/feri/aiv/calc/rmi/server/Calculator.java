package si.um.feri.aiv.calc.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements Calc {

	private static final long serialVersionUID = -8325734978425380619L;

	public Calculator() throws RemoteException {
	}

	private double history;
	
	private Calculation last;
	
	@Override
	public double add(double a, double b) throws RemoteException {
		System.out.println("add");
		history=a+b;
		last=new Calculation(a + " + " + b,a+b);
		return a+b;
	}
	
	@Override
	public double sub(double a, double b) throws RemoteException  {
		System.out.println("sub");
		history=a-b;
		last=new Calculation(a + " - " + b,a-b);
		return a-b;
	}
	
	@Override
	public double mul(double a, double b) throws RemoteException  {
		System.out.println("mul");
		history=a*b;
		last=new Calculation(a + " * " + b,a*b);
		return a*b;
	}
	
	@Override
	public double div(double a, double b) throws RemoteException  {
		System.out.println("div");
		history=a/b;
		last=new Calculation(a + " / " + b,a/b);
		return a/b;
	}
	
	@Override
	public double getHistory() throws RemoteException  {
		System.out.println("getHistory");
		return history;
	}
	
	@Override
	public Calculation getLastCalculation() throws RemoteException  {
		System.out.println("getLastCalculation");
		return last;
	}
	
}
