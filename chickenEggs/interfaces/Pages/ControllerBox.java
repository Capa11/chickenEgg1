package chickenEggs.interfaces.Pages;

import chickenEggs.interfaces.*;

import java.awt.event.KeyEvent;

import static chickenEggs.interfaces.variables.*;

public class ControllerBox extends drawable {
    public boolean isSelect = false;
    int changed;
    KeyEvent keyCode;
    StringBuilder str;
    drawable[] drawString;
    int fontSize;

    public ControllerBox(int x, int y, int w, int h, int fontSize, int changed) {
        super(x, y, w, h, health[0]);
        this.fontSize = fontSize;
        this.changed = changed;
        str = new StringBuilder();  // Initialize the StringBuilder
        drawString = new drawable[0];
    }

    public ControllerBox(int x, int y, int w, int h, int changed, int fontSize, int path) {
        super(x, y, w, h, path);
        this.fontSize = fontSize;
        this.changed = changed;
        str = new StringBuilder();  // Initialize the StringBuilder
        drawString = new drawable[0];
    }

    public void ifKeyPressed(int e) {

        if (e <= KeyEvent.VK_Z && e >= KeyEvent.VK_A) {
            str.append((char) (e - 'A' + 'a'));
        } else if (e == KeyEvent.VK_SPACE) {
            str.append("space");
        } else if (e == KeyEvent.VK_UP) {
            str.append("up");
        } else if (e == KeyEvent.VK_DOWN) {
            str.append("down");
        } else if (e == KeyEvent.VK_SHIFT) {
            str.append("shift");
        } else if (e == KeyEvent.VK_ENTER) {
            str.append("enter");
        } else if (e == KeyEvent.VK_TAB) {
            str.append("tab");
        } else if (e == KeyEvent.VK_ALT) {
            str.append("alt");
        } else if (e == KeyEvent.VK_CONTROL) {
            str.append("ctrl");
        } else if (e == KeyEvent.VK_LEFT) {
            str.append("left");
        } else if (e == KeyEvent.VK_RIGHT) {
            str.append("right");
        } else if (e == KeyEvent.VK_SLASH) {
            str.append("slash");
        } else if (e == KeyEvent.VK_MINUS) {
            str.append("minus");
        } else if (e == KeyEvent.VK_COMMA) {
            str.append("comma");
        } else if (e == KeyEvent.VK_PERIOD) {
            str.append("period");
        } else if (e == KeyEvent.VK_PLUS) {
            str.append("plus");
        } else if (e >= KeyEvent.VK_0 && e <= KeyEvent.VK_9) {
            str.append((char)e);
        }
        arr[changed] = str.toString();

        controllers.set(playerController-1, arr);

        float xEmpty = w - ((fontSize * str.length())); // To make the string written in the middle of button on the x-axis
        drawString = initwriteString(controllers.get(playerController-1)[changed], x - (float) w / 2 + xEmpty / 2, x + (float) w / 2, y + (float) fontSize / 2, fontSize, fontSize, 0);

        keyReleased();
    }



    public void keyPressed(int e) {
        if (isSelect && !isController(e)) {
            ifKeyPressed(e);
            controllerBits.set(e);
        }
        if(isSelect && isController(e)) controllerBits.clear(e);
    }

    public void keyReleased() {
        isSelect = false;
    }

    public boolean isController(int e){
        return controllerBits.get(e);
    }
    public void Clicked() {
        if (lastMouseX <= x + (float) w / 2 && lastMouseX >= x - (float) w / 2 && lastMouseY <= y + (float) h / 2 && lastMouseY >= y - (float) h / 2) {
            isSelect = true;
            drawString = new drawable[0];
            str = new StringBuilder();
        } else isSelect = false;
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(drawString);
    }
}
