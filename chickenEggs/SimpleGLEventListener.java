package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
<<<<<<< Updated upstream
import chickenEggs.objects.Pages.CustomScreen;
import chickenEggs.objects.Pages.HomeScreen;
=======
import chickenEggs.objects.*;
import chickenEggs.objects.Pages.CustomGame;
>>>>>>> Stashed changes

public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;
    HomeScreen homeScreen;
    CustomScreen customScreen;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
<<<<<<< Updated upstream
        homeScreen = new HomeScreen();
        customScreen = new CustomScreen();

=======
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
        new CustomGame();
>>>>>>> Stashed changes
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
<<<<<<< Updated upstream
        homeScreen.draw();
=======
        drawBackground();
        mons.draw();
        drawArray(str1);
        drawArray(str);
//mahmoud
//        new CustomGame();
>>>>>>> Stashed changes
    }
    void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backgrounds[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}


}
