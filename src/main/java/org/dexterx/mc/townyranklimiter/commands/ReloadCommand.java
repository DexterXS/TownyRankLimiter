package org.dexterx.mc.townyranklimiter.commands;

import org.dexterx.mc.townyranklimiter.TownyRankLimiter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 2 && args[0].equalsIgnoreCase("rank") && args[1].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("townyranklimiter.reload")) {
                sender.sendMessage(TownyRankLimiter.getInstance().getConfigManager().getFormattedMessage("messages.no_permission"));
                return true;
            }
            TownyRankLimiter.getInstance().reloadConfig();
            TownyRankLimiter.getInstance().getConfigManager().loadConfig();
            sender.sendMessage(TownyRankLimiter.getInstance().getConfigManager().getFormattedMessage("messages.reload_success"));
            return true;
        }
        return false;
    }
}
