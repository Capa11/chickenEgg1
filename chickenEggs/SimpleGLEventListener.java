package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.objects.Pages.CustomScreen;
import chickenEggs.objects.Pages.HomeScreen;

public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;
    HomeScreen homeScreen;
    CustomScreen customScreen;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
        homeScreen = new HomeScreen();
        customScreen = new CustomScreen();

    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        homeScreen.draw();
    }
    void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backgrounds[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}


}
