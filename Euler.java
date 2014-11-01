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
            case 6: six(); break;
            default: System.out.println("Problem has not been solved yet."); break;
        }
    }

    /*
    * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
    * The sum of these multiples is 23.
    *
    * Find the sum of all the multiples of 3 or 5 below 1000.
    *
    * Remember that checking each case consecutively is better than separate processes.
    */
    void one() {
        final int cap = 1000;
        int i = 3, sum = 0;
        // While the value is less than the cap
        do {
            // If the value is divisible by 3 or 5
            if (i % 3 == 0 || i % 5 == 0)
                // Add the value to the sum and increment the value
                sum += i++;
            // Otherwise simply increment the value
            else
                i++;
        } while (i < cap);
        Utilities.showAnswer("Sum of all the multiples of 3 or 5 below " + cap + ".", sum);
    }

    /*
    * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
    * By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    *
    * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
    * find the sum of the even-valued terms.
    *
    * Remember that in a sequence, when comparing two numbers a shift in the sequence
    * means a shift in the compared two values.
    */
    void two() {
        final int cap = 4000000;
        int sum = 0, tempSum;
        int[] fibPair = {1, 2}; // First compared terms of the sequence
        // While the second compared term is less than the cap
        do {
            // If the second term is divisible by 2
            if (fibPair[1] % 2 == 0)
                // Add it to the sum
                sum += fibPair[1];
            // Proceed in the sequence and change compared terms
            tempSum = fibPair[0] + fibPair[1];
            fibPair[0] = fibPair[1];
            fibPair[1] = tempSum;
        } while (fibPair[1] < cap);
        Utilities.showAnswer("Sum of the even-valued terms under " + cap + " of the Fibonacci Sequence.", sum);
    }

    /*
    * The prime factors of 13195 are 5, 7, 13 and 29.
    *
    * What is the largest prime factor of the number 600851475143?
    *
    * Remember that checking the divisibility using every value < the given value will not work.
    * In order to effectively check if a number is prime, you have to acknowledge that by taking
    * the sqrt() of any value, the number of values to compare divisiblity has perceivably decreased,
    * without losing integrity. Then, work downwards, in order to find the _largest_ prime factor.
    */
    void three() {
        final long prime = 600851475143L;
        long primeFactor = 1,
        i = (long)Math.sqrt(prime); // Take the sqrt() of the given prime
        // While the divisor is greater than 1 and the factor has not been determined
        do {
            // If the prime is evenly divided
            if (prime % i == 0)
                // If the divisor is prime
                if (Utilities.isPrime(i))
                    // Then the factor is determined
                    primeFactor = i;
            // Otherwise decrement the divisor
            i--;
        } while (i > 1 && primeFactor == 1);
        Utilities.showAnswer("Largest prime factor of the number " + prime + ".", primeFactor);
    }

    /*
    * A palindromic number reads the same both ways. The largest palindrome made from the product
    * of two 2-digit numbers is 9009 = 91 × 99.
    *
    * Find the largest palindrome made from the product of two 3-digit numbers.
    *
    * Remember that in order to check the validity of a palindrome, the second half must
    * be reversed and then compared to the first half.
    */
    void four() {
        String result;
        int palindrome = 0;
        // For two values > 99 and < 1000
        for (int i = 999; i > 99; i--)
            for (int k = 999; k > 99; k--)
                // If they both multiply together to produce a palindromic number
                if (Utilities.isPalindrome(i * k) && palindrome < i * k)
                    // Store that palindrome
                    palindrome = i * k;
        Utilities.showAnswer("Largest palindrome made from the product of two 3-digit numbers.", palindrome);
    }

    /*
    * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    *
    * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    *
    * Remember that multiples of a number carry extra factors; multiply by the base/root factor instead.
    */
    void five() {
        final int min = 1,
        max = 20;
        long multiple = 1; // Is compared to numbers > min and < max
        // For a value > min and < max
        for (int i = min; i <= max; i++)
            // If it does not evenly divide the decided multiple
            if (multiple % i != 0) {
                // If it is divisible by 2
                if (i % 2 == 0)
                    // Multiply the given multiple by 2
                    multiple *= 2;
                // Otherwise if it is divisible by 3
                else if (i % 3 == 0)
                    // Multiple the given multiple by 3
                    multiple *= 3;
                // Otherwise simply multiply the given multiple by the value
                else
                    multiple *= i;
            }
        Utilities.showAnswer("Smallest positive number that is evenly divisible\nby all of the numbers from " + min + " to " + max + ".", multiple);
    }

    /*
    * The sum of the squares of the first ten natural numbers is: 1^2 + 2^2 + ... + 10^2 = 385
    * The square of the sum of the first ten natural numbers is: (1 + 2 + ... + 10)^2 = 55^2 = 3025
    * Hence the difference between the sum of the squares of the first ten natural numbers
    * and the square of the sum is 3025 − 385 = 2640.
    *
    * Find the difference between the sum of the squares of the first one hundred natural numbers
    * and the square of the sum.
    *
    * Remember that Math.pow(x, 2) is the same as x * x! Keep code simple.
    */
    void six() {
        long sumOfSquares = 0, squareOfSum = 0;
        for (int i = 1; i <= 100; i++)
            sumOfSquares += i * i;
        for (int i = 1; i <= 100; i++)
            squareOfSum += i;
        squareOfSum *= squareOfSum;
        Utilities.showAnswer("Difference between the sum of the squares of the first 100 natural numbers and the square of the sum.",
            squareOfSum - sumOfSquares);
    }

}
