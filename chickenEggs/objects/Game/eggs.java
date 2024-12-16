package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;

public class eggs extends Egg{
    public eggs(int x, int y, int w, int h,int path) {
        super(x, y, w, h , path);
        speed=4;
    }
    public eggs(int x, int y, int w, int h) {
        super(x, y, w, h , egg[0]);
        speed=4;
    }
    public eggs(int x, int y) {
        super(x, y, wegg, hegg , egg[0]);
        speed=4;
    }


}
