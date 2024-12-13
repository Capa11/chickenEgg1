package chickenEggs.objects.Pages.Buttons;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.interfaces.drawable;
import chickenEggs.objects.Pages.Data.Ais;
import chickenEggs.objects.Pages.Data.Humans;
import chickenEggs.objects.Pages.Data.Players;

import static chickenEggs.interfaces.variables.*;
import static chickenEggs.interfaces.variables.drawArray;

public class LeftPlayers extends Button {
    public LeftPlayers(){}
    public LeftPlayers(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize);
    }
    public LeftPlayers(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize, ystring, iconpath, xicon, yicon, wicon, hicon);
    }

    @Override
    public void ifClicked(){
        if (numPlayers== numHuman+numAi){
            numAi=0;
            numHuman =0;
            new Humans(0);
            new Ais(0);
        }
        if (numPlayers>0){
            new Players(--numPlayers);
        }
        System.out.println("Number of players is "+numPlayers);
    }
}

