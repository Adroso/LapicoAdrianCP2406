package Players;

import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Adroso360 on 1/10/2016.
 */
public class HumanHandle {

    public String getCategory(String categories) {
        String[] localCats = categories.split(", ");
        //handles if there is only 1 category passed in.
        if (localCats.length == 1){
            return localCats[0];
        }
        for (int i = 0; i < localCats.length; i++){
            System.out.println(i + " : " + localCats[i] );
        }
        int userInput = -1;
        while (userInput < 0 || userInput > localCats.length-1) {
            try {
                System.out.println("Enter Your choice2: ");
                userInput = new Scanner(System.in).nextInt();
            }
            catch (InputMismatchException p2) {
                System.out.println("Please Enter Valid Input2");
            }
        }
        return localCats[userInput];
    }

    public Card getCard(Card currentCard, String currentCat, Player currentPlayer) {
        //handles if there is only 1 category passed in.
        for (int i = 0; i < currentPlayer.hand.size(); i++){
            System.out.println(i + " : " + currentPlayer.hand.get(i).title );
        }
        System.out.println(currentPlayer.hand.size() + " : Don't Play A Card");
        int userInput = -1;
        while (userInput < 0 || userInput > currentPlayer.hand.size()) {
            try {
                System.out.println("Enter Your choice: ");
                userInput = new Scanner(System.in).nextInt();

                if(userInput == currentPlayer.hand.size()){
                    return currentCard;
                }
            } catch (InputMismatchException p2) {
                System.out.println("Please Enter Valid Input");
            }
            if (userInput < 0 || userInput > currentPlayer.hand.size())
                if (currentCard instanceof PlayCard && !currentPlayer.hand.get(userInput).isBetterThan((PlayCard) currentCard,currentCat)){
                    System.out.println(currentPlayer.hand.get(userInput).title + " is not better than " + currentCard.title);
                    userInput = -1;
                }
                else
                    if (currentCard instanceof TrumpCard){
                    return currentPlayer.hand.get(userInput);
                    }
        }

        return currentPlayer.hand.get(userInput);
    }
}
