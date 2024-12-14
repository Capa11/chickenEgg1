package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class UltimateChicken extends Chicken {
    public UltimateChicken() {
        super( chicken[3],400,0);
        this.health = 4;
        this.eggDuration = 1000;
        this.speed = 3;
    }
}
