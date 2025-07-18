package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;
import chickenEggs.objects.Game.Players.*;
import chickenEggs.objects.Game.rocket;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;


public class HomeScreen extends Page {
    int y = 500;
    //for testing

    Button playButton = new NavBtn(-500, -450, 400, 200, icons[2],new ScoreBoard(this) , "play game", 28 ,-480 , icons[9], -500 , -420 , 100,100 );
    Button customButton = new NavBtn(0, -450, 400, 200, icons[2], new CustomScreen(this), "custom game", 28 , -480 , icons[11], 0, -420 , 100 , 100 );
    Button instructionButton = new NavBtn(500, -450, 400, 200,icons[2], new Statement(this), "instruction", 28 , -480 , icons[10]  , 500 , -430 , 100 , 100);
    public HomeScreen() {
        super(background[0]);
        rocket.rocketSkin= new boolean[]{true, true, true, true, true, true, true};
        buttons.add(playButton);
        buttons.add(customButton);
        buttons.add(instructionButton);
    }

    @Override
    public void draw() {
        super.draw();
        DrawSprite(0 , 0 ,1200,500,background[1]);
        action =true;
    }
}