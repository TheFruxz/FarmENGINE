package de.fruxz.farmengine.file

interface ConfigurationFile {

    fun load()
    fun save()

    fun set(path: String, v: Any?)

    fun <T> get(path: String): T?
    fun <T> getList(path: String): List<T?>?

}