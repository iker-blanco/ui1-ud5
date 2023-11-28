package primeexercise;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PrimeServer {
    public static void main(String[] args) {
        try {
            PrimeService stub = new PrimeServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("PrimeService", stub);
            System.out.println("Prime service started");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
