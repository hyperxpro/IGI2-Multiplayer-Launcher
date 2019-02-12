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

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class Check_Loader {

    public static void check() {
        try {
            File file = new File("IGI-2 Multiplayer Launcher Files\\res\\Launcher.2.Launcher");
            StringBuffer hexString;

            if (file.exists()) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                {
                    FileInputStream fis = new FileInputStream(file);

                    byte[] dataBytes = new byte[1024];

                    int nread = 0;
                    while ((nread = fis.read(dataBytes)) != -1) {
                        md.update(dataBytes, 0, nread);
                    };
                    byte[] mdbytes = md.digest();

                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
                    }

                    hexString = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
                    }
                }

                if (!hexString.toString().equals("f4c3ca2af99a169875b13333da9391320e6b3488377d3cc966afdf4315facf")) {
                    JOptionPane.showMessageDialog(null, "Image Loader Files Are Corrupted. Please Reinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Image Loader Files Not Found. Please Reinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Show Detailed Error.\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 134", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Read Image Loader File.\nMake Sure Launcher Have Enough Rights To Access Image Loader Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Algorithm On Image Loader Files.\nMake Sure Launcher Have Enough Rights To Access Image Loader Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
