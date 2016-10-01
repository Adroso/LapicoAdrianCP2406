package Players;

/**
 * Created by Adroso360 on 3/09/2016.
 */
public class Hooman extends Player {

    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    public Hooman(int position) {
        super(position);
    }
}

