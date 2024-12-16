package chickenEggs.objects.Pages;

import chickenEggs.interfaces.Pages.ControllerBox;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.inputbox;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.BitSet;


public class PlayerControllerScreen extends Page {
    drawable[] player = initwriteString("player" , -220 , 1000 , 600 , 70, 70 , 0);
    drawable[] controllers = initwriteString("up down left right fire", -900, -800, 550, 60, 80, 100);
    ControllerBox[] controllerBoxes = new ControllerBox[5];
    BitSet keyBits = new BitSet();

    public PlayerControllerScreen(Page back){
        super(background[0]);

        int x = 80;
        int y = 370;
        int w = 400;
        int h = 100;
        int fontSize = 40;
        int path = health[0];

        for (int i = 0; i < controllerBoxes.length; i++) {
            controllerBoxes[i] = new ControllerBox(x, y, w, h, i , fontSize, path);
            y -= 200;
        }
        buttons.add(new NavBtn((int)(-xaxis+150),(int)(yaxis-100),150,100,icons[8],back,"",0));
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(player);
        DrawSprite(280 , 570 , 90 , 90 ,numbers[playerController]);
        drawArray(controllers);
        drawArray(controllerBoxes);
    }

    @Override
    public void ifClicked() {
        for (ControllerBox controllerBox : controllerBoxes) {
            controllerBox.Clicked();
        }
    }

    @Override
    public void keyPressed(int e) {

        for (ControllerBox controllerBox : controllerBoxes) {
            controllerBox.keyPressed(e);
        }
    }


}
