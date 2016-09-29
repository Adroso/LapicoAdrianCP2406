package Gameplay; /**
 * Created by Adroso360 on 3/09/2016.
 */
import Cards.BaseSuperTCard;
import Players.SuperTplayer;
import Cards.SuperTDeck;

import java.util.*;
public class SuperTGame {
    private static final int INITIAL_CARD_DEAL = 8 ;
    private int numPlayers;
    private SuperTplayer[] players;
    private SuperTDeck deck;

    public SuperTGame(int numPlayers) {
        this.numPlayers = numPlayers;
        new SuperTDeck();
    }

    public void selectDealer() {
        Random ran = new Random();
        int randomDealer = ran.nextInt(numPlayers)+1;
        System.out.println("Player: " + randomDealer + " is the dealer");

    }

    public void dealRandomCardsToPlayers() {
        players = new SuperTplayer[numPlayers];

        for (SuperTplayer player: players) {
            ArrayList<BaseSuperTCard> card = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard();
        }
    }
}
