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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 *
 * @author Hyper
 */
public class Settings {

    private boolean AutoClose;
    private String Theme;
    private String MusicLink;
    private String MusicType;

    public String getMusicType() {
        return MusicType;
    }

    public void setMusicType(String MusicType) {
        this.MusicType = MusicType;
    }

    public boolean isAutoClose() {
        return AutoClose;
    }

    public void setAutoClose(boolean AutoClose) {
        this.AutoClose = AutoClose;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String Theme) {
        this.Theme = Theme;
    }

    public String getMusicLink() {
        return MusicLink;
    }

    public void setMusicLink(String MusicLink) {
        this.MusicLink = MusicLink;
    }

    public void getSettings() {
        Properties Data = new Properties();

        try {
            
            if (!new File("IGI-2 Multiplayer Launcher Files\\IGI-2_Multiplayer_Launcher_v9.6.Launcher").exists()) {
                setTheme("com.alee.laf.WebLookAndFeel");
                setAutoClose(false);
                setMusicLink("Auto");
                return;
            }

            Data.load(new BufferedReader(new FileReader("IGI-2 Multiplayer Launcher Files\\IGI-2_Multiplayer_Launcher_v9.6.Launcher"), 8192));

            setTheme(Data.getProperty("Theme"));
            setMusicLink(Data.getProperty("MusicLink"));
            setMusicType(Data.getProperty("MusicType"));

            if (Data.getProperty("Close").equals("true")) {
                setAutoClose(true);
            } else {
                setAutoClose(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void saveSettings(boolean AutoClose, String Theme, String MusicName, String MusicType) {

        setAutoClose(AutoClose);
        setMusicLink(MusicName);
        setTheme(Theme);
        setMusicType(MusicType);

        String Data = "Close=" + isAutoClose() + "\n"
                + "Theme=" + getTheme() + "\n"
                + "MusicLink=" + getMusicLink() + "\n"
                + "MusicType=" + getMusicType();

        { // Write Settings To File
            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                fw = new FileWriter("IGI-2 Multiplayer Launcher Files\\IGI-2_Multiplayer_Launcher_v9.6.Launcher");
                bw = new BufferedWriter(fw);
                bw.write(Data);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
