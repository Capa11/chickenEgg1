package chickenEggs.objects.Pages.Buttons;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Pages.Data.Humans;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.drawArray;

public class PrevHuman extends Button {
    public PrevHuman(){}
    public PrevHuman(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize);
    }
    public PrevHuman(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize, ystring, iconpath, xicon, yicon, wicon, hicon);
    }

    @Override
    public void ifClicked(){
        if (numHuman>0){
            new Humans(--numHuman);
            numAi = numPlayers-numHuman;
        }
        System.out.println("Number of players is "+numPlayers);
        System.out.println("Number of human is "+numHuman);
        System.out.println("Number of Ai is "+numAi);
    }
    @Override
    public void ifMouseMoved(){
        super.path = background[1];
    }
    @Override
    public void ifMouseOutMoved(){
        super.path = icons[6];
    }
}

