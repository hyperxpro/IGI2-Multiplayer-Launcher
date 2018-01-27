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
