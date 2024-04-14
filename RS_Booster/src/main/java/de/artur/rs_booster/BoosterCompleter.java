package de.artur.rs_booster;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BoosterCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender s, @NotNull Command cmd, @NotNull String l, @NotNull String[] args) {
        if(args.length == 1) {
            ArrayList<String> a1 = new ArrayList<>();
            a1.add("help");
            a1.add("status");
            a1.add("info");
            a1.add("adminhelp");
            a1.add("give");
            a1.add("remove");
            a1.add("reset");
            a1.add("see");
            return a1;
        }
        if(args.length == 2) {
            ArrayList<String> players = new ArrayList<>();
            for(Player p : Bukkit.getOnlinePlayers()) {
                players.add(p.getName());
            }
            return players;
        }
        if (args.length == 3) {
            ArrayList<String> booster = new ArrayList<>();
            booster.add("FlyBooster");
            booster.add("DropBooster");
            booster.add("XPBooster");
            booster.add("BreakBooster");
            booster.add("NachtsichtBooster");
            booster.add("StärkeBooster");
            return booster;
        }
        if(args.length == 4) {
            ArrayList<String> anzahl = new ArrayList<>();
            anzahl.add("1");
            anzahl.add("5");
            anzahl.add("10");
            anzahl.add("15");
            anzahl.add("20");
            anzahl.add("25");
            anzahl.add("50");
            anzahl.add("100");
            return anzahl;
        }
        return null;
    }
}
