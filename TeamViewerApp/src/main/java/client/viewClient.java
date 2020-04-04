/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanv
 */
public class viewClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            Thread speaker = new Thread(new Speaker(socket));
            speaker.start();
            Thread recorder = new Thread(new Recorder(socket));
            recorder.start();
        } catch (IOException ex) {
            Logger.getLogger(viewClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(viewClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
