package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
public class singleGame extends drawable{
    public int xminGame,xmaxGame,yminGame,ymaxGame;
    public singleGame(int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        this.xminGame=xminGame;this.xmaxGame=xmaxGame;
        this.yminGame=yminGame;this.ymaxGame=ymaxGame;
    }

}
