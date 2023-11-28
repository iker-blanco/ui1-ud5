package remotecountexercise;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CountImpl extends UnicastRemoteObject implements Count {
    private int sum = 0;

    public CountImpl() throws RemoteException {
        super();
    }

    public synchronized void increment() throws RemoteException {
        sum++;
    }
    public synchronized int getSum() throws RemoteException {
        return sum;
    }
}