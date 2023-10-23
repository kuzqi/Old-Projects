package wee.latebd;

import java.awt.Color;
import java.awt.Component;
import java.rmi.server.Skeleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.tools.DocumentationTool.Location;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.w3c.dom.Entity;

public class GayHunter extends BukkitRunnable {
  Piglin piglin;
  
  Player target;
  
  String name = "" + ChatColor.DARK_RED + ChatColor.DARK_RED + "Gay Hunter " + ChatColor.BOLD;
  
  List<Zombie> miniZombies;
  
  List<Skeleton> skeletons;
  
  private int seconds;
  
  private int lastTntThrow;
  
  private int lastBeamThrow;
  
  private int lastLeap;
  
  private int lastMiniPiglinSpawn;
  
  int current;
  
  List<String> list;
  
  public void run() {
    System.out.println("Still alive");
    if (this.piglin.isDead()) {
      cancel();
      for (Zombie zombie : this.miniZombies) {
        zombie.setKiller(this.target);
        zombie.setHealth(0.0D);
      } 
      for (Skeleton skeleton : this.skeletons) {
        skeleton.setKiller(this.target);
        skeleton.setHealth(0.0D);
      } 
      this.target.sendTitle("" + ChatColor.GOLD + "You have defeated the GAY HUNTER", "You have been rewarded with our friendship <3", 10, 150, 20);
      this.target.playSound(this.target.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
      return;
    } 
    this.seconds++;
    this.piglin.setTarget((LivingEntity)this.target);
    this.piglin.setFallDistance(0.0F);
    int heal = (int)this.piglin.getHealth();
    this.piglin.customName((Component)Component.text(this.name + this.name + "/300"));
    if (this.seconds >= 25 && this.seconds % 25 == 0) {
      this.target.sendTitle("" + ChatColor.RED + ChatColor.RED + "RUN!!", "NOW", 10, 10, 10);
      this.target.sendTitle("" + ChatColor.RED + ChatColor.RED + "RUN!!", "NOW", 40, 10, 10);
      useUlt();
      return;
    } 
    if (this.seconds < 8) {
      if (this.lastLeap > 5) {
        leapToTarget();
        this.lastLeap = 0;
        sendToxicMessage();
      } else {
        this.lastLeap++;
      } 
      if (this.lastBeamThrow > 2) {
        throwABeamTwardsTarget();
        this.lastBeamThrow = 0;
      } else {
        this.lastBeamThrow++;
      } 
    } else {
      if (this.lastLeap > 5) {
        leapToTarget();
        this.lastLeap = 0;
        sendToxicMessage();
      } else {
        this.lastLeap++;
      } 
      if (this.lastBeamThrow > 2) {
        throwABeamTwardsTarget();
        this.lastBeamThrow = 0;
      } else {
        this.lastBeamThrow++;
      } 
      if (this.lastTntThrow > 3) {
        throwTntTwardsTarget();
        this.lastTntThrow = 0;
      } else {
        this.lastTntThrow++;
      } 
      if (this.lastMiniPiglinSpawn > 10) {
        summonChilds();
        this.lastMiniPiglinSpawn = 0;
      } else {
        this.lastMiniPiglinSpawn++;
      } 
    } 
  }
  
  public GayHunter(Piglin piglin, Player target) {
    this.current = 0;
    this.list = List.of("Haha! Is that the best you puny adventurers can do? Pathetic!", "Well, well, well... Looks like you've brought your feeble skills to the wrong boss. Prepare to be utterly defeated!", "Oh, how cute! Is this your attempt to challenge my greatness? You'll need more than that!", "Ha! You call that an attack? It tickles! Try harder, if you dare!", "Oh, dear adventurers, your feeble attempts are almost adorable. Too bad they're utterly futile!", "Pathetic mortals! Your feeble attacks are like a gentle breeze. Prepare for my true power!", "Is that the best you can muster? I've seen squirrels with more bite! Come on, show me something impressive!", "How disappointing! I expected a real challenge, not this feeble attempt at a battle!", "You dare stand before me with such weak attacks? It's almost insulting! Prepare to face true despair!", "You thought you could defeat me with that? My grandma hits harder than that!");
    this.piglin = piglin;
    this.target = target;
    this.miniZombies = new ArrayList<>();
    this.skeletons = new ArrayList<>();
    piglin.setTarget((LivingEntity)target);
    piglin.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(300.0D);
    piglin.setHealth(300.0D);
    piglin.customName((Component)Component.text(this.name + this.name + "/300"));
    piglin.setCustomNameVisible(true);
    piglin.setAdult();
    piglin.setImmuneToZombification(true);
    piglin.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 2));
    piglin.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 2));
    ItemStack sword = new ItemStack(Material.GOLDEN_SWORD);
    ItemMeta swordMeta = sword.getItemMeta();
    swordMeta.setDisplayName("" + ChatColor.RED + ChatColor.RED + "Gay Hunter's Sword");
    sword.setLore(List.of("" + ChatColor.GOLD + "Only homophobic people can use this sword"));
    swordMeta.setUnbreakable(true);
    sword.addEnchantment(Enchantment.DAMAGE_ALL, 2);
    sword.setItemMeta(swordMeta);
    ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
    ItemStack legg = new ItemStack(Material.LEATHER_LEGGINGS);
    ItemStack boot = new ItemStack(Material.LEATHER_BOOTS);
    ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
    LeatherArmorMeta leatherMeta = (LeatherArmorMeta)chestplate.getItemMeta();
    leatherMeta.setDisplayName("" + ChatColor.RED + ChatColor.RED + "Gay Hunter's Armor");
    leatherMeta.setLore(List.of("" + ChatColor.GOLD + "Only homophobic people can use this armor"));
    leatherMeta.setUnbreakable(true);
    leatherMeta.setColor(Color.RED);
    chestplate.setItemMeta((ItemMeta)leatherMeta);
    chestplate.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
    leatherMeta.setColor(Color.BLACK);
    legg.setItemMeta((ItemMeta)leatherMeta);
    legg.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
    leatherMeta.setColor(Color.RED);
    boot.setItemMeta((ItemMeta)leatherMeta);
    boot.addEnchantment(Enchantment.PROTECTION_FALL, 4);
    boot.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
    leatherMeta.setColor(Color.BLACK);
    helmet.setItemMeta((ItemMeta)leatherMeta);
    helmet.addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 4);
    piglin.getEquipment().setHelmet(helmet);
    piglin.getEquipment().setChestplate(chestplate);
    piglin.getEquipment().setLeggings(legg);
    piglin.getEquipment().setBoots(boot);
    piglin.getEquipment().setItemInMainHand(sword);
    piglin.getEquipment().setHelmetDropChance(100.0F);
    piglin.getEquipment().setChestplateDropChance(100.0F);
    piglin.getEquipment().setLeggingsDropChance(100.0F);
    piglin.getEquipment().setBootsDropChance(100.0F);
    piglin.getEquipment().setItemInMainHand(sword);
    spawnLeapPartic();
    spawnLeapPartic();
  }
  
  private void sendToxicMessage() {
    World world = this.piglin.getWorld();
    for (Player player : world.getPlayers()) {
      player.sendMessage(this.name + ": " + this.name + ChatColor.RED);
      player.sendTitle(this.name, "" + ChatColor.RED + ChatColor.RED, 0, 60, 10);
      this.current++;
      if (this.current >= this.list.size())
        this.current = 0; 
    } 
  }
  
  public void leapToTarget() {
    Location targetLocation = this.target.getLocation();
    targetLocation.setY(targetLocation.getY() + 2.0D);
    this.piglin.setVelocity(targetLocation.toVector()
        .subtract(this.piglin.getLocation().toVector()).normalize().multiply(2));
    spawnLeapPartic();
  }
  
  public void spawnLeapPartic() {
    World world = this.target.getWorld();
    for (int i = 0; i < 360; i += 30) {
      double x = Math.cos(i);
      double z = Math.sin(i);
      world.spawnParticle(Particle.SMOKE_LARGE, this.piglin.getLocation(), 10, x, 0.5D, z, 0.1D);
      world.spawnParticle(Particle.FLAME, this.piglin.getLocation(), 10, x, 0.5D, z, 0.1D);
      world.spawnParticle(Particle.FLASH, this.piglin.getLocation(), 10, x, 0.5D, z, 0.1D);
    } 
    Bukkit.getScheduler().runTaskLater((Plugin)LateBd.getPlugin(LateBd.class), bukkitTask -> {
          this.target.getLocation().getWorld().playSound(this.target.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 30.0F, 1.0F);
          for (int i = 0; i < 360; i += 80) {
            double x = Math.cos(i);
            double z = Math.sin(i);
            world.spawnParticle(Particle.EXPLOSION_NORMAL, this.target.getLocation(), 10, x, 0.5D, z, 0.1D);
          } 
        }20L);
  }
  
  public void useUlt() {
    this.piglin.teleport(this.piglin.getLocation().add(0.0D, 8.0D, 0.0D));
    this.piglin.setAI(false);
    this.piglin.setInvulnerable(true);
    this.piglin.setHealth(this.piglin.getHealth() + this.piglin.getHealth() * 0.3D);
    World world = this.target.getWorld();
    int i;
    for (i = 0; i < 20; i++)
      Bukkit.getScheduler().runTaskLater((Plugin)LateBd.getPlugin(LateBd.class), bukkitTask -> throwTntTwardsTarget(), (i * 4)); 
    for (i = 0; i < 360; i += 80) {
      double x = Math.cos(i);
      double z = Math.sin(i);
      world.spawnParticle(Particle.SMOKE_LARGE, this.piglin.getLocation(), 10, x, 0.5D, z, 0.1D);
      world.spawnParticle(Particle.FLAME, this.piglin.getLocation(), 10, x, 0.5D, z, 0.1D);
      world.spawnParticle(Particle.FLASH, this.piglin.getLocation(), 10, x, 0.5D, z, 0.1D);
    } 
    for (i = 0; i < 360; i += 80) {
      double x = Math.cos(i);
      double z = Math.sin(i);
      world.strikeLightning(this.piglin.getLocation().add(x, 0.0D, z));
    } 
    Bukkit.getScheduler().runTaskLater((Plugin)LateBd.getPlugin(LateBd.class), bukkitTask -> {
          this.piglin.teleport(this.target.getLocation());
          spawnLeapPartic();
          this.piglin.setAI(true);
          this.piglin.setInvulnerable(false);
        }100L);
  }
  
  public void throwTntTwardsTarget() {
    Location targetLocation = this.target.getLocation();
    TNTPrimed tnt = (TNTPrimed)this.piglin.getWorld().spawn(this.piglin.getLocation().add(0.0D, 3.0D, 0.0D), TNTPrimed.class);
    tnt.setFuseTicks(20);
    tnt.setVelocity(targetLocation.toVector()
        .subtract(this.piglin.getLocation().add(3.0D, 0.0D, 0.0D).toVector()).normalize());
  }
  
  public void throwABeamTwardsTarget() {
    shootBeam(this.piglin.getLocation().add(0.0D, 2.0D, 0.0D), this.target, 30.0D);
    this.piglin.getLocation().getWorld().playSound(this.piglin.getLocation(), Sound.ENTITY_IRON_GOLEM_DAMAGE, 30.0F, 0.1F);
    this.target.damage(5.0D);
  }
  
  public void shootBeam(Location fromOrigin, Player player, double maxRange) {
    try {
      if (player != null && player.isOnline() && 
        fromOrigin != null) {
        Location toLocation = this.target.getLocation().add(0.0D, 2.0D, 0.0D);
        if (fromOrigin.getX() != toLocation.getX() || fromOrigin.getY() != toLocation.getY() || fromOrigin.getZ() != toLocation.getZ()) {
          Location fromNew = fromOrigin.clone();
          Vector direction = toLocation.toVector().subtract(fromOrigin.toVector()).normalize();
          double range = Math.min(fromOrigin.distanceSquared(toLocation), maxRange * maxRange);
          while (fromOrigin.distanceSquared(fromNew) <= range) {
            fromNew.getWorld().spawnParticle(Particle.END_ROD, fromNew, 5, 0.0D, 0.0D, 0.0D, 0.0D);
            fromNew.add(direction);
          } 
        } 
      } 
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  public void summonChilds() {
    Location location = this.piglin.getLocation();
    World world = location.getWorld();
    int c = 0;
    for (int i = 0; i < 360; i += 80) {
      double x = Math.cos(i);
      double z = Math.sin(i);
      world.spawnParticle(Particle.FLAME, location, 10, x, 0.5D, z, 0.1D);
      world.spawnParticle(Particle.FLASH, location, 10, x, 0.5D, z, 0.1D);
      Location temp = location.offset(x, 0.0D, x).toLocation(world);
      Zombie e = (Zombie)location.getWorld().spawnEntity(temp, EntityType.ZOMBIE);
      applyZombie(e);
      Skeleton skeleton = (Skeleton)location.getWorld().spawnEntity(location, EntityType.SKELETON);
      applySkeleton(skeleton);
      System.out.println("c: " + c);
      if (c % 2 == 0) {
        e.addPassenger((Entity)skeleton);
        System.out.println("added passenger");
      } 
      c++;
    } 
  }
  
  public void applySkeleton(Skeleton skeleton) {
    skeleton.customName((Component)Component.text("" + ChatColor.GOLD + "Homophobic Skeleton"));
    skeleton.setCustomNameVisible(true);
    this.skeletons.add(skeleton);
  }
  
  public void applyZombie(Zombie pigZombie) {
    pigZombie.customName((Component)Component.text("" + ChatColor.BLACK + "Homophobic Zombie"));
    pigZombie.setCustomNameVisible(true);
    pigZombie.setBaby();
    this.miniZombies.add(pigZombie);
  }
}
