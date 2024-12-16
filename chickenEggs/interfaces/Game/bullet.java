package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class bullet extends singleGameObject {
    public int  Speed = 5  ,path;
    public Player playerWhoFireMe;
    public static int defaultSize = 30;
    public bullet(int x, int y, int w, int h,int path) {
        super(x, y, w, h , path);
    }
    public bullet(int x, int y,int path) {
        super(x, y, defaultSize, defaultSize, path);
    }
    public boolean moveup() {
        this.y+=Speed;
        if(y<yaxis-h/2)return true;
        else return false;
    }

}