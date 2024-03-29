package Gameplay;
import Cards.Card;
import Cards.SuperTDeck;
import Cards.TrumpCard;
import GUI.GameW;
import Players.BotAI;
import Players.HumanHandle;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Adroso360 on 1/10/2016.
 */
public class SuperTRound {

    private final ArrayList<Player> players;
    private final GameW gameW;
    private Player currentPlayer;
    private final SuperTDeck deck;
    private final ArrayList<Player> playersNotWonYet;
    private final ArrayList<Player> playersWhoWon;
    private final String currentCat;
    private final RoundFinishedType roundFinishedType;

    public SuperTRound(GameW gameW, ArrayList<Player> players, RoundFinished roundFinished, SuperTDeck deck, ArrayList<Player> playersNotWonYet, ArrayList<Player> playersWhoWon) {
        this.playersNotWonYet = playersNotWonYet;
        this.playersWhoWon = playersWhoWon;
        this.players = players;
        this.currentPlayer = roundFinished.getPlayer();
        this.currentCat = roundFinished.getCat();
        this.roundFinishedType = roundFinished.getRoundFinishType();
        this.deck = deck;
        this.gameW = gameW;
    }

    public RoundFinished beginRound() {

        System.out.println("<<<<<<<<<<<<<< NEW ROUND HAS STARTED >>>>>>>>>>>>>>");
        //GUI
        GameW.gameW.clearStatus();
        GameW.gameW.changeMajorStatus("A NEW ROUND HAS STARTED");
        gameW.displayPlayer(currentPlayer.toString());
        gameW.displayCat(currentCat);
        sleep();
        GameW.gameW.clearMajorStatus();
        Card currentCard = null;
        if(roundFinishedType.equals(RoundFinishedType.STANDARD)){
            currentCard = findPickCard(currentPlayer, currentCat, currentCard);
            //GUI
            gameW.displayCard(currentCard.fileName);

            System.out.println(currentPlayer.position + " played the card: " + currentCard.toString());
            sleep();
            currentPlayer.hand.remove(currentCard);
            didPlayerWin(currentPlayer);
        }
        //gameW.displayCard(currentCard.fileName);
        //Handles current player cycle
        Collections.rotate(players, players.indexOf(currentPlayer) * -1);
        Collections.rotate(players, - 1);

        // Round Handler
        while (players.size() > 1){
            currentPlayer = players.get(0);
            gameW.displayPlayer(currentPlayer.toString());
            Card oldCard = currentCard;
            currentCard = findPickCard(currentPlayer, currentCat, currentCard);
            //GUI
            try {
                gameW.displayCard(currentCard.fileName);
                gameW.displayPlayer(currentPlayer.toString());
                gameW.displayCat(currentCat);
            }
            catch (NullPointerException a){
                gameW.displayCard("Slide66.jpg");
            }
            if(oldCard == null && currentCard == null || oldCard!= null && currentCard.equals(oldCard)){
                System.out.println(currentPlayer.position + " did not play a card and is removed from the round");
                //GUI
                GameW.gameW.changeStatus(currentPlayer.position + " did not play a card and is removed from the round");
                sleep();
                players.remove(currentPlayer);
                //Checks if the deck is empty upon drawing.

                if(deck.count() > 0)
                    currentPlayer.hand.add(deck.takeCard());
                else
                    //GUI
                    GameW.gameW.changeStatus("The Deck Is Empty");
                    GameW.gameW.clearStatus();

            } else if(currentCard instanceof TrumpCard){
                System.out.println("Player: " + currentPlayer.position + " played the trump card: " + currentCard.toString());
                sleep();
                currentPlayer.hand.remove(currentCard);
                didPlayerWin(currentPlayer);
                Collections.rotate(players, -1);
                return new RoundFinished(findCategory(currentPlayer, ((TrumpCard) currentCard).categories), currentPlayer, RoundFinishedType.TRUMPCARD);
            } else {
                System.out.println("Player: " + currentPlayer.position + " played the card: " + currentCard.toString());
                sleep();
                gameW.displayPlayer(currentPlayer.toString());
                gameW.displayCat(currentCat);
                currentPlayer.hand.remove(currentCard);
                didPlayerWin(currentPlayer);
                Collections.rotate(players, -1);
            }
        }
        return new RoundFinished(findCategory(players.get(0), "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity"), players.get(0), RoundFinishedType.STANDARD);
    }

    public static class RoundFinished {
        private final String cat;
        private final Player player;
        private final RoundFinishedType roundFinishType;

        public RoundFinished(String cat, Player player, RoundFinishedType roundFinishType) {
            this.cat = cat;
            this.player = player;
            this.roundFinishType = roundFinishType;
        }

        public String getCat() {
            return cat;
        }

        public Player getPlayer() {
            return player;
        }

        public RoundFinishedType getRoundFinishType() {
            return roundFinishType;
        }
    }

    public enum RoundFinishedType {
        STANDARD,
        TRUMPCARD
    }

    private void didPlayerWin(Player currentPlayer) {
        if(currentPlayer.hand.size() == 0){
            System.out.println("Player: " + currentPlayer.position + " WON! as they have no cards!");
            if (currentPlayer.position ==0){
                GameW.gameW.handGUIGenerator(currentPlayer.hand);
            }
            playersNotWonYet.remove(currentPlayer);
            playersWhoWon.add(currentPlayer);
            players.remove(currentPlayer);
        }
    }

    public Card findPickCard(Player currentPlayer, String currentCat, Card currentCard){
        if (currentPlayer.getPlayerType() == Player.PlayerType.HUMAN){
            currentCard = new HumanHandle().getCard(currentCard,currentCat,currentPlayer);
        }
        else
        if (currentPlayer.getPlayerType() == Player.PlayerType.BOT){
            currentCard = new BotAI().chooseCard(currentCard, currentCat,currentPlayer);
        }
        return currentCard;
    }
    public static String findCategory(Player currentPlayer, String categories){
        String currentCat = null;
        if (currentPlayer.getPlayerType() == Player.PlayerType.HUMAN){
            currentCat = new HumanHandle().getCategory(categories);
            System.out.println("You have chosen: "+ currentCat);

        }
        else
        if (currentPlayer.getPlayerType() == Player.PlayerType.BOT) {
            currentCat = new BotAI().chooseCategory(categories);
            System.out.println("Player: " + currentPlayer + " Has Chosen the Category:  " + currentCat);
        }
        return currentCat;

    }
    // Adds a delay
    public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
