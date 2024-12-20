package chickenEggs.interfaces.Pages;

import chickenEggs.interfaces.*;

import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class Page extends drawable {
    public ArrayList<Button> buttons = new ArrayList<>();
    boolean isGame;
    public Page(){
    }
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
    public void ifClicked(){}//for calling subclasses when overriding
    public void ifMouseMotion(){}//for calling subclasses when overriding
    public void ifkeyPressed(int e) {}//for calling subclasses when overriding

    public void isClicked(){
        for (Button button : buttons) {
            button.isClicked();
        }
        ifClicked();
    }
    public void mouseMoved(){
        for (Button button : buttons) {
            button.mouseMoved();
        }
        ifMouseMotion();
    }
    public void keyPressed(int e){
        for (Button button : buttons) {
            button.keyPressed(e);
        }
        ifkeyPressed(e);
    }


    @Override
    public void draw(){
        drawBackground();//draw background of page;
        for (Button button : buttons) {
            button.draw();
        }
        if(isGame)draw();//calling draw method of gamePage
    }
}