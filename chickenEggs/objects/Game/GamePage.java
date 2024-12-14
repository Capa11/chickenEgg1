package chickenEggs.objects.Game;

import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Game.bullet;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.bullets;

public class GamePage extends Page {
    float[] probilityChickens;
    public int xminGame,xmaxGame,yminGame,ymaxGame,howManyPlayers,lives=5;int[] score;
    public mousePlayer mousePlayer;
    public boolean isDead=false;
    public ArrayList<Egg> eggs=new ArrayList<>();
    public ArrayList<Chicken> chickens=new ArrayList<>();
    public ArrayList<bullet> bullets=new ArrayList<>(0);
    public ArrayList<keyPlayer> keyPlayers;
    public ArrayList<AiPlayer> AiPlayers;
    public ArrayList<Player> players = new ArrayList<>();;
    public GamePage(mousePlayer mousePlayer, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int level){//level 0 means not custom game
        path=background[0];
        this.xminGame=(int) -xaxis;this.xmaxGame=(int) xaxis;
        this.yminGame=(int) -yaxis;this.ymaxGame=(int) yaxis;
        this.keyPlayers=keyPlayers;
        this.AiPlayers=AiPlayers;
        this.mousePlayer=mousePlayer;
        if(mousePlayer!=null)players.add(mousePlayer);
        players.addAll(keyPlayers);
        players.addAll(AiPlayers);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).xminGame=(int) -xaxis;
            players.get(i).xmaxGame=(int)  xaxis;
            players.get(i).yminGame=(int) -yaxis;
            players.get(i).ymaxGame=(int)  yaxis;
        }

    }
    public ArrayList<Chicken> initChicken(int level){
       chickens = new ArrayList<>(20);//how many chickens
        for (int i = 0; i < chickens.size(); i++) {
            chickens.set(i,new Chicken(0,0,0,0,0,0,0,0,0,0,0));
        }
        return chickens;
    }
    public void ifkeyPressed(int e) {
        if(e== KeyEvent.VK_ESCAPE){
            isGameRunning=!isGameRunning;
            //menu bar
        }
        keyPressed(e);
    }
    public void ifClicked(){
        mouseClicked();
    }
    public void ifMouseMotion(){
        mouseMotion();
    }
    public void moveAll(){
        moveAllBullets();
        moveAllEggs();

    }
    @Override
    public void draw(){
        super.draw();
         moveAll();
        for (int i = 0; i < chickens.size(); i++) {
            chickens.get(i).draw();
        }
        for (int i = 0; i < eggs.size(); i++) {
            eggs.get(i).draw();
        }
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw();
        }
        for (int i = 0; i < players.size(); i++) {
            players.get(i).draw();
        }

    }
    public void moveAllBullets(){
        for (int i = 0; i < bullets.size(); i++) {
            if(!bullets.get(i).moveup())bullets.remove(i);
        }
    }
    public void moveAllEggs(){
        for (int i = 0; i < eggs.size(); i++) {
            if(!eggs.get(i).fall())eggs.remove(i);
        }
    }
    public void mouseMotion(){
        if(isMouseInside(xminGame,xmaxGame,yminGame,ymaxGame)&&mousePlayer!=null){
            System.out.println("motion");
            mousePlayer.mouseMotion();
        }
    }
    public void mouseClicked(){
        if(isClickInside(xminGame,xmaxGame,yminGame,ymaxGame)&&mousePlayer!=null) {
            System.out.println("click");
                mousePlayer.mouseClicked();

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



