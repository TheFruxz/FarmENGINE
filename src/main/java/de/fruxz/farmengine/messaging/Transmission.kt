package de.fruxz.farmengine.messaging

import org.bukkit.Bukkit
import org.bukkit.command.CommandSender

class Transmission(val raw: String) {

    val tagged = "§bFarmENGINE §8>> §7$raw"

    fun send(target: CommandSender) {
        target.sendMessage(tagged)
    }

    fun broadcast() {
        Bukkit.broadcastMessage(tagged)
    }

    fun sendConsole() {
        Bukkit.getConsoleSender().sendMessage(tagged)
    }

}