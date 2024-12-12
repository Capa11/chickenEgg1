package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class Rocket extends singleGameObject{
    int Speed = 6 , health , path;
    public Rocket(int x, int y, int width, int hight, int path, float xminGame, float xmaxGame , float yminGame, float ymaxGame) {
        super(x, y,width, hight, path, xminGame, xmaxGame ,yminGame, ymaxGame);
    }
    public void moveleft() {
        this.x-=Speed;
    }

    public void moveright() {
        this.x+=Speed;
    }


    public void moveup() {
        this.y+=Speed;
    }


    public void movedown() {
        this.y-=Speed;
    }
}
