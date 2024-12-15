package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.GamePage;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;
import chickenEggs.objects.Game.rocket;
import chickenEggs.objects.Pages.CustomScreen;

import chickenEggs.interfaces.Pages.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;
    mousePlayer mousePlayer ;
    ArrayList<keyPlayer> keyPlayers = new ArrayList<>();
    ArrayList<AiPlayer> AiPlayers = new ArrayList<>(0);
    GamePage gamePage;
    public static inputbox box;
    rocket r = new rocket(0,0);

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
        int[] keyController = {KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_SPACE};
        keyPlayer omar = new keyPlayer(keyController , "omar");
        omar.score = 14575;
        keyPlayers.add(omar);
        keyPlayer Hazem = new keyPlayer(keyController , "hazem");
        Hazem.score = 14574;
        keyPlayers.add(Hazem);
        keyPlayers.add(new keyPlayer(keyController,"capa"));
        mousePlayer=new mousePlayer("yousef");
        runningPage=new GamePage(mousePlayer,keyPlayers,AiPlayers,0);
        gamePage = new GamePage(mousePlayer,keyPlayers,AiPlayers,0);
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        runningPage.draw();
        Operations=true;
        gamePage.draw_score();// you must print score before any printing operation... else if you want to see an exception
        gamePage.draw_names();
        gamePage.draw_health();
    }
    void drawBackground(){
        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
