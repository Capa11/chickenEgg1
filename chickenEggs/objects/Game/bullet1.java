package chickenEggs.objects.Game;
import static chickenEggs.interfaces.variables.*;

import chickenEggs.interfaces.Game.*;

public class bullet1 extends bullet{
    public bullet1(int x, int y, int w, int h) {
        super(x, y, w, h , bullets[0]);
    }
    public bullet1(int x, int y) {
        super(x, y, bullets[0]);
    }
}
