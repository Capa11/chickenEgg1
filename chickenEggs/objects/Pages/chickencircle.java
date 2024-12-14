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
    private drawable[] numbers;
    private drawable[] down;

    public chickencircle() {
        super(background[0]);

        // Initialize 10 numbers
        numbers = new drawable[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new drawable();
            numbers[i].setPath(i); // Assuming paths are integers from 0 to 9
        }

        // Initialize 5 down objects
        down = new drawable[5];
        for (int i = 0; i < down.length; i++) {
            down[i] = new drawable();
            down[i].setPath(numbers[i].path);
        }

        // Set center to the middle of the screen
        centerX = xaxis / 2f;
        centerY = yaxis / 2f;

        // Initialize grid and draw array
        initGrid(down, -1000, -900, 500, 50, 50, 20);
        drawArray(down);
    }

    @Override
    public void draw() {
        super.drawBackground();
        animateText(); // Update positions for circular motion
    }

    private void animateText() {
        // Calculate new positions using circular motion formula
        float xOffset = centerX + (float) (radius * Math.cos(angle));
        float yOffset = centerY + (float) (radius * Math.sin(angle));

        // Increment the angle to create continuous motion
        angle += speed;

        // Ensure the angle doesn't grow indefinitely
        if (angle >= 2 * Math.PI) {
            angle -= 2 * Math.PI; // Reset angle to keep it within 0 to 2π
        }

        // Draw the sprite in circular motion
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

    // Updated initGrid method to match the provided arguments
    private void initGrid(drawable[] array, int x, int y, int w, int h, int dx, int dy) {
        // Implementation of initGrid
    }

    private void drawArray(drawable[] array) {
        // Implementation of drawArray
    }
}