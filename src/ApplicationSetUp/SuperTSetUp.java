package ApplicationSetUp; /**
 * Created by Adroso360 on 27/08/2016.
 */
import Gameplay.SuperTGame;

import java.util.*;
public class SuperTSetUp {
    public static void main(String[] args) {

        boolean menuCheck = true;
        displayWelcome();
        while (menuCheck) {
            displayMenu();
            int userChoice = getUserMenuInput();
            while (userChoice != 1 && userChoice != 2 && userChoice != 3) {
                System.out.println("Invalid Input");
                displayMenu();
                userChoice =getUserMenuInput();
            }
            switch (userChoice) {
                case 1:
                    menuCheck =false;
                    startNewGame();
                    break;
                case 2:
                    displayGameInfo();
                    break;
                case 3:
                    menuCheck = false;
                    System.exit(1);
                    break;
            }
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
        while (numPlayers != 3 && numPlayers != 4 && numPlayers != 5) {
            System.out.println("Invalid Input");
            numPlayers = getNumPlayers();
        }
        SuperTGame game = new SuperTGame(numPlayers);
        /*game.selectDealer();*/
        /*System.out.println(Cards.SuperTDeck.Deckbuilder(1));*/
        /*game.dealRandomCardsToPlayers();*/
    }

    private static int getNumPlayers() {
        System.out.println("How many Players? Choose 3 - 5");
        int userInput = 0;
        try {
            userInput = getUserMenuInput();
        }
        catch (InputMismatchException pl) {
            System.out.println("Not a Number Exception");
        }
        return userInput;
    }

    private static int getUserMenuInput() {
        Scanner reader = new Scanner(System.in);
        int userInput = 0;
        try {
            userInput = reader.nextInt();
        } catch (InputMismatchException p2) {
            System.out.println("Not a number Exception");
        }
        return userInput;
    }

    private static void displayMenu() {
        System.out.println("Please Select A Following Action: \n 1 - Play Game \n 2 - Information \n 3 - Exit Game");
    }

    private static void displayWelcome() {
        System.out.println("Welcome to Mineral Supertrumps!");
    }
}
