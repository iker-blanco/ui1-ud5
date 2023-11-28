package webexercise;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class WebClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            WebService stub = (WebService) registry.lookup("WebService");

            // Example usage
            stub.consultarWeb("https://google.com");
            System.out.println("Web content downloaded.");

            List<String> links = stub.consultarWebLinks("https://google.com");
            System.out.println("Links found: " + links.size());
            for (String link : links) {
                System.out.println(link);
            }

            // Delete the downloaded file
            stub.borrarDatos();
            System.out.println("Downloaded data deleted.");

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
