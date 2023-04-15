package application;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        OggPlayer oggPlayer = new OggPlayer();
        oggPlayer.playAudio("assets/audio/lullabyX.ogg");
        Thread.sleep(5000); // Esperar 5 segundos
        oggPlayer.stopAudio();
    }
}