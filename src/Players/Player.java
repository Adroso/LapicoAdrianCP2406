package Players;

import Cards.Card;
import Cards.PlayCard;

import java.util.ArrayList;

/**
 * Created by Adroso360 on 30/09/2016.
 */
public abstract class Player {
    public int position;
    public ArrayList<Card> hand;
    public abstract PlayerType getPlayerType();


    public Player(int position){
        this.position = position;
    }
    public String toString() {
        return String.valueOf((position));
    }

    public void setCard(ArrayList<Card> cards) {
        hand = cards;
    }

    public enum PlayerType{
        BOT,
        HUMAN,
    }
}
