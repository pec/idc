package idc;


import java.net.*;
import java.io.*;
/**
 *
 * @author fridim
 */

public class Server extends Thread implements Com{
    static private ServerSocket serverSocket;
    
    public void run () {
        try {
            ServerSocket server = new ServerSocket(Config.port);
            boolean listening = true;
            
            Socket client = null;
            while(listening) {
                client = server.accept() ;
                new ServerThread(client).start();
                // on traite la connexion dans un thread
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

}
