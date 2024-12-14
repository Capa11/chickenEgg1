package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;

import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.CustomGameInstraction;
//import chickenEggs.objects.Pages.Statement;


public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;

    public static inputbox box;
    OrdinaryChicken chicken;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
//        runningPage=new CustomScreen();
        runningPage = new CustomGameInstraction();
//        runningPage = new Statement();

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
