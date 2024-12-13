package chickenEggs.objects.Pages;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Pages.Buttons.*;

import java.util.ArrayList;
import static chickenEggs.interfaces.variables.*;

//2
public class CustomScreen extends Page {
    //    drawable[] arr1 =  initwriteString("players  1 2 3 4", -900, 950, 500, 60, 100, 10);
//    drawable[] arr2 =  initwriteString("settings", -900, -850, 400, 60, 100, 10);
//    drawable[] arr3 =  initwriteString("levels", -900, -850, 200, 60, 100, 10);
//    drawable[] arr4 =  initwriteString("game modes", -900, -850, 0, 60, 100, 10);
//    public CustomScreen() {
//    }
//    void drawBackground(){
//        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backgrounds[0]);
//       // DrawSprite(0,0, (1200), (800), backgrounds[1]);
//    }
//
//    @Override
//    public void draw() {
//        drawBackground();
//        drawArray(arr1);
//        drawArray(arr2);
//        drawArray(arr3);
//        drawArray(arr4);
//    }

    //Labels
    drawable[] playersText = initwriteString("players",-850,-475,390,60,60,0);
    drawable[] humansText = initwriteString("human",-700,-475,200,65,65,0);
    drawable[] aiText = initwriteString("ai",-575,-475,0,70,70,0);
    drawable[] levelText = initwriteString("level",-745,-495,-200,70,70,0);


    //settings
    NavBtn settings = new NavBtn((int)(-xaxis+150),(int)(yaxis-100),250,200,icons[8],null,"",0);
//    Buttons
    Button rightPlayers = new RightPlayers(300, (int)(yaxis-300), 130, 100, icons[4], null, "", 50);
    Button leftPlayers = new LeftPlayers(-300, (int)(yaxis-300), 130, 100, icons[4+2], null, "", 50);
    Button leftHuman = new PrevHuman(-300, (int)(yaxis-500), 130, 100, icons[4+2], null, "", 50);
    Button rightHuman = new NextHuman(300, (int)(yaxis-500), 130, 100, icons[4], null, "", 50);
    Button rightAi = new NextAi(300, (int)(yaxis-700), 130, 100, icons[4], null, "", 50);
    Button leftAi = new PrevAi(-300, (int)(yaxis-700), 130, 100, icons[4+2], null, "", 50);
    Button rightLevels = new NextLevel(300, (int)(yaxis-900), 130, 100, icons[4], null, "", 50);
    Button leftLevels = new PrevLevel(-300, (int)(yaxis-900), 130, 100, icons[4+2], null, "", 50);
//  Data
    protected static Integer howManyPlayers = numPlayers;
    protected static Integer howManyHumans = numHuman;
    protected static Integer howManyAis = numAi;
    protected static String whatIsLevel = level;

//Start
NavBtn startGame = new NavBtn((int)((-xaxis+xaxis)/2),(int)(-yaxis+100),450,250,icons[9],null,"",0);

    ArrayList<Button> arr = new ArrayList<>();

    public CustomScreen() {
        super(background[0]);
//        arr.add(b1);
        arr.add(rightPlayers);
        arr.add(leftPlayers);
        arr.add(rightHuman);
        arr.add(leftHuman);
        arr.add(rightAi);
        arr.add(leftAi);
        arr.add(rightLevels);
        arr.add(leftLevels);
        arr.add(settings);
        arr.add(startGame);
//        arr.add(incVol);
//        arr.add(decVol);
        super.buttons = arr;
    }
    @Override
    public void draw(){
        super.draw();
        drawArray(playersText);
        drawArray(humansText);
        drawArray(aiText);
        drawArray(levelText);
        drawArray(initwriteString(howManyPlayers.toString(),-100,100,400,200,200,0));
        drawArray(initwriteString(howManyHumans.toString(),-100,100,200,200,200,0));
        drawArray(initwriteString(howManyAis.toString(),-100,100,0,200,200,0));
        drawArray(initwriteString(whatIsLevel,-180,180,-275,60,60,0));
    }
}





















