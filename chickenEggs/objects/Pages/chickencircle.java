package chickenEggs.objects.Pages;

import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Page;

import static chickenEggs.interfaces.variables.*;

public class chickencircle extends Page {
    private float centerX; // Center X position
    private float centerY; // Center Y position
    private float radius = 200; // Radius of the circular motion
    private float angle = 0; // Current angle in radians
    private float speed = 0.05f; // Speed of the circular motion (angle increment per frame)

    public chickencircle() {
        super(background[0]);
        // Set center to the middle of the screen
        centerX = 2000 / 2f;
        centerY = 600*2 / 2f;
    }

    @Override
    public void draw() {
        super.drawBackground();
        animateText(); // Update position for circular motion
    }

    private void animateText() {
        // Calculate new positions using circular motion formula
        // Center the sprite's rotation around the screen center
        float xOffset = centerX + (float) (radius * Math.cos(angle));
        float yOffset = centerY + (float) (radius * Math.sin(angle));

        // Increment the angle to create continuous motion
        angle += speed;

        // Ensure the angle doesn't grow indefinitely
        if (angle >= 2 * Math.PI) {
            angle -= 2 * Math.PI; // Reset angle to keep it within 0 to 2π
        }

        // Draw the sprite in circular motion
        // Adjust the drawing position to center the sprite around the calculated point
        DrawSprite((int) xOffset - 50, (int) yOffset - 30, 100, 60, background[1]);
    }

    // Optional: Method to adjust the speed of rotation
    public void setRotationSpeed(float newSpeed) {
        this.speed = newSpeed;
    }

    // Optional: Method to adjust the radius of rotation
    public void setRotationRadius(float newRadius) {
        this.radius = newRadius;
    }
}