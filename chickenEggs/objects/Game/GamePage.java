package chickenEggs.objects.Game;

import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Game.bullet;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;

import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.objects.Game.Chickens.SuperChicken;
import chickenEggs.objects.Game.Chickens.UltimateChicken;
import chickenEggs.objects.Game.Chickens.UnordinaryChicken;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class GamePage extends Page {
    ArrayList<drawable[]> scores;
    ArrayList<drawable[]>healths;
    public mousePlayer mousePlayer;
    public boolean isDead=false;
    public static int oneMinute=60*60;//because animator is 60 fps
    public ArrayList<Egg> eggs=new ArrayList<>();
    public ArrayList<Chicken> chickens=new ArrayList<>();
    public ArrayList<bullet> bullets=new ArrayList<>();
    public ArrayList<keyPlayer> keyPlayers = new ArrayList<>();
    public ArrayList<AiPlayer> AiPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    ArrayList<drawable[]>names;
    public int timer;
    int level;
    boolean isCustom=true;
    public GamePage(mousePlayer mousePlayer, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int difficulty){//level 0 means not custom game
        path=background[0];
        this.keyPlayers=keyPlayers;
        this.AiPlayers=AiPlayers;
        this.mousePlayer=mousePlayer;
        if(mousePlayer!=null)players.add(mousePlayer);
        players.addAll(keyPlayers);
        players.addAll(AiPlayers);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).bullets=bullets;
        }

        //init the x of each rocket when beginning
        drawable[] temp = new drawable[players.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new drawable();
        }
        initGrid(temp,-xaxis,xaxis,-yaxis,rocket.wRocket,rocket.hRocket,400,0);
        for (int i = 0; i < players.size(); i++) {
            players.get(i).r.xBegining=temp[i].x;
        }


         scores = new ArrayList<>();
         healths = new ArrayList<>();
         names = new ArrayList<>();
        initChicken(5);
        if(difficulty==0){
            level=1;
            isCustom=false;
        }
        else if(difficulty==1){
            level=3;
            timer=oneMinute*3;//1 minute
        }
        else if(difficulty==2){
            level=5;
            timer=oneMinute*2;
        }
        else {
            level=7;
            timer=oneMinute*2;
        }
    }
    @Override
    public void draw() {
        super.draw();
        moveAll();
        checkCollesion();
        drawObjects();
        if(isCustom)timer--;
        if(isAllPlayerDead()||timer<=0)losing();
        if(isAllChickenDead())winning();

    }
    public void losing(){


    }
    public void winning(){
        if(isCustom){

        }
        else{
            for (int i = 0; i < players.size(); i++) {
                players.get(i).r.start();
            }
            initChicken(++level);
        }
    }
    public boolean isAllPlayerDead(){
        boolean check=true;
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).health>0)check=false;
        }
        return check;
    }
    public boolean isAllChickenDead(){
       return chickens.size()==0;
    }
















    public void drawObjects(){
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
    public void initChicken(int level){
        generateChickenDistribution(level);
        Chicken[]  chickens1 = new Chicken[chickens.size()];
        for (int i = 0; i < chickens1.length; i++) {
            chickens1[i]=chickens.get(i);
        }
        initGridNoWH(chickens1,-xaxis,xaxis,yaxis,0,0,0);
        Egg.hegg=chickens1[0].h/2;
        Egg.wegg=chickens1[0].w/2;
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
    public void checkCollesion(){
        //checking players and chicken
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).health>0) {
                for (int j = 0; j < chickens.size(); j++) {
                    if (players.get(i).r.iscollesion(chickens.get(j))) {
                        players.get(i).destroy();
                        break;
                    }
                }
            }
        }

        //checking players and eggs
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).health>0) {
                for (int j = 0; j < eggs.size(); j++) {
                    if (players.get(i).r.iscollesion(eggs.get(j))) {
                        players.get(i).destroy();
                        eggs.remove(j);
                        break;
                    }
                }
            }
        }
        //checking bullets and eggs
        for (int i = 0; i < bullets.size(); i++) {
                for (int j = 0; j < eggs.size(); j++) {
                    if (bullets.get(i).iscollesion(eggs.get(j))) {
                        bullets.remove(i);
                        eggs.remove(j);
                        break;
                    }
                }

        }

        //checking bullets and chickens
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < chickens.size(); j++) {
                if(bullets.get(i).iscollesion(chickens.get(j))){
                    bullets.get(i).playerWhoFireMe.damaging(chickens.get(j).getDamageScore());
                    bullets.remove(i);
                    i--;
                    if(chickens.get(j).health<=0)chickens.remove(j);
                    break;
                }
            }
        }
    }
    public void generateChickenDistribution(int level) {
        int targetPoints = level * 500;
        int[] chickenPoints = {20, 40, 60, 80};

        int currentTotal = 0;
        int rand;
        while (currentTotal < targetPoints) {
            rand = (int) (Math.random() * 10);
            if (rand < 4) {
                chickens.add(new OrdinaryChicken(10000-level*500));
                currentTotal += chickenPoints[0];
            } else if (rand < 7) {
                chickens.add(new SuperChicken(8000-level*400));
                currentTotal += chickenPoints[1];
            } else if (rand < 9) {
                chickens.add(new UltimateChicken(7000-level*350));
                currentTotal += chickenPoints[2];
            } else {
                chickens.add(new UnordinaryChicken(5000-level*250));
                currentTotal += chickenPoints[3];
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



