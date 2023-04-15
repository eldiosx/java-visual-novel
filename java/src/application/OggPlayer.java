package application;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import com.jcraft.jorbis.*;


//Ejemplo para llamar a estas funciones:
/*
package application;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OggPlayer oggPlayer = new OggPlayer();
        oggPlayer.playAudio("assets/audio/lullabyX.ogg");
        Thread.sleep(5000); // Esperar 5 segundos
        oggPlayer.stopAudio();
    }
}
*/
public class OggPlayer {
    private volatile boolean isPlaying = false;
    private Thread audioThread;
    private String filePath;

    public void playAudio(String filePath) {
        if (isPlaying) {
            System.out.println("Audio already playing.");
            return;
        }

        this.filePath = filePath;
        isPlaying = true;
        audioThread = new Thread(() -> {
            try {
                // Cargar archivo de audio Ogg
                InputStream in = new FileInputStream(filePath);
                OggInputStream oggIn = new OggInputStream(in);

                int channels = 2; // número de canales (estéreo)
                int rate = 44100; // frecuencia de muestreo (44100 Hz)
                int bufferSize = 4096; // tamaño del búfer de audio
                // Crear objeto de formato de audio
                AudioFormat audioFormat = new AudioFormat((float) rate, 16, channels, true, false);

                // Crear objeto de línea de datos de origen
                DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
                SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);

                // Abrir línea de datos de origen
                sourceDataLine.open(audioFormat);
                sourceDataLine.start();

                // Reproducir audio
                byte[] buffer = new byte[bufferSize];
                while (isPlaying) {
                    int bytesRead = oggIn.read(buffer, 0, bufferSize);
                    if (bytesRead == -1) {
                        break;
                    }
                    sourceDataLine.write(buffer, 0, bytesRead);
                }

                // Cerrar línea de datos de origen
                sourceDataLine.drain();
                sourceDataLine.stop();
                sourceDataLine.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        audioThread.start();
    }

    public void stopAudio() {
        isPlaying = false;
        audioThread = null;
    }
}
