package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class SuperChicken extends Chicken {
    public SuperChicken ( int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(chicken[2] , xmingame, xmaxgame, ymingame, ymaxgame,250,0);
        this.health = 3;
        this.eggDuration = 60;
        this.speed = 3;
    }
}
