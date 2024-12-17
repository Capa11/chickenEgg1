package chickenEggs.interfaces.Pages;
import chickenEggs.interfaces.*;
import static chickenEggs.interfaces.variables.*;
public class Button extends drawable{
    Page page;drawable[] buttonName;public boolean haveIcon=false,isSelect=false;drawable icon;public String text;
    int whover,hhover;
    int wnoHover,hnoHover;
    public Button(){}
    public Button(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize){
        super(xbutton,ybutton,wbutton,hbutton,backGround);
        this.page=page;
        this.text = s;
        float xEmpty=w-((fontsize*s.length()));//to make the string written in middle of button in x axis
        buttonName=initwriteString(s,xbutton-wbutton/2+xEmpty/2,xbutton+wbutton/2,ybutton+fontsize/2,fontsize,fontsize,0);//wbutton and fontsize used for centrilize the string in y axis
        whover=(int)(w*1.2);
        hhover=(int)(h*1.2);
        hnoHover=h;
        wnoHover=w;
    }
    public Button(int xbutton, int ybutton , int wbutton, int hbutton, int backGround,Page page,String s,int fontsize,int ystring,int iconpath,int xicon,int yicon,int wicon,int hicon){
        super(xbutton,ybutton,wbutton,hbutton,backGround);
        this.page=page;
        this.text =s;
        float xEmpty=w-((fontsize*s.length()));
        buttonName=initwriteString(s,xbutton-w/2+xEmpty/2,xbutton+w/2,ystring,fontsize,fontsize,0);
        haveIcon=true;
        icon=new drawable(xicon,yicon,wicon,hicon,iconpath);
        whover=(int)(w*1.3);
        hhover=(int)(h*1.3);
        hnoHover=h;
        wnoHover=w;
    }
    @Override
    public void draw(){
        super.draw();//draw background of button
        drawArray(buttonName);//writing button name on it
        if(haveIcon)icon.draw();
    }
    public boolean isInside(float xcheck,float ycheck){
        if(xcheck<=x+w/2&&xcheck>=x-w/2&&ycheck<=y+h/2&&ycheck>=y-h/2){
            return true;
        }
        return false;
    }
    public void ifMouseMoved(){}//for calling subclasses when overriding
    public void ifMouseOutMoved(){}//for calling subclasses when overriding
    public void ifkeyPressed(int e) {}//for calling subclasses when overriding
    public void ifClicked(){}
    public void isClicked(){
        if(isInside(lastMouseX,lastMouseY)){
            isSelect=true;
            sounds[1].play();
            ifClicked();
        }
        else {
            isSelect=false;
        }
    }
    public boolean mouseMoved(){
        if(isInside(xmouse,ymouse)){
            w=whover;
            h=hhover;
            ifMouseMoved();
            return true;
        }else {
            w=wnoHover;
            h=hnoHover;
            ifMouseOutMoved();
            return false;
        }

    }
    public void keyPressed(int e){
        if(isSelect)ifkeyPressed(e);
    }

}
