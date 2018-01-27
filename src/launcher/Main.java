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

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import static launcher.Main_GUI.serverListTable;

public class Main {

    // Launcher 
    public static List<Server> lista;
    public static List<Server> oldList;
    public static int update;
    public static String Theme = "com.alee.laf.WebLookAndFeel";
    public static String Authentication_Check = "Not Autheneitcated, Waiting For Authentication...";
    public static int ServerListQuery = 0;
    public static int ServerUpdateQuery = 0;
    public static boolean JoinBeaconSender = false;
    public static String UserIdentity;

    public static void main(String args[]) throws Exception {

        // Check Loader Image
        Check_Loader.check();

        new StartUpProcess().Process(); // Launch Start Up Process

        while (Authentication_Check.equals("Not Autheneitcated, Waiting For Authentication...")) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }

        Authentication_Check = "Not Autheneitcated, Waiting For Authentication..."; // Disable Authentication

        // Check Image
        Check_Image.check();

        // Start Server Fetching
        new Main_GUI();

        // Start Query Controller For Server List
        new ServerListQueryController().start();
        // Start Query Controller For Server Status
        new ServerInfoQueryController().start();

    }

    public static void updateServerList() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        String Pass = "";
        String MapStats = "";

        // Remove Old Table Data
        for (int i = lista.size(); i < 100; i++) {
            Main_GUI.serverListTable.setValueAt(null, i, 0);
            Main_GUI.serverListTable.setValueAt(null, i, 1);
            Main_GUI.serverListTable.setValueAt(null, i, 2);
            Main_GUI.serverListTable.setValueAt(null, i, 3);
            Main_GUI.serverListTable.setValueAt(null, i, 4);
            Main_GUI.serverListTable.setValueAt(null, i, 5);
            Main_GUI.serverListTable.setValueAt(null, i, 6);
        }

        // Process New Table Data
        int TableNumber = 0;
        for (Server Data : lista) {
            serverListTable.getColumnModel().getColumn(TableNumber).setCellRenderer(centerRenderer);
            Main_GUI.serverListTable.setValueAt(Data.name, TableNumber, 0);
            Main_GUI.serverListTable.setValueAt(Data.numpl + "/" + Data.maxpl, TableNumber, 1);
            Main_GUI.serverListTable.setValueAt("" + Data.map, TableNumber, 2);
            Main_GUI.serverListTable.setValueAt("" + Data.time, TableNumber, 3);

            if (Data.mapstat.matches(".*[a-zA-Z]+.*")) {
                MapStats = Data.mapstat;
            } else {
                MapStats = "∞";
            }

            Main_GUI.serverListTable.setValueAt(MapStats, TableNumber, 4);

            if (Data.PasswordStatus.contains("AEPEM")) {
                Pass = "No";
            } else if (Data.PasswordStatus.contains("Yes")) {
                Pass = "Yes";
            }

            Main_GUI.serverListTable.setValueAt("           " + Pass, TableNumber, 5);
            Main_GUI.serverListTable.setValueAt("" + Data.uptime, TableNumber, 6);

            TableNumber++;
        }
    }

    // Start Theme
    static {
        try {
            Settings Setting = new Settings();
            Setting.getSettings();
            Theme = Setting.getTheme();

            switch (Theme) {
                case "com.jtattoo.plaf.acryl.AcrylLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    AcrylLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.aero.AeroLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    AeroLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    AluminiumLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    BernsteinLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.fast.FastLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    FastLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.graphite.GraphiteLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    GraphiteLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.hifi.HiFiLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    HiFiLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.luna.LunaLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    LunaLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.mcwin.McWinLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    McWinLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.mint.MintLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    MintLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.noire.NoireLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    NoireLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.smart.SmartLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    SmartLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                    break;
                }
                case "com.jtattoo.plaf.texture.TextureLookAndFeel": {
                    Properties props = new Properties();
                    props.put("logoString", "");
                    AcrylLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                    break;
                }
                default:
                    UIManager.setLookAndFeel(Theme);
                    break;
            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Strings

    public static final String MASTERSERVERURL = "core-system-igi2-masterserver.igi2.co.in";
    public static final int MASTERSERVERPORT = 50000;

    // Anti Cheat 
    public static final String WeaponsDir = "WEAPONS";
    public static final String HumanplayerDir = "HUMANPLAYER";
    public static final String GameFile = "igi2_game.exe";
    public static final String XLauncher = "X.Launcher";

    public static final String MISSION = "MISSIONS\\multiplayer\\";
    public static final String MISSIONS1 = "mission.qvm";
    public static final String MISSIONS2 = "objects.qvm";

    public static final String BridgeDentsr1 = Main.MISSION + "mplocation1\\level4\\" + Main.MISSIONS1;
    public static final String BridgeDentsr2 = Main.MISSION + "mplocation1\\level4\\" + Main.MISSIONS2;

    public static final String chinesetemple1 = Main.MISSION + "chinesetemple\\" + Main.MISSIONS1;
    public static final String chinesetemple2 = Main.MISSION + "chinesetemple\\" + Main.MISSIONS2;

    public static final String dockbeta1 = Main.MISSION + "dockbeta\\" + Main.MISSIONS1;
    public static final String dockbeta2 = Main.MISSION + "dockbeta\\" + Main.MISSIONS2;

    public static final String dockside1 = Main.MISSION + "dockside\\" + Main.MISSIONS1;
    public static final String dockside2 = Main.MISSION + "dockside\\" + Main.MISSIONS2;

    public static final String factory1 = Main.MISSION + "factory\\" + Main.MISSIONS1;
    public static final String factory2 = Main.MISSION + "factory\\" + Main.MISSIONS2;

    public static final String forestraid1 = Main.MISSION + "forestraid\\" + Main.MISSIONS1;
    public static final String forestraid2 = Main.MISSION + "forestraid\\" + Main.MISSIONS2;

    public static final String JungleX1 = Main.MISSION + "JungleX\\" + Main.MISSIONS1;
    public static final String JungleX2 = Main.MISSION + "JungleX\\" + Main.MISSIONS2;

    public static final String libyanvillage1 = Main.MISSION + "libyanvillage\\" + Main.MISSIONS1;
    public static final String libyanvillage2 = Main.MISSION + "libyanvillage\\" + Main.MISSIONS2;

    public static final String PriboiVilla1 = Main.MISSION + "mplocation2\\LEVEL3\\" + Main.MISSIONS1;
    public static final String PriboiVilla2 = Main.MISSION + "mplocation2\\LEVEL3\\" + Main.MISSIONS2;

    public static final String IslandAssault1 = Main.MISSION + "mplocation2\\LEVEL1\\" + Main.MISSIONS1;
    public static final String IslandAssault2 = Main.MISSION + "mplocation2\\LEVEL1\\" + Main.MISSIONS2;

    public static final String redstone1 = Main.MISSION + "redstone\\" + Main.MISSIONS1;
    public static final String redstone2 = Main.MISSION + "redstone\\" + Main.MISSIONS2;

    public static final String sandstorm1 = Main.MISSION + "sandstorm\\" + Main.MISSIONS1;
    public static final String sandstorm2 = Main.MISSION + "sandstorm\\" + Main.MISSIONS2;

    public static final String SnowstormX1 = Main.MISSION + "Snowstone X\\" + Main.MISSIONS1;
    public static final String SnowstormX2 = Main.MISSION + "Snowstone X\\" + Main.MISSIONS2;

    public static final String timberland1 = Main.MISSION + "timberland\\" + Main.MISSIONS1;
    public static final String timberland2 = Main.MISSION + "timberland\\" + Main.MISSIONS2;

    public static final String winterland1 = Main.MISSION + "winterland\\" + Main.MISSIONS1;
    public static final String winterland2 = Main.MISSION + "winterland\\" + Main.MISSIONS2;

    public static final String prisonescape1 = Main.MISSION + "Prison Escape\\" + Main.MISSIONS1;
    public static final String prisonescape2 = Main.MISSION + "Prison Escape\\" + Main.MISSIONS2;

    public static final String dockland1 = Main.MISSION + "docklands\\" + Main.MISSIONS1;
    public static final String dockland2 = Main.MISSION + "docklands\\" + Main.MISSIONS2;

    // Password And Keys
    public static final String XLauncherPassword = "";
    public static final String Key = ""; // 16 Bit Key
    public static final String KeyAES = ""; // 18 Bit Key
    public static final String IV = ""; // 16 Bit Key
    public static final String CBCA = ""; // 16 Bit Key
    public static final String CBCB = ""; // 16 Bit Key
    public static final String AESSecretKey = ""; // AES Key

    // Important Strings
    public static final String GameFileString1 = "$9";
    public static final String GameFileString2 = "#JZ@";
    public static final String GameFileString3 = "@#ZM9#";
    public static final String GameFileString4 = "B6$#T5#@";

    // Files
    public static final String Remember_Login_Data_File = "IGI-2 Multiplayer Launcher Files\\RM_LG_DATA.LAUNCHER";

}
