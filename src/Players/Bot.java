package Players;

/**
 * Created by Adroso360 on 30/09/2016.
 */
public class Bot extends Player {
    public PlayerType getPlayerType() {
        return PlayerType.BOT;
    }

    public Bot(int position) {
        super(position);
    }
}
