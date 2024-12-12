package chickenEggs.objects.Pages.Buttons;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.drawArray;

public class PrevLevel extends Button {
    public PrevLevel(){}
    public PrevLevel(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize);
    }
    public PrevLevel(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize, ystring, iconpath, xicon, yicon, wicon, hicon);
    }

    @Override
    public void ifClicked(){

    }
}

