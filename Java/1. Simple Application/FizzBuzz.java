import java.util.Scanner;


public class FizzBuzz {

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        run();
    }


    public static void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("FizzBuzz!!\nEnter a Number: ");

        String temp = scanner.nextLine();

        while(!isNumeric(temp)) {
            System.out.println("Invalid Input! Try Again!!");
            temp = scanner.nextLine();
        }

        int input = Integer.parseInt(temp);

        if (input % 5 == 0) {
            if (input % 3 == 0) System.out.println("FizzBuzz!");
            else System.out.println("Fizz!");
        } 
        else if (input % 3 == 0) System.out.println("Buzz!");
        else System.out.println(input);

        scanner.close();
    }
}
