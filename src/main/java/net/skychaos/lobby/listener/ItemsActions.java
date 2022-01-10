package net.skychaos.lobby.listener;

import net.skychaos.lobby.ChaosLobby;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

@RequiredArgsConstructor
public class ItemsActions implements Listener {

    private final ChaosLobby plugin;

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent event) {
        final Player player = event.getPlayer();

        Action a = event.getAction();
        if(a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
            if(player.getInventory().getItemInMainHand().getType() == Material.COMPASS)
                plugin.getGuiManager().getGUIList().get("servers").open(player);
        }
    }

}
