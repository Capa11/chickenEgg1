package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class Statement extends Page {
    drawable[] line1;
    drawable[] credits;
    private float yOffset = -500; // Start from the bottom
    private float creditsOffset = -1500; // Start credits from the bottom
    private float speed = 3; // Speed of the animation

    public Statement() {
        super(background[0]);
        line1 = initwriteString("in a galaxy far away the fate of earth hangs by a feather the chickens have returned and this time they are not clucking around with their cunning formations and relentless egg attacks it is up to you to defend the planet take control of your spaceship dodge the incoming eggs and fry these feathered foes in this fast paced action packed arcade adventure", -900, 900, yOffset, 50, 50, 8);
        credits = initwriteString("game made by hazem capa omar youssef mahmoud", -900, 900, creditsOffset, 50, 50, 8);
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
        line1 = initwriteString("in a galaxy far away the fate of earth hangs by a feather the chickens have returned and this time they are not clucking around with their cunning formations and relentless egg attacks it is up to you to defend the planet take control of your spaceship dodge the incoming eggs and fry these feathered foes in this fast paced action packed arcade adventure", -900, 900, yOffset, 50, 50, 8);
        credits = initwriteString("game made by hazem capa omar youssef mahmoud", -900, 900, creditsOffset, 50, 50, 8);
    }
}