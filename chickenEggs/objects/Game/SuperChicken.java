package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;
public class SuperChicken extends Chicken {
    public SuperChicken (int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , chicken[2] , xmingame, xmaxgame, ymingame, ymaxgame);
        this.health = 3;
        this.eggDuration = 60;
        this.speed = 3;
    }
}
