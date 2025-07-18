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
    ArrayList<ArrayList<drawable>> scores;
    ArrayList<drawable[]>healths;
    ArrayList<Integer>StartEnd = new ArrayList<>();;
    public mousePlayer mousePlayer;
    public static int oneMinute=60*60;//because animator is 60 fps
    public ArrayList<Egg> eggsArray =new ArrayList<>();
    public ArrayList<Chicken> chickens=new ArrayList<>();
    public ArrayList<bullet> bullets=new ArrayList<>();
    public ArrayList<keyPlayer>  keyPlayers;
    public ArrayList<AiPlayer> AiPlayers;
    public ArrayList<Player> players = new ArrayList<>();
    public boolean winning=false;
    ArrayList<drawable[]>names;
    public Integer timer=1;
    int level;
    public Page backPage;
    public GameEnd gameEnd ;
    public GamePause gamePause;
    boolean isCustom=true;
    boolean isPause=false;
    float chickenSpeed=1;
    float theta=0;
    ArrayList<Pairii> xyChickens;

    public GamePage(mousePlayer mousePlayer, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int difficulty,Page backpage){//level 0 means not custom game
        path=background[0];
        this.keyPlayers=keyPlayers;
        this.AiPlayers=AiPlayers;
        this.mousePlayer=mousePlayer;
        if(mousePlayer!=null)players.add(mousePlayer);
        players.addAll(keyPlayers);
        players.addAll(AiPlayers);
        isGameRunning=true;
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
            System.out.println(2);
        }
        else {
            level=7;
            timer=oneMinute*2;
        }
        initChicken(level);
        gamePause = new GamePause(backpage);
        this.backPage=backpage;
    }
    @Override
    public void draw() {
        super.draw();
        if(isGameRunning) {
            chickenMove();
            moveAll();
            checkCollesion();
            drawObjects();
            draw_info();
            if (isCustom){
                timer--;
                timerDraw();
            }
            if (isAllPlayerDead() || timer <= 0) losing();
            if (isAllChickenDead()) winning();
        }
        else{
            if(isPause) {
                gamePause.draw();
            }
            else{

                gameEnd.draw();
            }
        }
        for (int i = 0; i < keyPlayers.size(); i++) {
            keyPlayers.get(i).keyPressed(3);
        }
    }
    public void chickenMove(){
        float r=50;
        for (int i = 0; i < chickens.size(); i++) {
            chickens.get(i).x= (int) (xyChickens.get(i).f+r*Math.cos(Math.toRadians(theta)));
            chickens.get(i).y= (int) (xyChickens.get(i).s+r*Math.sin(Math.toRadians(theta)));
        }
        theta+=0.7;
        if(theta==360)theta=0;

    }
    public void timerDraw(){
        drawable[] timerdisplay =initwriteString(Integer.toString(timer/(60)),xaxis-200,xaxis,yaxis-60,60,60,0);
        initGrid(timerdisplay,xaxis-200,xaxis,yaxis-60,60,60,0,0);
        drawArray(timerdisplay);

    }
    public void losing(){
        System.out.println("losing");
        if(!isCustom){
            updateScoreBoard(mousePlayer.name,mousePlayer.score);
        }
        isGameRunning=false;
        winning=false;
        sounds[0].play();
        runningPage = new GameEnd(players,false);
    }
    public void winning(){
        System.out.println("winning");
        if(!isCustom){
            updateScoreBoard(mousePlayer.name,mousePlayer.score);
        }

        if(isCustom){
            isGameRunning=false;
            winning=true;
            runningPage = new GameEnd(players,false);
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
        for (int i = 0; i < eggsArray.size(); i++) {
            eggsArray.get(i).draw();
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
        initGridNoWH(chickens1,-xaxis+30,xaxis-30,yaxis-30,0,50,0);
        xyChickens=new ArrayList<>();
        for (int i = 0; i < chickens.size(); i++) {
            xyChickens.add(new Pairii(chickens.get(i).x,chickens.get(i).y));
        }
        Egg.hegg=chickens1[0].h/2;
        Egg.wegg=chickens1[0].w/2;


    }
    public void ifkeyPressed(int e) {
        if(e== KeyEvent.VK_ESCAPE){
            isGameRunning=!isGameRunning;
            isPause=!isPause;
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
                for (int j = 0; j < eggsArray.size(); j++) {
                    if (players.get(i).r.iscollesion(eggsArray.get(j))) {
                        players.get(i).destroy();
                        eggsArray.remove(j);
                        break;
                    }
                }
            }
        }
        //checking bullets and eggs
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < eggsArray.size(); j++) {
                if (bullets.get(i).iscollesion(eggsArray.get(j))) {
                    bullets.remove(i);
                    eggsArray.remove(j);
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
                    if(chickens.get(j).health<=0){
                        chickens.remove(j);
                        xyChickens.remove(j);
                    }
                    break;
                }
            }
        }
    }
    public void generateChickenDistribution(int level) {
        System.out.println(level);
        int targetPoints = level * 500;
        int[] chickenPoints = {20, 40, 60, 80};

        int currentTotal = 0;
        int rand;
        System.out.println(targetPoints);
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
            if(eggxy!=null) eggsArray.add(new eggs(eggxy.f,eggxy.s));
        }
    }
    public void moveAllBullets(){
        for (int i = 0; i < bullets.size(); i++) {
            if(!bullets.get(i).moveup())bullets.remove(i);
        }
    }
    public void moveAllEggs(){
        for (int i = 0; i < eggsArray.size(); i++) {
            if(!eggsArray.get(i).fall()) eggsArray.remove(i);
        }
    }
    public void mouseMotion(){
        if(isMouseInside()&&mousePlayer!=null){
            mousePlayer.mouseMotion();
        }
    }
    public void mouseClicked(){
        if(isClickInside()&&mousePlayer!=null) {
            mousePlayer.mouseClicked();
        }
    }
    public void keyPressed(int e){
        if(isGameRunning) {
            for (int i = 0; i < keyPlayers.size(); i++) {
                keyPlayers.get(i).keyPressed(e);
            }
        }
        if(e==KeyEvent.VK_ESCAPE){
            isGameRunning=!isGameRunning;
            isPause=!isPause;
        }
    }
    private void initScores(){
        int xstart = (int)-xaxis + 100;
        int ystart = (int)(-yaxis+50);
        int space = 0;
        if(players.size()==2)space = 1200;
        if(players.size()==3)space = 500;
        if(players.size()==4)space = 300;
        int x = xstart;
        for (int i = 0; i < players.size(); i++) {
            String s =Integer.toString(players.get(i).score);
            scores.add(new ArrayList<drawable>());
            StartEnd.add(x);
            for (int j = 0; j < s.length() ; j++) {
                scores.get(i).add(new drawable(x , ystart, 30 , 30 ,numbers[s.charAt(j) - '0']));
                x+=50;
            }
            x+=space;
        }
    }
    private void inithealths(){
        int ystart = (int)(-yaxis+10);
        int size = 40;
        for (int i = 0; i < players.size(); i++) {
            String num = Integer.toString(players.get(i).health);
            drawable[]nums = new drawable[num.length()];
            drawable[]healthsss = new drawable[1];
            healths.add(healthsss);
            healths.add(nums);
            int x = StartEnd.get(i);
            healths.get(i)[0] = new drawable(x , ystart , size , size , chicken[chicken.length-1]);
            for (int j = 0; j < nums.length ; j++) {
                healths.get(1)[j] = new drawable(x +=70  , ystart , 30 , 30 , numbers[num.charAt(j) - '0']);
            }
        }
    }
    private void draw_score(){
        initScores();
        for (int i = 0; i < scores.size(); i++) {
            for (int j = 0; j < scores.get(i).size(); j++) {
                scores.get(i).get(j).draw();
            }
        }
    }
    private void draw_health(){
        inithealths();
        for (int i = 0; i < healths.size(); i++) {
            for (int j = 0; j < healths.get(i).length; j++) {
                if(healths.get(i)!=null && healths.get(i)[j]!=null)healths.get(i)[j].draw();
            }
        }
    }
private void initnames(){
    int ystart = (int)(-yaxis+100);
    for (int i = 0; i < players.size(); i++) {
        names.add(new drawable[players.get(i).name.length()]);
        String s = players.get(i).name.toLowerCase();
        s = s.replaceAll("\\s", "");
        int x = (StartEnd.size()!=0) ?StartEnd.get(i) : 0;
        for (int j = 0; j < names.get(i).length; j++) {
            if(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')names.get(i)[j] = new drawable(x , ystart , 30 , 30 , Letters[s.charAt(j)-'a']);
            else if(s.charAt(j) >= '0' && s.charAt(j) <= '9')names.get(i)[j] = new drawable(x , ystart , 30 , 30 , numbers[s.charAt(j)-'0']);
            x+=50;
        }
    }
}
    private void draw_names(){
        initnames();
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < names.get(i).length; j++) {
                if(names.get(i)!=null && names.get(i)[j]!=null)names.get(i)[j].draw();
            }
        }
    }public void draw_info() {
        draw_score();//must be first
        draw_names();
        draw_health();
        scores.clear();
        names.clear();
        healths.clear();
        StartEnd.clear();
//    }
    }
}