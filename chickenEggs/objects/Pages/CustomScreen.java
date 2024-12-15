package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Pages.Buttons.*;

import java.util.ArrayList;
import static chickenEggs.interfaces.variables.*;

//2
public class CustomScreen extends Page {
    drawable[] playersText = initwriteString("players",-850,-475,390,60,60,0);
    drawable[] humansText = initwriteString("human",-700,-475,200,65,65,0);
    drawable[] levelText = initwriteString("level",-745,-495,0,70,70,0);


    //settings
    NavBtn backBtn;
//    Buttons
    Button rightPlayers = new RightPlayers(300, (int)(yaxis-300), 130, 100, icons[5], null, "", 50);
    Button leftPlayers = new LeftPlayers(-300, (int)(yaxis-300), 130, 100, icons[7], null, "", 50);
    Button leftHuman = new PrevHuman(-300, (int)(yaxis-500), 130, 100, icons[7], null, "", 50);
    Button rightHuman = new NextHuman(300, (int)(yaxis-500), 130, 100, icons[5], null, "", 50);
//    Button rightAi = new NextAi(300, (int)(yaxis-700), 130, 100, icons[4], null, "", 50);
//    Button leftAi = new PrevAi(-300, (int)(yaxis-700), 130, 100, icons[4+2], null, "", 50);
    Button rightLevels = new NextLevel(300, (int)(yaxis-700), 130, 100, icons[5], null, "", 50);
    Button leftLevels = new PrevLevel(-300, (int)(yaxis-700), 130, 100, icons[7], null, "", 50);
//  Data
    protected static Integer howManyPlayers = numPlayers;
    protected static Integer howManyHumans = numHuman;
//    protected static Integer howManyAis = numAi;
    protected static String whatIsLevel = level;

//Start
    NavBtn startGame = new NavBtn((int)((-xaxis+xaxis)/2),(int)(-yaxis+300),600,350,icons[3],new ScoreBoard(this),"",0);

    public CustomScreen(){
    }

    public CustomScreen(Page back) {
        super(background[0]);
        this.backBtn = new NavBtn((int)(-xaxis+150),(int)(yaxis-100),250,200,icons[8],back,"",0);
        buttons.add(rightPlayers);
        buttons.add(leftPlayers);
        buttons.add(rightHuman);
        buttons.add(leftHuman);
//        arr.add(rightAi);
//        arr.add(leftAi);
        buttons.add(rightLevels);
        buttons.add(leftLevels);
        buttons.add(this.backBtn);
        buttons.add(startGame);
//        arr.add(incVol);
//        arr.add(decVol);
    }
    @Override
    public void draw(){
        super.draw();
        drawArray(playersText);
        drawArray(humansText);
//        drawArray(aiText);
        drawArray(levelText);
        drawArray(initwriteString(howManyPlayers.toString(),-100,100,400,200,200,0));
        drawArray(initwriteString(howManyHumans.toString(),-100,100,200,200,200,0));
//        drawArray(initwriteString(howManyAis.toString(),-100,100,0,200,200,0));
        switch (whatIsLevel){
            case "easy": drawArray(initwriteString(whatIsLevel,-135,135,-70,60,60,0));
                break;
            case "medium": drawArray(initwriteString(whatIsLevel,-180,180,-70,60,60,0));
                break;
            case "hard": drawArray(initwriteString(whatIsLevel,-135,135,-70,60,60,0));
                break;
        }
    }
}





















