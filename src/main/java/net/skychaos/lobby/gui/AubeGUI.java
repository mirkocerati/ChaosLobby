package net.skychaos.lobby.gui;

import net.skychaos.lobby.items.LobbyItem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class AubeGUI {

    public String title;

    public int size;

    private final Map<Integer, LobbyItem> items;

    public AubeGUI(String title, Integer size) {
        this.items = new HashMap<>();
        this.size = size;
        this.title = title;
    }

    public void addItem(Integer slot, LobbyItem item) {
        this.items.putIfAbsent(slot, item);
    }

    public void removeItem(Integer slot) {
        this.items.remove(slot);

    }

    public void open(Player player) {
        Inventory inventory = Bukkit.createInventory(player, size, title);
        for(Integer slot : items.keySet()) {
            inventory.setItem(slot, items.get(slot).toItemStack());
        }
        player.openInventory(inventory);
    }

    public static AubeGUI getFromConfig(ConfigurationSection section) {
        AubeGUI gui = new AubeGUI(section.getString("title"), section.getInt("size"));

        for(String key : section.getConfigurationSection("items").getKeys(false)) {
            gui.addItem(section.getInt("items." + key + ".slot"), LobbyItem.getFromConfig(section.getConfigurationSection("items." + key)));
        }

        return gui;
    }

}
