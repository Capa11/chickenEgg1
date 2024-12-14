package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class HandelChickenMove extends Page {
    drawable[] rightToLeftText;
    drawable[] leftToRightText;
    private float rightToLeftStart = 0; // Start from the middle of the screen
    private float rightToLeftEnd = -1000; // End position off-screen to the left
    private float leftToRightStart = -1000; // Start from the left
    private float leftToRightEnd = 0; // End position off-screen to the right
    private float speed = 4; // Speed of the animation
    private float textWidth = 1000; // Desired width of the text

    public HandelChickenMove() {
        super(background[0]);
        rightToLeftText = initwriteString("this will be fixed at the middle of the screen", rightToLeftStart, rightToLeftStart + textWidth, 600, 100, 50, 8);
        leftToRightText = initwriteString("this will be fixed at the middle of the screen", leftToRightStart, leftToRightStart + textWidth, 600, 100, 50, 8);
    }

    @Override
    public void draw() {
        super.drawBackground();
        drawArray(rightToLeftText);
        drawArray(leftToRightText);
        animateText();
    }

    private void animateText() {
        if (rightToLeftStart > rightToLeftEnd) {
            rightToLeftStart -= speed;
        }
        if (leftToRightStart < leftToRightEnd) {
            leftToRightStart += speed;
        }
        rightToLeftText = initwriteString("this will be fixed at the middle of the screen", rightToLeftStart, rightToLeftStart + textWidth, 600, 100, 50, 8);
        leftToRightText = initwriteString("this will be fixed at the middle of the screen", leftToRightStart, leftToRightStart + textWidth, 600, 100, 50, 8);
    }
}