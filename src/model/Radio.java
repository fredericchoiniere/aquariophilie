// Itération 3: Jérémie Caron

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

    // constructeur pour initialiser l'audio stream et le clip 
    public Radio()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY); // pour qu'il n'arrete pas à la fin de son cycle
    }

    // Methode pour jouer la musique
    public void play() {
        clip.start();
        status = "play";
    }

    // Methode pour mettre la musique sur pause
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    
    /** 
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     * Méthode pour rejouer la musique (rejouer après une pause)
     */
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

    
    /** 
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     * Méthode pour remettre le son à zéro
     */
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}

// Слава Україні!