package org.dexterx.mc.townyranklimiter.listeners;

import com.palmergames.bukkit.towny.event.TownAddResidentRankEvent;
import org.dexterx.mc.townyranklimiter.utils.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class RankAssignListener implements Listener {

    private final ConfigManager configManager;

    public RankAssignListener(ConfigManager configManager) {
        this.configManager = configManager;
    }

    @EventHandler
    public void onRankAssign(@NotNull TownAddResidentRankEvent event) {
        String rank = event.getRank();
        Player player = event.getResident().getPlayer();
        if (configManager.isRankLimitExceeded(event.getTown(), rank)) {
            if (player != null) {
                player.sendMessage(configManager.getRankLimitExceededMessage(rank));
            }
            event.setCancelled(true);
        }
    }
}
