/*
IGI-2 Multiplayer Launcher

Copyright (c) 2018, Aayush Atharva

Permission is hereby granted, free of charge to any person obtaining a copy of this software and associated documentation files 
(the "Software"), to deal in the Software with restriction. A person can use, copy the Software without restriction. But if a person modify
the software, the person must push the code to the Software GitHub repository. If a person wants to publish or distribute the software,
the person must put this "Created By: Aayush Atharva" on About Section of the Software. And If a person want's to sell the software,
the person get permission from the owner of this Software. 


IGI-2 Multiplayer Launche
Owner: Aayush Atharva
Email: aayush@igi2.co.in
*/

package launcher;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class Check_Image {

    public static void check() {
        try {
            File file = new File("IGI-2 Multiplayer Launcher Files\\res\\Launcher.1.Launcher");
            StringBuffer hexString;

            if (file.exists()) {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                {
                    FileInputStream fis = new FileInputStream(file);

                    byte[] dataBytes = new byte[1024];

                    int nread = 0;
                    while ((nread = fis.read(dataBytes)) != -1) {
                        md.update(dataBytes, 0, nread);
                    };
                    byte[] mdbytes = md.digest();

                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
                    }

                    hexString = new StringBuffer();
                    for (int i = 0; i < mdbytes.length; i++) {
                        hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
                    }
                }

                if (!hexString.toString().equals("6d6a5731af745b5b5d1991aa3de78f3c496b8ceee93fae4b0da8e57f6856968")) {
                    JOptionPane.showMessageDialog(null, "Image Files Are Corrupted. Please Reinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Image Files Not Found. Please Reinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Fatal Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }

        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Show Detailed Error.\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 134", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Read Image File.\nMake Sure Launcher Have Enough Rights To Access Image Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Algorithm On Image Files.\nMake Sure Launcher Have Enough Rights To Access Image Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
