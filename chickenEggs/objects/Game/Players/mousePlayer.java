package chickenEggs.objects.Game.Players;

import chickenEggs.interfaces.Game.Player;
import chickenEggs.objects.Game.bullet1;
import chickenEggs.objects.Game.rocket;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.xmouse;

public class mousePlayer extends Player {
    public mousePlayer(String name) {
        super( name);
    }
    public void mouseClicked(){
        if(isClickInside()) {
            r.fire();
        }
    }

    public void mouseMotion(){
        if(isMouseInside()){
            if (!r.preparingRocket) {
                if (xmouse != r.x) r.x = (int) xmouse;
                if (ymouse != r.y) r.y = (int) ymouse;
            }
        }
    }
}
