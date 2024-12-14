package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class rocket extends singleGameObject {
    boolean preparingRocket =true;int waitTimer=0;
    public static boolean[] rocketSkin ={true,true,true,true};
    public static int wRocket=200;public static int hRocket=200;
    boolean bulletready=true;

    public rocket(int x, int y){
        super(x,y,wRocket,hRocket,rockets[0]);
    }
    public rocket(){
        super(0, (int) (-yaxis+20),wRocket,hRocket);
    }
    public void distroy(){
        start();
    }
    public void start(){
        y= (int) (-yaxis+100);
    }
    public void draw(){
//        if(y<yminGame+h&& preparingRocket){
//            y+=speed;
//        }
//        else preparingRocket =false;
//        if(isInside())
        super.draw();
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
        GamePage.bullets.add(new bullet1(x,y+bullet.defaultSize));
    }
    public void bulletready(){
        bulletready=true;
    }




}
