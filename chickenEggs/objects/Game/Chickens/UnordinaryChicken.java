package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class UnordinaryChicken extends Chicken {
    public UnordinaryChicken( ) {
        super(chicken[1],500,300,2000);
        this.health = 2;
        this.eggDuration = 500;
        this.speed = 3;
    }
    public UnordinaryChicken(int maxTimer) {
        super(chicken[1],500,300,maxTimer);
        this.health = 2;
        this.eggDuration = 500;
        this.speed = 3;
    }


}
