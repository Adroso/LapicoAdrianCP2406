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
    private SuperTbasePlayer[] players;
    private SuperTDeck deck;
    public int yourPlayerId;
    public int randomDealer;
    public int startingPlay;

    public SuperTGame(int numPlayers) {
        deck = new SuperTDeck();
        this.numPlayers = numPlayers;
        System.out.println("Creating New Game of  " + numPlayers +" Players.........");
        // RETIRED assignpositions();
        selectDealer();
        new SuperTDeck();
        dealRandomCardsToPlayers();

        //Handling the game just for the user
        selectYouasPlayer();
        SuperTbasePlayer hupl = getHumanPlayer();
        showPlayer(hupl);
        new SuperTRound(arrayToList(players), players[startingPlay]).beginRound();
    }


    private void showPlayer(SuperTbasePlayer hupl) {
        System.out.println("You are Player "+ hupl );
    }

    private SuperTbasePlayer getHumanPlayer() {
        return players[yourPlayerId];
    }


    private void selectYouasPlayer() {
        yourPlayerId = 0;
    }

    public void selectDealer() {
        Random ran = new Random();
        randomDealer = ran.nextInt(numPlayers)+1;
        startingPlay = randomDealer-1;
        //TODO set dealer to true on slected number
        System.out.println("Player: " + randomDealer + " is the dealer" + "\n Player: " + (randomDealer-1 + " Will go First") );

    }

    public void dealRandomCardsToPlayers() {
        players = new SuperTbasePlayer[numPlayers];
        for (int i = 0; i < numPlayers; i++){
            players[i] = new SuperTBotPlayer(i);

        }
        for (SuperTbasePlayer player: players) {
            ArrayList<BaseSuperTCard> cards = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard(cards);
        }
    }
    public ArrayList<SuperTbasePlayer> arrayToList(SuperTbasePlayer[] players){
       ArrayList<SuperTbasePlayer> newArrayList = new ArrayList<SuperTbasePlayer>();
        for (SuperTbasePlayer superTbasePlayer:players){
            newArrayList.add(superTbasePlayer);
        }
        return newArrayList;
    }
}

//////////TEST CODE or OLD CODE///////////////
//RETIRED Instances the number of player objects
    /*private void assignpositions() {
        SuperTHumanplayer player = new SuperTHumanplayer(0);
        for (int i = 1; i < numPlayers; i++) {
            SuperTBotPlayer bplayer = new SuperTBotPlayer(i);
            System.out.println(bplayer);
        }
        System.out.println(player);
    }*/