package webexercise;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface WebService extends Remote {
    void consultarWeb(String url) throws RemoteException;
    void borrarDatos() throws RemoteException;
    List<String> consultarWebLinks(String url) throws RemoteException;
}
