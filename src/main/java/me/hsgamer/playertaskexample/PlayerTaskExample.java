package me.hsgamer.playertaskexample;

import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerTaskExample extends JavaPlugin implements Listener {
    private TaskManager taskManager;

    @Override
    public void onEnable() {
        taskManager = new TaskManager(this);

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll((Plugin) this);

        taskManager.clearAll();

        taskManager = null;
    }

    // EVENT HANDLER

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        taskManager.addTask(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        taskManager.removeTask(event.getPlayer().getUniqueId());
    }
}
