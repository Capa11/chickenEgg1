package chickenEggs;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.objects.Game.*;
import chickenEggs.interfaces.*;
import chickenEggs.objects.Pages.CustomScreen;

import chickenEggs.interfaces.Pages.*;


public class SimpleGLEventListener extends variables {
    drawable mons;
    drawable[] str1;
    drawable[] str;


    public static inputbox box;
    OrdinaryChicken chicken;

    public void init(GLAutoDrawable gld) {
        gl = gld.getGL();
        init(gl);
        runningPage=new CustomScreen();

    UnordinaryChicken chicken1;
    OrdinaryChicken chicken;
    SuperChicken chicken2;
    UltimateChicken chicken3;
    eggs egg;
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
        chicken1 = new UnordinaryChicken(-200,0,200,200,3,-1000,1000,-600,600);
        chicken2 = new SuperChicken(-400,0,200,200,3,-1000,1000,-600,600);
        chicken3 = new UltimateChicken(-600,0,200,200,3,-1000,1000,-600,600);

    }
    public void display(GLAutoDrawable gld) {
        gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        runningPage.draw();



        drawBackground();
        chicken.draw();
        chicken1.draw();
        chicken2.draw();
        chicken3.draw();
        chicken.falleggs();
        chicken1.falleggs();
        chicken2.falleggs();
        chicken3.falleggs();
        for (int i = 0; i < chicken.eggs.size(); i++) {
            if(!(chicken.eggs.get(i).is_inside())){
                chicken.eggs.remove(i);
            }
        }
        for (int i = 0; i < chicken1.eggs.size(); i++) {
            if(!(chicken1.eggs.get(i).is_inside())){
                chicken1.eggs.remove(i);
            }
        }
        for (int i = 0; i < chicken2.eggs.size(); i++) {
            if(!(chicken2.eggs.get(i).is_inside())){
                chicken2.eggs.remove(i);
            }
        }
        for (int i = 0; i < chicken3.eggs.size(); i++) {
            if(!(chicken3.eggs.get(i).is_inside())){
                chicken3.eggs.remove(i);
            }
        }

    }


    void drawBackground(){
        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),backninjastarDigitsDotBlank[0]);
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {}

}
