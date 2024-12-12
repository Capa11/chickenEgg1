package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
<<<<<<< Updated upstream
=======
import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;
import chickenEggs.objects.Pages.CustomScreen;
>>>>>>> Stashed changes

import chickenEggs.interfaces.*;
import chickenEggs.objects.*;
public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
<<<<<<< Updated upstream
        mons = new monst(300,0,200,200);
        str1 = new drawable[20];
        for (int i = 0; i < 20; i++) {
            str1[i] = new drawable();
            str1[i].path=baskets[0];
        }
        initGrid(str1,-xaxis,xaxis,0,300,100,20,20);
        str = new drawable[20];
        for (int i = 0; i < 20; i++) {
            str[i] = new drawable();
            str[i].path=baskets[1];
        }
        initGrid(str,-xaxis,xaxis,yaxis,100,100,20,20);
=======
        runningPage=new CustomScreen();
>>>>>>> Stashed changes
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        drawBackground();
<<<<<<< Updated upstream
        mons.draw();
        drawArray(str1);
        drawArray(str);
=======
        runningPage.draw();
>>>>>>> Stashed changes

    }
    void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
