package chickenEggs.objects.Game.Players;

import chickenEggs.interfaces.Game.Player;
import chickenEggs.objects.Game.rocket;

public class AiPlayer extends Player {
    public AiPlayer(rocket r, String name, int xminGame, int xmaxGame, int yminGame, int ymaxGame) {
        super(r, name, xminGame, xmaxGame, yminGame, ymaxGame);
    }
}
