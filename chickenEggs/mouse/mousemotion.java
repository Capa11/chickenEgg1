package chickenEggs.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static chickenEggs.SimpleGLEventListener.*;


public class mousemotion implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        if (Operations) {

            // how x  and y translated after mouse dragging
            float deltaX = e.getX() - lastMouseX;
            float deltaY = e.getY() - lastMouseY;

            xtranslation += deltaX * 2.6;
            ytranslation -= deltaY * 1.85;

            lastMouseX = e.getX();
            lastMouseY = e.getY();
        }
    }

    @Override public void mouseMoved(MouseEvent e) {
        if (Operations) {
            xmouse = convertX(e.getX(), e.getComponent().getWidth());
            ymouse = convertY(e.getY(), e.getComponent().getHeight());
            // System.out.println(xmouse+" "+ymouse);
            runningPage.mouseMoved();
        }
    }
}
