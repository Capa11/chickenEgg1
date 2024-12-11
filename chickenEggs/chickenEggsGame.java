package chickenEggs;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import chickenEggs.keyboard.key;
import chickenEggs.mouse.mouseWheel;
import chickenEggs.mouse.mousebutton;
import chickenEggs.mouse.mousemotion;

import javax.media.opengl.GLCanvas;
import javax.swing.*;
import java.awt.*;


    public class chickenEggsGame extends JFrame {
        public static void main(String[] args) {
            new chickenEggsGame();
        }
        static Animator animator;
        public chickenEggsGame() {
            GLCanvas glcanvas;
            SimpleGLEventListener listener = new SimpleGLEventListener();
            glcanvas = new GLCanvas();
            glcanvas.addGLEventListener(listener);
            getContentPane().add(glcanvas, BorderLayout.CENTER);
            animator = new FPSAnimator(glcanvas,60);
            animator.start();
            glcanvas.addKeyListener(new key());
            glcanvas.addMouseMotionListener(new mousemotion());
            glcanvas.addMouseListener(new mousebutton());
            glcanvas.addMouseWheelListener(new mouseWheel());
            setTitle("chickenEggs");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(600, 600);
            setLocationRelativeTo(null);
            setVisible(true);
            setFocusable(true);
            glcanvas.requestFocus();

        }
       /* public static void showOnScreen(int screen, JFrame frame ) throws RuntimeException {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice[] gd = ge.getScreenDevices();
            int width = 0, height = 0;
            if( screen > -1 && screen < gd.length ) {
                width = gd[screen].getDefaultConfiguration().getBounds().width;
                height = gd[screen].getDefaultConfiguration().getBounds().height;
                frame.setLocation(
                        ((width / 2) - (frame.getSize().width / 2)) + gd[screen].getDefaultConfiguration().getBounds().x,
                        ((height / 2) - (frame.getSize().height / 2)) + gd[screen].getDefaultConfiguration().getBounds().y
                );
                frame.setVisible(true);
            } else {
                throw new RuntimeException( "No Screens Found" );
            }
        }*/


    }
