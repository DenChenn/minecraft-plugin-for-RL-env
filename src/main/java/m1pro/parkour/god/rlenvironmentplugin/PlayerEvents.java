package m1pro.parkour.god.rlenvironmentplugin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class PlayerEvents implements Listener {
    ArrayList<IntegerLocation> PastLocationList = new ArrayList<>();

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location realTimeLocation = player.getLocation();
        int xInteger = (int) Math.floor(realTimeLocation.getX());
        int yInteger = (int) Math.floor(realTimeLocation.getY());
        int zInteger = (int) Math.floor(realTimeLocation.getZ());
        IntegerLocation integerLocation = new IntegerLocation(xInteger, yInteger, zInteger);

        if(!this.PastLocationList.contains(integerLocation)) {
            String realLocationX = String.valueOf(xInteger);
            String realLocationY = String.valueOf(yInteger);
            String realLocationZ = String.valueOf(zInteger);

            player.sendMessage(ChatColor.LIGHT_PURPLE + "New block explored in location : (" + realLocationX + ", " + realLocationY + ", " + realLocationZ + ")");
            this.PastLocationList.add(integerLocation);
        }
    }

    @EventHandler
    public void playerDead(PlayerDeathEvent event){
        Player player = event.getEntity();
        String playerName = player.getName();

        player.sendMessage(ChatColor.RED + playerName);
    }
}
