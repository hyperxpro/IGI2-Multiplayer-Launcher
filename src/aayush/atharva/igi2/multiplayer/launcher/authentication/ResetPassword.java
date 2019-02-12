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
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import launcher.ServerConnector;

public class ResetPassword {

    private String Username_Email;
    private String Password;
    private String OSName;
    private String PCName;

    public ResetPassword(String Username_Email, String Password, String OSName, String PCName) {
        this.Username_Email = Username_Email;
        this.Password = Password;
        this.OSName = OSName;
        this.PCName = PCName;
    }

    public void Reset() throws UnsupportedEncodingException, IOException {

        String GetEmail = JOptionPane.showInputDialog(null, "Enter The Email Which You Used For Your IGI-2 Multiplayer Launcher Account", "Enter Your Email", 1);

        if (!GetEmail.contains("@") && !GetEmail.contains(".")) {
            JOptionPane.showMessageDialog(null, "The Email you entered is invalid.\nPlease enter a valid email.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String ReseterID = generateReseterID();
        String Data = "Query=Reset_Password" + "\n"
                + "Email=" + GetEmail + "\n"
                + "OSName=" + getOSName() + "\n"
                + "PCName=" + getPCName() + "\n"
                + "ReseterID=" + ReseterID;

        String Response = new ServerConnector(Data).Server();

        Properties ResponseData = new Properties();
        InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
        ResponseData.load(input);

        if (ResponseData.getProperty("Response").equals("Continue_Verification_Password_Reset") || ResponseData.getProperty("Response").contains("Verification Code Already Sent To Your Email")) {

            String Code = null;

            if (ResponseData.getProperty("Response").contains("Verification Code Already Sent To Your Email")) {
                JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
                Code = JOptionPane.showInputDialog(null, "A verification code has been already sent your Email.\nCheck Spam Folder of your Email if you don't find the code in Inbox.\nPlease enter the code.", "Enter The Verification Code", 1);
            } else {
                Code = JOptionPane.showInputDialog(null, "A verification code has been sent to your Email.\nCheck Spam Folder of your Email if you don't find the code in Inbox.\nPlease enter the code.", "Enter The Verification Code", 1);
            }

            if (Code == null) {
                JOptionPane.showMessageDialog(null, "Password Reset Request Cancelled");
                return;
            }

            Data = Data + "\n" + "EmailCode=" + Code;

            Response = new ServerConnector(Data).Server();
            input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
            ResponseData.load(input);

            if (ResponseData.getProperty("Response").equals("Code_Verified") && ResponseData.getProperty("ReseterID").equals(ReseterID)) {
                JTextField First_Password = new JPasswordField();
                JTextField Confirm_Password = new JPasswordField();
                Object[] message_r = {
                    "Password:", First_Password,
                    "Confirm Password:", Confirm_Password
                };

                int option = JOptionPane.showConfirmDialog(null, message_r, "Enter Your New Password", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {

                    if (First_Password.getText().equals(Confirm_Password.getText())) {

                        if (First_Password.getText().length() <= 50) {
                        } else {
                            JOptionPane.showMessageDialog(null, "Maximum Password Characters Limit is 50", "Too Big Password", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        if (First_Password.getText().length() >= 8) {
                        } else {
                            JOptionPane.showMessageDialog(null, "Your Password Must Be At Least 8 Characters Long", "Too Short Password", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String Characters = "\\ / : * ? \" < > | [ ]";
                        if (First_Password.getText().contains("\\") || First_Password.getText().contains("/") || First_Password.getText().contains(":") || First_Password.getText().contains("*") || First_Password.getText().contains("?") || First_Password.getText().contains("\"") || First_Password.getText().contains("<") || First_Password.getText().contains(">") || First_Password.getText().contains("|")) {
                            JOptionPane.showMessageDialog(null, "Your Password should not contain any of the following characters:\n" + Characters, "Error!", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        Data = Data + "\n" + "EmailCode=" + Code + "\n" + "Password=" + First_Password.getText();

                        Response = new ServerConnector(Data).Server();
                        input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
                        ResponseData.load(input);

                        if (ResponseData.getProperty("Response").equals("Password Updated Successfully. Now You Can Login To Your Account With New Password!")) {
                            JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"));
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "You Passwords Didn't Matched\nPlease Try Again", "Passwords Not Same", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Password Reset Request Cancelled");
                    return;
                }

            }

            if (ResponseData.getProperty("Response").equals("Wrong Verification Code")) {
                JOptionPane.showMessageDialog(null, "You've entered wrong verification code.\nTry Again by clicking on \"Reset Password\" button.", "Verification Code Wrong", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, ResponseData.getProperty("Response"), "Message", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private String getUsername_Email() {
        return Username_Email;
    }

    private String getPassword() {
        return Password;
    }

    private String getOSName() {
        return OSName;
    }

    private String getPCName() {
        return PCName;
    }

    public String generateReseterID() {
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
