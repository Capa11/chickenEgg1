package chickenEggs.objects.Pages.Buttons;

import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Pages.Data.Humans;
import chickenEggs.objects.Pages.Data.Players;

import static chickenEggs.interfaces.variables.*;

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
        if (numPlayers<=numHuman){
            numHuman = 0;
            new Humans(numHuman);
        }
        if (numPlayers>0){
            new Players(--numPlayers);
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

