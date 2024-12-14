package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;


public class HomeScreen extends Page {
    static ArrayList<Button> buttons = new ArrayList<>();
    int y = 500;

    Button playButton = new NavBtn(-500, -450, 400, 200, icons[icons.length-1], new GamePage(), "start the game", 25 ,-500 , icons[icons.length-4],-500 , -420 , 150,150  );
    Button customButton = new NavBtn(0, -450, 400, 200, icons[icons.length-1], new CustomScreen(), "custom game", 25 , -500 , icons[icons.length-2],0, -420 , 150 , 150 );
    Button instructionButton = new NavBtn(500, -450, 400, 200,icons[icons.length-1], new CustomScreen(), "instruction", 25 , -500 , icons[icons.length-3]  , 500 , -430 , 200 , 200);
    public HomeScreen() {
        super(background[0], buttons);
        buttons.add(playButton);
        buttons.add(customButton);
        buttons.add(instructionButton);
    }

    @Override
    public void draw() {
        super.draw();
        DrawSprite(0 , 0 ,1200,500,background[1]);
    }


}
