package FunGames.Utils;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
    private ItemMeta itemMeta;
    private ItemStack itemStack;

    public ItemBuilder(Material mat, int size, int theByte) {
        itemStack = new ItemStack(mat, size, (byte) theByte);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder setDisplayname(String s) {
        itemMeta.setDisplayName(s);
        return this;
    }

    public ItemBuilder setLore(String... s) {
        itemMeta.setLore(Arrays.asList(s));
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... s) {
        itemMeta.addItemFlags(s);
        return this;
    }

    public ItemBuilder hideEnchants() {
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean flag) {
        itemMeta.spigot().setUnbreakable(flag);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchant, int level) {
        itemMeta.addEnchant(enchant, level, true);
        return this;
    }

    public ItemBuilder addUnsafeEnch(Enchantment enchant, int level) {
        itemStack.addUnsafeEnchantment(enchant, level);
        return this;
    }

    @Override
    public String toString() {
        return "ItemBuilder{itemMeta=" + itemMeta + ", itemStack=" + itemStack + '}';
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}