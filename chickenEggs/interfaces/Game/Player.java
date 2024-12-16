package chickenEggs.interfaces.Game;

import chickenEggs.objects.Game.rocket;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public abstract class Player {
    public rocket r;
    public String name;
    public int health=5;
    public ArrayList<bullet> bullets;
    public int score=0;public Player(String name){
        this.name=name;
        int i=0;
        r=new rocket(this);
        while(i<rocket.rocketSkin.length){
            if(rocket.rocketSkin[i]){
                rocket.rocketSkin[i]=false;
                r.path=rockets[i];
                return;
            }
            i++;
        }
    }
    public void damaging(int damageScore){
        score+=damageScore;
    }
    public void destroy(){
        r.destroy();
    }
    public void draw(){
        if(health>0)r.draw();
    }
}