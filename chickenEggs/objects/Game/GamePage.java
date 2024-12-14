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
    public int howManyPlayers,lives=5;
    ArrayList<drawable[]> scores;
    ArrayList<drawable[]>healths;
    public mousePlayer mousePlayer;
    public boolean isDead=false;
    public ArrayList<Egg> eggs=new ArrayList<>();
    public ArrayList<Chicken> chickens=new ArrayList<>();
    public ArrayList<bullet> bullets=new ArrayList<>(0);
    public ArrayList<keyPlayer> keyPlayers = new ArrayList<>();
    public ArrayList<AiPlayer> AiPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    ArrayList<drawable[]>names;
    public GamePage(mousePlayer mousePlayer, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int level){//level 0 means not custom game
        path=background[0];
        this.keyPlayers=keyPlayers;
        this.AiPlayers=AiPlayers;
        this.mousePlayer=mousePlayer;
        if(mousePlayer!=null)players.add(mousePlayer);
        players.addAll(keyPlayers);
        players.addAll(AiPlayers);
         scores = new ArrayList<drawable[]>();
         healths = new ArrayList<drawable[]>();
         names = new ArrayList<>();
    }
    public ArrayList<Chicken> initChicken(int level){
       chickens = new ArrayList<>(20);//how many chickens
        for (int i = 0; i < chickens.size(); i++) {
            chickens.set(i,new Chicken(0,0,0,0,0,0,0));
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
    public void initChicken() {
        Chicken[] chickens1 = (Chicken[]) chickens.toArray();
        for (int i = 0; i < chickens.size(); i++) {
            initGrid(chickens1,-xaxis,xaxis,-yaxis,Chicken.defaultSize,Chicken.defaultSize,20,20);
        }
    }
    private void initScores(){
        int xstart = (int)-xaxis + 100;
        int ystart = (int)(-yaxis+120);
        int space = 0;
        if(players.size()==2)space = 1200;
        if(players.size()==3)space = 500;
        if(players.size()==4)space = 200;
        int x = xstart;
        for (int i = 0; i < players.size(); i++) {
            String s = "" + players.get(i).score;
             scores.add(new drawable[s.length()]);
            for (int j = 0; j < s.length(); j++) {
                scores.get(i)[j] = new drawable(x , ystart, 60 , 60 ,numbers[s.charAt(j) - '0']);
                x+=50;
            }
            x+=space;
        }
    }
    public void inithealths(){
        int xstart = (int)-xaxis + 100;
        int ystart = (int)(-yaxis+20);
        int space = 0;
        int x = xstart;
        if(players.size()==2)space = 1300;
        if(players.size()==3)space = 600;
        if(players.size()==4)space = 300;
        for (int i = 0; i < players.size(); i++) {
            healths.add(new drawable[players.get(i).health]);

            for (int j = 0; j < players.get(i).health; j++) {
                healths.get(i)[j] = new drawable(x , ystart , 60 , 60 , heart[0]);
                x+=70;
            }
            x+=space;
        }
    }
    public void draw_score(){
        initScores();
        for (int i = 0; i < scores.size(); i++) {
            for (int j = 0; j < scores.get(i).length; j++) {
                if(scores.get(i)!=null && scores.get(i)[j]!=null)scores.get(i)[j].draw();
            }
        }
    }
    public void draw_healt(){
        inithealths();
        for (int i = 0; i < healths.size(); i++) {
            for (int j = 0; j < healths.get(i).length; j++) {
                if(healths.get(i)!=null && healths.get(i)[j]!=null)healths.get(i)[j].draw();
            }
        }
    }
    public void initnames(){
        int xstart = (int)-xaxis + 100;
        int ystart = (int)(-yaxis+200);
        int space = 0;
        int x = xstart;
        if(players.size()==2)space = 1200;
        if(players.size()==3)space = 500;
        if(players.size()==4)space = 300;
        for (int i = 0; i < players.size(); i++) {
            names.add(new drawable[players.get(i).name.length()]);
            String s = players.get(i).name;
            for (int j = 0; j < names.get(i).length; j++) {
                names.get(i)[j] = new drawable(x , ystart , 60 , 60 , Letters[s.charAt(j)-'a']);
                x+=50;
            }
            x+=space;
        }
    }
    public void draw_names(){
        initnames();
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < names.get(i).length; j++) {
                if(names.get(i)!=null && names.get(i)[j]!=null)names.get(i)[j].draw();
            }
        }
    }
}



