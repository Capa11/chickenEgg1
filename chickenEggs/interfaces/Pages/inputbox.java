package chickenEggs.interfaces.Pages;

import chickenEggs.interfaces.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class inputbox extends drawable {
    public boolean isSelect = false;
    ArrayList<Character> str;
    int sizelimit;
    drawable[] drawString;
    int fontsize;

    public inputbox(int x, int y, int w, int h, int sizelimit, int fontSize) {
        super(x, y, w, h, health[0]);
        this.sizelimit = sizelimit;
        this.fontsize = fontSize;
        str = new ArrayList<>();
        drawString = new drawable[0];
    }

    public inputbox(int x, int y, int w, int h, int sizelimit, int fontSize, int path) {
        super(x, y, w, h, path);
        this.sizelimit = sizelimit;
        this.fontsize = fontSize;
        str = new ArrayList<>();
        drawString = new drawable[0];
    }

    public void ifKeyPressed(int e) {
        if (e <= KeyEvent.VK_Z && e >= KeyEvent.VK_A && str.size() < sizelimit) {
            str.add((char) (e - 'A' + 'a'));
        }
        else if (e == KeyEvent.VK_SPACE) {
            str.add('s');
            str.add('p');
            str.add('a');
            str.add('c');
            str.add('e');
        } else if (e == KeyEvent.VK_UP) {
            str.add('u');str.add('p');

        }else if (e == KeyEvent.VK_DOWN) {
            str.add('d');str.add('o');str.add('w');str.add('n');
        }
        else if (e == KeyEvent.VK_SHIFT) {
            str.add('s');
            str.add('h');
            str.add('i');
            str.add('f');
            str.add('t');
        } else if (e == KeyEvent.VK_ENTER) {
            str.add('e');
            str.add('n');
            str.add('t');
            str.add('e');
            str.add('r');
        } else if (e == KeyEvent.VK_TAB) {
            str.add('t');
            str.add('a');
            str.add('b');
        } else if (e == KeyEvent.VK_ALT) {
            str.add('a');
            str.add('l');
            str.add('t');
        } else if (e == KeyEvent.VK_CONTROL) {
            str.add('c');
            str.add('t');
            str.add('r');
            str.add('l');
        } else if (e == KeyEvent.VK_LEFT) {
            str.add('l');
            str.add('e');
            str.add('f');
            str.add('t');
        } else if (e == KeyEvent.VK_RIGHT) {
            str.add('r');
            str.add('i');
            str.add('g');
            str.add('h');
            str.add('t');
        } else if (e == KeyEvent.VK_SLASH) {
            str.add('/');
        } else if (e == KeyEvent.VK_MINUS) {
            str.add('-');
        } else if (e == KeyEvent.VK_COMMA) {
            str.add(',');
        } else if (e == KeyEvent.VK_PERIOD) {
            str.add('.');
        } else if (e == KeyEvent.VK_BACK_SLASH) {
            str.add('\\');
        } else if (e == KeyEvent.VK_PLUS) {
            str.add('-');
        }


        if (e == KeyEvent.VK_BACK_SPACE && !str.isEmpty()) {
            str.remove(str.size() - 1);
        }
        float xEmpty = w - ((fontsize * str.size()));//to make the string written in middle of button in x axis
        drawString = initwriteString(str, x - (float) w / 2 + xEmpty / 2, x + (float) w / 2, y + (float) fontsize / 2, fontsize, fontsize, 0);
    }

    public void keyPressed(int e) {
        System.out.println((char) e);
        if (isSelect) {
            ifKeyPressed(e);
        }
    }

    public boolean isClicked() {
        if (lastMouseX <= x + (float) w / 2 && lastMouseX >= x - (float) w / 2 && lastMouseY <= y + (float) h / 2 && lastMouseY >= y - (float) h / 2) {
            isSelect = true;
            str.clear();
            System.out.println("clicked");
            return true;
        } else {
            isSelect = false;
            return false;
        }
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(drawString);
    }
}