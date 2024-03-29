package Gameplay; /**
 * Created by Adroso360 on 3/09/2016.
 */
import Cards.Card;
import GUI.GameW;
import GUI.MenuW;
import Players.Bot;
import Cards.SuperTDeck;
import Players.Human;
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

    public SuperTGame(int numPlayers, GameW gameW) {
        deck = new SuperTDeck();
        this.numPlayers = numPlayers;
        System.out.println("Creating New Game of  " + numPlayers +" Players.........");
        selectDealer();
        new SuperTDeck();
        dealRandomCardsToPlayers();

        //Handling the game just for the user
        selectYouasPlayer();
        Player hupl = getHumanPlayer();
        showPlayer(hupl);

        //Handles Round Winners and Overall Game winners.
        Player startingPlayer = players[new Random().nextInt(players.length)];
        ArrayList<Player> playersNotWonYet = arrayToList(players);
        ArrayList<Player> playersWhoWon = new ArrayList<>();
        SuperTRound.RoundFinished roundFinished = new SuperTRound.RoundFinished(SuperTRound.findCategory(startingPlayer, "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity"), startingPlayer, SuperTRound.RoundFinishedType.STANDARD);
        while(playersNotWonYet.size() > 1){
            roundFinished =  new SuperTRound(gameW,arrayToList(playersNotWonYet.toArray(new Player[playersNotWonYet.size()])), roundFinished, deck, playersNotWonYet, playersWhoWon).beginRound();
        }
        for(Player player: playersWhoWon){
            System.out.println((playersWhoWon.indexOf(player) +1) + "Place : Player " + player.position);
        }
        GameW.gameW.buildWinners(playersWhoWon);
        sleependgame();
        GameW.gameW.gameClear();
        new MenuW("New Game");

    }
    private void showPlayer(Player hupl) {
        System.out.println("You are Player "+ hupl +"\n");
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
        startingPlay = randomDealer+1;
        System.out.println("Player: " + randomDealer + " is the dealer"+ "\n");
    }

    public void dealRandomCardsToPlayers() {
        players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++){
            //Change to Bot when done.
            players[i] = new Bot(i);

        }
        players[0] = new Human(0);

        for (Player player: players) {
            ArrayList<Card> cards = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard(cards);
        }
    }
    //Converts to List to be handled by the SuperTRound Class
    public ArrayList<Player> arrayToList(Player[] players){
       ArrayList<Player> newArrayList = new ArrayList<Player>();
        for (Player superTbasePlayer:players){
            newArrayList.add(superTbasePlayer);
        }
        return newArrayList;
    }

    public void sleependgame(){
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
