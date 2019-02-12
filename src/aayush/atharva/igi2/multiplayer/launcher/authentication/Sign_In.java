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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.swing.JOptionPane;
import launcher.Main;
import static launcher.Main.UserIdentity;
import launcher.ServerConnector;

public class Sign_In {

    public static String MP_Name;

    private String Username_Email;
    private String Password;

    public Sign_In(String Username_Email, String Password) {
        this.Username_Email = Username_Email;
        this.Password = Password;
    }

    public void SignIn() throws Exception {

        String Email_Username = getUsername_Email();
        String UserPassword = getPassword();

        if (Email_Username.contains("@")) { // Email

            String SignerID = generateSignInID();
            String SignInData = "Query=SignIn" + "\n"
                    + "AuthHeader=Email" + "\n"
                    + "Email=" + Email_Username + "\n"
                    + "Password=" + UserPassword + "\n"
                    + "SignerID=" + SignerID;

            String Response = new ServerConnector(SignInData).Server();

            Properties Data = new Properties();
            InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
            Data.load(input);

            if (Data.getProperty("Response").equals("No Account Exist With The Email Address You Entered")) {
                JOptionPane.showMessageDialog(null, "No Account Exists With The Email Which You've Entered.\nPlease Enter A Valid Email", "Wrong Email", JOptionPane.ERROR_MESSAGE);
            } else if (Data.getProperty("Response").equals("Session Authenticated") && Data.getProperty("SignerID").equals(SignerID)) {
                MP_Name = Data.getProperty("MP_Name");
                UserIdentity = Email_Username;
                Main.Authentication_Check = "Yes Autheneitcated, Authentication Completed...";
            } else if (Data.getProperty("Response").equals("Wrong Password")) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Password.", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, Data.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }

        } else { // Username
            String SignerID = generateSignInID();
            String SignInData = "Query=SignIn" + "\n"
                    + "AuthHeader=Username" + "\n"
                    + "Username=" + Email_Username + "\n"
                    + "Password=" + UserPassword + "\n"
                    + "SignerID=" + SignerID;

            String Reponse = new ServerConnector(SignInData).Server();

            Properties Data = new Properties();
            InputStream input = new ByteArrayInputStream(Reponse.getBytes(StandardCharsets.UTF_8.name()));
            Data.load(input);

            if (Data.getProperty("Response").equals("No Account Exist With The Username You Entered")) {
                JOptionPane.showMessageDialog(null, "No Account Exists With The Username Which You've Entered.\nPlease Enter A Valid Username", "Wrong Username", JOptionPane.ERROR_MESSAGE);
            } else if (Data.getProperty("Response").equals("Session Authenticated") && Data.getProperty("SignerID").equals(SignerID)) {
                MP_Name = Data.getProperty("MP_Name");
                UserIdentity = Email_Username;
                Main.Authentication_Check = "Yes Autheneitcated, Authentication Completed...";
            } else if (Data.getProperty("Response").equals("Wrong Password")) {
                JOptionPane.showMessageDialog(null, "Please Enter Correct Password.", "Incorrect Password", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, Data.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public String getUsername_Email() {
        return Username_Email;
    }

    public String getPassword() {
        return Password;
    }

    public String DateTimeLocal() {
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm:ss dd-MMM-yyyy]");
        return sdf.format(new Date());
    }

    public String generateSignInID() {
        return generateRandomChars("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 20);
    }

    // Generate Random Code
    public String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i = i + 1) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
        }
        return sb.toString();
    }
}
