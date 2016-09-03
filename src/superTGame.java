/**
 * Created by Adroso360 on 3/09/2016.
 */
import java.util.*;
public class superTGame {
    private int numPlayers;
    public superTGame(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public void selectDealer() {
        Random ran = new Random();
        int randomDealer = ran.nextInt(numPlayers)+1;
        System.out.println(randomDealer);

    }
}
