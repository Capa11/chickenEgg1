package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;
import chickenEggs.objects.Pages.ControllerScreen;
import chickenEggs.objects.Pages.CustomScreen;

import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.HomeScreen;
import chickenEggs.objects.Pages.PlayerControllerScreen;


public class SimpleGLEventListener extends variables {

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
        runningPage=new HomeScreen();
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        runningPage.draw();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
