package chickenEggs.objects.Pages;

import chickenEggs.interfaces.Pages.Page;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.inputbox;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.BitSet;


public class PlayerControllerScreen extends Page {
    drawable[] player = initwriteString("player" , -220 , 1000 , 600 , 70, 70 , 0);
    drawable[] controllers = initwriteString("up down left right fire", -900, -800, 550, 60, 80, 100);
    inputbox[] inputBoxes = new inputbox[5];
    BitSet keyBits = new BitSet();


    public PlayerControllerScreen(){
        super(background[0]);

        int x = 80;
        int y = 370;
        int w = 400;
        int h = 100;
        int fontSize = 40;
        int sizeLimit = 1;
        int path = health[0];

        for (int i = 0; i < inputBoxes.length; i++) {
            inputBoxes[i] = new inputbox(x, y, w, h, sizeLimit, fontSize, path);
            y -= 200;
        }
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(player);
        DrawSprite(280 , 570 , 90 , 90 ,numbers[playerController]);
        drawArray(controllers);
        drawArray(inputBoxes);
    }

    @Override
    public void ifClicked() {
        for (inputbox inputBox : inputBoxes) {
            inputBox.isClicked();
        }
    }

    @Override
    public void keyPressed(int e) {
        for (inputbox inputBox : inputBoxes) {
            inputBox.keyPressed(e);
        }
    }
}