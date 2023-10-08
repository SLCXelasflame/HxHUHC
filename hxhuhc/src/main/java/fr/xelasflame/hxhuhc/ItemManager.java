package fr.xelasflame.hxhuhc;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;


public class ItemManager {

    public static HashMap<String, ItemStack> itemliste = new HashMap<>();
    public static ItemStack gon;
    public static ItemStack kirua;
    public static ItemStack netero;
    public static ItemStack morau;
    public static ItemStack biscuit;




    public static void init() {
        creategon();
        createkirua();
        createnetero();
        createmorau();
        createbiscuit();
    }

    private static void creategon() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("On commence toujours par la pierre");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(meta);
        gon = item;
        itemliste.put("gon1", item);
    }
    private static void createkirua() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Electricite");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(meta);
        kirua = item;
        itemliste.put("kirua1", item);

    }

    private static void createnetero() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Priere");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(meta);
        netero = item;
        itemliste.put("netero1", item);

    }
    private static void createmorau() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Fumee");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(meta);
        morau = item;
        itemliste.put("morau1", item);

    }
    private static void createbiscuit() {
        ItemStack item = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Transformation");
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        item.setItemMeta(meta);
        biscuit = item;
        itemliste.put("biscuit1", item);

    }

}