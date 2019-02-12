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

import aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.*;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.*;
import static aayush.atharva.igi2.multiplayer.launcher.authentication.Sign_In.MP_Name;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.swing.JOptionPane;
import static launcher.Main.GameFileString4;
import static launcher.Main_PlayersGUI.isServerJoinButtonPressed;

/**
 *
 * @author Hyper
 */
public class Join extends Thread {

    private String IP;
    private String PORT;
    private String ID;
    private String ServerName;

    public Join(String IP, String PORT, String ID, String ServerName) {
        this.IP = IP;
        this.PORT = PORT;
        this.ID = ID;
        this.ServerName = ServerName;
    }

    @Override
    public void run() {

        AntiCheat.anticheat();

        isServerJoinButtonPressed = true; // Disable Join Button

        // Check Files Hashes And Verify Anti-Cheat
        if (BridgeDentsr1.equals(BridgeDentsrSHA_1) && BridgeDentsr2.equals(BridgeDentsrSHA_2) && chinesetemple1.equals(chinesetempleSHA_1) && chinesetemple2.equals(chinesetempleSHA_2)
                && dockbeta1.equals(dockbetaSHA_1) && dockbeta2.equals(dockbetaSHA_2) && dockside1.equals(docksideSHA_1) && dockside2.equals(docksideSHA_2) && factory1.equals(factorySHA_1)
                && factory2.equals(factorySHA_2) && forestraid1.equals(forestraidSHA_1) && forestraid2.equals(forestraidSHA_2) && JungleX1.equals(JungleXSHA_1) && JungleX2.equals(JungleXSHA_2)
                && libyanvillage1.equals(libyanvillageSHA_1) && libyanvillage2.equals(libyanvillageSHA_2) && PriboiVilla1.equals(PriboiVillaSHA_1) && PriboiVilla2.equals(PriboiVillaSHA_2)
                && redstone1.equals(redstoneSHA_1) && redstone2.equals(redstoneSHA_2) && sandstorm1.equals(sandstormSHA_1) && sandstorm2.equals(sandstormSHA_2)
                && SnowstormX1.equals(SnowstormXSHA_1) && SnowstormX2.equals(SnowstormXSHA_2) && timberland1.equals(timberlandSHA_1) && timberland2.equals(timberlandSHA_2)
                && winterland1.equals(winterlandSHA_1) && winterland2.equals(winterlandSHA_2) && IslandAssault1.equals(I_ASHA_1) && IslandAssault2.equals(I_ASHA_2) && prisonescape1.equals(prisonescapeSHA_1)
                && prisonescape2.equals(prisonescapeSHA_2) && dockland1.equals(docklandsSHA_1) && dockland2.equals(docklandsSHA_2) && igi2_game_SHA_1.equals(igi2_game_SHA_2) && Weapons_Ammo_SHA.equals(Weapons_Ammo_Hash)
                && Weapons_wqvm_SHA.equals(Weapons_wqvm_Hash) && Weapons_wres_SHA.equals(Weapons_wres_Hash) && Humanplayer_SHA.equals(Humanplayer_Hash)) {

            InputStream input = null;

            try {

                String JoinerID = getID();

                String JoinData = "Query=Join_Server" + "\n"
                        + "ServerIP=" + getIP() + "\n"
                        + "ServerPORT=" + getPORT() + "\n"
                        + "JoinerID=" + JoinerID + "\n"
                        + "MP_Name=" + MP_Name + "\n"
                        + "Identity=" + Main.UserIdentity;

                String Response = new ServerConnector(JoinData).Server();

                // Load Data To Properties
                Properties ResponseData = new Properties();
                input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
                ResponseData.load(input);

                if (ResponseData.getProperty("Response").equals("In_Queue")) {
                    Queue_GUI queue_GUI = new Queue_GUI(getServerName());

                    String QueueNumber = ResponseData.getProperty("QueueNumber"); // Load Queue Number

                    queue_GUI.setStatus("You Are Currently In Queue. You Will Be Connected To Server Automatically.", "Your Position In Queue: " + QueueNumber); // Set Status Of Queue

                    // Wait Until Queue Becomes Zero
                    do {
                        Response = new ServerConnector(JoinData).Server();
                        input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
                        ResponseData.load(input);
                        QueueNumber = ResponseData.getProperty("QueueNumber");
                        queue_GUI.setStatus("You Are Currently In Queue. You Will Be Connected To Server Automatically.", "Your Position In Queue: " + QueueNumber); // Set Status Of Queue
                        sleep(1000);
                    } while (Integer.parseInt(QueueNumber) > 0); // Wait Until Queue Becomes Zero

                    // Load Password
                    String Password = ResponseData.getProperty("ServerPassword");

                    // Start Join Beacon Sender
                    Main.JoinBeaconSender = true;
                    new JoinBeacon(JoinData).start(); // Start Joining Server Beacon

                    queue_GUI.setStatus("Joining Server...", ""); // Set Status To Joining Server

                    sleep(2500); // Wait 2 Seconds For Server Password To Settle

                    // Check Files Hashes And Verify Anti-Cheat
                    if (BridgeDentsr1.equals(BridgeDentsrSHA_1) && BridgeDentsr2.equals(BridgeDentsrSHA_2) && chinesetemple1.equals(chinesetempleSHA_1) && chinesetemple2.equals(chinesetempleSHA_2)
                            && dockbeta1.equals(dockbetaSHA_1) && dockbeta2.equals(dockbetaSHA_2) && dockside1.equals(docksideSHA_1) && dockside2.equals(docksideSHA_2) && factory1.equals(factorySHA_1)
                            && factory2.equals(factorySHA_2) && forestraid1.equals(forestraidSHA_1) && forestraid2.equals(forestraidSHA_2) && JungleX1.equals(JungleXSHA_1) && JungleX2.equals(JungleXSHA_2)
                            && libyanvillage1.equals(libyanvillageSHA_1) && libyanvillage2.equals(libyanvillageSHA_2) && PriboiVilla1.equals(PriboiVillaSHA_1) && PriboiVilla2.equals(PriboiVillaSHA_2)
                            && redstone1.equals(redstoneSHA_1) && redstone2.equals(redstoneSHA_2) && sandstorm1.equals(sandstormSHA_1) && sandstorm2.equals(sandstormSHA_2)
                            && SnowstormX1.equals(SnowstormXSHA_1) && SnowstormX2.equals(SnowstormXSHA_2) && timberland1.equals(timberlandSHA_1) && timberland2.equals(timberlandSHA_2)
                            && winterland1.equals(winterlandSHA_1) && winterland2.equals(winterlandSHA_2) && IslandAssault1.equals(I_ASHA_1) && IslandAssault2.equals(I_ASHA_2) && prisonescape1.equals(prisonescapeSHA_1)
                            && prisonescape2.equals(prisonescapeSHA_2) && dockland1.equals(docklandsSHA_1) && dockland2.equals(docklandsSHA_2) && igi2_game_SHA_1.equals(igi2_game_SHA_2) && Weapons_Ammo_SHA.equals(Weapons_Ammo_Hash)
                            && Weapons_wqvm_SHA.equals(Weapons_wqvm_Hash) && Weapons_wres_SHA.equals(Weapons_wres_Hash) && Humanplayer_SHA.equals(Humanplayer_Hash)) {

                        try {
                            Runtime.getRuntime().exec(Main.GameFile + " " + "$9" + getIP() + " " + "#JZ@" + getPORT() + " @#ZM9#\"" + MP_Name + "\" " + GameFileString4 + "" + Password);
                        } catch (IOException ex) {
                            Main.JoinBeaconSender = false;
                            isServerJoinButtonPressed = false;
                            queue_GUI.dispose();
                            JOptionPane.showMessageDialog(null, "Unable To Launch Game! This Can Happen When Launcher is unable to access 'igi2_game.exe' file.\nThis Can Happen Which Something Is Restricting Launcher From accessing 'igi2_game.exe' file.\nPut 'igi2_game.exe' File In Your Anti-Virus Exception or Whitelist and Try running Launcher as Administrator.\nIf Problem Still Persists, Contact Support at: aayush@igi2.co.in for further help.");
                            System.exit(1);
                        }

                    } else {
                        AntiCheat.anticheat();
                        JOptionPane.showMessageDialog(null, "You're Using Cheat Or Hack For IGI-2 Multiplayer. Remove Cheat Or Hack To Play", "Cheat / Hack Detected!", JOptionPane.ERROR_MESSAGE);
                    }

                    new AntiCheatBeacon(getIP(), getPORT(), MP_Name, JoinerID).start(); // Confirm Anti-Cheat
                    Thread.sleep(20000); // Wait 20 Seconds
                    Main.JoinBeaconSender = false; // Stop Joining Beacon
                    queue_GUI.dispose(); // Close Queue Window
                    isServerJoinButtonPressed = false; // Enable Button

                } else {
                    Main.JoinBeaconSender = false;
                    isServerJoinButtonPressed = false;
                    JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            } catch (IOException ex) {
            } catch (InterruptedException ex) {
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }
                } catch (IOException ex) {
                    // Ignore
                }
            }
        } else {
            AntiCheat.anticheat();
            isServerJoinButtonPressed = false;
            JOptionPane.showMessageDialog(null, "You're Using Cheat Or Hack For IGI-2 Multiplayer. Remove Cheat Or Hack To Play", "Cheat / Hack Detected!", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getIP() {
        return IP;
    }

    private String getPORT() {
        return PORT;
    }

    private String getID() {
        return ID;
    }

    private String getServerName() {
        return ServerName;
    }

}
