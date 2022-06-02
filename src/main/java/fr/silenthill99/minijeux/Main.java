package fr.silenthill99.minijeux;

import fr.silenthill99.minijeux.events.Events;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Main extends JavaPlugin
{

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private List<Player> player = new ArrayList<>();
    private GState state;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Le plugin est opérationnel !");
        getServer().getPluginManager().registerEvents(new Events(), this);
        setState(GState.WAITING);

    }

    public void setState(GState state)
    {
        this.state = state;
    }

    public boolean isState(GState state)
    {
        return this.state == state;
    }

    public List<Player> getPlayers() {
        return player;
    }
}
