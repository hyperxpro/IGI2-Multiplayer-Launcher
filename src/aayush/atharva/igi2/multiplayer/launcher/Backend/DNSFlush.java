/*
 * IGI-2 Multiplayer Launcher
 *
 * Copyright (c) 2018, Aayush Atharva
 *
 * Permission is hereby granted, free of charge to any person obtaining a copy of this software and associated documentation files 
 * (the "Software"), to deal in the Software with restriction. A person can use, copy the Software without restriction. But if a person modify
 * the software, the person must push the code to the Software GitHub repository. If a person wants to publish or distribute the software,
 * the person must put this "Created By: Aayush Atharva" on About Section of the Software. And If a person want's to sell the software,
 * the person get permission from the owner of this Software. 
 *
 *
 * IGI-2 Multiplayer Launche
 * Owner: Aayush Atharva
 * Email: aayush@igi2.co.in
 */
package aayush.atharva.igi2.multiplayer.launcher.Backend;

import java.io.IOException;
import javax.swing.JOptionPane;

public class DNSFlush {

    public static void flush() {

        try {
            Runtime.getRuntime().exec("ipconfig -flushdns");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Flush DNS Cache For Clearing Old DNS Cache\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 127", JOptionPane.ERROR_MESSAGE);
        }

    }
}