/*
 * IGI-2 Multiplayer Launcher
 *
 * Copyright (c) 2018, Aayush Atharva
 *
 * Permission is hereby granted, free of charge to any person obtaining a copy of this software and associated documentation files 
 * (the "Software"), to deal in the Software with restriction. A person can use, copy the Software without restriction. But if a person 
 * modify the software, the person must push the code to the Software GitHub repository. If a person wants to publish or distribute the 
 * software, the person must put this "Created By: Aayush Atharva" on About Section of the Software And this License must be present with 
 * every file of the Software. And If a person wants to sell the software, the person get permission from the owner of this Software.
 *
 *
 *
 *
 * IGI-2 Multiplayer Launcher
 * Owner: Aayush Atharva
 * Email: aayush@igi2.co.in
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
