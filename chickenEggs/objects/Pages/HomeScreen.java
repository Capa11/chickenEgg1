package chickenEggs.objects.Pages;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.objects.*;

import static chickenEggs.interfaces.variables.*;

public class HomeScreen extends drawable{
    drawable[] arr =  initwriteString("hazem" , 50 , 200 , -500 ,10 , 10 , 2 );
    void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backgrounds[0]);
        DrawSprite(0,0, (1200), (500), backgrounds[1]);
    }
<<<<<<< Updated upstream
    drawable[] button(String str , float ys, int x , int y , int gabY , float Bw , float Bh , int w , int h , int texture ){
        drawable ha = new drawable(50 ,100 , 500 , 200 , numbers[2]);
       return initwriteString(str , x - (Bw/2) , x + (Bw/2) , y - (Bh/2),w,h, gabY);
=======
    drawable[] button(String str , float ys, int x , int y , int gabY , float Bw , float Bh , int w , int h ){
       return initwriteString(str , x - (Bw/2) , x + (Bw/2) , y - (Bh/2),w,h, gabY );
>>>>>>> Stashed changes
    }
    public HomeScreen() {
    }

    @Override
    public void draw() {
        drawBackground();
        drawArray(arr);
    }
}
