package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class bullet extends singleGameObject {
    public int  Speed = 5  ,path;
    public static int defaultSize = 30;
    public bullet(int x, int y, int w, int h,int path, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , path, xmingame , xmaxgame , ymingame , ymaxgame);
    }
    public bullet(int x, int y,int path, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, defaultSize, defaultSize, path, xmingame , xmaxgame , ymingame , ymaxgame);
    }
    public boolean moveup() {
        this.y+=Speed;
        if(y<ymaxGame-h/2)return true;
        else return false;
    }

}
