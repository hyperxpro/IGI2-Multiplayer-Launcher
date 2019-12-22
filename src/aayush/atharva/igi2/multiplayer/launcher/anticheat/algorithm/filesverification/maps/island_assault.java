
package aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps;

import java.io.File;
import launcher.Main;

public class island_assault {
    
     public static void main() {
        File forestraid1 = new File(Main.IslandAssault1);
        forestraid1.delete();

        File forestraid2 = new File(Main.IslandAssault2);
        forestraid2.delete();
    }
    
}
