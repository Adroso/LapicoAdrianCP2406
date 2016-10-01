package Players;

/**
 * Created by Adroso360 on 30/09/2016.
 */
public class SuperTBotPlayer extends SuperTbasePlayer {
    public PlayerType getPlayerType() {
        return PlayerType.BOT;
    }

    public SuperTBotPlayer(int position) {
        super(position);
    }
}
