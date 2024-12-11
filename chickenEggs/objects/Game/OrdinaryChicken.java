package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;

public class OrdinaryChicken extends drawable implements Chicken {
   public int health = 1;
    public int eggDuration = 5 ;
    public int eggtimer =eggDuration;
    public int Speed = 3;
    public boolean damaged = false;
    public  float xmingame  =  -xaxis , xmaxgame = xaxis , ymingame = -yaxis , ymaxgame = yaxis;
    public ArrayList<eggs> eggs = new ArrayList<>();
    @Override
    public void moveleft() {
    this.x+=Speed;
    }

    public OrdinaryChicken(int x, int y, int w, int h, int speed, float xmingame, float xmaxgame, float ymingame, float ymaxgame) {
        super(x, y, w, h , chicken[0]);
        this.health = health;
        this.eggDuration = eggDuration;
        Speed = speed;
        this.damaged = damaged;
        this.xmingame = xmingame;
        this.xmaxgame = xmaxgame;
        this.ymingame = ymingame;
        this.ymaxgame = ymaxgame;
    }

    @Override
    public void moveright() {
        this.x+=Speed;
    }

    @Override
    public void moveup() {
        this.y+=Speed;
    }

    @Override
    public void movedown() {
        this.y-=Speed;
    }

    @Override
    public void makeegg() {
        eggs egg = new eggs(this.x , this.y , 40 , 40 ,  xmingame,  xmaxgame,  ymingame,  ymaxgame);
        egg.draw();
        eggs.add(egg);
    }

    @Override
    public boolean istheredamage() {
    if(damaged){
        health--;
        return true;
    }
    else return false;
    }

    @Override
    public boolean amIdead() {
    return health<=0;
    }
    public void eggDuration() {
    this.eggtimer--;
    if(this.eggtimer <= 0){
        makeegg();
        eggtimer = eggDuration;
    }
        for (int i = 0; i < eggs.size(); i++) {
            eggs.get(i).fall();
        }
    }
    public void SetDamaged(boolean damaged) {
        this.damaged = damaged;
        istheredamage();
    }
}
