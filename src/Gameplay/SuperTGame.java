package Gameplay; /**
 * Created by Adroso360 on 3/09/2016.
 */
import Cards.Card;
import Players.Bot;
import Players.Hooman;
import Cards.SuperTDeck;
import Players.Player;

import java.util.*;
public class SuperTGame {
    private static final int INITIAL_CARD_DEAL = 8 ;
    private int numPlayers;
    private Player[] players;
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
        Player hupl = getHumanPlayer();
        showPlayer(hupl);
        new SuperTRound(arrayToList(players), players[0]).beginRound();
    }


    private void showPlayer(Player hupl) {
        System.out.println("You are Player "+ hupl );
    }

    private Player getHumanPlayer() {
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
        players = new Player[numPlayers];
        players[0] = new Hooman(0);
        for (int i = 1; i < numPlayers; i++){
            players[i] = new Bot(i);

        }
        for (Player player: players) {
            ArrayList<Card> cards = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard(cards);
        }
    }
    public ArrayList<Player> arrayToList(Player[] players){
       ArrayList<Player> newArrayList = new ArrayList<Player>();
        for (Player superTbasePlayer:players){
            newArrayList.add(superTbasePlayer);
        }
        return newArrayList;
    }
}

//////////TEST CODE or OLD CODE///////////////
//RETIRED Instances the number of player objects
    /*private void assignpositions() {
        Hooman player = new Hooman(0);
        for (int i = 1; i < numPlayers; i++) {
            Bot bplayer = new Bot(i);
            System.out.println(bplayer);
        }
        System.out.println(player);
    }*/