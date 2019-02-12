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
package aayush.atharva.igi2.multiplayer.launcher.authentication;

import aayush.atharva.TurboCryptography.Decryption;
import aayush.atharva.TurboCryptography.Encryption;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.JOptionPane;
import launcher.Main;

public class Remember_Login_Credentials {

    private String UserName_Email;
    private String Password;

    public Remember_Login_Credentials(String UserName_Email, String Password) {
        this.UserName_Email = UserName_Email;
        this.Password = Password;
    }

    public Remember_Login_Credentials() {
    }

    public void Save_Login() {

        try {
            String Data = new Encryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, "Username_Email=" + getUserName_Email() + "\n" + "Password=" + getPassword()).Encrypt();

            if (new File(Main.Remember_Login_Data_File).exists()) {
                FileOutputStream flusher = new FileOutputStream(Main.Remember_Login_Data_File);
                flusher.write(("").getBytes());
                flusher.close();
            }

            WriteDataToFile(Data);
        } catch (Exception ex) {
        }

    }

    public String RestoreLogin() throws UnsupportedEncodingException, IOException {

        if (!new File(Main.Remember_Login_Data_File).exists()) {
            return null;
        }

        String FileData = ReadDataToFile();

        if (FileData != null) {
            String aData = null;
            try {
                aData = new Decryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, FileData).Decrypt();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unable To Restore Login Credentials\nDatabase File Corrupted", "Error", JOptionPane.ERROR_MESSAGE);
                new File(Main.Remember_Login_Data_File).delete();
            }

            Properties Data = new Properties();
            InputStream input = new ByteArrayInputStream(aData.getBytes(StandardCharsets.UTF_8.name()));
            Data.load(input);

            return "Username_Email=" + Data.getProperty("Username_Email") + "\n" + "Password=" + Data.getProperty("Password");

        }

        return null;
    }

    private String ReadDataToFile() {
        try {

            Scanner scanner = new Scanner(new BufferedReader(new FileReader(Main.Remember_Login_Data_File), 8120));
            StringBuilder FileData = new StringBuilder();

            while (scanner.hasNextLine()) {
                FileData.append(scanner.nextLine());
            }

            scanner.close();

            if (FileData.toString().isEmpty()) {
                return null;
            }

            return FileData.toString();

        } catch (Exception ex) {
        }
        return null;
    }

    private void WriteDataToFile(String Data) throws IOException {
        FileWriter writer = new FileWriter(Main.Remember_Login_Data_File, true);
        writer.write(Data);
        writer.write("\r\n");
        writer.close();
    }

    private String getUserName_Email() {
        return UserName_Email;
    }

    private String getPassword() {
        return Password;
    }
}
