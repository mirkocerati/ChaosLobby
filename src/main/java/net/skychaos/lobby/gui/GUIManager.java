package net.skychaos.lobby.gui;

import lombok.Getter;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;
import java.util.Map;

public class GUIManager {

    @Getter
    private final Map<String, AubeGUI> GUIList;

    public GUIManager() {
        this.GUIList = new HashMap<>();
    }

    public void addGUI(String name, AubeGUI gui) {
        this.GUIList.put(name, gui);
    }

    public void loadGUIs(ConfigurationSection section) {
        for(String key : section.getKeys(false))
            addGUI(key, AubeGUI.getFromConfig(section.getConfigurationSection(key)));
    }

}
