package de.fruxz.farmengine.commands

import de.fruxz.farmengine.messaging.Transmission
import de.fruxz.farmengine.utils.FarmWorldUtils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FarmWorldCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender is Player) {

            sender.teleport(FarmWorldUtils().getPlayersSpawn(sender))

            Transmission("§aSuccessfully teleported to the farmworld!").send(sender)

        } else
            Transmission("§cOnly for players!").sendConsole()

        return true
    }

}