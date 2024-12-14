package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class chickencircle extends Page {
    drawable[] line1;
    drawable[] down; // Declare down array
    private float yOffset = -500; // Start from the bottom
    private float creditsOffset = -1500; // Start credits from the bottom
    private float speed = 3; // Speed of the animation

    public chickencircle() {
        super(background[0]);

        // Initialize line1 text string
//        line1 = initwriteString("in a galaxy far away the fate of earth hangs by a feather the " +
//                "chickens have returned and this time they are not clucking around with their" +
//                " cunning formations and relentless egg attacks it is up to you to defend the planet " +
//                "take control of your spaceship dodge the incoming eggs and fry these feathered foes" +
//                " in this fast paced action packed arcade adventure", -900, 900, yOffset, 50, 50, 8);

        // Initialize down objects array


        down = new drawable[5];
        for (int i = 0; i < down.length; i++) {
            down[i] = new drawable();
            down[i].setPath(numbers[i]); // Assuming 'numbers' array is defined elsewhere
        }
        initGrid(down, -1000, -300, 500, 50, 50, 20, 10);
    }

    @Override
    public void draw() {
        super.drawBackground();
        // Draw the background sprite
//        DrawSprite(-100, (int) yOffset + 300, 1000, 600, background[1]);

        // Draw the text and down objects
//        drawArray(line1);
        drawArray(down); // Draw the down array
    }

    // Additional methods for initGrid and drawArray would be assumed to be in place
}
