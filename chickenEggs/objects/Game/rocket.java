package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class rocket extends singleGameObject {
    boolean preparingRocket =true;int waitTimer=0;
    public int rocketKind;
    public Player player;
    ArrayList<bullet> bullets;
    public rocket(int rocketKind, int x, int y, int w, int h, int xminGame, int xmaxGame , int yminGame, int ymaxGame, ArrayList<bullet> bullets){
        super(x,y,w,h,xminGame,xmaxGame ,yminGame,ymaxGame);
        this.player=player;
        if(rocketKind==0)path=monsters[0];
        this.bullets=bullets;
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
    public void fire(){
        bullets.add(new bullet1(x,y+y/2+bullet1.defaultSize/2,xminGame,xmaxGame,yminGame,ymaxGame));
    }



}
