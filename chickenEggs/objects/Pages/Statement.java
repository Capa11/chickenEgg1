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
    drawable[] printControls;
    drawable[] printControls2;
    drawable[] printPlayers;
    private float yOffset = -500;
    private float controllersOffset = -1500;

    private float creditsOffset = -3000;
    static ArrayList<Button> buttons = new ArrayList<>();

    public Statement(Page back) {
        super(background[0],buttons);
        settings = new NavBtn((int)(-xaxis+150),(int)(yaxis-100),150,100,icons[8],back,"",0);
        buttons.add(settings);
        line1 = initwriteString("in a galaxy far away the fate of earth hangs by a feather the chickens have returned and this time they are not clucking around with their cunning formations and relentless egg attacks it is up to you to defend the planet take control of your spaceship dodge the incoming eggs and fry these feathered foes in this fast paced action packed arcade adventure", -900, 900, yOffset, 50, 50, 8);
        printControls = initwriteString("up    down    left    right   fire",-600 , 900 , controllersOffset , 30 , 30 ,20);
        printPlayers = initwriteString("player1   player2    player3    player4",-800 , -300 , controllersOffset - 100 , 50 , 50 ,20);
        printControls2 = initwriteString("plays with mouse and fire with left click " ,-200 ,controllersOffset-100 , 50 , 50 ,50 , 20 );
        credits = initwriteString("game made by hazem capa omar youssef mahmoud", -750, 900, creditsOffset, 50, 50, 8);
    }

    @Override
    public void draw() {
        super.draw();
        String s = "  player 2  player 3  player 4";
        DrawSprite(-100, (int) yOffset+300, 1000, 600, background[1]);
        drawArray(line1);
        drawArray(printControls);
        drawArray(printControls2);
        drawArray(printPlayers);
        drawArray(credits);
        animateText();
        action =false;
    }

    @Override
    public void ifClicked() {
        yOffset = -500;
        creditsOffset = -1500;
        action = true;
    }

    @Override
    public void isClicked(){
        for (Button button : buttons) {
            button.isClicked();
        }
        ifClicked();
    }

    private void animateText() {
        float speed = 0.7f;
        yOffset += speed;
        if (creditsOffset < -300) {
            creditsOffset += speed;
        }
        if(controllersOffset < 400 ){
            controllersOffset +=speed;
        }
        line1 = initwriteString("chicken egg game the game can be played from 1 player to 4 player you have 2 modes first mode is playgame and this one player mode after ending your name and score is stored in scoreboard after the game close and play game again the scoreboard remains the same and your scores is stored try to get high score the second mode is custom game that you can custom all your game and your controller", -900, 900, yOffset, 50, 50, 8);
        //printControls = initwriteString("up     down     left     right    fire",-300 , 900 , controllersOffset , 30 , 30 ,10);
        printPlayers = initwriteString("player 1",-800 , -300 , controllersOffset - 100 , 50 , 50 ,40);
        printControls2 = initwriteString("plays with mouse and fire with left click and pause the game with esc" ,-300 ,900,controllersOffset-100  , 30 ,30 , 20 );
        credits = initwriteString("game made by hazem capa omar youssef mahmoud", -900, 900, creditsOffset, 50, 50, 8);
    }
}