package chickenEggs.objects.Game.Players;

import chickenEggs.interfaces.Game.Player;
import chickenEggs.objects.Game.rocket;

import java.awt.event.KeyEvent;

import static chickenEggs.interfaces.variables.*;

public class keyPlayer extends Player {
    public int[] controller;
    //controller[0] = up, [1]=down,[2]=right,[3]=left,[4]=fire
    //example controller={w,s,d,a,space}
    public keyPlayer(int[] controller, rocket r, String name, int xminGame, int xmaxGame, int yminGame, int ymaxGame) {
        super(r, name, xminGame, xmaxGame, yminGame, ymaxGame);
        this.controller=controller;
    }

    public void keyPressed(int e){
        if(keyBits.get(controller[0]))r.moveup();
        if(keyBits.get(controller[1]))r.movedown();
        if(keyBits.get(controller[2]))r.moveright();
        if(keyBits.get(controller[3]))r.moveleft();
        if(keyBits.get(controller[4]))r.fire();
    }
}
