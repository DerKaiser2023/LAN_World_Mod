package com.lanworldmod.lanworldmod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class JoinLANCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "joinlan";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/joinlan <invitecode>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            sender.addChatMessage(new ChatComponentText("Usage: /joinlan <invitecode>"));
            return;
        }

        String code = args[0];
        sender.addChatMessage(new ChatComponentText("Attempting to join using code: " + code));
        LANWorldJoiner joiner = new LANWorldJoiner(code);
        joiner.connectToLANWorld();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0; // Allow all players to use
    }
}
