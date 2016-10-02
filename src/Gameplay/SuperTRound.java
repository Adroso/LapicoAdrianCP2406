package Gameplay;
import Cards.Card;
import Cards.SuperTDeck;
import Cards.TrumpCard;
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
    private Player currentPlayer;
    private final SuperTDeck deck;
    private final ArrayList<Player> playersNotWonYet;
    private final ArrayList<Player> playersWhoWon;
    private final String currentCat;
    private final RoundFinishedType roundFinishedType;

    public SuperTRound(ArrayList<Player> players, RoundFinished roundFinished, SuperTDeck deck, ArrayList<Player> playersNotWonYet, ArrayList<Player> playersWhoWon) {
        this.playersNotWonYet = playersNotWonYet;
        this.playersWhoWon = playersWhoWon;
        this.players = players;
        this.currentPlayer = roundFinished.getPlayer();
        this.currentCat = roundFinished.getCat();
        this.roundFinishedType = roundFinished.getRoundFinishType();
        this.deck = deck;
    }

    public RoundFinished beginRound() {
        System.out.println("NEW ROUND HAS STARTED");
        Card currentCard = null;
        if(roundFinishedType.equals(RoundFinishedType.STANDARD)){
            currentCard = findPickCard(currentPlayer, currentCat, null);
            System.out.println(currentPlayer.position + "posistion");
            System.out.println(currentCard.title + "posistion");
            System.out.println(currentPlayer.position + " played the card: " + currentCard.title);
            currentPlayer.hand.remove(currentCard);
            didPlayerWin(currentPlayer);
        }

        Collections.rotate(players, players.indexOf(currentPlayer) * -1);
        Collections.rotate(players, - 1);

        // Round Handler
        while (players.size() > 1){
            currentPlayer = players.get(0);
            Card oldCard = currentCard;
            currentCard = findPickCard(currentPlayer, currentCat, currentCard);
            if(oldCard == null && currentCard == null || oldCard!= null && currentCard.equals(oldCard)){
                System.out.println(currentPlayer.position + " did not play a card and is removed from the round");
                players.remove(currentPlayer);
                //Checks if the deck is empty upon drawing.

                if(deck.count() > 0)
                    currentPlayer.hand.add(deck.takeCard());
                else
                    System.out.println("no cards left in deck to draw");

            } else if(currentCard instanceof TrumpCard){
                System.out.println(currentPlayer.position + " played the trump card: " + currentCard.title);
                currentPlayer.hand.remove(currentCard);
                didPlayerWin(currentPlayer);
                Collections.rotate(players, -1);
                return new RoundFinished(findCategory(currentPlayer, ((TrumpCard) currentCard).categories), currentPlayer, RoundFinishedType.TRUMPCARD);
            } else {
                System.out.println(currentPlayer.position + " played the card: " + currentCard.title);
                currentPlayer.hand.remove(currentCard);
                didPlayerWin(currentPlayer);
                Collections.rotate(players, -1);
            }
        }
        System.out.println("Player who won: " + players.get(0));
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
            System.out.println(currentPlayer.position + " won and has no cards!");
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
            System.out.println("You have choosen: "+ currentCat);

        }
        else
        if (currentPlayer.getPlayerType() == Player.PlayerType.BOT) {
            currentCat = new BotAI().chooseCategory(categories);
            System.out.println("Player: " + currentPlayer + " Has Choosen the Category:  " + currentCat);
        }
        return currentCat;

    }
}
