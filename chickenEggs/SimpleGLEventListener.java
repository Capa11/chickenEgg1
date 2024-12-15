package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
<<<<<<< HEAD
import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Game.Player;
import chickenEggs.interfaces.Game.bullet;
import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.objects.Game.GamePage;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;
import chickenEggs.objects.Game.bullet1;
import chickenEggs.objects.Game.rocket;
=======
import chickenEggs.objects.Pages.ControllerScreen;
>>>>>>> origin/hazem
import chickenEggs.objects.Pages.CustomScreen;

import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.HomeScreen;
import chickenEggs.objects.Pages.PlayerControllerScreen;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;
    mousePlayer mousePlayer ;
    ArrayList<keyPlayer> keyPlayers = new ArrayList<>();
    ArrayList<AiPlayer> AiPlayers = new ArrayList<>(0);

    public static inputbox box;
    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
<<<<<<< HEAD
        int[] keyController = {KeyEvent.VK_UP,KeyEvent.VK_DOWN,KeyEvent.VK_RIGHT,KeyEvent.VK_LEFT,KeyEvent.VK_SPACE};

        keyPlayers.add(new keyPlayer(keyController,"Capa"));
        mousePlayer=new mousePlayer("Yousef");
        runningPage=new GamePage(mousePlayer,keyPlayers,AiPlayers,0);
//        bullet b = new bullet1(0,0);
//        Chicken c = new OrdinaryChicken(100);
//        System.out.println(b.iscollesion(c));
=======
        runningPage=new ControllerScreen();
>>>>>>> origin/hazem
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        runningPage.draw();
<<<<<<< HEAD
        Operations=true;

    }
    void drawBackground(){
        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
=======
>>>>>>> origin/hazem
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
