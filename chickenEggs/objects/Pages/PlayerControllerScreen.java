package chickenEggs.objects.Pages;

import chickenEggs.interfaces.Pages.Page;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.inputbox;

import java.util.ArrayList;


public class PlayerControllerScreen extends Page {
    drawable[] player = initwriteString("player" , -220 , 1000 , 600 , 70, 70 , 0);
    drawable[] controllers = initwriteString("up down left right fire missile", -900, -800, 550, 60, 80, 80);
    inputbox[] inputBoxes = new inputbox[5];


    public PlayerControllerScreen(){
        super(background[0]);

        int x = 480;
        int y = 570;
        int w = 200;
        int h = 100;
        int fontSize = 40;
        int sizelimit = 10;
        int path = health[0];

        for (int i = 0; i < inputBoxes.length; i++) {
            inputBoxes[i] = new inputbox(x, y, w, h, sizelimit, fontSize, path);
            y -= 200;
        }
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(player);
        DrawSprite(280 , 570 , 90 , 90 ,numbers[playerController]);
        drawArray(controllers);
    }
}
