package chickenEggs.objects.Pages;
import chickenEggs.interfaces.*;
import chickenEggs.interfaces.Pages.Button;
import chickenEggs.interfaces.Pages.NavBtn;
import chickenEggs.interfaces.Pages.Page;
import chickenEggs.objects.Sound;

import chickenEggs.SimpleGLEventListener;
import java.util.ArrayList;

import static chickenEggs.interfaces.variables.*;

public class ControllerScreen extends Page {

    Button player1 = new NavBtn(-200, -100, 350, 100, health[0], new PlayerControllerScreen(), "player 1", 40);
    Button player2 = new NavBtn(250, -100, 350, 100, health[0], new PlayerControllerScreen(), "player 2", 40);
    Button player3 = new NavBtn(-200, -300, 350, 100, health[0], new PlayerControllerScreen(), "player 3", 40);
    Button player4 = new NavBtn(250, -300, 350, 100, health[0], new PlayerControllerScreen(), "player 4", 40);
    drawable[] settings = initwriteString("settings", -220, 200, 600, 70, 70, 0);
    drawable[] volume = initwriteString("volume", -100, 400, 350, 40, 40, 0);
    drawable[] level = new drawable[10];
    drawable[] controller = initwriteString("controller", -150, 400, 100, 40, 50, 0);
    static ArrayList<Button> buttons = new ArrayList<>();
    int n = (int) (Sound.getGlobalVolume() * 10); // Start at 50%

    public ControllerScreen() {
        super(background[0], buttons);
        for (int i = 0; i < level.length; i++) {
            level[i] = new drawable();
            level[i].setPath(i < n ? health[1] : health[0]); // Initialize volume bar to 50%
        }
        initGrid(level, -950, 1000, 280, 50, 50, 10, 10);
        buttons.add(player1);
        buttons.add(player2);
        buttons.add(player3);
        buttons.add(player4);

        // Set custom cursor when ControllerScreen loads
        // it will not work here because it is not in the init method
        //   SimpleGLEventListener.setCustomCursor("chickenEgg1/chickenEggs/Assets/Man/Man2.png");
    }

    @Override
    public void draw() {
        super.draw();
        drawArray(settings);
        drawArray(volume);
        drawArray(controller);
        drawArray(level);
        DrawSprite(-300, 255, 50, 60, icons[6]);
        DrawSprite(350, 255, 50, 60, icons[4]);
    }

    @Override
    public void isClicked() {
        for (Button button : buttons) {
            if (button.isInside(lastMouseX, lastMouseY)) {
                playerController = Integer.parseInt(String.valueOf(button.text.charAt(button.text.length() - 1)));
                System.out.println(playerController);
                break;
            }
        }

        if (lastMouseX <= 375 && lastMouseX >= 325 && lastMouseY <= 280 && lastMouseY >= 226 && n < 10) {
            if (n < 0) n = 0;
            level[n].path = health[1];
            adjustVolume(0.1f); // Increase volume by 0.1
            n++;
            playButtonSound();
            SimpleGLEventListener.setCustomCursor("chickenEgg1/chickenEggs/Assets/Man/11.png");
        }
        if (lastMouseX >= -325 && lastMouseX <= -272 && lastMouseY <= 280 && lastMouseY >= 225 && n > 0) {
            n--;
            level[n].path = health[0];
            adjustVolume(-0.1f); // Decrease volume by 0.1
            playButtonSound();
            SimpleGLEventListener.setCustomCursor("chickenEgg1/chickenEggs/Assets/Man/man2.png");
        }

        super.isClicked();
    }

    private void adjustVolume(float delta) {
        float newVolume = Sound.getGlobalVolume() + delta;
        Sound.setGlobalVolume(newVolume);
    }

    private void playButtonSound() {
        Sound buttonSound = Sound.loadFromFile("chickenEgg1/chickenEggs/Sounds/sound3.wav");
        if (buttonSound != null) {
            buttonSound.play();
        }
    }
}

