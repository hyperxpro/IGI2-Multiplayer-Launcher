package launcher;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdatePlayers extends Thread {

    Main_PlayersGUI Player_GUI;

    public UpdatePlayers(Main_PlayersGUI GUI) {
        this.Player_GUI = GUI;
    }

    @Override
    public void run() {
        try {
            this.Player_GUI.updateTable();
        } catch (IOException ex) {
            Logger.getLogger(UpdatePlayers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
