package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class Rocket1 extends Rocket{
    public Rocket1(int x, int y , int width, int height , int xminGame , int xmaxGame , int yminGame , int ymaxGame) {
        super(x, y  ,width , height , rockets[0],xminGame ,xmaxGame , yminGame , ymaxGame);
    }
}

