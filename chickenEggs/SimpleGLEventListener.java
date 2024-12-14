package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;

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
    OrdinaryChicken chicken;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
//        runningPage=new CustomScreen();
//        runningPage = new CustomGameInstraction();
//        runningPage = new Statement();
//        runningPage = new HandelChickenMove();
//        runningPage = new InstractionDefult();
        runningPage = new chickencircle();
        // runningPage = new chickencircle2();

        // Set custom cursor
        setCustomCursor(gld);

    }
//cursor
    private void setCustomCursor(GLAutoDrawable gld) {
        // Get the AWT component from the GL drawable
        java.awt.Component component = (java.awt.Component) gld;

        // Load the cursor image
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image cursorImage = toolkit.getImage("chickenEgg1/chickenEggs/Assets/Man/Man2.png");
        //chickenEggs/Assets/Man/Man2.png
        //D:\practice code\304 file\project-game-jetbrains--main\chickenEgg1\chickenEggs\Assets\Man\Man2.png

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


    }
    void drawBackground(){
        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
