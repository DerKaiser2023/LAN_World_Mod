package com.lanworldmod.lanworldmod;

import com.lanworldmod.lanworldmod.network.NetworkHandler;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class LANWorldJoiner {

    private String inviteCode;
    private String publicIp;
    private int port;

    public LANWorldJoiner(String inviteCode) {
        this.inviteCode = inviteCode;
        this.publicIp = getPublicIP(); // Replace with your mapping logic if needed
        this.port = 25565; // Default Minecraft port, or decode from code later
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
        if ("UNKNOWN".equals(publicIp)) {
            System.out.println("Cannot connect: Public IP not found.");
            return;
        }

        NetworkHandler.establishConnection(publicIp, port);
    }
}
