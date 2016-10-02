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
    private final ArrayList<Player> playersNotWonYet;
    private final ArrayList<Player> playersWhoWon;

    public SuperTRound(ArrayList<Player> players, Player startingPlayer, SuperTDeck deck, ArrayList<Player> playersNotWonYet, ArrayList<Player> playersWhoWon) {
        this.playersNotWonYet = playersNotWonYet;
        this.playersWhoWon = playersWhoWon;
        this.players = players;
        this.startingPlayer = startingPlayer;
        this.deck = deck;
    }

    public Player beginRound() {
        System.out.println("NEW ROUND HAS STARTED");
        Player currentPlayer = startingPlayer;
        String currentCat = findCategory(currentPlayer, "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity");
        Card currentCard = findPickCard(currentPlayer, currentCat, null);
        System.out.println(currentPlayer.position + "posistion");
        System.out.println(currentCard.title + "posistion");
        System.out.println(currentPlayer.position + " played the card: " + currentCard.title);
        currentPlayer.hand.remove(currentCard);
        didPlayerWin(currentPlayer);
        Collections.rotate(players, players.indexOf(currentPlayer) * -1);
        Collections.rotate(players, - 1);

        // Round Handler
        while (players.size() > 1){
            currentPlayer = players.get(0);
            Card oldCard = currentCard;
            currentCard = findPickCard(currentPlayer, currentCat, currentCard);
            didPlayerWin(currentPlayer);
            if(currentCard.equals(oldCard)){
                System.out.println(currentPlayer.position + " did not play a card and is removed from the round");
                players.remove(currentPlayer);
                //Checks if the deck is empty upon drawing.
                try {
                    currentPlayer.hand.add(deck.takeCard());
                }
                catch (Exception p4){
                    System.out.println("The Deck is Empty, Unable to draw A card.");
                }

            } else if(currentCard instanceof TrumpCard){
                System.out.println(currentPlayer.position + " played the trump card: " + currentCard.title);
                currentCat = findCategory(currentPlayer, ((TrumpCard) currentCard).categories);
                currentPlayer.hand.remove(currentCard);
                Collections.rotate(players, -1);
            } else {
                System.out.println(currentPlayer.position + " played the card: " + currentCard.title);
                currentPlayer.hand.remove(currentCard);
                Collections.rotate(players, -1);
            }
        }
        System.out.println("Player who won: " + players.get(0));
        return players.get(0);
    }

    private void didPlayerWin(Player currentPlayer) {
        if(currentPlayer.hand.size() == 0){
            System.out.println(currentPlayer.position + " won and has no cards!");
            playersNotWonYet.remove(currentPlayer);
            playersWhoWon.add(currentPlayer);
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
