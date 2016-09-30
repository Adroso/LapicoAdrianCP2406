package Gameplay; /**
 * Created by Adroso360 on 3/09/2016.
 */
import Cards.BaseSuperTCard;
import Players.SuperTBotPlayer;
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
        System.out.println("Creating New Game of  " + numPlayers +" Players.........");
        assignpositions();
        selectDealer();
        new SuperTDeck();

    }

    //Instances the number of player objects
    private void assignpositions() {
        SuperTHumanplayer player = new SuperTHumanplayer(0);
        for (int i = 1; i < numPlayers; i++) {
            SuperTBotPlayer bplayer = new SuperTBotPlayer(i);
            System.out.println(bplayer);
        }
        System.out.println(player);
    }

    public void selectDealer() {
        Random ran = new Random();
        int randomDealer = ran.nextInt(numPlayers)+1;
        //TODO set dealer to true on slected number
        System.out.println("Player: " + randomDealer + " is the dealer");

    }

    public void dealRandomCardsToPlayers() {
        players = new SuperTHumanplayer[numPlayers];

        for (SuperTHumanplayer player: players) {
            ArrayList<BaseSuperTCard> card = deck.dealCards(INITIAL_CARD_DEAL);
            //player.setCard();
        }
    }
}
