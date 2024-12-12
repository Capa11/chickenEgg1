package chickenEggs.interfaces.Pages;

import chickenEggs.interfaces.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class inputbox extends drawable {
    public boolean isSelect=false;
    ArrayList<Character> str;int sizelimit;
    drawable[] drawString;
    int fontsize;
    public inputbox(int x, int y , int w, int h, int sizelimit, int fontSize){
        super(x,y,w,h,health[0]);
        this.sizelimit=sizelimit;
        this.fontsize=fontSize;
        str=new ArrayList<>();
        drawString=new drawable[0];
    }
    public inputbox(int x, int y , int w, int h, int sizelimit, int fontSize, int path){
        super(x,y,w,h,path);
        this.sizelimit=sizelimit;
        this.fontsize=fontSize;
        str=new ArrayList<>();
        drawString=new drawable[0];
    }
    public void writeBox(KeyEvent e){
        System.out.println((char)e.getKeyCode());
        if(isSelect) {
            if (e.getKeyCode() <= KeyEvent.VK_Z && e.getKeyCode() >= KeyEvent.VK_A && str.size() < sizelimit) {
                str.add((char) (e.getKeyCode()-'A'+'a'));
            }
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && str.size() > 0) {
                str.remove(str.size() - 1);
            }
            float xEmpty = w - ((fontsize * str.size()));//to make the string written in middle of button in x axis
            drawString = initwriteString(str, x - w / 2 + xEmpty / 2, x + w / 2, y+fontsize/2, fontsize, fontsize, 0);
        }
    }
    public boolean isClicked(){
        if(lastMouseX<=x+w/2&&lastMouseX>=x-w/2&&lastMouseY<=y+h/2&&lastMouseY>=y-h/2){
            isSelect=true;
            System.out.println("clicked");
            return true;
        }
        else{
            isSelect=false;
            return false;
        }
    }
    @Override
    public void draw(){
        super.draw();
        drawArray(drawString);
    }
}