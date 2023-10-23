package Player;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import Utils.ItemBuilder;
import me.redpvp.Main.Main;
import me.redpvp.RedPvP.ScoreBoard;

public class PlayerSettings implements Listener {

	public Main main;
	public PlayerSettings(Main main) {
		this.main = main;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		ScoreBoard.Scoreboard(p);
		if (!(p.getGameMode() == GameMode.SURVIVAL)) p.setGameMode(GameMode.SURVIVAL);
		if (p.getHealth() < 20) p.setHealth(20);
		if (p.getFireTicks() > 0) p.setFireTicks(0);
	
	}

	  @EventHandler
	  public void onHungerMeterChange(FoodLevelChangeEvent e) {
	    e.setCancelled(true);
	  }
	  
	  @EventHandler
	  public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
	      if (e.getEntity() instanceof ItemFrame) {
	    	  e.setCancelled(true);
	      }
	  }
	
	  @EventHandler
	    public void onInteract(PlayerInteractEntityEvent e){
	        if (e.getRightClicked().getType() == EntityType.PLAYER) {
	            if(e.getRightClicked().getCustomName().equals("§eShop")) {
				  Player p = e.getPlayer();
				  Inventory ShopGui = main.getServer().createInventory(p, 54, "§4Shop");
			    	ItemStack Rod1 = new ItemBuilder (Material.FISHING_ROD,1,0).setDisplayname("§eFishing Rod").addEnchant(Enchantment.DURABILITY, 3).setLore("§cPrice: §a16 Gold").build();
			    	ItemStack Rod2 = new ItemBuilder (Material.FISHING_ROD,1,0).setDisplayname("§eFishing Rod").addEnchant(Enchantment.DURABILITY, 4).setLore("§cPrice: §a20 Gold").build();
			    	// -- - -- - -- - - - -  -- - - -- -- 
			    	ItemStack chestplate1 = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§bDiamond Chestplate").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
			    	ItemStack chestplate2 = new ItemBuilder (Material.DIAMOND_CHESTPLATE,1,0).setDisplayname("§bDiamond Chestplate").setLore("§cPrice: §a16 Gold").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
			    	
			    	ItemStack helmet1 = new ItemBuilder (Material.DIAMOND_HELMET,1,0).setDisplayname("§bDiamond Helmet").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
			    	ItemStack helmet2 = new ItemBuilder (Material.DIAMOND_HELMET,1,0).setDisplayname("§bDiamond Helmet").setLore("§cPrice: §a16 Gold").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
			    	
			    	ItemStack leggings1 = new ItemBuilder (Material.DIAMOND_LEGGINGS,1,0).setDisplayname("§bDiamond Leggings").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
			    	ItemStack leggings2 = new ItemBuilder (Material.DIAMOND_LEGGINGS,1,0).setDisplayname("§bDiamond Leggings").setLore("§cPrice: §a16 Gold").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
			    	
			    	ItemStack boot1 = new ItemBuilder (Material.DIAMOND_BOOTS,1,0).setDisplayname("§bDiamond Boots").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.DURABILITY,3).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,3).build();
			    	ItemStack boot2 = new ItemBuilder (Material.DIAMOND_BOOTS,1,0).setDisplayname("§bDiamond Boots").setLore("§cPrice: §a16 Gold").addEnchant(Enchantment.DURABILITY,4).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4).build();
			    	
			    	ItemStack apple1 = new ItemBuilder (Material.GOLDEN_APPLE,2,1).setDisplayname("§dGolden Apple").setLore("§cPrice: §a4 Gold").build();
			    	ItemStack apple2 = new ItemBuilder (Material.GOLDEN_APPLE,4,1).setDisplayname("§dGolden Apple").setLore("§cPrice: §a8 Gold").build();
			    	ItemStack apple3 = new ItemBuilder (Material.GOLDEN_APPLE,6,1).setDisplayname("§dGolden Apple").setLore("§cPrice: §a12 Gold").build();
			    	
			    	ItemStack axe1 = new ItemBuilder (Material.DIAMOND_AXE,1,0).setDisplayname("§3Diamond Axe").setLore("§cPrice: §a4 Gold").addEnchant(Enchantment.DAMAGE_ALL, 2).addEnchant(Enchantment.DURABILITY, 3).build();
			    	ItemStack axe2 = new ItemBuilder (Material.DIAMOND_AXE,1,0).setDisplayname("§3Diamond Axe").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.DAMAGE_ALL, 3).addEnchant(Enchantment.DURABILITY, 4).build();
			    	
			    	ItemStack bow1 = new ItemBuilder (Material.BOW,1,0).setDisplayname("§9Bow").setLore("§cPrice: §a4 Gold").addEnchant(Enchantment.ARROW_DAMAGE, 1).addEnchant(Enchantment.DURABILITY, 2).build();
			    	ItemStack bow2 = new ItemBuilder (Material.BOW,1,0).setDisplayname("§9Bow").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.ARROW_DAMAGE, 2).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.ARROW_KNOCKBACK, 1).build();
			    	ItemStack bow3 = new ItemBuilder (Material.BOW,1,0).setDisplayname("§9Bow").setLore("§cPrice: §a12 Gold").addEnchant(Enchantment.ARROW_DAMAGE, 3).addEnchant(Enchantment.DURABILITY, 4).addEnchant(Enchantment.ARROW_FIRE, 1).addEnchant(Enchantment.ARROW_KNOCKBACK, 1).build();
			    	
			    	ItemStack sword1 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§bDiamond Sword").setLore("§cPrice: §a4 Gold").addEnchant(Enchantment.DAMAGE_ALL, 2).addEnchant(Enchantment.DURABILITY, 2).build();
			    	ItemStack sword2 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§bDiamond Sword").setLore("§cPrice: §a8 Gold").addEnchant(Enchantment.DAMAGE_ALL, 3).addEnchant(Enchantment.FIRE_ASPECT, 1).addEnchant(Enchantment.DURABILITY, 3).build();
			    	ItemStack sword3 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§bDiamond Sword").setLore("§cPrice: §a12 Gold").addEnchant(Enchantment.DAMAGE_ALL, 4).addEnchant(Enchantment.FIRE_ASPECT, 1).addEnchant(Enchantment.DURABILITY, 4).addEnchant(Enchantment.KNOCKBACK, 1).build();
			    	ItemStack sword4 = new ItemBuilder (Material.DIAMOND_SWORD,1,0).setDisplayname("§bDiamond Sword").setLore("§cPrice: §a18 Gold").addEnchant(Enchantment.DAMAGE_ALL, 5).addEnchant(Enchantment.FIRE_ASPECT, 1).addEnchant(Enchantment.DURABILITY, 5).addEnchant(Enchantment.KNOCKBACK, 2).build();
			    	
			    	ItemStack converter = new ItemBuilder (Material.DOUBLE_PLANT,1,0).setDisplayname("§6Converter").setLore("","§e2 Gold §8>> §44 Coins").build();
			    	
			    	ItemStack speed = new ItemBuilder (Material.POTION,1,8226).setDisplayname("§7Speed Potion").setLore("§cPrice: §a6 Gold").build();
			    	ItemStack jumpboost = new ItemBuilder (Material.POTION,1,8203).setDisplayname("§aJump Potion").setLore("§cPrice: §a4 Gold").build();
			    	ItemStack fireresistance = new ItemBuilder (Material.POTION,1,8259).setDisplayname("§6Fire Resistance Potion").setLore("§cPrice: §a4 Gold").build();
			    	ItemStack strength = new ItemBuilder (Material.POTION,1,8233).setDisplayname("§5Strength Potion").setLore("§cPrice: §a6 Gold").build();
			    	
			    	ItemStack apple5 = new ItemBuilder (Material.GOLDEN_APPLE,1,1).setDisplayname("§dGolden Apple").setLore("§cPrice: §a2 Gold").build();
			    	
			    	
			    	ShopGui.setItem(0, Rod1);
			    	ShopGui.setItem(8, Rod2);
			    	ShopGui.setItem(18, helmet1);
			    	ShopGui.setItem(19, helmet2);
			    	ShopGui.setItem(27, chestplate1);
			    	ShopGui.setItem(28, chestplate2);
			    	ShopGui.setItem(29, apple1);
			    	ShopGui.setItem(36, leggings1);
			    	ShopGui.setItem(37, leggings2);
			    	ShopGui.setItem(38, apple2);
			    	ShopGui.setItem(45, boot1);
			    	ShopGui.setItem(46, boot2);
			    	ShopGui.setItem(47, apple3);
			    	ShopGui.setItem(49, axe1);
			    	ShopGui.setItem(50, axe2);
			    	ShopGui.setItem(34, bow1);
			    	ShopGui.setItem(43, bow2);
			    	ShopGui.setItem(52, bow3);
			    	ShopGui.setItem(26, sword1);
			    	ShopGui.setItem(35, sword2);
			    	ShopGui.setItem(44, sword3);
			    	ShopGui.setItem(53, sword4);
			    	ShopGui.setItem(22, converter);
			    	ShopGui.setItem(2, speed);
			    	ShopGui.setItem(3, jumpboost);
			    	ShopGui.setItem(5, fireresistance);
			    	ShopGui.setItem(6, strength);
			    	ShopGui.setItem(4, apple5);
			    	p.openInventory(ShopGui);
			  }
		  }
	  }
	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent e) {
		if (e.getPlayer() instanceof Player) {
			if (e.getItemDrop().getItemStack().getItemMeta().getLore().contains("§c§lLOCKED")){
				e.getItemDrop().remove(); e.getPlayer().playSound(e.getPlayer().getLocation(),Sound.ITEM_BREAK,1,1);
			}
		}
	}
}

