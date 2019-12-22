
package launcher;

/**
 *
 * @author Hyper
 */
public class JoinBeacon extends Thread {

    private String Data;

    public JoinBeacon(String PacketData) {
        this.Data = PacketData;
    }

    @Override
    public void run() {
        while (Main.JoinBeaconSender) {

            if (!Main.JoinBeaconSender) {
                return;
            }

            new ServerConnector(getData() + "\n" + "Status=KeepConnectionAlive_JoiningServer").Server();

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                // Ignore
            }
        }
    }

    private String getData() {
        return Data;
    }

}
