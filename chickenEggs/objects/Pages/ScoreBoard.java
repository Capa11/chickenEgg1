package chickenEggs.objects.Pages;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.Pages.inputbox;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Pages.Buttons.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class ScoreBoard extends Page {
    //InputBox
    inputbox inputbox = new inputbox(0,0,0,0,0,0,0);

    //Labels
    drawable[] playersText = initwriteString("players",-850,-475,390,60,60,0);
    drawable[] humansText = initwriteString("human",-700,-475,200,65,65,0);
    drawable[] aiText = initwriteString("ai",-575,-475,0,70,70,0);
    drawable[] levelText = initwriteString("level",-745,-495,-200,70,70,0);


    //settings
    NavBtn play = new NavBtn((int)(-xaxis+150),(int)(yaxis-100),150,150,icons[8],null,"",0);
    //    Buttons
    static Button btnClearScoreBord = new BtnClearScoreBoard(300, (int)(-yaxis+300), 130, 100, icons[4], null, "", 50);

    //  Data
    protected static Integer howManyPlayers = numPlayers;
    protected static Integer howManyHumans = numHuman;
    protected static Integer howManyAis = numAi;
    protected static String whatIsLevel = level;

    //Start
    static NavBtn startGame = new NavBtn((int)((-xaxis+xaxis)/2),(int)(-yaxis+100),350,200,icons[2],null,"",0);

    ArrayList<Button> arr = new ArrayList<>();
    ArrayList<Pair> scores = getScoreBoard();

    public ScoreBoard() {
        super(background[0]);
        arr.add(btnClearScoreBord);
        arr.add(startGame);
        super.buttons = arr;
    }
    @Override
    public void draw(){
        for (int i = 0; i < scores.size(); i++) {
            
        }
        super.draw();
        drawArray(playersText);
        drawArray(humansText);
        drawArray(aiText);
        drawArray(levelText);
        drawArray(initwriteString(howManyPlayers.toString(),-100,100,400,200,200,0));
        drawArray(initwriteString(howManyHumans.toString(),-100,100,200,200,200,0));
        drawArray(initwriteString(howManyAis.toString(),-100,100,0,200,200,0));
        drawArray(initwriteString(whatIsLevel,-240,240,-265,50,50,0));
    }
}
