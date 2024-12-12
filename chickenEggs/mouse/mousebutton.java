package chickenEggs.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static chickenEggs.SimpleGLEventListener.*;

public class mousebutton implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(Operations) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                dragging = true;
                lastMouseX = xmouse;
                lastMouseY = ymouse;
                runningPage.checkclick();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Operations) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                dragging = false;
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
