package Gameplay;
import Cards.Card;
import Cards.PlayCard;
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
    private final Player startingPlayer;
    private final SuperTDeck deck;

    public SuperTRound(ArrayList<Player> players, Player startingPlayer, SuperTDeck deck) {
        this.players = players;
        this.startingPlayer = startingPlayer;
        this.deck = deck;
    }

    public Player beginRound() {
        Player currentPlayer = startingPlayer;
        String currentCat = findCategory(currentPlayer, "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity");
        Card currentCard = findPickCard(currentPlayer, currentCat, null);
        System.out.println(currentPlayer.position + " played the card: " + currentCard.title);
        currentPlayer.hand.remove(currentCard);
        Collections.rotate(players, players.indexOf(currentCard));

        // Round Handler for players left in game
        while (players.size() > 1){
            Collections.rotate(players, 1);
            currentPlayer = players.get(0);
            Card oldCard = currentCard;
            currentCard = findPickCard(currentPlayer, currentCat, currentCard);
            if(currentCard.equals(oldCard)){
                System.out.println(currentPlayer.position + " did not play a card and is removed from the round");
                players.remove(currentPlayer);
                currentPlayer.hand.add(deck.takeCard());
            } else if(currentCard instanceof TrumpCard){
                System.out.println(currentPlayer.position + " played the trump card: " + currentCard.title);
                currentCat = findCategory(currentPlayer, ((TrumpCard) currentCard).categories);
                currentPlayer.hand.remove(currentCard);
            } else {
                System.out.println(currentPlayer.position + " played the card: " + currentCard.title);
                currentPlayer.hand.remove(currentCard);
            }
        }
        return players.get(0);
    }
    public Card findPickCard(Player currentPlayer, String currentCat, Card currentCard){
        if (currentPlayer.getPlayerType() == Player.PlayerType.HUMAN){
            currentCard = new HumanHandle().getCard(currentCard,currentCat,currentPlayer);
        }
        else
        if (currentPlayer.getPlayerType() == Player.PlayerType.BOT){
            currentCard = new BotAI().chooseCard(null, currentCat,startingPlayer);
        }
        return currentCard;
    }
    public String findCategory(Player currentPlayer, String categories){
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
