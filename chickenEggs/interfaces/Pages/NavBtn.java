package chickenEggs.interfaces.Pages;

import chickenEggs.interfaces.drawable;

import static chickenEggs.interfaces.variables.*;

public class NavBtn extends Button{
    public NavBtn(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize);
     }
    public NavBtn(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround,page,s,fontsize,ystring,iconpath,xicon,yicon,wicon,hicon);
    }

    @Override
    public void ifClicked() {
        runningPage=page;
    }
}
