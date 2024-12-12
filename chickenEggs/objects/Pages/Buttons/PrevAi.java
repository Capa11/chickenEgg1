package chickenEggs.objects.Pages.Buttons;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Pages.Data.Ais;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.drawArray;

public class PrevAi extends Button {
    public PrevAi(){}
    public PrevAi(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize);
    }
    public PrevAi(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize, ystring, iconpath, xicon, yicon, wicon, hicon);
    }


    @Override
    public void ifClicked(){
        if (numHuman+numAi<numPlayers && numAi>0){
            new Ais(--numAi);
        }
        System.out.println("Number of ai is "+numAi);
    }
}

