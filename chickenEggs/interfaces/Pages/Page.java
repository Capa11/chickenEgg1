package chickenEggs.interfaces.Pages;

import chickenEggs.interfaces.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class Page extends drawable {
    public ArrayList<Button> buttons;boolean isGame;
    public Page(int backgroundPath,ArrayList<Button> buttons){
        path=backgroundPath;
        this.buttons=buttons;
    }
    public Page(int backgroundPath){
        path=backgroundPath;
    }
    public void drawBackground(){
        DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2),path);
    }
    public void checkclick(){
        for (int i = 0; i < buttons.size(); i++) {
            if(buttons.get(i).isClicked()){
                return;
            }
        }
    }
    @Override
    public void draw(){
        drawBackground();//draw background of page;
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).draw();
        }
        if(isGame)draw();//calling draw method of gamePage
    }
}