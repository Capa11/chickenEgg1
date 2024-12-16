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
    inputbox inputbox = new inputbox(0,-350,1200,300,8,80,icons[2]);
    NavBtn back;


    //Labels
    drawable[] playersText = initwriteString("players",-850,-475,390,60,60,0);
    drawable[] humansText = initwriteString("human",-700,-475,200,65,65,0);
    drawable[] aiText = initwriteString("ai",-575,-475,0,70,70,0);
    drawable[] levelText = initwriteString("level",-745,-495,-200,70,70,0);


    //settings
    NavBtn play = new NavBtn((int)(-200),(int)(-yaxis+100),400,275,icons[9],null,"",0);
    //    Buttons
    static Button btnClearScoreBord = new BtnClearScoreBoard(200, (int)(-yaxis+100), 400, 275, icons[11], null, "", 50);

    //InputBox

    static ArrayList<Button> arr = new ArrayList<>();
    ArrayList<Pair> scores = getScoreBoard();
/*
    public ScoreBoard(){}
*/

    public ScoreBoard(Page back) {
        super(background[0],arr);
        this.back = new NavBtn((int)(-xaxis+150),(int)(yaxis-100),250,200,icons[8],back,"",0);
       /* arr.add(btnClearScoreBord);
        arr.add(play);*/
        arr.add(this.back);
    }

    @Override
    public void ifkeyPressed(int e) {
        inputbox.keyPressed(e);
    }

    @Override
    public void ifClicked() {
        inputbox.isClicked();
    }

    @Override
    public void draw(){
        super.draw();
        DrawSprite(0,450,700,400,icons[icons.length-1]);
        inputbox.draw();
        drawScores(scores);
    }
    public void drawScores(ArrayList<Pair> arra){
        for (int i = 0; i < arra.size() && i<3; i++) {
            drawArray(initwriteString((i+1)+"",-300,-200,100-i*150,50,50,0));
            drawArray(initwriteString(arra.get(i).getS(),-180,180,100-i*150,50,50,0));
            drawArray(initwriteString(arra.get(i).getIn().toString(),200,300,150-i*150,50,50,0));
        }
    }
}
