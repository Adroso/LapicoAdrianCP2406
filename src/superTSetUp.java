/**
 * Created by Adroso360 on 27/08/2016.
 */
import java.util.*;
public class superTSetUp {
    public static void main(String[] args) {

        displayWelcome();
        displayMenu();
        int userChoice = getUserMenuInput();
        switch (userChoice){
            case 1: startNewGame();
                break;
            case 2: displayGameInfo();
                break;
            case 3: System.exit(1);
                break;
        }
    }

    private static void displayGameInfo() {
        System.out.println("This is a game designed by to help players learn about the properties\n" +
                "and uses of economically-significant and common rock-forming minerals.\n" +
                "The pack consists of 54 mineral cards and 6 “supertrump” cards.\n" +
                "Each mineral card includes information about the mineral such as the generic chemical formula,\n" +
                "the classification, crystal system, the geological environment where the mineral is\n" +
                "commonly found or formed (igneous, metamorphic, sedimentary, or the mantle), as well as information in the\n" +
                "five playing categories (or trumps) of Hardness, Specific Gravity, Cleavage, Crustal Abundance, and Economic Value.\n" +
                "The first three trump categories relate to distinct physical properties of the mineral,\n" +
                "while last two categories rate the importance of the mineral in terms of abundance in the\n" +
                "Earths crust (continental and oceanic) and value to modern societies.\n" +
                "\n" +
                "Number of players: 3 to 5\n" +
                "\n" +
                "Objective: To be the first player to lose all of your cards");
    }

    private static void startNewGame() {
        int numPlayers = getNumPlayers();
        superTGame game = new superTGame(numPlayers);
        game.selectDealer();
        game.dealRandomCardsToPlayers();
    }

    private static int getNumPlayers() {
        System.out.println("How many Players? Choose 3 - 5");
        int userInput = getUserMenuInput();
        return userInput;
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
