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

import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.BridgeDentsrSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.BridgeDentsrSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.Humanplayer_SHA;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.I_ASHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.I_ASHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.JungleXSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.JungleXSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.PriboiVillaSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.PriboiVillaSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.SnowstormXSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.SnowstormXSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.Weapons_Ammo_SHA;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.Weapons_wqvm_SHA;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.Weapons_wres_SHA;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.chinesetempleSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.chinesetempleSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.dockbetaSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.dockbetaSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.docklandsSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.docklandsSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.docksideSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.docksideSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.factorySHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.factorySHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.forestraidSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.forestraidSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.igi2_game_SHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.libyanvillageSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.libyanvillageSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.prisonescapeSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.prisonescapeSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.redstoneSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.redstoneSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.sandstormSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.sandstormSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.timberlandSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.timberlandSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.winterlandSHA_1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_Execute.winterlandSHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.BridgeDentsr1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.BridgeDentsr2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.Humanplayer_Hash;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.IslandAssault1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.IslandAssault2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.JungleX1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.JungleX2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.PriboiVilla1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.PriboiVilla2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.SnowstormX1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.SnowstormX2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.Weapons_Ammo_Hash;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.Weapons_wqvm_Hash;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.Weapons_wres_Hash;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.chinesetemple1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.chinesetemple2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.dockbeta1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.dockbeta2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.dockland1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.dockland2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.dockside1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.dockside2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.factory1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.factory2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.forestraid1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.forestraid2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.igi2_game_SHA_2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.libyanvillage1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.libyanvillage2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.prisonescape1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.prisonescape2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.redstone1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.redstone2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.sandstorm1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.sandstorm2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.timberland1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.timberland2;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.winterland1;
import static aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat_SHA256_Hashes.winterland2;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class AntiCheatBeacon extends Thread {

    private String ServerIP;
    private String ServerPORT;
    private String PlayerName;
    private String JoinerID;

    public AntiCheatBeacon(String ServerIP, String ServerPORT, String PlayerName, String JoinerID) {
        this.ServerIP = ServerIP;
        this.ServerPORT = ServerPORT;
        this.PlayerName = PlayerName;
        this.JoinerID = JoinerID;
    }

    @Override
    public void run() {

        boolean Stop = false;

        if (!waitForGameToLaunch()) {
            return;
        }

        if (!AnalyzeLog()) {
            return;
        }

        while (true) {

            if (Stop) {
                return;
            }

            try {

                // Check Files Hashes And Verify Anti-Cheat
                if (BridgeDentsr1.equals(BridgeDentsrSHA_1) && BridgeDentsr2.equals(BridgeDentsrSHA_2) && chinesetemple1.equals(chinesetempleSHA_1) && chinesetemple2.equals(chinesetempleSHA_2)
                        && dockbeta1.equals(dockbetaSHA_1) && dockbeta2.equals(dockbetaSHA_2) && dockside1.equals(docksideSHA_1) && dockside2.equals(docksideSHA_2) && factory1.equals(factorySHA_1)
                        && factory2.equals(factorySHA_2) && forestraid1.equals(forestraidSHA_1) && forestraid2.equals(forestraidSHA_2) && JungleX1.equals(JungleXSHA_1) && JungleX2.equals(JungleXSHA_2)
                        && libyanvillage1.equals(libyanvillageSHA_1) && libyanvillage2.equals(libyanvillageSHA_2) && PriboiVilla1.equals(PriboiVillaSHA_1) && PriboiVilla2.equals(PriboiVillaSHA_2)
                        && redstone1.equals(redstoneSHA_1) && redstone2.equals(redstoneSHA_2) && sandstorm1.equals(sandstormSHA_1) && sandstorm2.equals(sandstormSHA_2)
                        && SnowstormX1.equals(SnowstormXSHA_1) && SnowstormX2.equals(SnowstormXSHA_2) && timberland1.equals(timberlandSHA_1) && timberland2.equals(timberlandSHA_2)
                        && winterland1.equals(winterlandSHA_1) && winterland2.equals(winterlandSHA_2) && IslandAssault1.equals(I_ASHA_1) && IslandAssault2.equals(I_ASHA_2) && prisonescape1.equals(prisonescapeSHA_1)
                        && prisonescape2.equals(prisonescapeSHA_2) && dockland1.equals(docklandsSHA_1) && dockland2.equals(docklandsSHA_2) && igi2_game_SHA_1.equals(igi2_game_SHA_2) && Weapons_Ammo_SHA.equals(Weapons_Ammo_Hash)
                        && Weapons_wqvm_SHA.equals(Weapons_wqvm_Hash) && Weapons_wres_SHA.equals(Weapons_wres_Hash) && Humanplayer_SHA.equals(Humanplayer_Hash)) {

                    String Response = new ServerConnector("Query=ACB" + "\n" + "SIP=" + getServerIP() + "\n" + "SPORT=" + getServerPORT() + "\n" + "PNAME=" + getPlayerName() + "\n" + "JID=" + getJoinerID()).Server();

                    Properties Data = new Properties();
                    InputStream input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
                    Data.load(input);

                    if (Data.getProperty("Response").equals("Disconnect")) {
                        Stop = true;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "You're Using Cheat Or Hack For IGI-2 Multiplayer. Remove Cheat Or Hack To Play", "Cheat / Hack Detected!", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }

            } catch (IOException ex) {
                Logger.getLogger(AntiCheatBeacon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean waitForGameToLaunch() {
        BufferedReader reader = null;
        try {

            String linia;

            while (true) {
                Process process = Runtime.getRuntime().exec("powershell.exe \"Get-Process igi2_game | Select-Object Path\"");
                reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((linia = reader.readLine()) != null) {
                    if (linia.contains(System.getProperty("user.dir") + "\\igi2_game.exe")) {
                        return true;
                    }
                }
                reader.close();
            }

        } catch (IOException ex) {
            // Throw
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // Ignore
                }
            }
        }
        return false;
    }

    private boolean AnalyzeLog() {
        String Line = "";
        long Lenght;
        long Position = 0;
        RandomAccessFile czyt = null;

        try {
            czyt = new RandomAccessFile("Multiplayer.log", "r");
            while (true) {

                Lenght = czyt.length();
                czyt.seek(Position);

                while (Position < Lenght) {
                    Line = czyt.readLine();
                    Position = czyt.getFilePointer();
                }

                if (Position > 80) {
                    return true;
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            // Ignore
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Game Not Running. Please Run IGI-2 Multiplayer Launcher As Administrator", "Unable To Detect Game", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Read Game Files. Please Run IGI-2 Multiplayer Launcher As Administrator", "Unable To Read Game Files", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            try {
                if (czyt != null) {
                    czyt.close();
                }
            } catch (IOException ex1) {
                // Ignore
            }
        }
        return false;
    }

    private String getJoinerID() {
        return JoinerID;
    }

    private String getServerIP() {
        return ServerIP;
    }

    private String getServerPORT() {
        return ServerPORT;
    }

    private String getPlayerName() {
        return PlayerName;
    }

}
