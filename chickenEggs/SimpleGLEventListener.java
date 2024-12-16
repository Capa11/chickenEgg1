package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;

import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.*;
import chickenEggs.objects.Sound;
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

    private java.awt.Component component;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);

        // Initialize the background sound and start looping
        Sound backgroundSound = Sound.loadFromFile("chickenEgg1/chickenEggs/Sounds/BlueBoyAdventure.wav");
        if (backgroundSound != null) {
            backgroundSound.playLooping();
        }
//        Dead Chicken Sound Effect.wav
        // D:\practice code\304 file\project-game-jetbrains--main\chickenEgg1\chickenEggs\Sounds\BlueBoyAdventure.wav


//        runningPage=new CustomScreen();
//        runningPage = new CustomGameInstraction();
//        runningPage = new Statement();
//        runningPage = new HandelChickenMove();
//        runningPage = new HandelChickenMove2();
//        runningPage = new InstractionDefult();
        // runningPage = new chickencircle2();
//        runningPage = new chickencircle();
        runningPage = new ControllerScreen();

        // this is for cursor
        component = (java.awt.Component) gld;

        // Assign this instance to the static variable for access in other classes
        variables.simpleGLEventListenerInstance = this;

        // un comment this line to set custom cursor
//       setCustomCursor("chickenEgg1/chickenEggs/Assets/Man/11.png");
    }

    //cursor
    // Make setCustomCursor public and accept an image path
    public static void setCustomCursor(String imagePath) {
        SimpleGLEventListener listener = variables.simpleGLEventListenerInstance;
        if (listener != null && listener.component != null) {
            // Load the cursor image
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image cursorImage = toolkit.getImage(imagePath);

            // Create the custom cursor
            Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "Custom Cursor");

            // Set the custom cursor on the component
            listener.component.setCursor(customCursor);
        }
    }
    //end

    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        runningPage.draw();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {}

    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}
}
