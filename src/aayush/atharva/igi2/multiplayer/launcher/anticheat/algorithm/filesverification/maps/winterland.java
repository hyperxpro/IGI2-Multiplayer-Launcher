package aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps;

import java.io.File;

import launcher.Main;

public class winterland {

    public static void main() {
        File winterland1 = new File(Main.winterland1);
        winterland1.delete();

        File winterland2 = new File(Main.winterland2);
        winterland2.delete();
    }
}
