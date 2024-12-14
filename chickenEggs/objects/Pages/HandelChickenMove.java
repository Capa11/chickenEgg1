package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class HandelChickenMove extends Page {
    drawable[] line1;
    drawable[] credits;
    private float xOffsetStart = 0; // Start from the middle of the screen
    private float xOffsetEnd = -1000; // End position off-screen to the left
    private float creditsOffsetStart = -1500; // Start from the left
    private float creditsOffsetEnd = 0; // End position off-screen to the right
    private float speed = 4; // Speed of the animation
    private float textWidth = 1000; // Desired width of the text

    public HandelChickenMove() {
        super(background[0]);
        line1 = initwriteString("this will be fixed at the middle of the screen", xOffsetStart, xOffsetStart + textWidth, 600, 100, 50, 8);
        credits = initwriteString("this will be fixed at the middle of the screen", creditsOffsetStart, creditsOffsetStart + textWidth, 600, 100, 50, 8);
    }

    @Override
    public void draw() {
        super.drawBackground();
        drawArray(line1);
        drawArray(credits);
        animateText();
    }

    private void animateText() {
        if (xOffsetStart > xOffsetEnd) {
            xOffsetStart -= speed;
        }
        if (creditsOffsetStart < creditsOffsetEnd) {
            creditsOffsetStart += speed;
        }
        line1 = initwriteString("this will be fixed at the middle of the screen", xOffsetStart, xOffsetStart + textWidth, 600, 100, 50, 8);
        credits = initwriteString("this will be fixed at the middle of the screen", creditsOffsetStart, creditsOffsetStart + textWidth, 600, 100, 50, 8);
    }
}