package application;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Control;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;


public class BackgroundMusic {
    private volatile boolean isPlaying = false;
    private Thread audioThread;
    private String filePath;
    private FloatControl volumeControl;

    public void playAudio(String filePath, double volume) {
        if (isPlaying) {
            System.out.println("Audio already playing.");
            return;
        }

        this.setFilePath(filePath);
        isPlaying = true;
        audioThread = new Thread(() -> {
            try {
                // Cargar archivo de audio Ogg
                InputStream in = new FileInputStream(filePath);
                try (OggInputStream oggIn = new OggInputStream(in)) {
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
                    
                    // Obtener control de volumen
                    Control[] controls = sourceDataLine.getControls();
                    for (Control control : controls) {
                        if (control instanceof FloatControl) {
                            FloatControl floatControl = (FloatControl) control;
                            if (floatControl.getType() == FloatControl.Type.VOLUME) {
                                volumeControl = floatControl;
                                break;
                            }
                        }
                    }
                    
                    // Establecer volumen
                    if (volumeControl != null) {
                        volumeControl.setValue((float) volume);
                    }
                    
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
                }
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public void setVolume(double volume) {
        if (volumeControl != null) {
            volumeControl.setValue((float) volume);
        }
    }
}
