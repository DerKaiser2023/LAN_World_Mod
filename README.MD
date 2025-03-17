# LAN World Mod for Minecraft 1.7.10

## 📌 Overview
This mod allows players to host and join LAN worlds over the internet by generating a unique invite code. Instead of requiring players to be on the same local network, this mod enables remote connections to LAN-hosted Minecraft games, making it easier for friends to play together.

## ⚡ Features
- Generates an invite code when a LAN world is hosted.
- Allows players outside the local network to join using the invite code.
- Dynamically retrieves the public IP address of the host.
- Connects players automatically to the host's LAN world.

## 🛠️ Building the Mod
### Requirements:
- **Minecraft 1.7.10**
- **Forge Mod Loader (FML) for 1.7.10**
- **Java Development Kit (JDK) 8 or higher**
- **Gradle** (Recommended)

### Steps to Build:
1. Clone the repository:
   ```sh
   git clone https://github.com/DerKaiser/LAN_World_Mod.git
   cd LAN_World_Mod
   ```
2. Setup the Forge development environment:
   ```sh
   gradlew setupDecompWorkspace
   gradlew eclipse  # If using Eclipse
   gradlew idea  # If using IntelliJ IDEA
   ```
3. Build the mod:
   ```sh
   gradlew build
   ```
4. The compiled `.jar` file will be located in the `build/libs/` directory.

## 🚀 How to Use
### Hosting a LAN World
1. Open a single-player world.
2. Go to the **Pause Menu** and select **Open to LAN**.
3. The mod will generate an **invite code**.
4. Share the invite code with friends!

### Joining a LAN World
1. Open Minecraft and go to **Multiplayer**.
2. Enter the invite code.
3. The mod will handle the connection automatically.

## 🖥️ Technical Details
- Uses `https://checkip.amazonaws.com` to fetch the public IP address dynamically.
- Generates an invite code based on the public IP and port.
- Implements a direct socket connection to bypass LAN restrictions.

## ❗ Known Issues & Limitations
- Requires port forwarding if the host is behind a router.
- The IP address may change if the host has a dynamic IP (consider using a dynamic DNS service).
- Firewalls or security software may block connections.

## 📜 License
This project is open-source under the **MIT License**.

## 🤝 Contributing
Want to improve this mod? Feel free to **fork** the repository and submit a **pull request**!

## 📞 Support
For issues or feature requests, open an issue on the [GitHub Issues](https://github.com/DerKaiser2034/LAN_World_Mod/issues) page.