package aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem;

import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.*;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JOptionPane;

public class AntiCheat {

    public static void anticheat() {

        try {

            File anticheatzip = new File("X.Launcher");
            if (anticheatzip.exists()) {

                // Process Anti-Cheat
                Execute();

            } else {

                // Put Notification of Process of Download
                JOptionPane.showMessageDialog(null, "\"X.Launcher\" File Not Found\nDownloading Of \"X.Launcher\" File Will Get Started Now.\nSize: 2.4 MB");

                // Download X.Launcher
                DownloadXLauncher();

                // Process Anti-Cheat
                Execute();

            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Fatal Error Occured\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 103 | Fatal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
