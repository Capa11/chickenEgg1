package chickenEggs.objects.Pages.Buttons;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Pages.Data.Humans;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.drawArray;

public class NextHuman extends Button {
    public NextHuman(){}
    public NextHuman(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize);
    }
    public NextHuman(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize, ystring, iconpath, xicon, yicon, wicon, hicon);
    }

    @Override
    public void ifClicked(){
        if (numHuman+numAi<numPlayers && numHuman<4){
            new Humans(++numHuman);
        }
        System.out.println("Number of humans is "+numHuman);
    }
}

