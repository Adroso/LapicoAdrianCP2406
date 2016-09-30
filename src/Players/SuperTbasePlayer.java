package Players;

import java.util.ArrayList;

/**
 * Created by Adroso360 on 30/09/2016.
 */
public class SuperTbasePlayer {
    public int position;
    public boolean isDealer = false;
    public ArrayList hand;
    public String playStatus;

    public SuperTbasePlayer(int position){
        this.position = position;
    }
    public String toString() {
        return String.valueOf((position));
    }
}
