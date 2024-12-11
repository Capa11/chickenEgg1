package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;

public class singleGameObject extends drawable{
    public int xminGame,xmaxGame,yminGame,ymaxGame,speed=5;
    public singleGameObject(){}
    public singleGameObject(int x,int y ,int w,int h,int path,int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        super(x,y,w,h,path);
    }
    public boolean iscollesion(drawable obj){
        return  (Math.abs(x-obj.x)<=w/2+obj.w/2)&&(Math.abs(y-obj.y)<=h/2+obj.h/2);
    }
    public boolean isInside(){
        return x<=xmaxGame-w/2&&y<=ymaxGame-h/2&&x>=xminGame+w/2&&y>=yminGame+h/2;
    }
}
