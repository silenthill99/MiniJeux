package fr.silenthill99.minijeux.tasks;

import fr.silenthill99.minijeux.GState;
import fr.silenthill99.minijeux.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GAutoStart extends BukkitRunnable
{

    private int timer = 20;

    @Override
    public void run()
    {

        for (Player pls : Main.getInstance().getPlayers())
        {
            pls.setLevel(timer);
        }

        if (timer == 0)
        {
            Bukkit.broadcastMessage("Lancement du jeu");
            Main.getInstance().setState(GState.PLAYING);
            cancel();
        }

        timer--;
    }
}
