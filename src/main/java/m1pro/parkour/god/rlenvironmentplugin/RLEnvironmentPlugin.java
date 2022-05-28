package m1pro.parkour.god.rlenvironmentplugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class RLEnvironmentPlugin extends JavaPlugin {
    PlayerEvents playerEvents = new PlayerEvents();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("----------------------------");
        getLogger().info("Plugin successfully start !!");
        getLogger().info("----------------------------");

        // deal with event
        this.getServer().getPluginManager().registerEvents(playerEvents, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
