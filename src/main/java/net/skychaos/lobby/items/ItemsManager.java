package net.skychaos.lobby.items;

import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class ItemsManager {

    @Getter
    private final Map<Integer, LobbyItem> items;

    public ItemsManager() {
        this.items = new HashMap<>();
    }

    public void addItem(Integer slot, LobbyItem item) {
        this.items.put(slot, item);
    }

    public void loadGUIs(ConfigurationSection section) {
        for(String key : section.getKeys(false))
            addItem(section.getInt(key + ".slot"), LobbyItem.getFromConfig(section.getConfigurationSection(key)));
    }

}
