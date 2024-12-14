package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class UnordinaryChicken extends Chicken {
    public UnordinaryChicken( ) {
        super(chicken[1],500,0);
        this.health = 2;
        this.eggDuration = 80;
        this.speed = 3;
    }

}
