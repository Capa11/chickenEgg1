package chickenEggs.objects.Game;
import static chickenEggs.interfaces.variables.*;

import chickenEggs.interfaces.Game.*;

public class bullet1 extends bullet{
    public bullet1(int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , bullets[0], xmingame , xmaxgame , ymingame , ymaxgame);
    }
    public bullet1(int x, int y, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, bullets[0], xmingame , xmaxgame , ymingame , ymaxgame);
    }
}
