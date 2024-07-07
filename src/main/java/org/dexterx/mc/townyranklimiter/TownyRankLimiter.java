package org.dexterx.mc.townyranklimiter;

import org.dexterx.mc.townyranklimiter.commands.ReloadCommand;
import org.dexterx.mc.townyranklimiter.listeners.RankAssignListener;
import org.dexterx.mc.townyranklimiter.utils.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class TownyRankLimiter extends JavaPlugin {

    private static TownyRankLimiter instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        configManager = new ConfigManager(this);

        // Регистрация команды /trank
        Objects.requireNonNull(getCommand("trank")).setExecutor(new ReloadCommand());

        getServer().getPluginManager().registerEvents(new RankAssignListener(configManager), this);
    }

    @Override
    public void onDisable() {
        // Cleanup if necessary
    }

    public static TownyRankLimiter getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
