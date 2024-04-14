package de.artur.rs_booster;

import de.artur.rs_booster.commands.BoosterCommand;
import de.artur.rs_booster.listener.BoosterActivate;
import de.artur.rs_booster.listener.Listeners;
import de.artur.rs_booster.utils.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class RS_Booster extends JavaPlugin {

    public static MySQL mysql;
    public static RS_Booster instance;
    public static RS_Booster plugin;

    // §x§F§4§C§4§F§3&lB§x§F§5§B§5§F§4&lo§x§F§7§A§5§F§5&lo§x§F§8§9§6§F§7&ls§x§F§9§8§6§F§8&lt§x§F§B§7§7§F§9&le§x§F§C§6§7§F§A&lr
    @Override
    public void onEnable() {
        instance = this;
        plugin = this;
        BoosterActivate.FlyBooster = false;
        BoosterActivate.DropBooster = false;
        BoosterActivate.XPBooster = false;
        BoosterActivate.BreakBooster = false;
        BoosterActivate.NightVisionBooster = false;
        BoosterActivate.StrenghtBooster = false;
        Bukkit.getConsoleSender().sendMessage("&aBooster Plugin startet...");
        loadCommands();
        loadListener();
        loadConfig();
        connectMySQL();
        Bukkit.getConsoleSender().sendMessage("&aBooster Plugin erfolgreich gestartet!");
    }

    private void loadConfig() {
        this.getConfig().addDefault("Prefix", "§d§lBooster §8× ");
        this.getConfig().addDefault("CitybuildWorldName", "CB1");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void loadListener() {
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        Bukkit.getPluginManager().registerEvents(new BoosterActivate(), this);
    }

    private void loadCommands() {

        getCommand("booster").setExecutor(new BoosterCommand());
        getCommand("booster").setTabCompleter(new BoosterCompleter());
    }


    @Override
    public void onDisable() {

    }

    public static RS_Booster getInstance() {
        return instance;
    }

    public static RS_Booster getPlugin() {
        return plugin;
    }

    public void connectMySQL() {
        File mysqlf = new File("plugins/RS_Booster", "mysql.yml");
        YamlConfiguration mysqly = YamlConfiguration.loadConfiguration(mysqlf);
        if(mysqly.get("host") == null)
            mysqly.set("host", "host");
        if(mysqly.get("database") == null)
            mysqly.set("database", "database");
        if(mysqly.get("user") == null)
            mysqly.set("user", "user");
        if(mysqly.get("password") == null)
            mysqly.set("password", "password");
        try {
            mysqly.save(mysqlf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String host = mysqly.getString("host");
        String database = mysqly.getString("database");
        String user = mysqly.getString("user");
        String password = mysqly.getString("password");
        if (host.equalsIgnoreCase("host") && database.equalsIgnoreCase("database") && user.equalsIgnoreCase("user") && password.equalsIgnoreCase("password")) {
            Bukkit.getConsoleSender().sendMessage("§cBitte trage deine MySQL-Daten in der Config ein!");
            Bukkit.getPluginManager().disablePlugin(getInstance());
        } else {
            mysql = new MySQL(host, database, user, password);
            mysql.connect();
            mysql.update("CREATE TABLE IF NOT EXISTS booster(UUID varchar(64), all_booster int, fly_booster int, drop_booster int, xp_booster int, break_booster int, nightvision_booster int, strenght_booster int);");
        }
    }
}
