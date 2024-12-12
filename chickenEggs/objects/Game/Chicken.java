package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import java.util.*;
public class Chicken extends singleGameObject {
     public int health , eggDuration , eggtimer , Speed  ,path;
     public boolean damaged = false;//omar was here...
     public ArrayList<eggs> eggs = new ArrayList<>();
     public Chicken(int x, int y, int w, int h,int path, int xmingame, int xmaxgame, int ymingame, int ymaxgame) {
          super(x, y, w, h , path, xmingame , xmaxgame , ymingame , ymaxgame);
     }
     public void moveleft() {
          this.x-=Speed;
          if(!isInside())x+=Speed;
     }

     public void moveright() {
          this.x+=Speed;
          if(!isInside())x-=Speed;
     }


     public void moveup() {
          this.y+=Speed;
          if(!isInside())y-=Speed;
     }


     public void movedown() {
          this.y-=Speed;
          if(!isInside())y+=Speed;
     }


     public void makeegg() {
          eggs egg = new eggs(this.x , this.y-70 , 40 , 40 ,  xminGame,  xmaxGame,  yminGame,  ymaxGame);
          egg.draw();
          eggs.add(egg);
     }


     public void damage() {
          health--;
     }

     public boolean amIdead() {
          return health<=0;
     }
     public void fallegg() {
          this.eggtimer--;
          if(this.eggtimer <= 0){
               makeegg();
               eggtimer = eggDuration;
          }
          for (int i = 0; i < eggs.size(); i++) {
               eggs.get(i).fall();
               eggs.get(i).draw();
          }
     }

}
