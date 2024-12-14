package chickenEggs.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.BitSet;

import static chickenEggs.SimpleGLEventListener.*;

public class key implements KeyListener {


    public void keyReleased(final KeyEvent event) {
        if (Operations) {
            int keyCode = event.getKeyCode();
            keyBits.clear(keyCode);
        }
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(Operations) {
            int keyCode = e.getKeyCode();
            keyBits.set(keyCode);
            runningPage.keyPressed(keyCode);
        }
    }


}