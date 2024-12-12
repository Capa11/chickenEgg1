package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class bullet extends singleGameObject {
    public int  Speed = 5  ,path;
    public bullet(int x, int y, int w, int h,int path, float xmingame, float xmaxgame, float ymingame, float ymaxgame) {
        super(x, y, w, h , path, xmingame , xmaxgame , ymingame , ymaxgame);
    }
    public void moveup() {
        this.y+=Speed;
    }

}
