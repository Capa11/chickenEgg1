package chickenEggs.objects.Game;

import chickenEggs.interfaces.Game.Player;
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

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

import java.util.ArrayList;

public class GameEnd extends drawable {
    // two state for this class when win what will do and when when lose what will do
    boolean isWin;
    Page backPage;
    ArrayList<Player> players;
    int state;
    // it have two buttons one for back one for retry
    public GameEnd(Page backPage, ArrayList<Player> players, boolean isWin){
        super(0,0,1300,700,background[0]);
        this.isWin = isWin;
        this.backPage = backPage;
        this.players = players;
        if (isWin){
            state = icons[11];
        }else state = icons[12];

    }
    public void draw(){
        super.draw();
        DrawSprite(0,275,180,140,state);
//        drawArray(initwriteString("scores",-200,200,180,50,50,0));
        DrawSprite(0,145,240,120,icons[13]);
        for (int i = 0; i < players.size() && i<3; i++) {
            drawArray(initwriteString("i",-500,-400,85-i*70,50,50,0));
            drawArray(initwriteString(players.get(i).name,-400,400,85-i*70,50,50,0));
            drawArray(initwriteString(players.get(i).score+"",400,500,85-i*70,50,50,0));
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
        DrawSprite(-100,-250,150,90,icons[14]);
        DrawSprite(100,-250,150,90,icons[15]);
        mouseClicked();
//        mouseMotion();
    }

    public void mouseMotion(){
        if (xmouse>= -175 &&  xmouse<= -25 && ymouse>= -295 && ymouse<=-205){
            System.out.println("in Back");
        } else if (xmouse>= 25 &&  xmouse<= 175 && ymouse>= -295 && ymouse<=-205) {
            System.out.println("in Reset");
        }
    }
    public void mouseClicked(){
        if (lastMouseX>= -175 &&  lastMouseX<= -25 && lastMouseY>= -295 && lastMouseY<=-205){
            System.out.println("Back");
        } else if (lastMouseX>= 25 &&  lastMouseX<= 175 && lastMouseY>= -295 && lastMouseY<=-205) {
            System.out.println("Reset");
        }
    }

}