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
    int yourPlayerId;

    public SuperTGame(int numPlayers) {
        deck = new SuperTDeck();
        this.numPlayers = numPlayers;
        System.out.println("Creating New Game of  " + numPlayers +" Players.........");
        // RETIRED assignpositions();
        selectDealer();
        new SuperTDeck();
        dealRandomCardsToPlayers();
        selectYouasPlayer();
        SuperTHumanplayer hupl = getHumanPlayer();
        showPlayer(hupl);
       //showPlayer(players[1]);
        //showPlayer(players[2]);

    }


    private void showPlayer(SuperTHumanplayer hupl) {
        System.out.println("You are Player "+ hupl );
    }

    private SuperTHumanplayer getHumanPlayer() {
        return players[yourPlayerId];
    }


    private void selectYouasPlayer() {
        yourPlayerId = 0;
    }

    //RETIRED Instances the number of player objects
    /*private void assignpositions() {
        SuperTHumanplayer player = new SuperTHumanplayer(0);
        for (int i = 1; i < numPlayers; i++) {
            SuperTBotPlayer bplayer = new SuperTBotPlayer(i);
            System.out.println(bplayer);
        }
        System.out.println(player);
    }*/

    public void selectDealer() {
        Random ran = new Random();
        int randomDealer = ran.nextInt(numPlayers)+1;
        //TODO set dealer to true on slected number
        System.out.println("Player: " + randomDealer + " is the dealer" + "\n Player: " + (randomDealer-1 + " Will go First") );

    }

    public void dealRandomCardsToPlayers() {
        players = new SuperTHumanplayer[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new SuperTHumanplayer(i);

        }
        for (SuperTHumanplayer player: players) {
            ArrayList<BaseSuperTCard> cards = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard(cards);
        }
    }
}
