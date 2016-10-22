package Players;
import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;
import GUI.GameW;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by Adroso360 on 1/10/2016.
 */
public class HumanHandle {
    private boolean wasInputEntered = false;
    private String categoryWasSelected = "";
    private int cardWasSelected;
    public static HumanHandle humanHandle;

    public HumanHandle(){
        humanHandle = this;
    }

    public String getCategory(String categories) {
        //System.out.println("\n Choose a Category: \n");
        String[] localCats = categories.split(", ");
        //handles if there is only 1 category passed in.
        if (localCats.length == 1) {
            return localCats[0];
        }
        for (int i = 0; i < localCats.length; i++) {
            System.out.println(i + " : " + localCats[i]);
        }
        //int userInput = -1;
        // GUI
            GameW.gameW.displayCatChoice();

            while (!wasInputEntered){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasInputEntered = false;
            GameW.gameW.hideCatChoice();
        return categoryWasSelected;
        //return localCats[userInput];
    }

    public Card getCard(Card currentCard, String currentCat, Player currentPlayer) {
        //GUI
        GameW.gameW.handGUIGenerator(currentPlayer.hand);
        System.out.println("\nChoose A Card: \n");
        //handles if there is only 1 category passed in.
        for (int i = 0; i < currentPlayer.hand.size(); i++) {
            System.out.println(i + " : " + currentPlayer.hand.get(i).toString());
        }
        System.out.println(currentPlayer.hand.size() + " : Don't Play A Card");
        int userInput = -1;
        while (userInput < 0 || userInput > currentPlayer.hand.size()) {
            try {
                System.out.println("Enter Your choice: ");
                //userInput = new Scanner(System.in).nextInt();
                //GUI
                while (!wasInputEntered){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                userInput = cardWasSelected;
                wasInputEntered = false;

                if (userInput == currentPlayer.hand.size()) {
                    return currentCard;
                }
            } catch (InputMismatchException p2) {
                System.out.println("Please Enter Valid Number Input");
            }
            if (userInput > 0 && userInput < currentPlayer.hand.size()) {
                if (currentCard instanceof PlayCard && !currentPlayer.hand.get(userInput).isBetterThan((PlayCard) currentCard, currentCat)) {
                    System.out.println(currentPlayer.hand.get(userInput).title + " is not better than " + currentCard.title);
                    userInput = -1;
                } else if (currentCard instanceof TrumpCard) {

                    return currentPlayer.hand.get(userInput);
                }
            } else {
                System.out.println("Please choose a valid option"); // handles if user inputs greater than List
            }
        }

        //return cardWasSelected;
        return currentPlayer.hand.get(userInput);
    }

    public void categoryNotifier(String category){
        categoryWasSelected = category;
        wasInputEntered = true;
    }
    public void cardNotifier(int selectedCard){
        cardWasSelected = selectedCard;
        wasInputEntered = true;
    }
}
