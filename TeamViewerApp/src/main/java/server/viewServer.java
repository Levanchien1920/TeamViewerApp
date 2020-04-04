/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phanv
 */
public class viewServer {

    public static void main(String[] args) {
          ServerSocket serverSocket=null;
        try {
          
            serverSocket = new ServerSocket(3000);
            while (true) {
                try {
                    
                    Thread server = new Thread(new Sender(serverSocket.accept()));
                    server.start();
                } catch (IOException ex) {
                    Logger.getLogger(viewServer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(viewServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(viewServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
