package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class UltimateChicken extends Chicken {
    public UltimateChicken(int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super( chicken[3] , xmingame, xmaxgame, ymingame, ymaxgame,400,0);
        this.health = 4;
        this.eggDuration = 40;
        this.speed = 3;
    }
}
