package chickenEggs.objects.Pages;
import chickenEggs.interfaces.drawable;

import static chickenEggs.interfaces.variables.*;
public class CustomGame extends drawable{
    drawable[] arr1 =  initwriteString("players  1 2 3 4", -900, 950, 500, 60, 100, 10);
    public CustomGame() {
    }
    void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backninjastarDigitsDotBlank[0]);
        // DrawSprite(0,0, (1200), (800), backgrounds[1]);
    }

    @Override
    public void draw() {
        drawBackground();
//        drawArray(arr1);
//        drawArray(arr2);
//        drawArray(arr3);
//        drawArray(arr4);
    }
}
