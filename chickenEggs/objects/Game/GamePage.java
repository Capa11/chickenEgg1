package chickenEggs.objects.Game;

import chickenEggs.interfaces.Game.Chicken;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Game.Players.AiPlayer;
import chickenEggs.objects.Game.Players.keyPlayer;
import chickenEggs.objects.Game.Players.mousePlayer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;
public class GamePage extends Page {
    SingleGame singleGame;
    ArrayList<Chicken> chickens;
    float[] probilityChickens;
    public GamePage(mousePlayer mousePlayer, ArrayList<keyPlayer> keyPlayers, ArrayList<AiPlayer> AiPlayers, int level){//level 0 means not custom game
        path=background[0];
        if(level==0) {
            singleGame = new SingleGame((int) -xaxis, (int) xaxis, (int) -yaxis, (int) yaxis,mousePlayer,keyPlayers,AiPlayers,5,initChicken(level));
        }
    }
    public ArrayList<Chicken> initChicken(int level){
       chickens = new ArrayList<>(20);//how many chickens
        for (int i = 0; i < chickens.size(); i++) {
            chickens.set(i,new Chicken(0,0,0,0,0,0,0,0,0,0,0));
        }
        return chickens;
    }
    public void ifkeyPressed(int e) {
        if(e== KeyEvent.VK_ESCAPE){
            isGameRunning=!isGameRunning;
            //menu bar
        }
        singleGame.keyPressed(e);
    }
    public void ifClicked(){
        singleGame.mouseClicked();
    }
    public void ifMouseMotion(){
        singleGame.mouseMotion();

    }


}
