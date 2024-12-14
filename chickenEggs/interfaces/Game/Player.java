package chickenEggs.interfaces.Game;

import chickenEggs.objects.Game.bullet1;
import chickenEggs.objects.Game.rocket;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.xmouse;

public abstract class Player {
    public rocket r;
    public String name;
    public int score=0;public Player(String name){
        this.name=name;
        int i=0;
        r=new rocket(0,0);
        while(i<rocket.rocketSkin.length){
            if(rocket.rocketSkin[i]){
                rocket.rocketSkin[i]=false;
                r.path=rockets[i];
                return;
            }
            i++;
        }
    }
    public Pairii fire(){
        return r.fire();

    }

    public void killing(Chicken chicken){
        score+=chicken.scoreIfDead;
    }
    public void damaging(Chicken chicken){
        score+=chicken.scoreIfdamage;
    }
    public void draw(){
        r.draw();
    }
}
