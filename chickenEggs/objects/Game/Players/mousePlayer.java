package chickenEggs.objects.Game.Players;

import chickenEggs.interfaces.Game.Player;
import chickenEggs.objects.Game.bullet1;
import chickenEggs.objects.Game.rocket;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.xmouse;

public class mousePlayer extends Player {
    public mousePlayer(rocket r, String name, int xminGame, int xmaxGame, int yminGame, int ymaxGame) {
        super(r, name, xminGame, xmaxGame, yminGame, ymaxGame);
    }
    public void mouseClicked(){
        if(isClickInside( xminGame, xmaxGame , yminGame, ymaxGame)) {
            bullets.add(new bullet1((int) lastMouseX, (int) lastMouseY,xminGame,xmaxGame,yminGame,ymaxGame));
        }
    }

    public void mouseMotion(){
        if(isMouseInside(xminGame, xmaxGame , yminGame, ymaxGame)){
            if(xmouse!=r.x)r.x= (int) xmouse;
            if(ymouse!=r.y)r.y=(int)ymouse;
        }
    }
}
