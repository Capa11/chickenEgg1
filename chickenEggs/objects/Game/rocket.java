package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.*;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

public class rocket extends singleGameObject {
    boolean start=true;
    public rocket(){}
    public rocket(int x,int y,int w,int h,int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        super(x,y,w,h,monsters[0],xminGame,xmaxGame ,yminGame,ymaxGame);
    }
    public void distroy(){

    }
    public void start(){
        y=yminGame+h;
    }
    public void draw(){
        if(y<yminGame+h&&start){
            y+=speed;
        }
        else start=false;
        if(isInside()){

        }
        super.draw();
    }



}
