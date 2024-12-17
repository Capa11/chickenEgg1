package chickenEggs.objects.Game.Chickens;
import chickenEggs.interfaces.Game.Chicken;

import static chickenEggs.interfaces.variables.*;

public class OrdinaryChicken extends Chicken {
    public OrdinaryChicken ( ) {
        super(chicken[0],100,50,5000);
        this.health = 1;
        this.eggDuration = 2000;
        this.speed = 3;
    }
    public OrdinaryChicken (int maxtimer) {
        super(chicken[0],100,50,maxtimer);
        this.health = 1;
        this.eggDuration = 2000;
        this.speed = 3;
    }
    
}
