package com.lanworldmod.lanworldmod.network;

import java.io.IOException;
import java.net.Socket;

public class NetworkHander {

    public static void establishConnection(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            System.out.printIn("Connected to LAN world: " + ip + ":" + port);
        } catch (IOException e) {
            System.out.printIn("Error connecting: " + e.getMessage());
        }
    }
}
