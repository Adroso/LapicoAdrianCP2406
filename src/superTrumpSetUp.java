/**
 * Created by Adroso360 on 27/08/2016.
 */
import java.util.*;
public class superTrumpSetUp {
    public static void main(String[] args) {

        displayWelcome();
        displayMenu();
        int opt = getUserMenuInput();
        System.out.println(opt);
    }

    private static int getUserMenuInput() {
        Scanner reader = new Scanner(System.in);
        int userInput = reader.nextInt();
        return userInput;
    }

    private static void displayMenu() {
        System.out.println("Please Select A Following Action: \n 1 - Play Game \n 2 - Information \n 3 - Exit Game");
    }

    private static void displayWelcome() {
        System.out.println("Welcome to Mineral Supertrumps!");
    }
}
