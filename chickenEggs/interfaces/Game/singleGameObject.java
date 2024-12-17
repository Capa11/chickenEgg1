package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;

import static chickenEggs.interfaces.variables.*;

public class singleGameObject extends drawable{
    public int speed=5,score=0;
    public singleGameObject(int x, int y, int w, int h, int path){
        this( x,  y,  w,  h);
        this.path=path;
    }
    public singleGameObject( int path){
        this( 0,  0,  0,  0);
        this.path=path;
    }
    public singleGameObject(int x, int y, int w, int h){
        super(x,y,w,h);
    }
    public boolean iscollesion(drawable obj){
        return  (Math.abs(x-obj.x)<=w/2+obj.w/2)&&(Math.abs(y-obj.y)<=h/2+obj.h/2);
    }
    //true if all object inside it's map
    public boolean isInside(){
        return x<=xaxis-w/2&&x>=-xaxis+w/2&&y>=-yaxis+w/2&&y<=yaxis-h/2;

    }


}
