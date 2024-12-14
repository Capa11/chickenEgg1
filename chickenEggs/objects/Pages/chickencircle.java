package chickenEggs.objects.Pages;

import chickenEggs.SimpleGLEventListener;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class chickencircle extends Page {
    drawable[] down;
    private float centerX;
    private float centerY;
    private float radius = 500;
    private float angle = 0;
    private float rotationSpeed = 0.02f;
    private float zoomFactor = 1.0f; // For 2D perspective effect
    private float perspectiveAngle = 0; // Separate angle for perspective
    private float oscillationSpeed = 0.1f; // Speed of oscillation (up and down)
    private float oscillationOffset = 0; // Offset for oscillation effect

    private boolean cursorChanged = false; // Set to false to allow cursor change

    public chickencircle() {
        super(background[0]);

        // Define screen boundaries
        float screenLeft = -1000;
        float screenRight = 1000;
        float screenTop = 600;
        float screenBottom = -600;

        // Calculate center of the screen
        centerX = (screenLeft + screenRight) / 2;
        centerY = (screenTop + screenBottom) / 2;

        // Initialize the down array
        down = new drawable[5];
        for (int i = 0; i < down.length; i++) {
            down[i] = new drawable();
            down[i].setPath(numbers[i]);
        }

        // Initial positioning of objects
        initGrid(down, centerX, centerY, radius, 100, 100, 20, 10);

        // Remove changeCursor() from constructor
        // changeCursor();
    }

    @Override
    public void draw() {
        super.drawBackground();

        // Change cursor if not already changed
        if (!cursorChanged) {
            changeCursor();
        }

        // Update and draw with 2D circular positioning and vertical oscillation
        drawFerrisWheelEffect(down);
    }

    // Method to change the cursor
    private void changeCursor() {
        // Get the SimpleGLEventListener instance
        SimpleGLEventListener listener = getListener();
        if (listener != null) {
            // Call setCustomCursor with the desired image path
            listener.setCustomCursor("chickenEgg1/chickenEggs/Assets/Man/back.png");
            cursorChanged = true; // Mark that the cursor has been changed
        }
    }

    // Method to obtain the SimpleGLEventListener instance
    private SimpleGLEventListener getListener() {
        // Assuming you have access to the listener instance via variables or a singleton
        return variables.simpleGLEventListenerInstance;

    }

    /**
     * Draws the array with a Ferris wheel-like effect (circular + vertical oscillation)
     */
    private void drawFerrisWheelEffect(drawable[] array) {
        // Update perspective angle slightly differently
        perspectiveAngle += rotationSpeed * 0.5f;

        // Apply vertical oscillation using sine wave
        oscillationOffset = (float)Math.sin(oscillationSpeed) * 100; // Amplitude of oscillation

        for (int i = 0; i < array.length; i++) {
            // Calculate position offset
            float offsetAngle = (2 * 3.14159f / array.length) * i;

            // Calculate circular position
            float x = centerX + (float)Math.cos(angle + offsetAngle) * radius;
            float y = centerY + (float)Math.sin(angle + offsetAngle) * radius + oscillationOffset; // Add oscillation to vertical position

            // Create 2D perspective effect
            float scale = 1.0f - Math.abs((float)Math.sin(perspectiveAngle)) * 0.3f;

            // Additional perspective distortion
            float perspectiveX = x * scale;
            float perspectiveY = y * scale;

            // Reposition the object with perspective
            initGrid(new drawable[]{array[i]}, perspectiveX, perspectiveY, 10, 100, 100, 20, 10);

            // Draw the current object
            array[i].draw();
        }

        // Update rotation angle
        angle += rotationSpeed;
        if (angle >= 2 * 3.14159f) {
            angle -= 2 * 3.14159f;
        }

        // Update oscillation speed (optional for variation)
        oscillationSpeed += 0.05f;
    }

    /**
     * Adjust rotation speed
     */
    public void setRotationSpeed(float speed) {
        this.rotationSpeed = speed;
    }

    /**
     * Adjust circle radius
     */
    public void setRadius(float newRadius) {
        this.radius = newRadius;
    }

}


