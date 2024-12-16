package chickenEggs.interfaces;
import static chickenEggs.interfaces.variables.*;

public class drawable {
    public int x=200,y=200,path,w,h;
    public drawable(){
    }
    public drawable(int x,int y ,int w,int h){
        this.x=x;
        this.y=y;
        this.w= w;
        this.h=h;
    }
    public drawable(int x,int y ,int w,int h,int path){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.path=path;
    }

    public void increment() {
        this.y++;
    }

    public void setPath(int path){
        this.path=path;
    }
    public void draw(){
        DrawSprite(x,y,w,h,path);
    }

}

