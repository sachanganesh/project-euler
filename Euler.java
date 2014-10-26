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
                System.out.print("Please choose an Euler problem: ");
                response = input.nextLine();
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
        System.out.print("\n\n");
        System.out.println(i);
        System.out.print("\n\n");
    }

}
