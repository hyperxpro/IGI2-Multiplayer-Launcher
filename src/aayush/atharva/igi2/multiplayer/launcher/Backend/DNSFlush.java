package aayush.atharva.igi2.multiplayer.launcher.Backend;

import java.io.IOException;
import javax.swing.JOptionPane;

public class DNSFlush {

    public static void flush() {

        try {
            Runtime.getRuntime().exec("ipconfig -flushdns");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Flush DNS Cache For Clearing Old DNS Cache\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 127", JOptionPane.ERROR_MESSAGE);
        }

    }
}
