import java.util.Scanner;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class Euler {

    private Scanner input;

    private int choice;

    public Euler() {
        input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Euler euler = new Euler();
        euler.run();
    }

    void run() {
        System.out.println(Utilities.isPrime(25));
        String response;
        boolean err = false;
        System.out.printf("\n--Welcome to Euler Solutions--\n");
        System.out.println("By Sachandhan Ganesh");
        while (true) {
            do {
                System.out.print("\n\n");
                System.out.print("Please choose an Euler problem (q to quit): ");
                response = input.nextLine();
                if (response.toLowerCase().equals("q")) {
                    System.out.printf("\nThank you!\n\n");
                    System.exit(0);
                }
    			try {
    				choice = Integer.parseInt(response);
                } catch (NumberFormatException e) {
    				err = true;
                }
            } while (err);
            pickProblem(choice);
        }
    }

    void pickProblem(int i) {
        System.out.print("\n");
        switch (i) {
            case 1: one(); break;
            case 2: two(); break;
            case 3: three(); break;
            case 4: four(); break;
            case 5: five(); break;
            default: System.out.println("Problem has not been solved yet."); break;
        }
    }

    void one() {
        final int cap = 1000;
        int i = 3, sum = 0;
        do {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i++;
            else
                i++;
        } while (i < cap);
        Utilities.showAnswer("Sum of all the multiples of 3 or 5 below " + cap + ".", sum);
    }

    void two() {
        final int cap = 4000000;
        int sum = 0, tempSum;
        int[] fibPair = {1, 2};
        do {
            if (fibPair[1] % 2 == 0)
                sum += fibPair[1];
            tempSum = fibPair[0] + fibPair[1];
            fibPair[0] = fibPair[1];
            fibPair[1] = tempSum;
        } while (fibPair[1] < cap);
        Utilities.showAnswer("Sum of the even-valued terms under " + cap + " of the Fibonacci Sequence.", sum);
    }

    void three() {
        final long prime = 600851475143L;
        long primeFactor = 1, i = (long)Math.sqrt(prime);
        do {
            if (prime % i == 0)
                if (Utilities.isPrime(i))
                    primeFactor = i;
            i--;
        } while (i > 1 && primeFactor == 1);
        Utilities.showAnswer("Largest prime factor of the number " + prime + ".", primeFactor);
    }

    void four() {
        String result;
        int palindrome = 0;
        for (int i = 999; i > 99; i--)
            for (int k = 999; k > 99; k--)
                if (Utilities.isPalindrome(i * k) && palindrome < i * k)
                    palindrome = i * k;
        Utilities.showAnswer("Largest palindrome made from the product of two 3-digit numbers.", palindrome);
    }

    void five() {
        final int min = 1,
        max = 20;
        long multiple = 1;
        for (int i = min; i <= max; i++)
            if (multiple % i != 0) {
                if (i % 2 == 0)
                    multiple *= 2;
                else if (i % 3 == 0)
                    multiple *= 3;
                else
                    multiple *= i;
                System.out.println("\nNum (" + multiple + "): " + i + "\n");
            }
        Utilities.showAnswer("Smallest positive number that is evenly divisible\nby all of the numbers from " + min + " to " + max + ".", multiple);
    }

}
