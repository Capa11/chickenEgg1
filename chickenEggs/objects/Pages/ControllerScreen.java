package chickenEggs.objects.Pages;


import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;


public class ControllerScreen extends Page {
    Button player1 = new NavBtn(-200, -100, 350, 100, health[0], new PlayerControllerScreen(), "player 1", 40);
    Button player2 = new NavBtn(250, -100, 350, 100, health[0], new PlayerControllerScreen(), "player 2", 40);
    Button player3 = new NavBtn(-200, -300, 350, 100, health[0], new PlayerControllerScreen(), "player 3", 40);
    Button player4 = new NavBtn(250, -300, 350, 100, health[0], new PlayerControllerScreen(), "player 4", 40);
    drawable[] settings = initwriteString("settings", -220, 200, 600, 70, 70, 0);
    drawable[] volume = initwriteString("volume", -100, 400, 350, 40, 40, 0);
    drawable[] level = new drawable[10];
    drawable[] controller = initwriteString("controller", -150, 400, 100, 40, 50, 0);
    static ArrayList<Button> buttons = new ArrayList<>();

    public ControllerScreen() {
        super(background[0], buttons);
        for (int i = 0; i < level.length; i++) {
            level[i] = new drawable();
            level[i].setPath(health[0]);
        }
        initGrid(level, -950, 1000, 280, 50, 50, 10, 10);
        buttons.add(player1);
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
        DrawSprite(-300, 255, 50, 60, icons[6]);
        DrawSprite(350, 255, 50, 60, icons[4]);
    }

    @Override
    public void isClicked() {
        for (Button button : buttons) {
            if (button.isInside(lastMouseX, lastMouseY)) {
                playerController = Integer.parseInt(String.valueOf(button.text.charAt(button.text.length() - 1)));
                System.out.println(playerController);
                break;
            }
        }
        super.isClicked();
    }
}
