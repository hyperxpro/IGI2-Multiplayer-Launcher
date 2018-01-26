package aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps;

import java.io.File;

import launcher.Main;

public class priboivilla {

    public static void main() {
        File PriboiVilla1 = new File(Main.PriboiVilla1);
        PriboiVilla1.delete();

        File PriboiVilla2 = new File(Main.PriboiVilla2);
        PriboiVilla2.delete();

    }
}
