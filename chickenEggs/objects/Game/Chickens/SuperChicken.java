package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class SuperChicken extends Chicken {
    public SuperChicken () {
        super(chicken[2] ,250,100,4000);
        this.health = 3;
        this.eggDuration = 1500;
        this.speed = 3;
    }
    public SuperChicken (int maxTimer) {
        super(chicken[2] ,250,100,maxTimer);
        this.health = 3;
        this.eggDuration = 1500;
        this.speed = 3;
    }
}
