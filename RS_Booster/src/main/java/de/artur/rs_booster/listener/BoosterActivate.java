package de.artur.rs_booster.listener;

import de.artur.rs_booster.Booster;
import de.artur.rs_booster.RS_Booster;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class BoosterActivate implements Listener {

    public static ArrayList<Player> FlyPlayer = new ArrayList<>();
    public static boolean FlyBooster = false;
    public static boolean DropBooster = false;
    public static boolean BreakBooster = false;
    public static boolean XPBooster = false;
    public static boolean NightVisionBooster = false;
    public static boolean StrenghtBooster = false;


    String prefix = RS_Booster.getInstance().getConfig().getString("Prefix");

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (p.getOpenInventory().getTitle().equalsIgnoreCase("§6Booster Menü")) {
            e.setCancelled(true);
            if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equalsIgnoreCase("§6Fly Booster")) {
                if (Booster.getFlyBooster(p.getUniqueId()) >= 1) {
                    if(!FlyBooster) {
                        p.closeInventory();
                        Booster.removeFlyBooster(p.getUniqueId(), 1);
                        p.sendMessage(prefix + "§7Du hast einen §6Fly Booster §7für 15 Minuten aktiviert!");
                        FlyBooster = true;
                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                            p2.sendMessage(prefix + "§6§l" + p.getName() + "§7 hat einen §6Fly Booster §7für 15 Minuten aktiviert");
                            p2.playSound(p2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                            FlyPlayer.add(p2);
                            for (Player p3 : FlyPlayer) {
                                p3.setAllowFlight(true);
                            }

                        }
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () ->
                        {
                            Bukkit.broadcastMessage(prefix + "§7Der §6Fly Booster §7von §6§l" + p.getName() + "§7 läuft in 30 Sekunden ab");
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                            }

                        },(int)(20*60*14.5));
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () -> {
                            FlyBooster = false;
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.sendMessage(prefix + "§7Der §6Fly Booster §7von §6§l" + p.getName() + "§7 ist abgelaufen.");
                                p2.playSound(p2.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);

                                if(FlyPlayer.contains(p2)) {
                                    p2.setAllowFlight(false);
                                    FlyPlayer.remove(p2);
                                }
                            }

                        }, 20*60*15);
                    } else {
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Dieser Booster ist bereits aktiviert");
                    }

                } else {
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Du besitzt diesen Booster nicht");
                    }
                }
            }else if (Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName().equalsIgnoreCase("§6Drop Booster")) {
                if (Booster.getDropBooster(p.getUniqueId()) >= 1) {
                    if(!DropBooster) {
                        p.closeInventory();
                        Booster.removeDropBooster(p.getUniqueId(), 1);
                        DropBooster = true;
                        p.sendMessage(prefix + "§7Du hast einen §6Drop Booster §7für 15 Minuten aktiviert!");
                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                            p2.sendMessage(prefix + "§6§l" + p.getName() + "§7 hat einen §6Drop Booster §7für 15 Minuten aktiviert");
                            p2.playSound(p2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                        }
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () ->
                        {
                            Bukkit.broadcastMessage(prefix + "§7Der §6Drop Booster §7von §6§l" + p.getName() + "§7 läuft in 30 Sekunden ab");
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                            }
                        },(int)(20*60*14.5));
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () -> {
                            DropBooster = false;
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.sendMessage(prefix + "§7Der §6Drop Booster §7von §6§l" + p.getName() + "§7 ist abgelaufen.");
                                p2.playSound(p2.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
                            }

                        }, 20*60*15);
                    } else {
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Dieser Booster ist bereits aktiviert");
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(prefix + "§7Du besitzt diesen Booster nicht");
                }
            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6XP Booster")) {
                if (Booster.getXPBooster(p.getUniqueId()) >= 1) {
                    if(!XPBooster) {
                        p.closeInventory();
                        Booster.removeXPBooster(p.getUniqueId(), 1);
                        p.sendMessage(prefix + "§7Du hast einen §6XP Booster §7für 15 Minuten aktiviert!");
                        XPBooster = true;
                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                            p2.sendMessage(prefix + "§6§l" + p.getName() + "§7 hat einen §6XP Booster §7für 15 Minuten aktiviert");
                            p2.playSound(p2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                        }
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () ->
                        {
                            Bukkit.broadcastMessage(prefix + "§7Der §6XP Booster §7von §6§l" + p.getName() + "§7 läuft in 30 Sekunden ab");
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                            }
                        },(int)(20*60*14.5));
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () -> {
                            XPBooster = false;
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.sendMessage(prefix + "§7Der §6XP Booster §7von §6§l" + p.getName() + "§7 ist abgelaufen.");
                                p2.playSound(p2.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
                            }

                        }, 20 * 60 * 15);
                    } else {
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Dieser Booster ist bereits aktiviert");
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(prefix + "§7Du besitzt diesen Booster nicht");
                }
            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Break Booster")) {
                if (Booster.getBreakBooster(p.getUniqueId()) >= 1) {
                    if (!BreakBooster) {
                        p.closeInventory();
                        Booster.removeBreakBooster(p.getUniqueId(), 1);
                        p.sendMessage(prefix + "§7Du hast einen §6Break Booster §7für 15 Minuten aktiviert!");
                        BreakBooster = true;
                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                            p2.sendMessage(prefix + "§6§l" + p.getName() + "§7 hat einen §6Break Booster §7für 15 Minuten aktiviert");
                            p2.playSound(p2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                            p2.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(9000000*2, 4));
                        }
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () ->
                        {
                            Bukkit.broadcastMessage(prefix + "§7Der §6Break Booster §7von §6§l" + p.getName() + "§7 läuft in 30 Sekunden ab");
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                            }
                        },(int)(20*60*14.5));
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () -> {
                            BreakBooster = false;
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.sendMessage(prefix + "§7Der §6Break Booster §7von §6§l" + p.getName() + "§7 ist abgelaufen.");
                                p2.playSound(p2.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
                                p2.removePotionEffect(PotionEffectType.FAST_DIGGING);
                            }

                        }, 20*60*15);
                    } else {
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Dieser Booster ist bereits aktiviert");
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(prefix + "§7Du besitzt diesen Booster nicht");
                }
            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Nachtsicht Booster")) {
                if (Booster.getNightVisionBooster(p.getUniqueId()) >= 1) {
                    if(!NightVisionBooster) {
                        p.closeInventory();
                        Booster.removeNightVisionBooster(p.getUniqueId(), 1);
                        p.sendMessage(prefix + "§7Du hast einen §6Nachtsicht Booster §7für 15 Minuten aktiviert!");
                        NightVisionBooster = true;
                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                            p2.sendMessage(prefix + "§6§l" + p.getName() + "§7 hat einen §6Nachtsicht Booster §7für 15 Minuten aktiviert");
                            p2.playSound(p2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                            p2.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(9000000*2, 4));
                        }
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () ->
                        {
                            Bukkit.broadcastMessage(prefix + "§7Der §6Nachtsicht Booster §7von §6§l" + p.getName() + "§7 läuft in 30 Sekunden ab");
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                            }
                        },(int)(20*60*14.5));
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () -> {
                            NightVisionBooster = false;
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.sendMessage(prefix + "§7Der §6Nachtsicht Booster §7von §6§l" + p.getName() + "§7 ist abgelaufen.");
                                p2.playSound(p2.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
                                p2.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            }

                        }, 20*60*15);
                    }else{
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Dieser Booster ist bereits aktiviert");
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(prefix + "§7Du besitzt diesen Booster nicht");
                }
            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Stärke Booster")) {
                if (Booster.getStrenghtBooster(p.getUniqueId()) >= 1) {
                    if(!StrenghtBooster) {
                        p.closeInventory();
                        Booster.removeStrenghtBooster(p.getUniqueId(), 1);
                        p.sendMessage(prefix + "§7Du hast einen §6Stärke Booster §7für 15 Minuten aktiviert!");
                        StrenghtBooster = true;
                        for (Player p2 : Bukkit.getOnlinePlayers()) {
                            p2.sendMessage(prefix + "§6§l" + p.getName() + "§7 hat einen §6Stärke Booster §7für 15 Minuten aktiviert");
                            p2.playSound(p2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0f, 1.0f);
                            p2.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(9000000*2, 1));
                        }
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () ->
                        {
                            Bukkit.broadcastMessage(prefix + "§7Der §6Stärke Booster §7von §6§l" + p.getName() + "§7 läuft in 30 Sekunden ab");
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.playSound(p2.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0f, 1.0f);
                            }
                        },(int)(20*60*14.5));
                        Bukkit.getScheduler().runTaskLater(RS_Booster.getInstance(), () -> {
                            StrenghtBooster = false;
                            for (Player p2 : Bukkit.getOnlinePlayers()) {
                                p2.sendMessage(prefix + "§7Der §6Stärke Booster §7von §6§l" + p.getName() + "§7 ist abgelaufen.");
                                p2.playSound(p2.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 1.0f, 1.0f);
                                p2.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                            }

                        }, 20*60*15);
                    } else {
                        p.closeInventory();
                        p.sendMessage(prefix + "§7Dieser Booster ist bereits aktiviert");
                    }
                } else {
                    p.closeInventory();
                    p.sendMessage(prefix + "§7Du besitzt diesen Booster nicht");
                }
            }
        }


}
