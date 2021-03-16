package si.um.feri.aiv.staranje.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LajfBean extends UnicastRemoteObject implements Lajf {

	public LajfBean() throws RemoteException {
	}
	
	public void postaraj(Oseba o) throws RemoteException {
		System.out.println("Staram: "+o);
		o.setStarost(o.getStarost()+1);
		System.out.println("Postaran: "+o);
	}
	
}
