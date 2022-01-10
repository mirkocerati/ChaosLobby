package net.skychaos.lobby.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class LobbyItem {

    @Getter @Setter
    private String name;
    @Getter @Setter
    private Material material;
    @Getter @Setter
    private List<String> lore;
    @Getter @Setter
    private boolean unbreakable;
    @Getter @Setter
    private boolean enchanted;
    @Getter @Setter
    private boolean flags;

    public LobbyItem() {
        name = "";
        material = Material.ACACIA_BOAT;
        lore = new ArrayList<>();
    }

    public ItemStack toItemStack() {
        ItemStack stack = new ItemStack(material, 1);

        ItemMeta meta = stack.getItemMeta();
        meta.setLore(lore);
        meta.setDisplayName(name);
        meta.setUnbreakable(unbreakable);

        if(flags)
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DYE, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE);

        stack.setItemMeta(meta);

        if(enchanted)
            stack.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1);

        return stack;
    }

    public static LobbyItem getFromConfig(ConfigurationSection section) {
        LobbyItem item = new LobbyItem();
        item.setName(section.getString("name").replaceAll("&", "§"));
        item.setMaterial(Material.getMaterial(section.getString("material").toUpperCase()));
        item.setLore(section.getStringList("lore"));
        item.setUnbreakable(section.getBoolean("unbreakable"));
        item.setEnchanted(section.getBoolean("enchanted"));
        item.setFlags(section.getBoolean("flags"));
        return item;
    }
}
