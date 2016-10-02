package Players;

import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;
import java.util.Random;

/**
 * Created by Adroso360 on 1/10/2016.
 */
public class BotAI {
    public Card chooseCard(Card currentCard, String currentCat, Player currentPlayer) {
        if (currentCard == null){
            for (Card card : currentPlayer.hand){
                if (card instanceof PlayCard){
                    return card;
                }
            }
        }
        for (Card card : currentPlayer.hand) {
            if (card instanceof PlayCard && currentCard instanceof PlayCard){
                if(card.isBetterThan((PlayCard) currentCard, currentCat)){
                    return card;
                }

            }
            else
                if (currentCard instanceof TrumpCard && card instanceof PlayCard){
                return card;
                }

        }
        for (Card card : currentPlayer.hand){
            if (card instanceof TrumpCard){
                return card;
            }
        }
        if(currentCard == null){
            System.out.println(currentPlayer.hand.size());
            throw new NullPointerException("Current card is null :(");
        }
        return currentCard;
    }

    public String chooseCategory(String categories){
       String[] selectCat =  categories.split(", ");
        return selectCat[new Random().nextInt(selectCat.length)];
    }
}
