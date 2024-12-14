package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;
public class singleGame extends GamePage{
    public int xminGame,xmaxGame,yminGame,ymaxGame,howManyPlayers,lives;int[] score;
    public int wbullet=20,hbullet=20;
    public boolean haveMousePlayer=false;
    public Player MousePlayer;
    public boolean isDead=false;
    public ArrayList<Egg> eggs=new ArrayList<>();
    public ArrayList<Chicken> chickens=new ArrayList<>(0);
    public ArrayList<bullet> bullets=new ArrayList<>(0);
    public ArrayList<Player> players;
    public singleGame(int xminGame,int xmaxGame ,int yminGame,int ymaxGame,ArrayList<Player> players,int lives){
        this.xminGame=xminGame;this.xmaxGame=xmaxGame;
        this.yminGame=yminGame;this.ymaxGame=ymaxGame;
        score=new int[howManyPlayers];
        this.howManyPlayers=players.size();
        this.lives=lives;
        this.players=players;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).isMouse){
                haveMousePlayer=true;
                MousePlayer=players.get(i);
            }
        }
    }
    public boolean isClickInside() {
        if (lastMouseX <= xmaxGame && lastMouseX >= xminGame && lastMouseY <= ymaxGame && lastMouseY >= yminGame) {
            return true;
        } else return false;
    }
    public boolean isMouseInside() {
        if (xmouse <= xmaxGame && xmouse >= xminGame && ymouse <= ymaxGame && ymouse >= yminGame) {
            return true;
        } else return false;
    }
    public void moveAllBullets(){
        for (int i = 0; i < bullets.size(); i++) {
            if(!bullets.get(i).moveup())bullets.remove(i);
        }
    }
    public void mouseMotion(){
        if(isMouseInside()&&haveMousePlayer){
            MousePlayer.r.x= (int) xmouse;
            MousePlayer.r.y= (int) xmouse;
        }
    }
    public void mouseClicked(){
        if(isClickInside()&&haveMousePlayer) {
            bullets.add(new bullet1((int) lastMouseX, (int) lastMouseY,wbullet,hbullet,xminGame,xmaxGame,yminGame,ymaxGame));
        }
    }
    public void keyClicked(){

    }
}
