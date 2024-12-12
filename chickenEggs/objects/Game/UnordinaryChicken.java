package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;
public class UnordinaryChicken extends  Chicken {
    public UnordinaryChicken(int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , chicken[1] , xmingame, xmaxgame, ymingame, ymaxgame);
        this.health = 2;
        this.eggDuration = 80;
        this.speed = 3;
    }

}
