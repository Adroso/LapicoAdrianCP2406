package Gameplay; /**
 * Created by Adroso360 on 3/09/2016.
 */
import Cards.BaseSuperTCard;
import Players.SuperTHumanplayer;
import Cards.SuperTDeck;
import Players.SuperTbasePlayer;

import java.util.*;
public class SuperTGame {
    private static final int INITIAL_CARD_DEAL = 8 ;
    private int numPlayers;
    private SuperTHumanplayer[] players;
    private SuperTDeck deck;

    public SuperTGame(int numPlayers) {
        this.numPlayers = numPlayers;
        assignpositions();
        selectDealer();
        new SuperTDeck();

    }

    private void assignpositions() {
        for (int i = 0; i < numPlayers; i++){
            SuperTbasePlayer player = new SuperTbasePlayer(i);
            System.out.println(player.toString());
        }

    }

    public void selectDealer() {
        Random ran = new Random();
        int randomDealer = ran.nextInt(numPlayers)+1;
        System.out.println("Player: " + randomDealer + " is the dealer");

    }

    public void dealRandomCardsToPlayers() {
        players = new SuperTHumanplayer[numPlayers];

        for (SuperTHumanplayer player: players) {
            ArrayList<BaseSuperTCard> card = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard();
        }
    }
}
