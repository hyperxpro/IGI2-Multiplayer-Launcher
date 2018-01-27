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

import aayush.atharva.igi2.multiplayer.launcher.anticheat.MainCoreSystem.AntiCheat;
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
import static aayush.atharva.igi2.multiplayer.launcher.authentication.Sign_In.MP_Name;
import java.io.IOException;
import javax.swing.JOptionPane;
import static launcher.Main.GameFileString4;
import static launcher.Main_PlayersGUI.isServerJoinButtonPressed;

/**
 *
 * @author Hyper
 */
public class ManualPasswordJoin extends Thread {

    private String IP;
    private String Port;

    public ManualPasswordJoin(String IP, String Port) {
        this.IP = IP;
        this.Port = Port;
    }

    @Override
    public void run() {

        isServerJoinButtonPressed = true;

        String ServerPassword = JOptionPane.showInputDialog(null, "Server Is Password Protected!\nEnter Server Password");

        if (ServerPassword != null) {
        } else {
            isServerJoinButtonPressed = false;
            JOptionPane.showMessageDialog(null, "Join Request Cancelled");
            return;
        }

        AntiCheat.anticheat();

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

            // Launch Game
            try {
                Runtime.getRuntime().exec(Main.GameFile + " " + "$9" + getIP() + " " + "#JZ@" + getPort() + " @#ZM9#\"" + MP_Name + "\" " + GameFileString4 + "" + ServerPassword);
            } catch (IOException ex) {
                isServerJoinButtonPressed = false;
                JOptionPane.showMessageDialog(null, "Unable To Launch Game! This Can Happen When Launcher is unable to access 'igi2_game.exe' file.\nThis Can Happen Which Something Is Restricting Launcher From accessing 'igi2_game.exe' file.\nPut 'igi2_game.exe' File In Your Anti-Virus Exception or Whitelist and Try running Launcher as Administrator.\nIf Problem Still Persists, Contact Support at: aayush@igi2.co.in for further help.");
            }

            isServerJoinButtonPressed = false;

        } else {
            AntiCheat.anticheat();
            isServerJoinButtonPressed = false;
            JOptionPane.showMessageDialog(null, "You're Using Cheat Or Hack For IGI-2 Multiplayer. Remove Cheat Or Hack To Play", "Cheat / Hack Detected!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getIP() {
        return IP;
    }

    public String getPort() {
        return Port;
    }

}
