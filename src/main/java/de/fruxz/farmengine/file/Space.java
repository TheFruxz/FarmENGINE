package de.fruxz.farmengine.file;

public class Space {

    public static final FileManager config = new FileManager("config.yml");

    public static final Preference<String> farmworld = new Preference<String>(config, "farmworld-name", null);

}
