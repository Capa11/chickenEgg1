package chickenEggs.objects.Pages;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;

import java.util.ArrayList;
import static chickenEggs.interfaces.variables.*;

//2
public class CustomScreen extends Page {
    //    drawable[] arr1 =  initwriteString("players  1 2 3 4", -900, 950, 500, 60, 100, 10);
//    drawable[] arr2 =  initwriteString("settings", -900, -850, 400, 60, 100, 10);
//    drawable[] arr3 =  initwriteString("levels", -900, -850, 200, 60, 100, 10);
//    drawable[] arr4 =  initwriteString("game modes", -900, -850, 0, 60, 100, 10);
//    public CustomScreen() {
//    }
//    void drawBackground(){
//        //DrawSprite(0,0, (int) (xaxis*2), (int) (yaxis*2), backgrounds[0]);
//       // DrawSprite(0,0, (1200), (800), backgrounds[1]);
//    }
//
//    @Override
//    public void draw() {
//        drawBackground();
//        drawArray(arr1);
//        drawArray(arr2);
//        drawArray(arr3);
//        drawArray(arr4);
//    }

    //Labels
    drawable[] players = initwriteString("players",-600,-250,500,100,100,5);
//    Buttons
    CustomButton rightPlayers = new CustomButton(200, 400, 100, 80, icons[4], null, "", 50);
    CustomButton leftPlayers = new CustomButton(-200, 400, 100, 80, icons[4+2], null, "", 50);
    CustomButton leftHuman = new CustomButton(-200, 300, 100, 80, icons[4+2], null, "", 50);
    CustomButton rightHuman = new CustomButton(200, 300, 100, 80, icons[4], null, "", 50);
    CustomButton rightAi = new CustomButton(200, 200, 100, 80, icons[4], null, "", 50);
    CustomButton leftAi = new CustomButton(-200, 200, 100, 80, icons[4+2], null, "", 50);
    CustomButton rightLevels = new CustomButton(200, 100, 100, 80, icons[4], null, "", 50);
    CustomButton leftLevels = new CustomButton(-200, 100, 100, 80, icons[4+2], null, "", 50);
    CustomButton incVol = new CustomButton(200, 0, 100, 80, icons[0], null, "", 50);
    CustomButton decVol = new CustomButton(-200, 0, 100, 80, icons[0+2], null, "", 50);

    ArrayList<CustomButton> arr = new ArrayList<>();

    public CustomScreen() {
        super(man[man.length - 1]);
//        arr.add(b1);
        arr.add(rightPlayers);
        arr.add(leftPlayers);
        arr.add(rightHuman);
        arr.add(leftHuman);
        arr.add(rightAi);
        arr.add(leftAi);
        arr.add(rightLevels);
        arr.add(leftLevels);
        arr.add(incVol);
        arr.add(decVol);
        drawArray(players);
        super.buttons = arr;
    }
}





















 class CustomButton extends drawable{
    Page page;drawable[] buttonName;boolean haveIcon=false;drawable icon;
    public CustomButton(){}
    public CustomButton(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround);
        this.page=page;
        float xEmpty=w-((fontsize*s.length()));//to make the string written in middle of button in x axis
        buttonName=initwriteString(s,xbutton-wbutton/2+xEmpty/2,xbutton+wbutton/2,ybutton+fontsize/2,fontsize,fontsize,0);//wbutton and fontsize used for centrilize the string in y axis
    }
    public CustomButton(int xbutton, int ybutton , int w, int h, int backGround,Page page,String s,int ystring,int fontsize,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,w,h,backGround);
        this.page=page;
        float xEmpty=w-((fontsize*s.length()));
        buttonName=initwriteString(s,xbutton-w/2+xEmpty/2,xbutton+w/2,ystring,fontsize,fontsize,0);
        haveIcon=true;
        icon=new drawable(xicon,yicon,wicon,hicon,iconpath);
    }
    public boolean isClicked(){
        if(lastMouseX<=x+w/2&&lastMouseX>=x-w/2&&lastMouseY<=y+h/2&&lastMouseY>=y-h/2){
            runningPage=page;
            System.out.println("clicked");
            return true;
        }
        else return false;
    }
    @Override
    public void draw(){
        super.draw();//draw background of button
        drawArray(buttonName);//writing button name on it
        if(haveIcon)icon.draw();
    }
}
