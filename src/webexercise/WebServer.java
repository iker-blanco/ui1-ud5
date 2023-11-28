package webexercise;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WebServer {
    public static void main(String[] args) {
        try {
            WebService stub = new WebServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("WebService", stub);
            System.out.println("Web service started");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}