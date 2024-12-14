package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class UnordinaryChicken extends Chicken {
    public UnordinaryChicken( int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(chicken[1] , xmingame, xmaxgame, ymingame, ymaxgame,500,0);
        this.health = 2;
        this.eggDuration = 80;
        this.speed = 3;
    }

}
