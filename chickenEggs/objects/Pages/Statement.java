package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class Statement extends Page {
    NavBtn settings ;

    drawable[] line1;
    drawable[] credits;
    private float yOffset = -500; // Start from the bottom
    private float creditsOffset = -1500; // Start credits from the bottom
    private float speed = 1; // Speed of the animation
    static ArrayList<Button> buttons = new ArrayList<>();
    public Statement(){}

    public Statement(Page back) {
        super(background[0],buttons);
        settings = new NavBtn((int)(-xaxis+150),(int)(yaxis-100),250,200,icons[7],back,"",0);
        buttons.add(settings);
        line1 = initwriteString("in a galaxy far away the fate of earth hangs by a feather the chickens have returned and this time they are not clucking around with their cunning formations and relentless egg attacks it is up to you to defend the planet take control of your spaceship dodge the incoming eggs and fry these feathered foes in this fast paced action packed arcade adventure", -900, 900, yOffset, 50, 50, 8);
        credits = initwriteString("game made by hazem capa omar youssef mahmoud", -900, 900, creditsOffset, 50, 50, 8);
    }

    @Override
    public void draw() {
        super.draw();
        DrawSprite(-100, (int) yOffset+300, 1000, 600, background[1]);
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