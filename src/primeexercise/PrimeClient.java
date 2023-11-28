package primeexercise;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class PrimeClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            PrimeService stub = (PrimeService) registry.lookup("PrimeService");

            // Generate and test 10 random numbers
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int numberToCheck = 2 + random.nextInt(999); // Random number between 2 and 1000
                boolean isPrime = stub.isPrime(numberToCheck);
                System.out.println("Is " + numberToCheck + " a prime number? " + isPrime);
            }

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

