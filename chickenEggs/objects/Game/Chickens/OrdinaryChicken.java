package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class OrdinaryChicken extends Chicken {
    public OrdinaryChicken ( ) {
        super(chicken[0],100,50);
        this.health = 1;
        this.eggDuration = 100;
        this.speed = 3;
    }
}
