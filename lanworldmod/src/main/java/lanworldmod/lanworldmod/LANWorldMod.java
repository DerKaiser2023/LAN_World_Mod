package com.lanworldmod.lanworld;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import java.util.Random;

@Mod(modid = LANWorldMod.MODID, name = LANWorldMod.NAME, version = LANWorldMod.VERSION)
public class LANWorldMod
{
    public static final String MODID = "lanworldmod";
    public static final String NAME = "LAN World Mod";
    public static final String VERSION = "1.0";

    private static final Random random = new Random();
    private static String inviteCode = null;

    public LANWorldMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (inviteCode != null) {
            String message = "Connect to this LAN world using the code: " + inviteCode;
            event.player.sendMessage(new TextComponentString(message));
        }
    }

    public static void generateInviteCode() {
        int codePart1 = random.nextInt(10000);
        int codePart2 = random.nextInt(10000);
        inviteCode = String.format("%04d-%04d", codePart1, codePart2);
    }

    public static String getInviteCode() {
        return inviteCode;
    }
}