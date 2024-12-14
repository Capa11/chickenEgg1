package chickenEggs.interfaces.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import chickenEggs.objects.Game.eggs;
import chickenEggs.objects.Game.rocket;

import java.util.*;
public class Chicken extends singleGameObject {
     public int health , eggDuration , eggtimer , Speed  ,path,scoreIfDead,scoreIfdamage;
     public boolean damaged = false;//omar was here...
     public static int defaultSize=30;
     public Chicken(int x, int y, int w, int h,int path ,int scoreIfDead,int scoreIfdamage) {
          super(x, y, w, h , path);
          this.scoreIfDead=scoreIfDead;
          this.scoreIfdamage=scoreIfdamage;
     }
     public Chicken(int path,int scoreIfDead,int scoreIfdamage) {
          super(path);
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

     public void damage() {
          health--;
     }

     public boolean amIdead() {
          return health<=0;
     }
     public Pairii fallegg() {
          this.eggtimer--;
          if(this.eggtimer <= 0){
               eggtimer = eggDuration;
               return new Pairii(x,y-h/2);
          }
          return null;
     }
     public void draw(){
          super.draw();

     }

}
