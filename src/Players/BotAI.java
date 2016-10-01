package Players;

import Cards.BaseSuperTCard;
import Cards.SuperTPlayCard;
import Cards.SuperTTrumpCard;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Random;

/**
 * Created by Adroso360 on 1/10/2016.
 */
public class BotAI {
    public BaseSuperTCard chooseCard(BaseSuperTCard currentCard, String currentCat, SuperTbasePlayer currentPlayer) {
        for (BaseSuperTCard card : currentPlayer.hand) {
            if (card instanceof SuperTPlayCard && currentCard instanceof SuperTPlayCard){
                if(card.isBetterThan((SuperTPlayCard) currentCard, currentCat)){
                    return card;
                }

            }
            else
                if (currentCard instanceof SuperTTrumpCard && card instanceof SuperTPlayCard){
                return card;
                }

        }
    }

    public String chooseCategory(String categories){
       String[] selectCat =  categories.split(", ");
        return selectCat[new Random().nextInt(selectCat.length)];
    }
}
