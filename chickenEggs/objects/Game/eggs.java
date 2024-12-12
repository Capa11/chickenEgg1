package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

public class eggs extends drawable implements Egg{

    float xmingame , xmaxgame ,ymingame , ymaxgame;
    int speed = 4;
    public eggs(int x, int y, int w, int h, float xmingame, float xmaxgame, float ymingame, float ymaxgame){this.path = egg[0];}

    public eggs(int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h, egg[0]);
        this.xmingame = xmingame;
        this.xmaxgame = xmaxgame;
        this.ymingame = ymingame;
        this.ymaxgame = ymaxgame;
    }

    public boolean is_inside() {
        return !(this.y == ymingame);
    }
    public void fall(){
        this.y-=speed;
    }
}
