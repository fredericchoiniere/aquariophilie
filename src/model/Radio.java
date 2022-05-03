// Jérémie Caron    itération 3

package model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Radio {

    Long currentFrame;
    Clip clip;

    // statut du clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath = "res/sons/ambiance.wav";

    // constructor to initialize streams and clip
    public Radio()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        // pour qu'il n'arrete pas à la fin de son cycle
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Method pour jouer la musique
    public void play() {
        // start the clip
        clip.start();

        status = "play";
    }

    // Method pour pauser la music
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method pour reprendre après une pause
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (status.equals("play")) {
            System.out.println("Audio is already " +
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to reset audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}