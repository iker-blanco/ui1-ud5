package remotecountexercise;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CountClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Count stub = (Count) registry.lookup("Count");

            long totalResponseTime = 0;
            for (int i = 0; i < 1000; i++) {
                long startTime = System.nanoTime();
                stub.increment();
                long endTime = System.nanoTime();

                long responseTime = endTime - startTime;
                totalResponseTime += responseTime;
            }

            double averageResponseTime = totalResponseTime / 1000.0;

            // Retrieve the sum from the server
            int sum = stub.getSum();
            System.out.println("Final value of sum: " + sum);
            System.out.println("Average response time per increment: " + (averageResponseTime / 1e6) + " milliseconds");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}