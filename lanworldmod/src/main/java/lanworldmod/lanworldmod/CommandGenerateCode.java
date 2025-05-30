package com.lanworldmod.lanworldmod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandGenerateCode extends CommandBase {
    @Override
    public String getCommandName() {
        return "generatelancode";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/generatelancode";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        LANWorldMod.generateInviteCode();
        sender.addChatMessage(new ChatComponentText("Generated Invite Code: " + LANWorldMod.getInviteCode()));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
