package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;
import chickenEggs.objects.Pages.Buttons.*;

import java.util.ArrayList;
import static chickenEggs.interfaces.variables.*;

//2
public class CustomScreen extends Page {

    //Labels
    drawable[] playersText = initwriteString("players",-850,-475,390,60,60,0);
    drawable[] humansText = initwriteString("human",-700,-475,200,65,65,0);
//    drawable[] aiText = initwriteString("ai",-575,-475,0,70,70,0);
    drawable[] levelText = initwriteString("level",-745,-495,0,70,70,0);


    //settings
    NavBtn SettingButton = new NavBtn(900 , 520 , 200 , 180 , icons[13], new ControllerScreen(this) ,"",0 );
//    Buttons
    Button rightPlayers = new RightPlayers(300, (int)(yaxis-300), 130, 100, icons[1], null, "", 50);
    Button leftPlayers = new LeftPlayers(-300, (int)(yaxis-300), 130, 100, icons[4], null, "", 50);
    Button leftHuman = new PrevHuman(-300, (int)(yaxis-500), 130, 100, icons[4], null, "", 50);
    Button rightHuman = new NextHuman(300, (int)(yaxis-500), 130, 100, icons[1], null, "", 50);
//    Button rightAi = new NextAi(300, (int)(yaxis-700), 130, 100, icons[4], null, "", 50);
//    Button leftAi = new PrevAi(-300, (int)(yaxis-700), 130, 100, icons[4+2], null, "", 50);
    Button rightLevels = new NextLevel(300, (int)(yaxis-700), 130, 100,icons[1], null, "", 50);
    Button leftLevels = new PrevLevel(-300, (int)(yaxis-700), 130, 100, icons[4], null, "", 50);
//  Data
    protected static Integer howManyPlayers = numPlayers;
    protected static Integer howManyHumans = numHuman;
//    protected static Integer howManyAis = numAi;
    protected static String whatIsLevel = level;

//Start
    drawable startGame = new drawable((int) ((-xaxis + xaxis) / 2), (int) (-yaxis + 300), 400, 200, icons[3]);

    static ArrayList<Button> arr = new ArrayList<>();
    public CustomScreen(){
    }

    public CustomScreen(Page back) {
        super(background[0],arr);
        arr.add(new NavBtn((int)(-xaxis+150),(int)(yaxis-100),150,100,icons[8],back,"",0));
        arr.add(rightPlayers);
        arr.add(leftPlayers);
        arr.add(rightHuman);
        arr.add(leftHuman);
//        arr.add(rightAi);
//        arr.add(leftAi);
        arr.add(rightLevels);
        arr.add(leftLevels);
        arr.add(SettingButton);
//        arr.add(incVol);
//        arr.add(decVol);
    }
    @Override
    public void draw(){
        super.draw();
        startGame.draw();
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
    @Override
    public void ifClicked(){
        if(lastMouseX<=startGame.x+startGame.w/2&&lastMouseX>=startGame.x-startGame.w/2&&lastMouseY<=startGame.y+startGame.h/2&&lastMouseY>=startGame.y-startGame.h/2){
            ArrayList<keyPlayer> keyPlayers = new ArrayList<>();
            if(numHuman>1)keyPlayers.add(new keyPlayer(player2Controller,"FGSF"));
            if(numHuman>2)keyPlayers.add(new keyPlayer(player3Controller,"FGSSFDG"));
            if(numHuman>3)keyPlayers.add(new keyPlayer(player4Controller,"SFGFGG"));
            //ai player handle here



            int intlevel=3;
            switch (whatIsLevel){
                case "easy": intlevel=1;
                    break;
                case "medium":  intlevel=2;
                    break;
                case "hard":  intlevel=3;
                    break;
            }
            runningPage=new GamePage(new mousePlayer("p1"),keyPlayers,new ArrayList<>(),intlevel,this);
        }
    }
}






















