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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 *
 * @author Hyper
 */
public class Settings {

    private boolean AutoClose;
    private String Theme;
    private String MusicLink;
    private String MusicType;

    public String getMusicType() {
        return MusicType;
    }

    public void setMusicType(String MusicType) {
        this.MusicType = MusicType;
    }

    public boolean isAutoClose() {
        return AutoClose;
    }

    public void setAutoClose(boolean AutoClose) {
        this.AutoClose = AutoClose;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String Theme) {
        this.Theme = Theme;
    }

    public String getMusicLink() {
        return MusicLink;
    }

    public void setMusicLink(String MusicLink) {
        this.MusicLink = MusicLink;
    }

    public void getSettings() {
        Properties Data = new Properties();

        try {
            
            if (!new File("IGI-2 Multiplayer Launcher Files\\IGI-2_Multiplayer_Launcher_v9.6.Launcher").exists()) {
                setTheme("com.alee.laf.WebLookAndFeel");
                setAutoClose(false);
                setMusicLink("Auto");
                return;
            }

            Data.load(new BufferedReader(new FileReader("IGI-2 Multiplayer Launcher Files\\IGI-2_Multiplayer_Launcher_v9.6.Launcher"), 8192));

            setTheme(Data.getProperty("Theme"));
            setMusicLink(Data.getProperty("MusicLink"));
            setMusicType(Data.getProperty("MusicType"));

            if (Data.getProperty("Close").equals("true")) {
                setAutoClose(true);
            } else {
                setAutoClose(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void saveSettings(boolean AutoClose, String Theme, String MusicName, String MusicType) {

        setAutoClose(AutoClose);
        setMusicLink(MusicName);
        setTheme(Theme);
        setMusicType(MusicType);

        String Data = "Close=" + isAutoClose() + "\n"
                + "Theme=" + getTheme() + "\n"
                + "MusicLink=" + getMusicLink() + "\n"
                + "MusicType=" + getMusicType();

        { // Write Settings To File
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                fw = new FileWriter("IGI-2 Multiplayer Launcher Files\\IGI-2_Multiplayer_Launcher_v9.6.Launcher");
                bw = new BufferedWriter(fw);
                bw.write(Data);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
