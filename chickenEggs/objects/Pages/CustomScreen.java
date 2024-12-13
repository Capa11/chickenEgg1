package chickenEggs.objects.Pages;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.Pages.inputbox;

import java.util.ArrayList;
import static chickenEggs.interfaces.variables.*;

//2
public class CustomScreen extends Page {
    //    drawable[] arr1 =  initwriteString("players  1 2 3 4", -900, 950, 500, 60, 100, 10);
//    drawable[] arr2 =  initwriteString("settings", -900, -850, 400, 60, 100, 10);
//    drawable[] arr3 =  initwriteString("levels", -900, -850, 200, 60, 100, 10);
//    drawable[] arr4 =  initwriteString("game modes", -900, -850, 0, 60, 100, 10);
//    public CustomScreen() {
//    }
//    void drawBackground(){
//        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backgrounds[0]);
//       // DrawSprite(0,0, (1200), (800), backgrounds[1]);
//    }
//
//    @Override
//    public void draw() {
//        drawBackground();
//        drawArray(arr1);
//        drawArray(arr2);
//        drawArray(arr3);
//        drawArray(arr4);
//    }
    Button b1 = new NavBtn(0, 0, 500, 300, health[0], null, "yousef", 50);
    ArrayList<Button> arr = new ArrayList<>();
    inputbox box = new inputbox(0,400,400,100,5,30);

    public CustomScreen() {
        super(man[man.length - 1]);
        arr.add(b1);
        super.buttons = arr;
    }
    @Override
    public void keyPressed(int e){
        if (e == 'A') System.out.println("hhhh");
    }
}
