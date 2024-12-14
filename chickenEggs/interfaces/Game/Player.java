package chickenEggs.interfaces.Game;

import chickenEggs.objects.Game.bullet1;
import chickenEggs.objects.Game.rocket;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.xmouse;

public abstract class Player {
    public rocket r;
    public String name;
    public int score=0;
    public ArrayList<bullet> bullets;
    public int xminGame, xmaxGame , yminGame, ymaxGame;
    public Player(rocket r,String name,int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        this(xminGame,xmaxGame,yminGame,ymaxGame);
        this.r=r;
        this.name=name;
    }
    private Player(int xminGame,int xmaxGame ,int yminGame,int ymaxGame){
        this.xminGame=xminGame;
        this.xmaxGame=xmaxGame;
        this.ymaxGame=ymaxGame;
        this.yminGame=yminGame;
    }
    public void killing(Chicken chicken){
        score+=chicken.scoreIfDead;
    }
    public void damaging(Chicken chicken){
        score+=chicken.scoreIfdamage;
    }
}
