package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;

public class OrdinaryChicken extends Chicken {
    public OrdinaryChicken (int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , chicken[0] , xmingame, xmaxgame, ymingame, ymaxgame);
        this.health = 1;
        this.eggDuration = 100;
        this.speed = 3;
    }
}
