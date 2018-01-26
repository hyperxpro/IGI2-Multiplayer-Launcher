package aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps;

import java.io.File;

import launcher.Main;

public class redstone {

    public static void main() {

        File redstone1 = new File(Main.redstone1);
        redstone1.delete();

        File redstone2 = new File(Main.redstone2);
        redstone2.delete();
    }

}
