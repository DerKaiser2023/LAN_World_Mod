package com.lanworldmod.lanworldmod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URI;
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
            URI uri = URI.create("https://checkip.amazonaws.com");
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                return reader.readLine().trim();
            }
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