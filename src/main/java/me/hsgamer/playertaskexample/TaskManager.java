package me.hsgamer.playertaskexample;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

// We'll need a manager to manage all the tasks
public class TaskManager {
    private HashMap<UUID, Task> tasks = new HashMap<>();
    private JavaPlugin plugin;

    public TaskManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void addTask(UUID uuid) {
        if (!tasks.containsKey(uuid)) {
            tasks.put(uuid, new Task(uuid, plugin, true));
        } else {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "That UUID is already available");
        }
    }

    public void removeTask(UUID uuid) {
        if (tasks.containsKey(uuid)) {
            tasks.remove(uuid).getBukkitTask().cancel();
        } else {
            plugin.getServer().getConsoleSender().sendMessage(ChatColor.RED + "That UUID is not available to remove");
        }
    }

    public void clearAll() {
        tasks.forEach((uuid, task) -> removeTask(uuid));
    }
}
