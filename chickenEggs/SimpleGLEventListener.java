package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;
import chickenEggs.objects.*;
public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;
    OrdinaryChicken chicken;
    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
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
         chicken = new OrdinaryChicken(0,0,200,200,3,-1000,1000,-600,600);
        chicken.makeegg();
        chicken.eggs.get(0).draw();
    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        drawBackground();
        mons.draw();
        drawArray(str1);
        drawArray(str);
        chicken.draw();
        chicken.eggDuration();
        for (int i = 0; i < chicken.eggs.size(); i++) {
            if(!(chicken.eggs.get(i).is_inside())){chicken.eggs.remove(i);}
            else chicken.eggs.get(i).draw();
        }
    }
    void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
