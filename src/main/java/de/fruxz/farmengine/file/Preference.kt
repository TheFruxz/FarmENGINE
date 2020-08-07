package de.fruxz.farmengine.file

class Preference<T>(val file: FileManager, val path: String, val default: T?) {

    companion object {
        @JvmStatic
        val cache = HashMap<String, Any?>()
    }

    val superpath = "${file.path}::$path"

    var content: T?
        get() {
            if (!cache.containsKey(superpath)) {

                if (file.loader.contains(path)) {

                    @Suppress("UNCHECKED_CAST")
                    (return try {

                        file.loader.get(path) as T?

                    } catch (e: ClassCastException) {
                        content = default
                        default
                    })

                } else {
                    content = default
                    return default
                }

            } else {
                @Suppress("UNCHECKED_CAST")
                (return try {
                    cache[superpath] as T?
                } catch (e: ClassCastException) {
                    cache[superpath] = default
                    default
                })
            }
        }
        set(value) {
            cache[superpath] = value
            file.set(path, value)
        }

}