package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.*;

import static chickenEggs.interfaces.variables.*;

public class bullet extends singleGameObject {
    //public bullet(){
        //super(x, y, w, h, chicken[0], xmingame, xmaxgame, ymingame, ymaxgame);
    //}
    public bullet(int x,int y,int w,int h,int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        super(x,y,w,h,monsters[0],xminGame,xmaxGame ,yminGame,ymaxGame);
    }
    public void distroy(){

    }
}
