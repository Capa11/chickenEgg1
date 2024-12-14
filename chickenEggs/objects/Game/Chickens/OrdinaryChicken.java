package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class OrdinaryChicken extends Chicken {
    public OrdinaryChicken (int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , chicken[0] , xmingame, xmaxgame, ymingame, ymaxgame,200,0);
        this.health = 1;
        this.eggDuration = 100;
        this.speed = 3;
    }
}
