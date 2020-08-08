package de.fruxz.farmengine

import de.fruxz.farmengine.commands.FarmWorldCommand
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldCreator
import org.bukkit.WorldType
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable

class Main : JavaPlugin() {

    companion object {
        @JvmStatic
        var farmworldExists: Boolean = false
    }

    override fun onLoad() {
        super.onLoad()
    }

    override fun onEnable() {
        val farmworldName = "FarmENGINE"

        getCommand("farmworld")!!.setExecutor(FarmWorldCommand())

        if (Bukkit.getWorld(farmworldName) == null) {

            val creator = WorldCreator(farmworldName)

            creator.environment(World.Environment.NORMAL)
            creator.type(WorldType.LARGE_BIOMES)

            Bukkit.getConsoleSender().sendMessage("§8>> §cFarmENGINE is creating farmworld...")

            object : BukkitRunnable() {
                override fun run() {
                    creator.createWorld()
                }
            }.runTask(this)

            Bukkit.getConsoleSender().sendMessage("§8>> §aFarmENGINE world creation finished!")

            farmworldExists = true

        } else
            farmworldExists = true

    }

    override fun onDisable() {
        super.onDisable()
    }

}