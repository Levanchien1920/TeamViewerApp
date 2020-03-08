package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sender implements Runnable {
	public  static List<Socket> sockets = new ArrayList<Socket>();
	 private Socket connection;
	 private DataInputStream dataIn;
	 private DataOutputStream dataOut;

	public Sender (Socket conn) throws Exception {
		this.connection = conn;
		this.dataIn = new DataInputStream(connection.getInputStream());
		this.dataOut = new DataOutputStream(connection.getOutputStream());
		sockets.add(connection);
	}

	public void run() {
		int bytesRead = 0;
		byte[] inBytes = new byte[1];
		while (bytesRead != -1) {
			try {
				bytesRead = this.dataIn.read(inBytes, 0, inBytes.length);
			} catch (IOException e) {
			}
			if (bytesRead >= 0) {
				sendToAll(inBytes, bytesRead);
			}
		}
		sockets.remove(connection);
	}

	public void sendToAll(byte[] byteArray, int q) {
		Iterator<Socket> sockIt =sockets.iterator();
		while (sockIt.hasNext()) {
			Socket temp = sockIt.next();
			if (temp == this.connection)
			{
			    continue;
			}
			try {
				dataOut = new DataOutputStream(temp.getOutputStream());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				dataOut.write(byteArray, 0, q);
			} catch (IOException e) {
			}
		}
	}
}
