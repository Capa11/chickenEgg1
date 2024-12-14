package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class CustomGameInstraction extends Page {
    drawable[] line1;
    drawable[] credits;
    private float xOffsetStart = 1000; // Start from the right
    private float xOffsetEnd = 0; // End position at the beginning of the screen
    private float creditsOffsetStart = 1000; // Start credits from the right
    private float creditsOffsetEnd = 0; // End position at the beginning of the screen
    private float speed = 4; // Speed of the animation

    public CustomGameInstraction() {
        super(background[0]);
        line1 = initwriteString("this will go out of the screen", xOffsetStart, xOffsetEnd, -100, 100, 50, 8);
        credits = initwriteString("this will be fixed at the middle of the screen", creditsOffsetStart, creditsOffsetEnd, -200, 100, 50, 8);
    }

    @Override
    public void draw() {
        super.drawBackground();
        drawArray(line1);
        drawArray(credits);
        animateText();
    }

    private void animateText() {
        if (xOffsetStart > -1000) {
            xOffsetStart -= speed;
            xOffsetEnd -= speed;
        }
        if (creditsOffsetStart > 0) {
            creditsOffsetStart -= speed;
            creditsOffsetEnd -= speed;
        }
        line1 = initwriteString("this will go out of the screen", xOffsetStart, xOffsetEnd, -100, 100, 50, 8);
        credits = initwriteString("this will be fixed at the middle of the screen", creditsOffsetStart, creditsOffsetEnd, -200, 100, 50, 8);
    }
}