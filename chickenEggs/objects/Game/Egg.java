package chickenEggs.objects.Game;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;

public abstract class Egg extends singleGameObject {
    int speed=2;

    public Egg(int x, int y, int w, int h, int path, int xminGame, int xmaxGame, int yminGame, int ymaxGame) {
        super(x, y, w, h, path, xminGame, xmaxGame, yminGame, ymaxGame);
    }

    public boolean fall(){
        this.y-=speed;
        if(y>=yminGame)return true;
        return false;
    }
}
