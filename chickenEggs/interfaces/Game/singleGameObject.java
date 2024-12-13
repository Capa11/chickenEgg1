package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;

public class singleGameObject extends drawable{
    public float xminGame,xmaxGame,yminGame,ymaxGame,speed=5;
    public singleGameObject(int x, int y, int w, int h, int path, float xminGame, float xmaxGame, float yminGame, float ymaxGame){
        super(x,y,w,h,path);
        this.xminGame=xminGame;
        this.xmaxGame=xmaxGame;
        this.yminGame=yminGame;
        this.ymaxGame=ymaxGame;
    }
    public boolean iscollesion(drawable obj){
        return  (Math.abs(x-obj.x)<=w/2+obj.w/2)&&(Math.abs(y-obj.y)<=h/2+obj.h/2);
    }
    //true if all object inside it's map
    public boolean isInside(){
        return x<=xmaxGame-w/2&&y<=ymaxGame-h/2&&x>=xminGame+w/2&&y>=yminGame+h/2;
    }

    //true if part of object inside it's map
    public boolean isPartInside(){
        return x<=xmaxGame+w/2&&y<=ymaxGame+h/2&&x>=xminGame-w/2&&y>=yminGame-h/2;
    }

}
