package chickenEggs.objects.Game;
import chickenEggs.interfaces.Game.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class rocket extends singleGameObject {
    public boolean preparingRocket = true;
    int sheildTimer = 0;
    public static boolean[] rocketSkin = {true, true, true, true};
    public static int wRocket = 200;
    public static int hRocket = 200;
    boolean bulletready = true;
    public static int reloadTimer=100;
    int bulletReloadTimer=reloadTimer;
    Player player;
    int xBegining=0;
    public rocket(int x, int y, Player player) {
        super(x, y, wRocket, hRocket, rockets[0]);
        this.player = player;
        speed=10;
    }

    public rocket(Player player) {
        super(0, (int) (-yaxis + 100), wRocket, hRocket);
        this.player = player;
        speed=10;
        start();
    }

    public void destroy() {
        if (sheildTimer <= 0) {
            sounds[5].play();
            xBegining=0;
            start();
            player.health--;
            preparingRocket = true;
        }
    }

    public void start() {
        sheildTimer = 200;
        y = (int) (-yaxis - 100);
    }

    public void draw() {
//        if(y<yminGame+h&& preparingRocket){
//            y+=speed;
//        }
//        else preparingRocket =false;
//        if(isInside())
        super.draw();
        if (sheildTimer > 0){
            sheildTimer--;
            DrawSprite(x,y,wRocket+50,hRocket+50,icons[14]);
        }
        if (reloadTimer > 0) reloadTimer--;

        if (preparingRocket && y < -yaxis + 100) {
            y += 2;
            x=xBegining;
        }
        else preparingRocket = false;
    }

    public void moveleft() {
        if (!preparingRocket) {
            x -= speed;
            if (!isInside()) x += speed;
        }
    }

    public void moveright() {
        if (!preparingRocket) {
            x += speed;
            if (!isInside()) x -= speed;
        }
    }

    public void moveup() {
        if (!preparingRocket) {
            y += speed;
            if (!isInside()) y -= speed;
        }
    }

    public void movedown() {
        if (!preparingRocket) {
            y -= speed;
            if (!isInside()) y += speed;
        }
    }

    public void fire() {
        if (player.health > 0&&reloadTimer<=0){
            player.bullets.add(new bullet1(x, y + bullet.defaultSize,player));
            reloadTimer=bulletReloadTimer;
            sounds[3].play();
        }
    }


}
