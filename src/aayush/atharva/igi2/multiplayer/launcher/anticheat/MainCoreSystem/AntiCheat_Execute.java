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
package aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import launcher.Main;
import static launcher.Main_PlayersGUI.SHA;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class AntiCheat_Execute {

    public static void Execute() {

        try {

            String XLauncher_Hash = SHA("X.Launcher");

            // Verify X.Launcher File
            if (XLauncher_Hash.equals(XLauncher_SHA)) {

                // Process Anti Cheat
                AntiCheatImplement.anticheatdo();

                // Extract X.Launcher For X.Launcher.Launcher File
                try {
                    ZipFile zipFile = new ZipFile("X.Launcher");
                    if (zipFile.isEncrypted()) {
                        zipFile.setPassword(Main.XLauncherPassword);
                    }
                    zipFile.extractAll(".");
                } catch (ZipException e) {
                    JOptionPane.showMessageDialog(null, "\"X.Launcher\" File Corrupted and Cannot Be Fixed. Turn Off Anti Virus And Try Again. \nReinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 105", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                // Extract X.Launcher.Launcher For Game Files
                try {
                    ZipFile zipFile = new ZipFile("X.Launcher.Launcher");
                    if (zipFile.isEncrypted()) {
                        zipFile.setPassword(Main.XLauncherPassword);
                    }
                    zipFile.extractAll(".");
                } catch (ZipException e) {
                    JOptionPane.showMessageDialog(null, "\"X.Launcher\" File Corrupted and Cannot Be Fixed. Turn Off Anti Virus And Try Again. \nReinstall IGI-2 Multiplayer Essentials\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 106", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                // Delete X.Launcher.Launcher
                if (new File("X.Launcher.Launcher").exists()) {
                    new File("X.Launcher.Launcher").delete();
                }

            } else {

                // Notification of Process of Download
                JOptionPane.showMessageDialog(null, "\"X.Launcher\" File Is Corrupted\nDownloading Of \"X.Launcher\" File Will Be Started Now.\nSize: 2.4 MB");

                // Delete Old X.Launcher
                new File("X.Launcher").delete();

                // Delete Old X.Launcher.Launcher
                new File("X.Launcher.Launcher").delete();

                // Download X.Launcher
                DownloadXLauncher();

                // Restart Launcher
                JOptionPane.showMessageDialog(null, "\"X.Launcher\" File Is Successfully Downloaded\nRestart IGI-2 Multiplayer Launcher To Continue!");
                System.exit(0);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Game.Please Try Again Or Try Reinstalling Game\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 131", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void DownloadXLauncher() {
        try {
            // I/O
            String fileURL = "http://download.igi2.co.in/anticheat/X.Launcher.zip";
            String saveDir = "X.Launcher";
            URLConnection connection = new URL(fileURL).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/58.0.1271.95 Safari/537.11");
            connection.connect();

            // Write Data
            BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
            FileOutputStream fis = new FileOutputStream(saveDir);
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fis.write(buffer, 0, count);
            }

            // Close I/O
            fis.close();
            bis.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Download \"X.Launcher\" File From Server.\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 101", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // SHA-256 Hashes
    public static final String BridgeDentsrSHA_1 = "6521477524bdb22cf71e2c3da655edc03687f4d5365aebb651a414568256fa1";
    public static final String BridgeDentsrSHA_2 = "9673fd4ab7331aa9c794a079a61cf6ae70359c273bf124c677881ac2260361";

    public static final String chinesetempleSHA_1 = "69ea2e5f27d816b85b7e8fd629e669c31c812ebb8109917c0421044cd34f85";
    public static final String chinesetempleSHA_2 = "1229c6622a54b0516fdeeddc6185bd9ca989687ed5be39b3e822862cac911071";

    public static final String dockbetaSHA_1 = "caaf09bc848e6e1822b6c6b51f5be61f01520cf695c3d6e918d695998789f";
    public static final String dockbetaSHA_2 = "76d462fcff5bc516f9e1e3f9b9dee98937ad265376b417393df03dfea945675";

    public static final String docksideSHA_1 = "986fde43da58f3cc1c2accc764babb1b9f9217aa3d6ce7cce61ff20fbf3";
    public static final String docksideSHA_2 = "5deb496d2c3d88cf688d1a4b941b683c6d63279d55a74b279512dc3c4921ac";

    public static final String factorySHA_1 = "c289462ccc31f4779aca8ae2622c7044ef7a60b2189048e684bbbb8ca438b681";
    public static final String factorySHA_2 = "a2c4ae1c86c1bfc75da2777e0cf1ef78a6b31f41be467c87cf132d65894db9";

    public static final String forestraidSHA_1 = "25937c7f663696d936f8cf6a2ad2636d7fd2748deaffdb4769b4c316508a";
    public static final String forestraidSHA_2 = "3b1c625e6533521fb461ca103a539a3f429794b2eea69f40b542cc1eaa266";

    public static final String JungleXSHA_1 = "2238dff0ad108d425afd06cd3e1ae664652eb3be4a513f9b80c48c3d27d9c";
    public static final String JungleXSHA_2 = "71eb1b22d8b328def92eceaff94bf093316baba9ca947d9c87d7744772b1f";

    public static final String libyanvillageSHA_1 = "a8d8d09913edaf696384e14590e285fc21146b9d4911b63435ba47563a8ab2";
    public static final String libyanvillageSHA_2 = "d3ba33dd75619631eeff4eab2bb99caae62c529f33681f769167801fcc1d50";

    public static final String PriboiVillaSHA_1 = "ca2a6c7cf521b2acc4f9f732d49b55453777abf674cc9237ce6ac80cc3962d3";
    public static final String PriboiVillaSHA_2 = "1dee60b0f2a5f363a1ba5d233c3ca9f2ea9e46979931bb962f1e8b46d299447";

    public static final String redstoneSHA_1 = "fd9490874f8bc289339d756eadaf6bb3ac3a8725a773fb3794d409cf84a2288";
    public static final String redstoneSHA_2 = "31fdcda5678fdad2c6fe98479ac4913e49bad3ab53b79cedf9c46133286b63e";

    public static final String sandstormSHA_1 = "1ef03ab6e8828e929857295562d164fdff86526eebd278ae52451be750281b";
    public static final String sandstormSHA_2 = "71a9eaad1ee101ea1da96a70c649f7f962af5f806bfb99feca4279806e47fe";

    public static final String SnowstormXSHA_1 = "3e2f9b7122c4f32f6c7fb9f6d475ed2ccf81787b451b893aeb3caee2a925";
    public static final String SnowstormXSHA_2 = "41e4320a48a7c4185b9def013525f9f5509f4e7452190745916cda5b5627";

    public static final String timberlandSHA_1 = "169694ea83904161ba607049113f1bea31284b87cca45f5d504ac686ac1fe7a7";
    public static final String timberlandSHA_2 = "ff22b93b6c348f2758601971b35950bcd8411b574f6447315593b5cad7f24";

    public static final String winterlandSHA_1 = "325c164667f69bb2ece46c942328bff7b61a66d48420134565fcba221a37452";
    public static final String winterlandSHA_2 = "fce53ee7e4bcabbff7d5e3dd920b419e5aa8be45fe03bd7f1b2fa97b3beae37";

    public static final String prisonescapeSHA_1 = "fa87558bda26dd4ea8ba5ce451fa6a0e4aacf172b412c8279d980553d4475c1";
    public static final String prisonescapeSHA_2 = "428e2a31600a6c21bcd3cd484c6441fd7a1d656485ff92454b99563d5b8";

    public static final String I_ASHA_1 = "c684c1836c90b5c390bafb81baf553cdf053988b643c679724a85b125dbb4a";
    public static final String I_ASHA_2 = "92ba4de167d7018e8fd439a0837e2720a9f39b4d2e5f95519cc883d52f8";

    public static final String docklandsSHA_1 = "dcafc2102d394deed031e55e9b594c4388bc1672a1606e6a1534f6b815466297";
    public static final String docklandsSHA_2 = "935dddb3e0db6413486e562f3d7ea75fc4df365be14de7b08d25567611b695";

    public static final String igi2_game_SHA_1 = "c01f2edac21b813dd863d010da3a73fbbec6718cb6c6f373be976c8824c6eeb";

    public static final String XLauncher_SHA = "4a83661c37ffaff3e7a782970b29d8a5529df4a16e3b8fd80b7a36ce94ef8c";

    public static final String Weapons_Ammo_SHA = "cbab3f81f7d52f1965cdc67ccc204d1ce2adecfc83dfa2e637a3474184415414";
    public static final String Weapons_wqvm_SHA = "03cb791126af62beacb72ccb1c77ee81df8b0d9f7f29feeb115cb455e95ff8";
    public static final String Weapons_wres_SHA = "42ff741c58fe58c345f627a13f2c73d37e5ae36323a88459f2592b707d797142";

    public static final String Humanplayer_SHA = "1b176b792d58a4a8f9c93811e3457384ca3268cac22be842b1c3982ad7889";
}
