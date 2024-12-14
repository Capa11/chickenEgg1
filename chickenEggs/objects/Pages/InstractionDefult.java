package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class InstractionDefult extends Page {
    drawable[] line1;
    drawable[] credits;
    private float yOffset = -500; // Start from the bottom
    private float creditsOffset = -1500; // Start credits from the bottom
    private float speed = 3; // Speed of the animation

    public InstractionDefult() {
        super(background[0]);
        line1 = initwriteString("this will go out of the screen", -900, 900, yOffset, 50, 50, 8);
        credits = initwriteString("this will be fixed at the middle of the screen", -900, 900, creditsOffset, 50, 50, 8);
    }

    @Override
    public void draw() {
        super.drawBackground();
        drawArray(line1);
        drawArray(credits);
        animateText();
    }



    private void animateText() {
        yOffset += speed;
        if (creditsOffset < 0) {
            creditsOffset += speed;
        }
        line1 = initwriteString("this will go out of the screen", -900, 900, yOffset, 50, 50, 8);
        credits = initwriteString("this will be fixed at the middle of the screen ", -900, 900, creditsOffset, 50, 50, 8);
    }
}