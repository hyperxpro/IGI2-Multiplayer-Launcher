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
import aayush.atharva.igi2.multiplayer.launcher.authentication.SignIn_GUI;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class StartUpProcess {

    static Startup_Loading Loading;

    public StartUpProcess() {
        Loading = new Startup_Loading();
    }

    private static void setLoadingProcess(String process, String title) {
        Loading.setProcess(DateTimeLocal() + " " + process);
        Loading.setProcessTitle(title);
    }

    private static String DateTimeLocal() {
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss dd-MMM-yyyy]");
        return sdf.format(new Date());
    }


    public static String Maintenance;
    public static String Message;
    public static String SupportOver;
    public static String LatestVersion;
    public static String DownloadLink;
    public static String YoutubeMusicLink;
    public static String SystemInfo;


   

    public void Process() throws NoSuchAlgorithmException, NoSuchPaddingException {
        try {

            if (!new File("IGI-2 Multiplayer Launcher Files").exists()) {
                new File("IGI-2 Multiplayer Launcher Files").mkdir();
            }

            setLoadingProcess("Connection To Server...", "Starting IGI-2 Multiplayer Launcher");

            // Launcher Data Status
            StringBuilder sb = new StringBuilder();

            URLConnection connection = new URL("https://api-igi2.igi2.co.in/launcher/v9.6.1/Data.LAUNCHER").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/58.0.1271.95 Safari/537.11");
            connection.connect();

            setLoadingProcess("Connected To Server...", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Fetching Data...", "Starting IGI-2 Multiplayer Launcher");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();

            String OriginalPassword = new Decryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, sb.toString()).Decrypt();

            setLoadingProcess("Loading Data...", "Starting IGI-2 Multiplayer Launcher");

            Properties prop = new Properties();
            InputStream input = new ByteArrayInputStream(OriginalPassword.getBytes(StandardCharsets.UTF_8.name()));
            prop.load(input);

            setLoadingProcess("Processing Data...", "Starting IGI-2 Multiplayer Launcher");

            Maintenance = prop.getProperty("Maintenance");
            Message = prop.getProperty("Message");
            SupportOver = prop.getProperty("SupportOver");
            LatestVersion = prop.getProperty("LatestVersion");
            DownloadLink = prop.getProperty("DownloadLink");

            // Maintenance
            if (!Maintenance.equals("None")) {
                JOptionPane.showMessageDialog(null, "IGI-2 Multiplayer Launcher Is Under Maintenance.\nPlease try again after " + Maintenance + ".\nThank You!", "Maintaince Break", 1);
                System.exit(0);
            }

            // Message
            if (!Message.equals("None")) {
                JOptionPane.showMessageDialog(null, Message, "Message!", JOptionPane.INFORMATION_MESSAGE);
            }

            // Update Check
            {
                if (!LatestVersion.equals("9.6.1")) {
                    int choice = -2;

                    String[] options = {"Yes", "No", "Cancel"};
                    choice = JOptionPane.showOptionDialog(null, "IGI-2 Multiplayer Launcher " + LatestVersion + " Is Available To Be Downloaded!\nWould You Like To Download?", "Updates Are Available", 0,
                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    switch (choice) {
                        case 0:
                            Desktop.getDesktop().browse(new URL(DownloadLink).toURI());
                            break;
                        case 1:

                            break;
                        default:
                            choice = -1;
                            break;
                    }
                }
            }

            // Support Over Check
            if (SupportOver.equals("Yes")) {
                javax.swing.JOptionPane.showMessageDialog(null, "IGI-2 Multiplayer Launcher v9.6 Support Is Over!\nPlease Update To IGI-2 Multiplayer Launcher v" + LatestVersion, "IGI-2 Multiplayer Launcher v9.6 Support Over!", 1);

                int choice = -2;

                String[] options = {"Yes", "No", "Cancel"};
                choice = JOptionPane.showOptionDialog(null, "IGI-2 Multiplayer Launcher " + LatestVersion + " Is Available To Be Downloaded!\nWould You Like To Download?", "Updates Are Available", 0,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                switch (choice) {
                    case 0:
                        Desktop.getDesktop().browse(new URL(DownloadLink).toURI());
                        break;
                    case 1:

                        break;
                    default:
                        choice = -1;
                        break;
                }

                System.exit(0);
            }

            setLoadingProcess("Processing System Data... [1/12]", "Starting IGI-2 Multiplayer Launcher");
        
            setLoadingProcess("Processing System Data... [2/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [3/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [4/12]", "Starting IGI-2 Multiplayer Launcher");
            setLoadingProcess("Processing System Data... [5/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [6/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [7/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [8/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [9/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [10/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [11/12]", "Starting IGI-2 Multiplayer Launcher");

            setLoadingProcess("Processing System Data... [12/12]", "Starting IGI-2 Multiplayer Launcher");

            new SignIn_GUI();
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Start Launcher. Please Reinstall IGI-2 Multiplayer Essentials.\n Contact Support at: \"aayush@igi2.co.in\" for further help.", "Error 132", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Open Browser For Downloading New Updates.\n Contact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Launcher End-Point Error While Fetching Data At Startup Checks\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Checksum Failure", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (Exception ex) {
        }

        Loading.dispose();

    }

}
