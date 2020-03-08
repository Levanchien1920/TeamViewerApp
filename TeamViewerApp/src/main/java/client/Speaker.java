package client;

import java.io.DataInputStream;
import java.net.Socket;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class Speaker implements Runnable {
	 	private Socket connection;
	    private DataInputStream soundIn;
	    private SourceDataLine inSpeaker;

	    public Speaker(Socket conn) throws Exception
	    {
	        connection = conn;
	        soundIn = new DataInputStream(connection.getInputStream());
	        AudioFormat af = new AudioFormat(8000.0f,8,1,true,false);
	        DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
	        inSpeaker = (SourceDataLine)AudioSystem.getLine(info);
	        inSpeaker.open(af);
	    }

	    public void run()
	    {
	        int bytesRead = 0;
	        byte[] inSound = new byte[1];
	        inSpeaker.start();
	        while(bytesRead != -1)
	        {
	            try{bytesRead = soundIn.read(inSound, 0, inSound.length);} catch (Exception e){}
	            if(bytesRead >= 0)
	            {
	                inSpeaker.write(inSound, 0, bytesRead);
	            }
	        }
	    }
}
