package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;

public class Rocket2 extends Rocket{
    public Rocket2(int x, int y , int width, int height , float xminGame , float xmaxGame , float yminGame , float ymaxGame) {
        super(x, y  ,width , height , rockets[1],xminGame ,xmaxGame , yminGame , ymaxGame);
    }
}

