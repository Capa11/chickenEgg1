package chickenEggs.interfaces.Pages;
import chickenEggs.interfaces.*;
import static chickenEggs.interfaces.variables.*;
public abstract class Button extends drawable{
    Page page;drawable[] buttonName;boolean haveIcon=false;drawable icon;
    public Button(){}
    public Button(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround);
        this.page=page;
        float xEmpty=w-((fontsize*s.length()));//to make the string written in middle of button in x axis
        buttonName=initwriteString(s,xbutton-wbutton/2+xEmpty/2,xbutton+wbutton/2,ybutton+fontsize/2,fontsize,fontsize,0);//wbutton and fontsize used for centrilize the string in y axis
    }
    public Button(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround);
        this.page=page;
        float xEmpty=w-((fontsize*s.length()));
        buttonName=initwriteString(s,xbutton-w/2+xEmpty/2,xbutton+w/2,ystring,fontsize,fontsize,0);
        haveIcon=true;
        icon=new drawable(xicon,yicon,wicon,hicon,iconpath);
    }
    public abstract boolean isClicked();
    @Override
    public void draw(){
        super.draw();//draw background of button
        drawArray(buttonName);//writing button name on it
        if(haveIcon)icon.draw();
    }
}
