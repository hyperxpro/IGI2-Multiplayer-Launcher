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
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.swing.JOptionPane;
import launcher.ServerConnector;

/**
 *
 * @author Hyper
 */
public class SignUp {

    private String Name;
    private String MP_Name;
    private String Email;
    private String Username;
    private String Password;
    private String OSName;
    private String PCName;

    public SignUp(String Name, String MP_Name, String Email, String Username, String Password, String OSName, String PCName) {
        this.Name = Name;
        this.MP_Name = MP_Name;
        this.Email = Email;
        this.Username = Username;
        this.Password = Password;
        this.OSName = OSName;
        this.PCName = PCName;
    }

    public void SignUp() throws UnsupportedEncodingException, IOException {

        String Data = "Query=Sign_Up" + "\n"
                + "Name=" + getName() + "\n"
                + "Username=" + getUsername() + "\n"
                + "MP_Name=" + getMP_Name() + "\n"
                + "Email=" + getEmail() + "\n"
                + "Password=" + getPassword() + "\n"
                + "OSName=" + getOSName() + "\n"
                + "PCName=" + getPCName();

        String Response = new ServerConnector(Data).Server();

        Properties ResponseData = new Properties();
        InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
        ResponseData.load(input);

        if (ResponseData.getProperty("Response").equals("Continue_Verification_New_Account") || ResponseData.getProperty("Response").contains("Verification Code Already Sent To Your Email")) {

            String Code = null;

            if (ResponseData.getProperty("Response").contains("Verification Code Already Sent To Your Email")) {
                JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
                Code = JOptionPane.showInputDialog(null, "A verification code has been already sent your Email.\nCheck Spam Folder of your Email if you don't find the code in Inbox.\nPlease enter the code.", "Enter The Verification Code", 1);
            } else {
                Code = JOptionPane.showInputDialog(null, "A verification code has been sent to your Email.\nCheck Spam Folder of your Email if you don't find the code in Inbox.\nPlease enter the code.", "Enter The Verification Code", 1);
            }

            if (Code == null) {
                JOptionPane.showMessageDialog(null, "Sign Up Request Cancelled");
                return;
            }

            Data = Data + "\n" + "EmailCode=" + Code;

            Response = new ServerConnector(Data).Server();
            input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
            ResponseData.load(input);

            if (ResponseData.getProperty("Response").equals("Account Created Successfully")) {
                JOptionPane.showMessageDialog(null, "Your Account Has Been Successfully Created!\nSign In To Start IGI-2 Multiplayer Launcher", "Welcome To IGI-2 Multiplayer", JOptionPane.PLAIN_MESSAGE);
            } else if (ResponseData.getProperty("Response").equals("Wrong Verification Code")) {
                JOptionPane.showMessageDialog(null, "You've entered wrong verification code.\nTry Again by clicking on \"Sign Up\" button.", "Verification Code Wrong", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public String getOSName() {
        return OSName;
    }

    public String getPCName() {
        return PCName;
    }

    public String getName() {
        return Name;
    }

    public String getMP_Name() {
        return MP_Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

}
