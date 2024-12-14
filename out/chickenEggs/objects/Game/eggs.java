package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

public class eggs extends drawable implements Egg{

    float xmingame , xmaxgame ,ymingame , ymaxgame;
    int speed = 3;
    public eggs(int x, int y, int w, int h, float xmingame, float xmaxgame, float ymingame, float ymaxgame) {
        super(x, y, w, h, egg[0]);
        this.xmingame = xmingame;
        this.xmaxgame = xmaxgame;
        this.ymingame = ymingame;
        this.ymaxgame = ymaxgame;
    }

    public boolean is_inside() {
        return !(y == ymingame);
    }
    public void fall(){
        y-=speed;
    }
}
