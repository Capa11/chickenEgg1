package chickenEggs.objects.Game;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;

import static chickenEggs.interfaces.variables.*;

public abstract class Egg extends singleGameObject {
    int speed=2;

    public Egg(int x, int y, int w, int h, int path) {
        super(x, y, w, h, path);
    }

    public boolean fall(){
        this.y-=speed;
        if(y>=-yaxis)return true;
        return false;
    }
}
