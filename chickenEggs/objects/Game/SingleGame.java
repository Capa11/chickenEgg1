package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Game.bullet;
import chickenEggs.objects.Game.Players.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;
public class SingleGame {
    public int xminGame,xmaxGame,yminGame,ymaxGame,howManyPlayers,lives;int[] score;
    public int wbullet=20,hbullet=20;
    public boolean haveMousePlayer=false;
    public Player MousePlayer;
    public boolean isDead=false;
    public ArrayList<Egg> eggs=new ArrayList<>();
    public ArrayList<Chicken> chickens;
    public ArrayList<bullet> bullets=new ArrayList<>(0);
    public ArrayList<mousePlayer> mousePlayers;
    public ArrayList<keyPlayer> keyPlayers;
    public ArrayList<AiPlayer> AiPlayers;
    public SingleGame(int xminGame, int xmaxGame , int yminGame, int ymaxGame, ArrayList<mousePlayer> mousePlayers, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int lives, ArrayList<Chicken> chickens){
        this.xminGame=xminGame;this.xmaxGame=xmaxGame;
        this.yminGame=yminGame;this.ymaxGame=ymaxGame;
        score=new int[howManyPlayers];
        this.howManyPlayers=mousePlayers.size();
        this.lives=lives;
        this.keyPlayers=keyPlayers;
        this.AiPlayers=AiPlayers;
        this.chickens=chickens;
    }
    public void moveAllBullets(){
        for (int i = 0; i < bullets.size(); i++) {
            if(!bullets.get(i).moveup())bullets.remove(i);
        }
    }
    public void mouseMotion(){
        if(isMouseInside(xminGame,xmaxGame,yminGame,ymaxGame)&&haveMousePlayer){
            for (int i = 0; i < mousePlayers.size(); i++) {
                mousePlayers.get(i).mouseMotion();
            }
        }
    }
    public void mouseClicked(){
        if(isClickInside(xminGame,xmaxGame,yminGame,ymaxGame)&&haveMousePlayer) {
            for (int i = 0; i < mousePlayers.size(); i++) {
                mousePlayers.get(i).mouseClicked();
            }
        }
    }
    public void keyPressed(int e){
        for (int i = 0; i < keyPlayers.size(); i++) {
            keyPlayers.get(i).keyPressed(e);
        }
    }
    public void initChicken() {
        Chicken[] chickens1 = (Chicken[]) chickens.toArray();
        for (int i = 0; i < chickens.size(); i++) {
            initGrid(chickens1,xminGame,xmaxGame,yminGame,Chicken.defaultSize,Chicken.defaultSize,20,20);
        }
    }
}
