package ReadHtml;
import  java.io.*;

import sun.audio.*;

public class AudioPlay {

	public  void playSound() {

		try {
		
			InputStream in = getClass().getResourceAsStream("siren.wav");
			AudioStream as = new AudioStream(in);
			AudioData data = as.getData();
			ContinuousAudioDataStream cas = new ContinuousAudioDataStream (data);
			AudioPlayer.player.start(cas);
		} catch (FileNotFoundException e1) {
			System.err.println("Arquivo não encontrado");
		}  catch (IOException e) {
			System.err.println("Erro de I/O");
		}
	} 
}
