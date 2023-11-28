package remotecountexercise;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CountServer {
    public static void main(String[] args) {
        try {
            Count stub = new CountImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Default RMI port
            registry.bind("Count", stub);
            System.out.println("Count Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}