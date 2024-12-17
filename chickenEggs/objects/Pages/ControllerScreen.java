package chickenEggs.objects.Pages;


import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;



public class ControllerScreen extends Page {
    //Button player1 = new NavBtn(-200, -100, 350, 100, health[0], new PlayerControllerScreen(this,null), "player 1", 40);
    Button player2;
    Button player3;
    Button player4;
    drawable[] settings = initwriteString("settings", -220, 200, 600, 70, 70, 0);
    drawable[] volume = initwriteString("volume", -100, 400, 350, 40, 40, 0);
    drawable[] level = new drawable[10];
    drawable[] controller = initwriteString("controller", -150, 400, 100, 40, 50, 0);
    static ArrayList<Button> buttons = new ArrayList<>();
    int n=9;
    int i=0;
    public ControllerScreen(Page back) {
        super(background[0], buttons);
        controllers.add(arr);
        controllers.add(arr);
        controllers.add(arr);
        player2 = new NavBtn(0, -100, 350, 100, health[0], new PlayerControllerScreen(this,player2Controller), "player 2", 40);
        player3 = new NavBtn(-200, -300, 350, 100, health[0], new PlayerControllerScreen(this,player3Controller), "player 3", 40);
        player4 = new NavBtn(250, -300, 350, 100, health[0], new PlayerControllerScreen(this,player4Controller), "player 4", 40);
        for (int i = 0; i < level.length-1; i++) {
            level[i] = new drawable();
            level[i].setPath(health[1]);
        }

        level[9] = new drawable();
        level[9].setPath(health[0]);
        initGrid(level, -950, 1000, 280, 50, 50, 10, 10);
        buttons.add(new NavBtn((int)(-xaxis+150),(int)(yaxis-100),150,100,icons[8],back,"",0));
        buttons.add(player2);
        buttons.add(player3);
        buttons.add(player4);
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(settings);
        drawArray(volume);
        drawArray(controller);
        drawArray(level);
        DrawSprite(-300, 255, 50, 60, icons[4]);
        DrawSprite(350, 255, 50, 60, icons[1]);
    }

    @Override
    public void isClicked() {
        for (Button button : buttons) {
            if (button.isInside(lastMouseX, lastMouseY) && i>0 && i<=3) {
                playerController = button.text.charAt(button.text.length() - 1) -'0';
                System.out.println(playerController);
            }
            i++;
        }
        i=0;
        if(lastMouseX <= 375 && lastMouseX >= 325 && lastMouseY <= 280 && lastMouseY>=226 && n<10) {
            if (n < 0) n = 0;
            level[n++].path = health[1];
            Sound.setGlobalVolume(n/10f);
            sounds[1].play();
        }
        if(lastMouseX>=-325 && lastMouseX <=-272 && lastMouseY <=280 && lastMouseY>=225 && n >=0) {
            if (n == 10) n = 9;
            level[n--].path = health[0];
            Sound.setGlobalVolume(n/10f);
            sounds[1].play();
        }
        super.isClicked();
    }
}
