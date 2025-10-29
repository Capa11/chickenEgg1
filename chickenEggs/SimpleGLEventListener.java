package chickenEggs;

import com.jogamp.*;


import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;
import chickenEggs.objects.Game.Chickens.OrdinaryChicken;
import chickenEggs.objects.Pages.ControllerScreen;
import chickenEggs.objects.Pages.CustomScreen;

import chickenEggs.interfaces.Pages.*;
import chickenEggs.objects.Pages.HomeScreen;
import chickenEggs.objects.Pages.PlayerControllerScreen;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;


public class SimpleGLEventListener extends variables {
    public void init(GLAutoDrawable gld) {
        gl = gld.getGL().getGL2();
        init(gl);
        runningPage=new HomeScreen();
    }

    public void display(GLAutoDrawable gld) {
        gl = gld.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        runningPage.draw();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }
}
