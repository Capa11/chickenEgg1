package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class bullet1 extends bullet{
    public bullet1(int x, int y, int w, int h, float xmingame, float xmaxgame, float ymingame, float ymaxgame) {
        super(x, y, w, h , bullets[0], xmingame , xmaxgame , ymingame , ymaxgame);
    }
}