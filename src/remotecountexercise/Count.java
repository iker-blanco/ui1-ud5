package remotecountexercise;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Count extends Remote {
    void increment() throws RemoteException;
    int getSum() throws RemoteException;
}