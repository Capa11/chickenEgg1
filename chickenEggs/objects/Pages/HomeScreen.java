package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;
import chickenEggs.objects.Game.Players.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;


public class HomeScreen extends Page {
    int y = 500;
    //for testing
    mousePlayer mousePlayer = new mousePlayer("Capa");
    int[] controller ={KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_SPACE};
    ArrayList<keyPlayer> keyPlayers = new ArrayList<>();

    Button playButton;

    Button customButton = new NavBtn(0, -450, 400, 200, Letters[26], new CustomScreen(this), "custom game", 25 , -500 , Letters[26],0, -420 , 150 , 150 );
    Button instructionButton = new NavBtn(500, -450, 400, 200,Letters[26], new Statement(this), "instruction", 25 , -500 , Letters[26]  , 500 , -430 , 200 , 200);
    public HomeScreen() {
        super(background[0]);
        keyPlayers.add(new keyPlayer(controller,"Yousef"));
        Button playButton = new NavBtn(-500, -450, 400, 200, Letters[26], new GamePage(mousePlayer,keyPlayers,new ArrayList<AiPlayer>(),0,this), "start the game", 25 ,-500 , Letters[26],-500 , -420 , 150,150 );
        buttons.add(playButton);
        buttons.add(customButton);
        buttons.add(instructionButton);
//        controllers.add(arr);
//        controllers.add(arr);
//        controllers.add(arr);
//        controllers.add(arr);
    }

    @Override
    public void draw() {
        super.draw();
        DrawSprite(0 , 0 ,1200,500,background[1]);
    }


}