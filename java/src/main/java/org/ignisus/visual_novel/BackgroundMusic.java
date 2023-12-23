package org.ignisus.visual_novel;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

public class BackgroundMusic {
    private float volume = 0.5f; // Default volume value
    private SourceDataLine sourceDataLine;

    public void playAudio(String filePath) {
        this.setFilePath(filePath);

        Thread backgroundThread = new Thread(() -> {
            try (InputStream in = new FileInputStream(filePath); OggInputStream oggIn = new OggInputStream(in)) {

                int channels = 2; // Number of channels (stereo)
                int rate = 44100; // Sample rate (44100 Hz)
                int bufferSize = 4096; // Audio buffer size

                // Create audio format object
                AudioFormat audioFormat = new AudioFormat((float) rate, 16, channels, true, false);

                // Create source data line object
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

                // Open source data line
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();

                // Configure the volume of the source data line
                FloatControl gainControl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);

                // Play audio
                byte[] buffer = new byte[bufferSize];
                int bytesRead;
                while ((bytesRead = oggIn.read(buffer, 0, bufferSize)) != -1) {
                    if (sourceDataLine != null) {
                        sourceDataLine.write(buffer, 0, bytesRead);
                    } else {
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (sourceDataLine != null) {
                    sourceDataLine.drain();
                    sourceDataLine.stop();
                    sourceDataLine.close();
                }
            }

        });
        backgroundThread.start();
    }

    private void setFilePath(String filePath) {
        // Perform any necessary operations with the file path
    }

    public void setVolume(float volume) {
        this.volume = volume;
        if (sourceDataLine != null) {
            FloatControl gainControl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }

    public void stopAudio() {
        if (sourceDataLine != null) {
            sourceDataLine.stop();
            sourceDataLine.close();
            sourceDataLine = null;
        }
    }
}
