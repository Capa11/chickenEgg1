package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;
import javax.media.opengl.GL;
import static chickenEggs.interfaces.variables.*;

public class chickencircle2 extends Page {
    private drawable[] down;
    private float angle = 0;
    private final float ORBIT_RADIUS = 300;    // Distance from center
    private final float ROTATION_SPEED = 0.02f; // Speed of rotation
    private final float CENTER_X = 0;          // Screen center X
    private final float CENTER_Y = 0;          // Screen center Y

    public chickencircle2() {
        super(background[0]);
        down = new drawable[5];
        for (int i = 0; i < down.length; i++) {
            down[i] = new drawable();
            down[i].setPath(numbers[i]);
        }
        updateGridPosition();
    }

    @Override
    public void draw() {
        super.drawBackground();
        angle += ROTATION_SPEED;
        updateGridPosition();
        drawArray(down);
    }

    private void updateGridPosition() {
        float x = CENTER_X + ORBIT_RADIUS * (float)Math.cos(angle);
        float y = CENTER_Y + ORBIT_RADIUS * (float)Math.sin(angle);
        // Fixed grid size: width=200, spacing=50, columns=20, rows=10
        initGrid(down, x, y, 200, 50, 50, 20, 10);
    }
}