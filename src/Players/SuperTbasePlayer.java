package Players;

import Cards.BaseSuperTCard;
import Cards.SuperTTrumpCard;
import Cards.SuperTPlayCard;
import Cards.SuperTDeck;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adroso360 on 30/09/2016.
 */
public abstract class SuperTbasePlayer {
    public int position;
    public ArrayList<BaseSuperTCard> hand;
    public abstract PlayerType getPlayerType();


    public SuperTbasePlayer(int position){
        this.position = position;
    }
    public String toString() {
        //handTest();
        return String.valueOf((position));
    }

    public void setCard(ArrayList<BaseSuperTCard> cards) {
        hand = cards;
    }

    public  void handTest(){
        SuperTPlayCard lol = (SuperTPlayCard) hand.get(1);
        System.out.println(lol.title);

    }
    public enum PlayerType{
        BOT,
        HUMAN,
    }
}
