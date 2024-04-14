package de.artur.rs_booster;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Booster{


    // Booster Abfrage
    public static Integer getAllBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("all_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }
    public static Integer getFlyBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("fly_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }

    public static Integer getDropBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("drop_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }

    public static Integer getXPBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("xp_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }

    public static Integer getBreakBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("break_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }

    public static Integer getNightVisionBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("nightvision_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }

    public static Integer getStrenghtBooster(UUID uuid) {
        int i = 0;

        createPlayer(String.valueOf(uuid));

        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");

            if(rs.next())
                i = rs.getInt("strenght_booster");

        } catch (SQLException var3) {
            var3.printStackTrace();
        }
        return i;
    }

    //Booster setzen

    public static void setFlyBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET fly_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }

    public static void setDropBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET drop_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setBreakBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET break_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setNightVisionBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET nightvision_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setXPBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET xp_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setStrenghtBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET strenght_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }
    public static void setAllBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET all_booster= '" + amount + "' WHERE UUID= '" + uuid + "';");
        }
    }

    // Booster Hinzufügen

    public static void addAllBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setAllBooster(uuid, getAllBooster(uuid) + amount);
        }
    }

    public static void addFlyBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setFlyBooster(uuid, getFlyBooster(uuid) + amount);
        }
    }

    public static void addDropBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setDropBooster(uuid, getDropBooster(uuid) + amount);
        }
    }

    public static void addXPBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setXPBooster(uuid, getXPBooster(uuid) + amount);
        }
    }

    public static void addBreakBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setBreakBooster(uuid, getBreakBooster(uuid) + amount);
        }
    }

    public static void addNightVisionBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setNightVisionBooster(uuid, getNightVisionBooster(uuid) + amount);
        }
    }

    public static void addStrenghtBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setStrenghtBooster(uuid, getStrenghtBooster(uuid) + amount);
        }
    }

    // Booster entfernen

    public static  void removeAllBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setAllBooster(uuid, getAllBooster(uuid) - amount);
        }
    }

    public static  void removeFlyBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setFlyBooster(uuid, getFlyBooster(uuid) - amount);
        }
    }

    public static  void removeDropBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setDropBooster(uuid, getDropBooster(uuid) - amount);
        }
    }

    public static  void removeBreakBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setBreakBooster(uuid, getBreakBooster(uuid) - amount);
        }
    }

    public static  void removeXPBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setXPBooster(uuid, getXPBooster(uuid) - amount);
        }
    }

    public static  void removeNightVisionBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setNightVisionBooster(uuid, getNightVisionBooster(uuid) - amount);
        }
    }

    public static  void removeStrenghtBooster(UUID uuid, int amount) {
        if (playerExists(String.valueOf(uuid))) {
            setStrenghtBooster(uuid, getStrenghtBooster(uuid) - amount);
        }
    }


    // Booster Zurücksetzen
    public static void resetBooster(UUID uuid) {
        if (playerExists(String.valueOf(uuid))) {
            RS_Booster.mysql.update("UPDATE booster SET all_booster= '0' WHERE UUID= '" + uuid + "';");
            RS_Booster.mysql.update("UPDATE booster SET fly_booster= '0' WHERE UUID= '" + uuid + "';");
            RS_Booster.mysql.update("UPDATE booster SET drop_booster= '0' WHERE UUID= '" + uuid + "';");
            RS_Booster.mysql.update("UPDATE booster SET xp_booster= '0' WHERE UUID= '" + uuid + "';");
            RS_Booster.mysql.update("UPDATE booster SET break_booster= '0' WHERE UUID= '" + uuid + "';");
            RS_Booster.mysql.update("UPDATE booster SET nightvision_booster= '0' WHERE UUID= '" + uuid + "';");
            RS_Booster.mysql.update("UPDATE booster SET strenght_booster= '0' WHERE UUID= '" + uuid + "';");
        }
    }

    // Überprüfen ob der Spieler bereits in der Datenbank vorhanden ist
    public static boolean playerExists(String uuid) {
        try {
            ResultSet rs = RS_Booster.mysql.query("SELECT * FROM booster WHERE UUID= '" + uuid + "'");
            return rs.next();
        } catch (SQLException var2) {
            var2.printStackTrace();
            return false;
        }
    }

    // Spieler zur Datenbank hinzufügen
    public static void createPlayer(String uuid) {
        if (!playerExists(uuid)) {
            RS_Booster.mysql.update("INSERT INTO booster(UUID, all_booster, fly_booster, drop_booster, xp_booster, break_booster, nightvision_booster, strenght_booster) VALUES ('" + uuid + "', '0', '0', '0', '0', '0', '0', '0');");
        }
    }
}