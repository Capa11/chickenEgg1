package chickenEggs;


import com.jogamp.opengl.*;
import chickenEggs.keyboard.key;
import chickenEggs.mouse.mouseWheel;
import chickenEggs.mouse.mousebutton;
import chickenEggs.mouse.mousemotion;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.*;
import java.awt.*;


public class chickenEggsGame extends JFrame {
        public static void main(String[] args) {

            new chickenEggsGame();
        }
        public chickenEggsGame() {
            GLCapabilities caps = new GLCapabilities(GLProfile.getDefault());
            GLCanvas glcanvas = new GLCanvas(caps);
            glcanvas.addGLEventListener(new SimpleGLEventListener());
            getContentPane().add(glcanvas, BorderLayout.CENTER);
            FPSAnimator animator = new FPSAnimator(glcanvas,60);
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


    }
