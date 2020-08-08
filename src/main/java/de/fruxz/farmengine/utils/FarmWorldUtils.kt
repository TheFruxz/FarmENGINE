package de.fruxz.farmengine.utils

import de.fruxz.farmengine.Main
import de.fruxz.farmengine.file.FileManager
import de.fruxz.farmengine.file.Preference
import org.bukkit.Bukkit
import org.bukkit.HeightMap
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import kotlin.random.Random

class FarmWorldUtils {

    val exists = Main.farmworldExists
    val farmworldName = "FarmENGINE"
    val farmworld = if (exists) {

        Bukkit.getWorld(farmworldName)

    } else null

    val playerSpawnData = FileManager("playerSpawns.data")


    fun getPlayersSpawn(player: OfflinePlayer): Location {

        val location = Preference(
                playerSpawnData,
                "${player.uniqueId}",
                farmworld?.getHighestBlockAt(Random.nextInt(-1000000, 1000000), Random.nextInt(-1000000, 1000000))!!.location.add(0.5, 1.0, 0.5)
        )

        return location.content ?: farmworld.spawnLocation

    }

}