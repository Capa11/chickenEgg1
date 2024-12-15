package chickenEggs.objects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sound {
    private static float globalVolume = 0.0f; // Default volume set to 50%
    private byte[] mBytes;
    private DataLine.Info mInfo;
    private AudioFormat mFormat;
    private static List<Clip> playingClips = new ArrayList<>();

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
            playingClips.add(c); // Add to the list of playing clips
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
            playingClips.add(c); // Add to the list of playing clips
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void setGlobalVolume(float volume) {
        if (volume < 0.0f) {
            globalVolume = 0.0f;
        } else if (volume > 1.0f) {
            globalVolume = 1.0f;
        } else {
            globalVolume = Math.round(volume * 10) / 10.0f; // Round to nearest 0.1
        }
        // Update the volume of all currently playing clips
        for (Clip clip : playingClips) {
            setVolume(clip, globalVolume);
        }
    }

    public static float getGlobalVolume() {
        return globalVolume;
    }

    private static void setVolume(Clip clip, float volume) {
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