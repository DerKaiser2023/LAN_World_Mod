package com.lanworldmod.lanworldmod;

import java.net.Socket;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class LANWorldJoiner {

    private String inviteCode;
    private String publicIp;
    private int port;

    public LANWorldJoiner(String inviteCode) {
        this.inviteCode = inviteCode;
        this.publicIp = getPublicIP(); // Automatically fetch the public IP
        this.port = 25565; // Replace with actual port if different
    }

    private String getPublicIP() {
        try {
            URL url = new URL("https://checkip.amazonaws.com");
            Scanner scanner = new Scanner(url.openStream());
            return scanner.next().trim();
        } catch (IOException e) {
            System.out.println("Failed to fetch public IP: " + e.getMessage());
            return "UNKNOWN";
        }
    }

    public void connectToLANWorld() {
        if (publicIp.equals("UNKNOWN")) {
            System.out.println("Cannot connect: Public IP not found.");
            return;
        }

        try {
            Socket socket = new Socket(publicIp, port);
            System.out.println("Connected to LAN world at " + publicIp + ":" + port);
        } catch (IOException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
