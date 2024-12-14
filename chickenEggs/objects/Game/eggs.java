package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

public class eggs extends Egg{
    public eggs(int x, int y, int w, int h,int path, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , path, xmingame , xmaxgame , ymingame , ymaxgame);
        speed=4;
    }
    public eggs(int x, int y, int w, int h, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
        super(x, y, w, h , egg[0], xmingame , xmaxgame , ymingame , ymaxgame);
        speed=4;
    }

    public void fall(){
        this.y-=speed;
    }
}
