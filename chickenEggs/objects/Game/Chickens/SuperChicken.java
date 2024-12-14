package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class SuperChicken extends Chicken {
    public SuperChicken () {
        super(chicken[2] ,250,0);
        this.health = 3;
        this.eggDuration = 1500;
        this.speed = 3;
    }
}
