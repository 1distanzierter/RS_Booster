package de.artur.rs_booster.commands;

import de.artur.rs_booster.Booster;
import de.artur.rs_booster.RS_Booster;
import de.artur.rs_booster.listener.BoosterActivate;
import de.artur.rs_booster.utils.HeadUtil;
import de.artur.rs_booster.utils.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BoosterCommand implements CommandExecutor {

    String prefix = RS_Booster.getInstance().getConfig().getString("Prefix");
    String Fly = "§cDeaktiviert";
    String Break = "§cDeaktiviert";
    String Drop = "§cDeaktiviert";
    String XP = "§cDeaktiviert";
    String NightVision = "§cDeaktiviert";
    String Strenght = "§cDeaktiviert";

    @Override
    public boolean onCommand(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String l, @NotNull String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (args.length == 0) {
                    Inventory inv = Bukkit.createInventory(null, 9, "§6ʙᴏᴏѕᴛᴇʀ ᴍᴇɴü");
                    ItemStack amount = new ItemStack(HeadUtil.getCustomSkull("§6Anzahl deiner Booster", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRjMTY0YmFjMjE4NGE3NmExZWU5NjkxMzI0MmUzMzVmMWQ0MTFjYWZmNTEyMDVlYTM5YjIwNWU2ZjhmMDU4YSJ9fX0="));
                    ItemMeta amount_meta = amount.getItemMeta();
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("§7Fly Booster: §6" + Booster.getFlyBooster(p.getUniqueId()));
                    lore.add("§7Drop Booster: §6" + Booster.getDropBooster(p.getUniqueId()));
                    lore.add("§7XP Booster: §6" + Booster.getXPBooster(p.getUniqueId()));
                    lore.add("§7Break Booster: §6" + Booster.getBreakBooster(p.getUniqueId()));
                    lore.add("§7Nachtsicht Booster: §6" + Booster.getNightVisionBooster(p.getUniqueId()));
                    lore.add("§7Stärke Booster: §6" + Booster.getStrenghtBooster(p.getUniqueId()));
                    amount_meta.setLore(lore);
                    amount.setItemMeta(amount_meta);
                    for(int i=0; i<9; i++) {
                        ItemStack Placeholder = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta PlaceholderMeta = Placeholder.getItemMeta();
                        PlaceholderMeta.setDisplayName("§8-/-");
                        Placeholder.setItemMeta(PlaceholderMeta);
                        inv.setItem(i, Placeholder);
                    }
                    inv.setItem(0, amount);
                    inv.setItem(2, new ItemUtil(Material.FEATHER).setName("§6Fly Booster").setLore("§7Klicke zum Aktivieren").build(true, true, true));
                    inv.setItem(3, new ItemUtil(Material.BARRIER).setName("§6Drop Booster").setLore("§7Klicke zum Aktivieren").build(true, true, true));
                    inv.setItem(4, new ItemUtil(Material.EXPERIENCE_BOTTLE).setName("§6XP Booster").setLore("§7Klicke zum Aktivieren").build(true, true, true));
                    inv.setItem(5, new ItemUtil(Material.IRON_PICKAXE).setName("§6Break Booster").setLore("§7Klicke zum Aktivieren").build(true, true, true));
                    inv.setItem(6, new ItemUtil(Material.ENDER_EYE).setName("§6Nachtsicht Booster").setLore("§7Klicke zum Aktivieren").build(true, true, true));
                    inv.setItem(7, new ItemUtil(Material.IRON_SWORD).setName("§6Stärke Booster").setLore("§7Klicke zum Aktivieren").build(true, true, true));

                    p.openInventory(inv);

            } else if (args.length == 1) {
                switch (args[0]) {
                    case "help":
                        p.sendMessage("");
                        p.sendMessage(prefix + "§7Booster Help: \n"
                                + prefix + "§e/booster help §7- Zeigt dir diese Nachricht an\n"
                                + prefix + "§e/booster status §7- Zeigt dir alle aktiven Booster\n"
                                + prefix + "§e/booster info §7- Zeigt dir alle deine Booster\n"
                                + prefix + "§e/booster §7- Öffnet das Booster Menü");
                        p.sendMessage("");
                        break;
                    case "info":
                        p.sendMessage("");
                        p.sendMessage(prefix + "§7Du hast folgende Booster:\n"
                                + prefix + "§7Fly Booster: §6" + Booster.getFlyBooster(p.getUniqueId()) + "\n"
                                + prefix + "§7Drop Booster: §6" + Booster.getDropBooster(p.getUniqueId()) + "\n"
                                + prefix + "§7XP Booster: §6" + Booster.getXPBooster(p.getUniqueId()) + "\n"
                                + prefix + "§7Break Booster: §6" + Booster.getBreakBooster(p.getUniqueId()) + "\n"
                                + prefix + "§7Nachtsicht Booster: §6" + Booster.getNightVisionBooster(p.getUniqueId()) + "\n"
                                + prefix + "§7Stärke Booster: §6" + Booster.getStrenghtBooster(p.getUniqueId()) + "\n");
                        p.sendMessage("");
                        break;
                    case "status":
                        if(BoosterActivate.FlyBooster) {
                            Fly = "§aAktiviert";
                        } else
                            Fly = "§cDeaktiviert";

                        if(BoosterActivate.DropBooster) {
                            Drop = "§aAktiviert";
                        } else
                            Drop = "§cDeaktiviert";
                        if(BoosterActivate.XPBooster) {
                            XP = "§aAktiviert";
                        } else
                            XP = "§cDeaktiviert";
                        if(BoosterActivate.BreakBooster) {
                            Break = "§aAktiviert";
                        } else
                            Break = "§cDeaktiviert";
                        if(BoosterActivate.NightVisionBooster) {
                            NightVision = "§aAktiviert";
                        } else
                            NightVision = "§cDeaktiviert";
                        if(BoosterActivate.StrenghtBooster) {
                            Strenght = "§aAktiviert";
                        } else
                            Strenght = "§cDeaktiviert";
                        p.sendMessage("");
                        p.sendMessage(prefix + "§7Es sind folgende Booster aktiv:\n"
                                + prefix + "§7Fly Booster: " + Fly + "\n"
                                + prefix + "§7Drop Booster: " + Drop + "\n"
                                + prefix + "§7XP Booster: " + XP + "\n"
                                + prefix + "§7Break Booster: " + Break + "\n"
                                + prefix + "§7Nachtsicht Booster: " + NightVision + "\n"
                                + prefix + "§7Stärke Booster: " + Strenght + "\n");
                        break;

                    case "adminhelp":
                        if (p.hasPermission("booster.admin")) {
                        p.sendMessage("");
                        p.sendMessage(prefix + "§7Admin Booster Help: \n"
                                + prefix + "§e/booster adminhelp §7- Zeigt dir diese Nachricht an\n"
                                + prefix + "§e/booster give §7- Gebe einem Spieler Boostern\n"
                                + prefix + "§e/booster remove §7- Entferne einem Spieler Booster\n"
                                + prefix + "§e/booster reset §7- Setzte die Booster eines Spielers zurück\n"
                                + prefix + "§e/booster see §7- Siehe die Booster eines Spielers");
                        p.sendMessage("");
                        break;
                } else
                    p.sendMessage(prefix + "§cDazu hast du keine Berechtigung §7(booster.admin)");
                }

            } else if (args.length == 2) {
                if(p.hasPermission("booster.admin")) {
                    Player t = Bukkit.getPlayer(args[1]);
                    if (args[0].equalsIgnoreCase("reset")) {
                        Booster.resetBooster(t.getUniqueId());
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + "§7 seine Booster zurückgesetzt");
                    } else if (args[0].equalsIgnoreCase("see")) {
                        p.sendMessage("");
                        p.sendMessage(prefix + "§6" + t.getName() + " §7hat folgende Booster:\n"
                                + prefix +"\n"
                                + prefix + "§7Fly Booster: §6" + Booster.getFlyBooster(t.getUniqueId()) + "\n"
                                + prefix + "§7Drop Booster: §6" + Booster.getDropBooster(t.getUniqueId()) + "\n"
                                + prefix + "§7XP Booster: §6" + Booster.getXPBooster(t.getUniqueId()) + "\n"
                                + prefix + "§7Break Booster: §6" + Booster.getBreakBooster(t.getUniqueId()) + "\n"
                                + prefix + "§7Nachtsicht Booster: §6" + Booster.getNightVisionBooster(t.getUniqueId()) + "\n"
                                + prefix + "§7Stärke Booster: §6" + Booster.getStrenghtBooster(t.getUniqueId()) + "\n");
                        p.sendMessage("");
                    }
                } else
                    p.sendMessage(prefix + "§cDazu hast du keine Berechtigung §7(booster.admin)");

            } else if (args.length == 4) {
                if(p.hasPermission("booster.admin")) {
                Player t = Bukkit.getPlayer(args[1]);
                if (args[0].equalsIgnoreCase("give")) {
                    if(args[2].equalsIgnoreCase("FlyBooster")) {
                        Booster.addFlyBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Fly Booster gegeben");
                    } else if(args[2].equalsIgnoreCase("DropBooster")) {
                        Booster.addDropBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Drop Booster gegeben");
                    } else if(args[2].equalsIgnoreCase("XPBooster")) {
                        Booster.addXPBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 XP Booster gegeben");
                    } else if(args[2].equalsIgnoreCase("BreakBooster")) {
                        Booster.addBreakBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Break Booster gegeben");
                    } else if(args[2].equalsIgnoreCase("NachtsichtBooster")) {
                        Booster.addNightVisionBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Nachtsicht Booster gegeben");
                    } else if(args[2].equalsIgnoreCase("StärkeBooster")) {
                        Booster.addStrenghtBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Stärke Booster gegeben");
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if(args[2].equalsIgnoreCase("FlyBooster")) {
                        Booster.removeFlyBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Fly Booster entfern");
                    } else if(args[2].equalsIgnoreCase("DropBooster")) {
                        Booster.removeDropBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Drop Booster entfernt");
                    } else if(args[2].equalsIgnoreCase("XPBooster")) {
                        Booster.removeXPBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 XP Booster entfernt");
                    } else if(args[2].equalsIgnoreCase("BreakBooster")) {
                        Booster.removeBreakBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Break Booster entfernt");
                    } else if(args[2].equalsIgnoreCase("NachtsichtBooster")) {
                        Booster.removeNightVisionBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Nachtsicht Booster entfernt");
                    } else if(args[2].equalsIgnoreCase("StärkeBooster")) {
                        Booster.removeStrenghtBooster(t.getUniqueId(), Integer.parseInt(args[3]));
                        p.sendMessage(prefix + "§7Du hast §6" + t.getName() + " §a" + Integer.parseInt(args[3]) + "§7 Stärke Booster entfernt");
                    }
                }
            } else p.sendMessage(prefix + "§cDazu hast du keine Berechtigung §7(booster.admin)");
            }

        }
        return false;
    }
}
