package de.artur.rs_booster.listener;

import de.artur.rs_booster.Booster;
import de.artur.rs_booster.RS_Booster;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;

public class Listeners implements Listener {

    private String WorldName = RS_Booster.getInstance().getConfig().getString("CityBuildWorldName");

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Booster.createPlayer(String.valueOf(p.getUniqueId()));
        if(BoosterActivate.FlyBooster) {
            BoosterActivate.FlyPlayer.add(p);
            p.setAllowFlight(true);
        }
        if(BoosterActivate.BreakBooster) {
            p.addPotionEffect(PotionEffectType.FAST_DIGGING.createEffect(9000*2, 4));
        } if(BoosterActivate.NightVisionBooster) {
            p.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(9000*2, 4));
        } if(BoosterActivate.StrenghtBooster) {
            p.addPotionEffect(PotionEffectType.INCREASE_DAMAGE.createEffect(9000*2, 4));
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        p.removePotionEffect(PotionEffectType.FAST_DIGGING);

        if(BoosterActivate.NightVisionBooster) {
            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
        }
        if(BoosterActivate.StrenghtBooster) {
            p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        }
    }

    @EventHandler
    public void ChangeWorld(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        if(p.getWorld().equals(WorldName)) {
            if (BoosterActivate.FlyBooster) {
                BoosterActivate.FlyPlayer.add(p);
                p.setAllowFlight(true);
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if(BoosterActivate.FlyBooster) {
            BoosterActivate.FlyPlayer.add(p);
            p.setAllowFlight(true);
        }
    }
    @EventHandler
    public void DropBooster(BlockBreakEvent e) {
        if(BoosterActivate.DropBooster) {

            ItemStack tool = e.getPlayer().getInventory().getItemInMainHand();
            Collection<ItemStack> drops = e.getBlock().getDrops(tool);

            Material blockType = e.getBlock().getType();
            String typeName = blockType.name();

            if (typeName.endsWith("_LOG") || typeName.contains("STEM") || typeName.endsWith("_ORE") || typeName.equals("ANCIENT_DEBRIS")) {
                for(ItemStack drop : drops) {
                    drop.setAmount(drop.getAmount());
                    e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(), drop);
                }
            }

        }
    }
    @EventHandler
    public void XPBooster(PlayerExpChangeEvent e) {
        if(BoosterActivate.XPBooster) {
            int doublexp = e.getAmount() * 2;
            e.setAmount(doublexp);
        }
    }
}
