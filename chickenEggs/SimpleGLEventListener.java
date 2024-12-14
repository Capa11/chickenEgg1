package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;


import chickenEggs.objects.Pages.CustomScreen;

import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.InstractionDefult;
import chickenEggs.objects.Pages.ScoreBoard;
import chickenEggs.objects.Pages.Statement;



import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.*;
//cursor
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
//end


public class SimpleGLEventListener extends variables {

    drawable mons;
    drawable[] str1;
    drawable[] str;



    public static inputbox box;
    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
        runningPage = new Statement();

    }

    private java.awt.Component component;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
//        runningPage=new CustomScreen();
//        runningPage = new CustomGameInstraction();
//        runningPage = new Statement();
//        runningPage = new HandelChickenMove();
//        runningPage = new InstractionDefult();
        // runningPage = new chickencircle2();
        runningPage = new chickencircle();

        // Store the component for later use
        component = (java.awt.Component) gld;

        // Set initial custom cursor
        setCustomCursor("chickenEgg1/chickenEggs/Assets/Man/Man1.png");

    }
    //cursor
    // Make setCustomCursor public and accept an image path
    public void setCustomCursor(String imagePath) {
        // Load the cursor image
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursorImage = toolkit.getImage(imagePath);

        // Create the custom cursor
        Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "Custom Cursor");

        // Set the custom cursor on the component
        component.setCursor(customCursor);
    }
    //end


    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        runningPage.draw();
        Operations=true;

    }



    void drawBackground(){
        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }



    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
