/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package idc;

import java.net.*;
import java.io.*;
/**
 *
 * @author fridim
 */
public class Server {
    static private ServerSocket serverSocket;
    
    Server() {
        try {
            serverSocket = new ServerSocket(Config.port);
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
