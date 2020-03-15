package si.um.feri.aiv.staranje.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Lajf extends Remote {

	void postaraj(Oseba o) throws RemoteException;
	
}