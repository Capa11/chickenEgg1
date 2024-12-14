package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.objects.Game.GamePage;
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
    ArrayList<mousePlayer> mousePlayers = new ArrayList<mousePlayer>(1);
    ArrayList<keyPlayer> keyPlayers = new ArrayList<keyPlayer>(1);

    public static inputbox box;
    OrdinaryChicken chicken;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
        int[] keyController = {KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_SPACE};

//        rocket r = new rocket(0,0,0,200,200,-xaxis,xaxis,-yaxis,yaxis,
//        keyPlayers.set(0,new keyPlayer(keyController,new rocket())
//        runningPage=new GamePage(;
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        runningPage.draw();


    }
    void drawBackground(){
        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
