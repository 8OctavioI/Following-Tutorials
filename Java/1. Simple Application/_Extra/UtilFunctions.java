import java.util.Scanner;

class UtilFunctions {

    public boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.close();
    }

}
