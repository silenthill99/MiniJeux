package fr.silenthill99.minijeux.events;

import fr.silenthill99.minijeux.GState;
import fr.silenthill99.minijeux.Main;
import fr.silenthill99.minijeux.tasks.GAutoStart;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener
{

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "[+] " + player.getName());
        Location spawn = new Location(Bukkit.getWorld("world"), -88, 69, -163, 90f, 0f);
        player.teleport(spawn);
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setHealth(20);

        if (!Main.getInstance().isState(GState.WAITING))
        {
            player.setGameMode(GameMode.SPECTATOR);
            player.sendMessage("Le jeu a déjà démarré !");
            return;
        }

        if (!Main.getInstance().getPlayers().contains(player)) Main.getInstance().getPlayers().add(player);
        player.setGameMode(GameMode.ADVENTURE);

        if (Main.getInstance().isState(GState.WAITING) && Main.getInstance().getPlayers().size() == 1)
        {
            GAutoStart start = new GAutoStart();
            start.runTaskTimer(Main.getInstance(), 0, 20);
            Main.getInstance().setState(GState.STARTING);
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[-] " + player.getName());
    }

}
