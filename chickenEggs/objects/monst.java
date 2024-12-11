package chickenEggs.objects;

import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

public class monst extends drawable{
    public monst(int x, int y, int w, int h){
        super(x,y,w,h,backgrounds[backgrounds.length-1]);
    }

}
