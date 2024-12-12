package chickenEggs.objects.Game;
import chickenEggs.interfaces.drawable;
import static chickenEggs.interfaces.variables.*;
import chickenEggs.interfaces.*;
public interface Chicken {
     void moveleft();
     void moveright();
     void moveup();
     void movedown();
     void makeegg();
     void eggDuration();
     boolean istheredamage();
     boolean amIdead();

}
