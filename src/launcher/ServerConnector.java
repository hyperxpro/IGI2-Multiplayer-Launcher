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
package launcher;

import aayush.atharva.TurboCryptography.Decryption;
import aayush.atharva.TurboCryptography.Encryption;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class ServerConnector {

    private String Packet;

    public ServerConnector(String Packet) {
        this.Packet = Packet;
    }

    public String Server() {

        Socket socket = null;
        BufferedReader getData = null;
        PrintWriter sendData = null;

        try {

            socket = new Socket(Main.MASTERSERVERURL, Main.MASTERSERVERPORT);

            getData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendData = new PrintWriter(socket.getOutputStream(), true);

            sendData.println(new Encryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, getPacketData()).Encrypt());

            String Response = new Decryption(Main.AESSecretKey, Main.CBCA, Main.CBCB, Main.KeyAES, Main.Key, Main.IV, getData.readLine()).Decrypt();

            return Response;

        } catch (java.net.ConnectException ex) {
            JOptionPane.showMessageDialog(null, "Server Didn't Accepted Our Connection\nPlease Try Again", "Connecton Not Accepted", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (java.net.SocketException ex) {
            JOptionPane.showMessageDialog(null, "Server Closed Connection Unexpectedly", "Connection Closed", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (java.net.UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Connect To Master Server\nPlease Check Your Internet Connection", "Server Not Reachable", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "A Fatal Error Occured\nPlease Try Again", "Fatal Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // Catching Exception Optional
                }
            }

            if (getData != null) {
                try {
                    getData.close();
                } catch (IOException ex) {
                    // Catching Exception Optional
                }
            }

            if (sendData != null) {
                sendData.close();
            }
        }

        return null;
    }

    private String getPacketData() {
        return Packet;
    }
}
