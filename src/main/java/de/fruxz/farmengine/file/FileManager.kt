package de.fruxz.farmengine.file

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.FileNotFoundException
import kotlin.ClassCastException

class FileManager(val path: String) : ConfigurationFile {

    val file = File("plugins/FarmENGINE", path)
    val loader = YamlConfiguration.loadConfiguration(file)

    override fun load() {
        try {
            loader.load(file)
        } catch (e: FileNotFoundException) {
            loader.set("installed", true)
            save()
        }
    }

    override fun save() {
        loader.save(file)
    }

    override fun set(path: String, v: Any?) {
        load()
        loader.set(path, v)
        save()
    }

    fun <T> get(path: String, fallback: T?): T? {
        load()

        @Suppress("UNCHECKED_CAST")
        (return try {
            loader.get(path) as T?
        } catch (e: ClassCastException) {
            fallback
        })
    }

    override fun <T> get(path: String): T? {
        return get(path, null)
    }

    fun <T> getList(path: String, fallback: List<T?>?): List<T?>? {
        load()

        @Suppress("UNCHECKED_CAST")
        (return try {
            loader.getList(path) as List<T?>?
        } catch (e: ClassCastException) {
            fallback
        })
    }

    override fun <T> getList(path: String): List<T?>? {
        return getList(path, emptyList())
    }


}