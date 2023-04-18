package application;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;

import javafx.application.Platform;

public class BackgroundMusic {
    private float volume = 0.5f; // Valor de volumen por defecto
    private SourceDataLine sourceDataLine;

    public void playAudio(String filePath) {
        this.setFilePath(filePath);

        Thread backgroundThread = new Thread(() -> {
            try (InputStream in = new FileInputStream(filePath);
                    OggInputStream oggIn = new OggInputStream(in)) {

                int channels = 2; // número de canales (estéreo)
                int rate = 44100; // frecuencia de muestreo (44100 Hz)
                int bufferSize = 4096; // tamaño del búfer de audio

                // Crear objeto de formato de audio
                AudioFormat audioFormat = new AudioFormat((float) rate, 16, channels, true, false);

                // Crear objeto de línea de datos de origen
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

                // Abrir línea de datos de origen
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();

                // Configurar el volumen de la línea de datos de origen
                FloatControl gainControl = (FloatControl) sourceDataLine.getControl(FloatControl.Type.MASTER_GAIN);
                float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
                gainControl.setValue(dB);

                // Reproducir audio
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
