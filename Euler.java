import java.util.Scanner;

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
            pickSolution(choice);
        }
    }

    void pickSolution(int i) {
        System.out.print("\n");
        switch (i) {
            case 1: one(); break;
            case 2: two(); break;
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
        System.out.println("Sum of all the multiples of 3 or 5 below 1000.");
        System.out.printf("\n%d", sum);
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
        System.out.println("Sum of the even-valued terms under 4 million of the Fibonacci Sequence.");
        System.out.printf("\n%d", sum);
    }

}
