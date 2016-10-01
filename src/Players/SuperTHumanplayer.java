package Players;

/**
 * Created by Adroso360 on 3/09/2016.
 */
public class SuperTHumanplayer extends SuperTbasePlayer {

    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    public SuperTHumanplayer(int position) {
        super(position);
    }
}

