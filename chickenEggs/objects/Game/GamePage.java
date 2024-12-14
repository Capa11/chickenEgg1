package chickenEggs.objects.Game;

import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Game.bullet;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.objects.Game.Chickens.SuperChicken;
import chickenEggs.objects.Game.Chickens.UltimateChicken;
import chickenEggs.objects.Game.Chickens.UnordinaryChicken;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.bullets;

public class GamePage extends Page {
    float[] probilityChickens;
    public int howManyPlayers,lives=5;int[] score;
    public mousePlayer mousePlayer;
    public boolean isDead=false;
    public ArrayList<Egg> eggs=new ArrayList<>();
    public ArrayList<Chicken> chickens=new ArrayList<>();
    public ArrayList<bullet> bullets=new ArrayList<>(0);
    public ArrayList<keyPlayer> keyPlayers;
    public ArrayList<AiPlayer> AiPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    int level;
    boolean isCustom=false;
    public GamePage(mousePlayer mousePlayer, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int difficulty){//difficulty 0 means not custom game,1 easy,2,medium,3 hard
        path=background[0];
        this.keyPlayers=keyPlayers;
        this.AiPlayers=AiPlayers;
        this.mousePlayer=mousePlayer;
        if(mousePlayer!=null)players.add(mousePlayer);
        players.addAll(keyPlayers);
        players.addAll(AiPlayers);
        initChicken(5);
        if(difficulty==0){
            level=1;
            isCustom=true;
        }
        else if(difficulty==1)level=3;
        else if(difficulty==2)level=5;
        else level=7;
    }
    public void initChicken(int level){
        generateChickenDistribution(level);
        Chicken[]  chickens1 = new Chicken[chickens.size()];
        for (int i = 0; i < chickens1.length; i++) {
            chickens1[i]=chickens.get(i);
        }
        initGridNoWH(chickens1,-xaxis,xaxis,yaxis,0,0,0);
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
        checkChickens();

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
    public void checkCollesion(){
        //checking players and chicken
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < chickens.size(); j++) {
                if(players.get(i).r.iscollesion(chickens.get(i))){
                    players.get(i).r.distroy();
                }
            }
        }

        //checking players and eggs
        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < eggs.size(); j++) {
                if(players.get(i).r.iscollesion(chickens.get(i))){
                    players.get(i).r.distroy();
                }
            }
        }

        //checking bullets and chickens
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < chickens.size(); j++) {
                if(bullets.get(i).iscollesion(chickens.get(i))){
                    bullets.remove(i);
                    chickens.get(i).damage();
                }
            }
        }
    }
    public void checkChickens(){
        for (int i = 0; i < chickens.size(); i++) {
            Pairii eggxy = chickens.get(i).fallegg();
            if(eggxy!=null)eggs.add(new eggs(eggxy.f,eggxy.s));
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
        if(isMouseInside()&&mousePlayer!=null){
            System.out.println("motion");
            mousePlayer.mouseMotion();
        }
    }
    public void mouseClicked(){
        if(isClickInside()&&mousePlayer!=null) {
            System.out.println("click");
                mousePlayer.mouseClicked();
        }
    }
    public void keyPressed(int e){
        for (int i = 0; i < keyPlayers.size(); i++) {
            keyPlayers.get(i).keyPressed(e);
        }
    }
    public void generateChickenDistribution(int level) {
        int targetPoints=level*500;
        int[] chickenPoints = {20, 40, 60, 80};
        int currentTotal = 0;
        int rand;
        while (currentTotal<targetPoints) {
            rand = (int) (Math.random()*10);
            if(rand<4){
                chickens.add(new OrdinaryChicken());
                currentTotal+=chickenPoints[0];
            }
            else if(rand<7){
                chickens.add(new SuperChicken());
                currentTotal+=chickenPoints[1];
            }
            else if(rand<9){
                chickens.add(new UltimateChicken());
                currentTotal+=chickenPoints[2];
            }
            else{
                chickens.add(new UnordinaryChicken());
                currentTotal+=chickenPoints[3];
            }
        }
    }
}



