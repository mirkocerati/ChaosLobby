package net.skychaos.lobby.listener;

import net.skychaos.lobby.ChaosLobby;
import net.skychaos.lobby.configuration.Options;
import fr.xephi.authme.events.LoginEvent;
import fr.xephi.authme.events.LogoutEvent;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class JoinActions implements Listener {

    private final ChaosLobby plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        event.joinMessage(null);
        player.playerListName(Component.text(plugin.getLuckPerms().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix() + player.getName()));
    }

    @EventHandler
    public void onPlayerAuthentication(LoginEvent event) {
        final Player player = event.getPlayer();
        Title welcomeTitle = Title.title(Component.text("Aubenoire").color(TextColor.fromHexString("#3492eb")), Component.text("Una nuova era di Minecraft"));
        player.showTitle(welcomeTitle);

        for(Integer slot : plugin.getItemsManager().getItems().keySet()) {
            player.getInventory().setItem(slot, plugin.getItemsManager().getItems().get(slot).toItemStack());
        }
    }

    @EventHandler
    public void onPlayerLogout(LogoutEvent event) {
        final Player player = event.getPlayer();
        player.teleport(Options.SPAWN_LOCATION);
    }

}
