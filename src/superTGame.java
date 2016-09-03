/**
 * Created by Adroso360 on 3/09/2016.
 */
import java.util.*;
public class superTGame {
    private static final int INITIAL_CARD_DEAL = 8 ;
    private int numPlayers;
    private superTplayer [] players;
    private superTDeck deck;

    public superTGame(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void selectDealer() {
        Random ran = new Random();
        int randomDealer = ran.nextInt(numPlayers)+1;
        System.out.println(randomDealer);

    }

    public void dealRandomCardsToPlayers() {
        players = new superTplayer[numPlayers];

        for (superTplayer player: players) {
            ArrayList<superTCard> card = deck.dealCards(INITIAL_CARD_DEAL);
            player.setCard();
        }
    }
}
