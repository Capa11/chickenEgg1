package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import chickenEggs.objects.Game.eggs;

import java.util.*;
public class Chicken extends singleGameObject {
     public int health , eggDuration , eggtimer , Speed  ,path,scoreIfDead,scoreIfdamage;
     public boolean damaged = false;//omar was here...
     public ArrayList<chickenEggs.objects.Game.eggs> eggs = new ArrayList<>();
     public static int defaultSize=30;
     public Chicken(int x, int y, int w, int h,int path, int xmingame, int xmaxgame, int ymingame, int ymaxgame,int scoreIfDead,int scoreIfdamage) {
          super(x, y, w, h , path, xmingame , xmaxgame , ymingame , ymaxgame);
          this.scoreIfDead=scoreIfDead;
          this.scoreIfdamage=scoreIfdamage;
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
