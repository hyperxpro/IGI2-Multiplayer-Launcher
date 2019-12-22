
package aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps;

import java.io.File;

import launcher.Main;

public class factory {

    public static void main() {
        File factory1 = new File(Main.factory1);
        factory1.delete();

        File factory2 = new File(Main.factory2);
        factory2.delete();
    }
}
