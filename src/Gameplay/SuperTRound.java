package Gameplay;
import Cards.BaseSuperTCard;
import Gameplay.SuperTGame;
import Players.BotAI;
import Players.SuperTHumanplayer;
import Players.SuperTbasePlayer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

/**
 * Created by Adroso360 on 1/10/2016.
 */
public class SuperTRound {

    private final ArrayList<SuperTbasePlayer> players;
    private final SuperTbasePlayer startingPlayer;

    public SuperTRound(ArrayList<SuperTbasePlayer> players, SuperTbasePlayer startingPlayer) {
        this.players = players;
        this.startingPlayer = startingPlayer;
    }

    public SuperTbasePlayer beginRound() {
        SuperTbasePlayer currentPlayer = startingPlayer;
        String currentCat;
        BaseSuperTCard currentCard = null;
        if (currentPlayer.getPlayerType() == SuperTbasePlayer.PlayerType.BOT){
            currentCat = new BotAI().chooseCategory("Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity");
            System.out.println("Player: " + startingPlayer + " Has Choosen:  " + currentCat);
            currentCard = new BotAI().chooseCard(null, currentCat,startingPlayer);
        }
        else
            currentCat = new BotAI().chooseCategory("Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity");
        if (currentCard == null){
            System.out.println("Could not play a card");
            //TODO HANDLE THIS SHIT
        }
        else
            System.out.println("They Have then choosen: "+ currentCard.title);


        /*while (players.size() > 1){

        }*/
        throw new NotImplementedException();
    }
}
