import java.util.*;
import java.util.List;

/**
 * Created by Adroso360 on 3/09/2016.
 */

public class SuperTDeck {
    private static final int NUM_INIT_CARDS = 60;
    private ArrayList<SuperTCard> cards;



    public SuperTDeck(){
        cards = new ArrayList<SuperTCard>();
        for (int i = 0; i < NUM_INIT_CARDS; i++) {
             cards.add(new SuperTCard());
            // create random interger array with no repeating

        }
    }
    public ArrayList<SuperTCard> dealCards(int i) {
        return null;
    }

    public static String Deckbuilder(int inputNumber){
        String[] filenames = {"Slide01.jpg", "Slide02.jpg"};
        String[] chemistry = {"SiO_2", "Na Al Si_3 O_8 - Ca Al_2 Si_2 O_8"};

        String card = filenames[inputNumber] + chemistry[inputNumber];
        return card;
        }

    }

