package me.hsgamer.playertaskexample;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.UUID;

// This is a task for a player
public class Task extends BukkitRunnable {
    private Player player;
    private BukkitTask task;

    public Task(UUID uuid, JavaPlugin plugin, boolean async) {
        this.player = Bukkit.getPlayer(uuid);
        if (async) {
            this.task = runTaskTimerAsynchronously(plugin, 1, 1);
        } else {
            this.task = runTaskTimer(plugin, 1, 1);
        }
    }

    @Override
    public void run() {
        player.getWorld().spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 10);
    }

    public BukkitTask getBukkitTask() {
        return task;
    }
}
