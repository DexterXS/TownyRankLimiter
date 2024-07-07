package org.dexterx.mc.townyranklimiter.utils;

import com.palmergames.bukkit.towny.object.Town;
import org.dexterx.mc.townyranklimiter.TownyRankLimiter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ConfigManager {

    private final TownyRankLimiter plugin;
    private final Map<String, Integer> rankLimits;

    public ConfigManager(TownyRankLimiter plugin) {
        this.plugin = plugin;
        this.rankLimits = new HashMap<>();
        loadConfig();
    }

    public void loadConfig() {
        FileConfiguration config = plugin.getConfig();
        rankLimits.clear();
        if (config.isConfigurationSection("ranks")) {
            for (String rank : Objects.requireNonNull(config.getConfigurationSection("ranks")).getKeys(false)) {
                rankLimits.put(rank, config.getInt("ranks." + rank));
            }
        }
    }

    public boolean isRankLimitExceeded(Town town, String rank) {
        int currentCount = town.getResidents().stream()
                .mapToInt(resident -> resident.hasTownRank(rank) ? 1 : 0)
                .sum();
        return currentCount >= rankLimits.getOrDefault(rank, Integer.MAX_VALUE);
    }

    public String getRankLimitExceededMessage(String rank) {
        int limit = rankLimits.getOrDefault(rank, 0);
        String message = getFormattedMessage("messages.rank_limit_exceeded");
        return message.replace("{rank}", rank).replace("{limit}", String.valueOf(limit));
    }

    public String getFormattedMessage(String path) {
        FileConfiguration config = plugin.getConfig();
        return config.getString(path, "Message not found");
    }
}
