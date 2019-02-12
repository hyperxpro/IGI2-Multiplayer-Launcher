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

import aayush.atharva.TurboCryptography.Decryption;
import aayush.atharva.TurboCryptography.Encryption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class ServerConnector {

    private String Packet;

    public ServerConnector(String Packet) {
        this.Packet = Packet;
    }

    public String Server() {

        Socket socket = null;
        BufferedReader getData = null;
        PrintWriter sendData = null;

        try {

            socket = new Socket(Main.MASTERSERVERURL, Main.MASTERSERVERPORT);

            getData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendData = new PrintWriter(socket.getOutputStream(), true);

            sendData.println(new Encryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, getPacketData()).Encrypt());

            String Response = new Decryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, getData.readLine()).Decrypt();

            return Response;

        } catch (java.net.ConnectException ex) {
            JOptionPane.showMessageDialog(null, "Server Didn't Accepted Our Connection\nPlease Try Again", "Connecton Not Accepted", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (java.net.SocketException ex) {
            JOptionPane.showMessageDialog(null, "Server Closed Connection Unexpectedly", "Connection Closed", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (java.net.UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Connect To Master Server\nPlease Check Your Internet Connection", "Server Not Reachable", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "A Fatal Error Occured\nPlease Try Again", "Fatal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // Catching Exception Optional
                }
            }

            if (getData != null) {
                try {
                    getData.close();
                } catch (IOException ex) {
                    // Catching Exception Optional
                }
            }

            if (sendData != null) {
                sendData.close();
            }
        }

        return null;
    }

    private String getPacketData() {
        return Packet;
    }
}
