package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;
public class UltimateChicken extends Chicken {
    public UltimateChicken(int x, int y, int w, int h, float xmingame, float xmaxgame, float ymingame, float ymaxgame) {
        super(x, y, w, h , chicken[3] , xmingame, xmaxgame, ymingame, ymaxgame);
        this.health = 4;
        this.eggDuration = 40;
        this.speed = 3;
    }
}
