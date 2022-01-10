package net.skychaos.lobby.command.subcommands;

import net.skychaos.lobby.ChaosLobby;
import net.skychaos.lobby.command.SubCommand;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ReloadSubCommand implements SubCommand {

    private final ChaosLobby plugin;

    @Override
    public void onCommand(Player player, Command command, String[] args) {
        plugin.reloadConfig();
        player.sendMessage("Configuration reloaded.");
    }

    @Override
    public String getPermission() {
        return null;
    }
}
