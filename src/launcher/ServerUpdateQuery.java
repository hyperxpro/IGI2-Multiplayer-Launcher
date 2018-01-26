package launcher;

/**
 *
 * @author Hyper
 */
public class ServerUpdateQuery extends Thread {

    @Override
    public void run() {
        while (true) {
            Main.ServerUpdateQuery = 0;
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
            }
        }
    }
}
