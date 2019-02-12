/*
 * IGI-2 Multiplayer Launcher
 * ________________________________________
 * End-User License Agreement ("Agreement")
 *
 * Last updated: 12-February-2019
 *
 * Please read this End-User License Agreement ("Agreement") carefully before clicking the "I Agree" button, downloading or using IGI-2 Multiplayer Launcher ("Application").
 *
 * By clicking the "I Agree" button, downloading or using the Application, you are agreeing to be bound by the terms and conditions of this Agreement.
 *
 * If you do not agree to the terms of this Agreement, do not click on the "I Agree" button and do not download or use the Application.
 *
 * License
 *
 * Aayush Atharva grants you a revocable, non-exclusive, non-transferable, limited license to download, install, modify and use the Application solely for your personal, non-commercial purposes strictly in accordance with the terms of this Agreement. 
 *
 * Restrictions
 *
 * You agree not to, and you will not permit others to:
 *
 * a) license, sell, rent, lease, assign, distribute, transmit, host, outsource, disclose or otherwise commercially exploit the Application or make the Application available to any third party.
 *
 *
 * Modifications to Application
 *
 * Aayush Atharva reserves the right to modify, suspend or discontinue, temporarily or permanently, the Application or any service to which it connects, with or without notice and without liability to you.
 *
 *
 * Term and Termination
 *
 * This Agreement shall remain in effect until terminated by you or Aayush Atharva.
 *
 * Aayush Atharva may, in its sole discretion, at any time and for any or no reason, suspend or terminate this Agreement with or without prior notice.
 *
 * This Agreement will terminate immediately, without prior notice from Aayush Atharva, in the event that you fail to comply with any provision of this Agreement. You may also terminate this Agreement by deleting the Application and all copies thereof from any device where itÃ¢â‚¬â„¢s stored.
 *
 * Upon termination of this Agreement, you shall cease all use of the Application and delete all copies of the Application from any device where itÃ¢â‚¬â„¢s stored.
 *
 * Severability
 *
 * If any provision of this Agreement is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.
 *
 * Amendments to this Agreement
 *
 * Aayush Atharva reserves the right, at its sole discretion, to modify or replace this Agreement at any time. If a revision is material I will provide at least 7 days notice prior to any new terms taking effect. What constitutes a material change will be determined at our sole discretion.
 *
 * Contact Information
 *
 * If you have any questions about this Agreement, please contact me.
 *
 *
 * Aayush Atharva
 * Email: aayush@aayushatharva.com
 */
package launcher;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static launcher.Main.lista;
import static launcher.Main.oldList;
import static launcher.Main.update;
import static launcher.Main.updateServerList;

public class FetchServers extends Thread {

    @Override
    public void run() {
        try {
            boolean var = false;
            Server pom = null;
            oldList = new ArrayList();
            update = 0;
            List<String> ipList;
            ipList = Web.getServerList();
            lista = new ArrayList();
            Server s = null;
            for (String ips : ipList) {
                var = false;
                if (!oldList.isEmpty()) {
                    for (Server el : oldList) {
                        if (el.ips.equals(ips)) {
                            pom = el;
                            var = true;
                            break;
                        }
                    }
                }

                if (!var) {
                    s = new Server(ips);
                } else {
                    s = new Server(pom);
                }

                s.start();

            }

            while (update < ipList.size()) {
                Thread.sleep(10L);
            }

            updateServerList();
            oldList = lista;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable To Fetch Server. Please Check Your Internet And Try Again\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 135", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
