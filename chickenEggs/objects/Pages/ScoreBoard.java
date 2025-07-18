package chickenEggs.objects.Pages;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.Pages.inputbox;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Game.GamePage;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;
import chickenEggs.objects.Pages.Buttons.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class ScoreBoard extends Page {
    //InputBox
    inputbox inputbox = new inputbox(0,-200,800,150,8,80,icons[2]);

    //Labels
   /* drawable[] playersText = initwriteString("players",-850,-475,390,60,60,0);
    drawable[] humansText = initwriteString("human",-700,-475,200,65,65,0);
    drawable[] aiText = initwriteString("ai",-575,-475,0,70,70,0);
    drawable[] levelText = initwriteString("level",-745,-495,-200,70,70,0);


    //settings
    NavBtn play = new NavBtn((-200),(int)(-yaxis+100),200,100,icons[9],null,"",0);
    //    Buttons
    static Button btnClearScoreBord = new BtnClearScoreBoard(200, (int)(-yaxis+100), 400, 275, icons[5], null, "", 50);
*/
    //InputBox

    ArrayList<Pair> scores = getScoreBoard();
    mousePlayer mousePlayer ;
    ArrayList<keyPlayer> keyPlayers = new ArrayList<>();
    String name = "player";
    drawable playButton = new drawable(0, -450, 400, 200, icons[3]);
    public ScoreBoard(Page back) {
        super(background[0]);
        mousePlayer= new mousePlayer(name);
        /* arr.add(btnClearScoreBord);
        arr.add(play);*/
        buttons.add(new NavBtn((int)(-xaxis+150),(int)(yaxis-100),150,100,icons[8],back,"",0));
    }

    @Override
    public void keyPressed(int e) {
        super.keyPressed(e);
        inputbox.keyPressed(e);
        name = inputbox.getString();
    }

    @Override
    public void ifClicked() {
        inputbox.isClicked();
        if(lastMouseX<=playButton.x+playButton.w/2&&lastMouseX>=playButton.x-playButton.w/2&&lastMouseY<=playButton.y+playButton.h/2&&lastMouseY>=playButton.y-playButton.h/2){
            runningPage =new GamePage(new mousePlayer(name),keyPlayers,new ArrayList<>(),0,this);

        }
    }

    @Override
    public void draw(){
        isGameRunning = true;
        super.draw();
        DrawSprite(0,450,300,200,icons[12]);
        inputbox.draw();
        playButton.draw();

        drawScores(scores);
    }
    public void drawScores(ArrayList<Pair> arr){
        for (int i = 0; i < arr.size() && i<3; i++) {
            drawArray(initwriteString((i+1)+"",-400,-200,250-i*150,50,50,0));
            drawArray(initwriteString(arr.get(i).getS(),-280,180,250-i*150,50,50,0));
            drawArray(initwriteString(arr.get(i).getIn().toString(),100,300,300-i*150,50,50,0));
        }
    }

}