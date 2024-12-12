package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.*;

import static chickenEggs.interfaces.variables.*;

public class rocket extends singleGameObject {
    boolean preparingRocket =true;int waitTimer=0;
    public rocket(){
        super(x, y, w, h, chicken[0], xmingame, xmaxgame, ymingame, ymaxgame);
    }
    public rocket(int x,int y,int w,int h,int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        super(x,y,w,h,monsters[0],xminGame,xmaxGame ,yminGame,ymaxGame);
    }
    public void distroy(){
        start();
    }
    public void start(){
        y=yminGame-100;
    }
    public void draw(){
        if(y<yminGame+h&& preparingRocket){
            y+=speed;
        }
        else preparingRocket =false;
        if(isInside())super.draw();
    }
    public void moveleft(){
        x-=speed;
        if(!isInside())x+=speed;
    }
    public void moveright(){
        x+=speed;
        if(!isInside())x-=speed;
    }
    public void moveup(){
        y+=speed;
        if(!isInside())y-=speed;
    }
    public void movedown(){
        y-=speed;
        if(!isInside())y+=speed;
    }



}
