import java.util.ArrayList;

/**
 * Created by Adroso360 on 3/09/2016.
 */
public class superTDeck {
    private static final int NUM_INIT_CARDS = 60;
    private ArrayList<superTCard> cards;

    // import the XML card file
    public superTDeck(){
        cards = new ArrayList<superTCard>();
        for (int i = 0; i < NUM_INIT_CARDS; i++) {
             cards.add(new stCard());
            // create random interger array with no repeating

        }
    }
    public ArrayList<superTCard> dealCards(int i) {
        return null;
    }
}
