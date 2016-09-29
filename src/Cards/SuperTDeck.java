package Cards;

import java.util.*;

/**
 * Created by Adroso360 on 3/09/2016.
 */

public class SuperTDeck {
    private static final int NUM_INIT_CARDS = 60;
    private ArrayList<BaseSuperTCard> cards;

    public SuperTDeck(){
        cards = new ArrayList<BaseSuperTCard>();
        //Play Cards
        cards.add(new BaseSuperTCard("Slide01.jpg", "Slide01", "Quartz"));
        cards.add(new BaseSuperTCard("Slide02.jpg", "Slide02", "Plagioclase"));
        cards.add(new BaseSuperTCard("Slide03.jpg", "Slide03", "Orthoclase"));
        cards.add(new BaseSuperTCard("Slide04.jpg", "Slide04", "Biotite"));

        //Trump Cards
        cards.add(new SuperTTrumpCard("Slide55.jpg", "Slide55", "The Miner", "Economic value", "Economic value" ));
        cards.add(new SuperTTrumpCard("Slide56.jpg", "Slide56", "The Petrologist", "Crustal abundance", "Crustal abundance" ));
        cards.add(new SuperTTrumpCard("Slide57.jpg", "Slide57", "The Gemmologist", "Hardness", "Hardness" ));
        cards.add(new SuperTTrumpCard("Slide58.jpg", "Slide58", "The Mineralogist", "Cleavage", "Cleavage" ));
        cards.add(new SuperTTrumpCard("Slide59.jpg", "Slide59", "The Geophysicist", "Specific gravity", "Specific gravity" ));
        cards.add(new SuperTTrumpCard("Slide60.jpg", "Slide60", "The Geologist", "Change to trumps category of your choice", "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity"));


        //Testing Deck
        //Old input for File
        for (int i = 0; i < NUM_INIT_CARDS; i++) {
            System.out.println(cards.get(i));
            // create random interger array with no repeating
        }

        }
    public ArrayList<BaseSuperTCard> dealCards(int i) {
        return null;
    }

    }

