package Players;

/**
 * Created by Adroso360 on 3/09/2016.
 */
public class Human extends Player {

    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    public Human(int position) {
        super(position);
    }
}

