package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

public class Recorder implements Runnable {

	private Socket connection;
	private DataOutputStream soundOut;
	private TargetDataLine inMicro;

	public Recorder(Socket socket) throws Exception {
		connection = socket;
		soundOut = new DataOutputStream(connection.getOutputStream());
		AudioFormat af = new AudioFormat(8000.0f, 8, 1, true, false);
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, af);
		inMicro = (TargetDataLine) AudioSystem.getLine(info);
		inMicro.open(af);
	}

	@Override
	public void run() {
		int bytesRead = 0;
		byte[] soundData = new byte[1];
		inMicro.start();
		while (bytesRead != -1) {
			bytesRead = inMicro.read(soundData, 0, soundData.length);
			if (bytesRead >= 0) {
				try {
					soundOut.write(soundData, 0, bytesRead);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
