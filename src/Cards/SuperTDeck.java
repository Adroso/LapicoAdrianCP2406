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
        cards.add(new BaseSuperTCard("Slide01.jpg", "Slide01"));
        cards.add(new BaseSuperTCard("Slide02.jpg", "Slide02"));
        cards.add(new BaseSuperTCard("Slide03.jpg", "Slide03"));
        cards.add(new BaseSuperTCard("Slide04.jpg", "Slide04"));

        //Testing Deck
        System.out.println(cards.get(2));

        //Old input for File
        /*for (int i = 0; i < NUM_INIT_CARDS; i++) {
             cards.add(new Cards.BaseSuperTCard("Slide"));*/
            // create random interger array with no repeating

        }
    public ArrayList<BaseSuperTCard> dealCards(int i) {
        return null;
    }

    }

