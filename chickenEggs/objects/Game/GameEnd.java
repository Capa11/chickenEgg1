package chickenEggs.objects.Game;

import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Game.bullet;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;

import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.objects.Game.Chickens.SuperChicken;
import chickenEggs.objects.Game.Chickens.UltimateChicken;
import chickenEggs.objects.Game.Chickens.UnordinaryChicken;
import chickenEggs.objects.Game.*;
import chickenEggs.objects.Pages.HomeScreen;
import static chickenEggs.objects.Game.rocket.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;

public class GameEnd extends Page {
    // two state for this class when win what will do and when when lose what will do
    boolean isWin;
    ArrayList<Player> players;
    int state;
    drawable popup;
    NavBtn homeButton;
    // it have two buttons one for back one for retry
    public GameEnd( ArrayList<Player> players, boolean isWin){
        super(background[0]);
        popup = new drawable(0,0,1300,700,icons[2]);
        homeButton = new NavBtn(0, -150 ,150 ,100,icons[8],new HomeScreen(),"",0);
        buttons.add(homeButton);
        this.isWin = isWin;
        this.players = players;
        if (!isWin) {
            state = icons[icons.length-1];
        }else state = icons[icons.length-2];

    }
    public void draw(){
        super.draw();
        popup.draw();
        DrawSprite(0,275,180,140,state);
        buttons.forEach(button -> button.draw());
//        drawArray(initwriteString("scores",-200,200,180,50,50,0));
        //DrawSprite(0,145,240,120,icons[15]);
        for (int i = 0; i < players.size() && i<3; i++) {
            drawArray(initwriteString((i+1)+"",-500,-400,85-i*110,50,50,0));
            drawArray(initwriteString(players.get(i).name.toLowerCase(),-200,200,85-i*110,50,50,0));
            drawArray(initwriteString(players.get(i).score+"",300,600,85-i*110,50,50,0));
        }
//        drawArray(initwriteString("1",-600,-500,100-0*70,50,50,0));
//        drawArray(initwriteString("Ahmed",-500,500,100-0*70,50,50,0));
//        drawArray(initwriteString("250",500,900,100-0*70,50,50,0));
//        drawArray(initwriteString("2",-600,-500,100-1*70,50,50,0));
//        drawArray(initwriteString("Khaled",-500,500,100-1*70,50,50,0));
//        drawArray(initwriteString("50",500,900,100-1*70,50,50,0));
//        drawArray(initwriteString("3",-600,-500,100-2*70,50,50,0));
//        drawArray(initwriteString("Hassan",-500,500,100-2*70,50,50,0));
//        drawArray(initwriteString("100",500,900,100-2*70,50,50,0));
        //DrawSprite(120,-250,250,90,icons[15]);
        mouseClicked();
//        mouseMotion();
    }

    public void mouseMotion(){
        if (xmouse>= -175 &&  xmouse<= -25 && ymouse>= -295 && ymouse<=-205){

        }
    }
    public void mouseClicked(){
//        if (lastMouseX>= -175 &&  lastMouseX<= -25 && lastMouseY>= -295 && lastMouseY<=-205){
//            System.out.println("Back");
//            for (int i = 0; i < rocketSkin.length; i++) {
//                rocketSkin[i]=true;
//            }
//
//            runningPage = new HomeScreen();
//        } else
        if (lastMouseX>= 25 &&  lastMouseX<= 175 && lastMouseY>= -295 && lastMouseY<=-205) {
            System.out.println("Reset");
        }
    }

}