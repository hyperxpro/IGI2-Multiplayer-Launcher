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
package aayush.atharva.igi2.multiplayer.launcher.Backend;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;
import launcher.Main;

/**
 *
 * @author Hyper
 */
public class NetworkConnectionCheck {

    public void NetworkCheck() {

        Socket sock1 = null;
        Socket sock2 = null;
        Socket sock3 = null;

        try {

            sock1 = new Socket();
            sock2 = new Socket();
            sock3 = new Socket();

            InetSocketAddress addr1 = new InetSocketAddress("api-igi2.igi2.co.in", 443);
            InetSocketAddress addr2 = new InetSocketAddress("igi-2-masterserver-masterserver-igi2masterserver-global-cdn-nlb.igi2.co.in", 443);
            InetSocketAddress addr3 = new InetSocketAddress(Main.MASTERSERVERURL, Main.MASTERSERVERPORT);

            sock1.connect(addr1, 3000);
            sock2.connect(addr2, 3000);
            sock3.connect(addr3, 3000);

            JOptionPane.showMessageDialog(null, "All Services Are Online And Accessible From This Computer!", "Everything Is Up And Running", 1);

            sock1.close();
            sock2.close();
            sock3.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Services Are Down Or Not Reachable From This Computer.\nContact Support at: \"aayush@igi2.co.in\" if you continue to face this problem again.", "Services Not Reachable", 0);
        } finally {
            if (sock1 != null) {
                try {
                    sock1.close();
                } catch (IOException ex) {
                }
            }

            if (sock2 != null) {
                try {
                    sock2.close();
                } catch (IOException ex) {
                }
            }

            if (sock3 != null) {
                try {
                    sock3.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}
