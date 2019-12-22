
package launcher;

/**
 *
 * @author Hyper
 */
public class ServerListQueryController extends Thread {

    @Override
    public void run() {
        while (true) {
            Main.ServerListQuery = 0;
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
