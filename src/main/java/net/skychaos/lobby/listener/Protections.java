package net.skychaos.lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

public class Protections implements Listener {

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent event) {
        if(event.getEntityType() != EntityType.PLAYER)
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(event.getPlayer().getGameMode() != GameMode.CREATIVE && !event.getPlayer().hasPermission("admin"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getGameMode() != GameMode.CREATIVE && !event.getPlayer().hasPermission("admin"))
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerHurt(EntityDamageEvent event) {
        if(event.getEntityType() == EntityType.PLAYER)
            event.setCancelled(true);
    }

}
