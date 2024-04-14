package de.artur.rs_booster.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ItemUtil extends ItemStack {
    // ------------------------Imports
    private Material material;
    private int amount;
    private int subId;
    private String name;
    private String skullOwner;
    @SuppressWarnings("unused")
    private ItemMeta itemmeta;
    private List<String> lores = new ArrayList<>();
    private HashMap<Enchantment, Integer> enchantments = new HashMap<>();

    public ItemUtil(Material material) {
        this.material = material;
        this.amount = 1;
        this.subId = 0;
    }


    public ItemUtil(Material material, int amount, int subid) {
        this.material = material;
        this.amount = amount;
        this.subId = subid;
    }


    public ItemUtil setName(String name) {
        this.name = name;
        return this;
    }

    public ItemUtil setLore(String lore) {
        this.lores.add(lore);
        return this;
    }

    public ItemUtil setEntchantment(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);
        return this;
    }

    public ItemUtil setItemtoSkull(String skullOwner) {
        this.subId = 3;
        this.material = Material.PLAYER_HEAD;
        this.skullOwner = skullOwner;
        return this;
    }

    public ItemStack build(boolean Unbreakable, boolean hideUnbreakable, boolean hideEnchantments) {
        ItemStack itemStack = new ItemStack(this.material, this.amount, (byte) this.subId);
        if (this.material == Material.AIR) {
            return itemStack;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if (this.name != null) {
            itemMeta.setDisplayName(this.name);
        }
        if (material == Material.PLAYER_HEAD && skullOwner != null) {
            ((SkullMeta) itemMeta).setOwner(this.skullOwner);
        }

        if (enchantments.size() > 0) {
            for (Enchantment enchantment : this.enchantments.keySet()) {
                itemMeta.addEnchant(enchantment, this.enchantments.get(enchantment), true);
            }
        }

        if (Unbreakable)
            itemMeta.setUnbreakable(true);
        if(hideUnbreakable)
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        if(hideEnchantments)
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        itemMeta.setLore(this.lores);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


}