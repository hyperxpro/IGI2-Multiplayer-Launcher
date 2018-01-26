package aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps;

import java.io.File;

import launcher.Main;

public class sandstorm {

    public static void main() {
        File sandstorm1 = new File(Main.sandstorm1);
        sandstorm1.delete();

        File sandstorm2 = new File(Main.sandstorm2);
        sandstorm2.delete();

    }

}
