package net.skychaos.lobby;

import net.skychaos.lobby.gui.GUIManager;
import net.skychaos.lobby.items.ItemsManager;
import net.skychaos.lobby.listener.ItemsActions;
import net.skychaos.lobby.listener.JoinActions;
import net.skychaos.lobby.listener.Protections;
import lombok.Getter;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ChaosLobby extends JavaPlugin {

    @Getter private LuckPerms luckPerms;

    @Getter private GUIManager guiManager;

    @Getter private ItemsManager itemsManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        //Initialise luckperms instance
        this.luckPerms = LuckPermsProvider.get();

        this.guiManager = new GUIManager();

        getGuiManager().loadGUIs(getConfig().getConfigurationSection("guis"));

        this.itemsManager = new ItemsManager();

        getItemsManager().loadGUIs(getConfig().getConfigurationSection("join-items"));

        getServer().getPluginManager().registerEvents(new JoinActions(this), this);
        getServer().getPluginManager().registerEvents(new ItemsActions(this), this);
        getServer().getPluginManager().registerEvents(new Protections(), this);
    }

    @Override
    public void onDisable() {
        //to do
    }
}
