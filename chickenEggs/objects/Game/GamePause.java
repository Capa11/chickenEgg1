package chickenEggs.objects.Game;

import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.DrawSprite;

public class GamePause extends drawable {
    // it have three buttons one for back one for retry one for settings
    Page backPage;
    public GamePause(Page backPage){
        super(0,0,1300,700,background[0]);
        this.backPage = backPage;

    }
    public void draw(){
        super.draw();
        DrawSprite(-140,0,200,120,icons[8]);
        DrawSprite(140,0,250,120,icons[15]);

    }
    public void mouseMotion(){

    }
    public void mouseClicked(){

    }
}