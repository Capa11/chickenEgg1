package chickenEggs.objects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    private static float globalVolume = 1.0f; // Default volume (1.0 = max, 0.0 = mute)
    private byte[] mBytes;
    private DataLine.Info mInfo;
    private AudioFormat mFormat;

    private Sound() {}

    public static Sound loadFromFile(String filename) {
        try {
            Sound s = new Sound();
            File audioFile = new File(filename);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            s.mFormat = audioStream.getFormat();
            s.mInfo = new DataLine.Info(Clip.class, audioStream.getFormat());
            s.mBytes = new byte[(int)(s.mFormat.getFrameSize() * audioStream.getFrameLength())];
            audioStream.read(s.mBytes);
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Clip play() {
        try {
            Clip c = (Clip) AudioSystem.getLine(mInfo);
            c.open(mFormat, mBytes, 0, mBytes.length);
            setVolume(c, globalVolume); // Apply global volume
            c.start();
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Clip playLooping() {
        try {
            Clip c = (Clip) AudioSystem.getLine(mInfo);
            c.open(mFormat, mBytes, 0, mBytes.length);
            setVolume(c, globalVolume); // Apply global volume
            c.loop(Clip.LOOP_CONTINUOUSLY);
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void setGlobalVolume(float volume) {
        if (volume < 0.0f || volume > 1.0f) {
            throw new IllegalArgumentException("Volume must be between 0.0 and 1.0");
        }
        globalVolume = volume;
    }

    private void setVolume(Clip clip, float volume) {
        try {
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float min = volumeControl.getMinimum(); // Typically -80.0 dB
            float max = volumeControl.getMaximum(); // Typically 6.0 dB
            float range = max - min;
            float gain = (range * volume) + min; // Scale volume to decibel range
            volumeControl.setValue(gain);
        } catch (Exception ex) {
            System.err.println("Volume control not supported: " + ex.getMessage());
        }
    }
}