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

import launcher.Main;
import static launcher.Main_PlayersGUI.SHA;

public class AntiCheat_SHA256_Hashes {

    // Weapon Folder
    public static String Weapons_wres_Hash = SHA("WEAPONS\\weapons.res");
    public static String Weapons_wqvm_Hash = SHA("WEAPONS\\weapon.qvm");
    public static String Weapons_Ammo_Hash = SHA("WEAPONS\\ammo.qvm");

    // IGI2_Game.exe
    public static String igi2_game_SHA_2 = SHA("igi2_game.exe");

    // Humanplayer 
    public static String Humanplayer_Hash = SHA("HUMANPLAYER\\humanplayer.qvm");

    // Maps
    
    // Bridge Denstr
    public static String BridgeDentsr1 = SHA(Main.MISSION + "mplocation1\\level4\\" + Main.MISSIONS1);
    public static String BridgeDentsr2 = SHA(Main.MISSION + "mplocation1\\level4\\" + Main.MISSIONS2);

    // Chinese Temple
    public static String chinesetemple1 = SHA(Main.MISSION + "chinesetemple\\" + Main.MISSIONS1);
    public static String chinesetemple2 = SHA(Main.MISSION + "chinesetemple\\" + Main.MISSIONS2);

    // Dockbeta
    public static String dockbeta1 = SHA(Main.MISSION + "dockbeta\\" + Main.MISSIONS1);
    public static String dockbeta2 = SHA(Main.MISSION + "dockbeta\\" + Main.MISSIONS2);

    // Dockside
    public static String dockside1 = SHA(Main.MISSION + "dockside\\" + Main.MISSIONS1);
    public static String dockside2 = SHA(Main.MISSION + "dockside\\" + Main.MISSIONS2);

    // Factory
    public static String factory1 = SHA(Main.MISSION + "factory\\" + Main.MISSIONS1);
    public static String factory2 = SHA(Main.MISSION + "factory\\" + Main.MISSIONS2);

    // Forestraid
    public static String forestraid1 = SHA(Main.MISSION + "forestraid\\" + Main.MISSIONS1);
    public static String forestraid2 = SHA(Main.MISSION + "forestraid\\" + Main.MISSIONS2);

    // JungleX
    public static String JungleX1 = SHA(Main.MISSION + "JungleX\\" + Main.MISSIONS1);
    public static String JungleX2 = SHA(Main.MISSION + "JungleX\\" + Main.MISSIONS2);

    // Libyan Village
    public static String libyanvillage1 = SHA(Main.MISSION + "libyanvillage\\" + Main.MISSIONS1);
    public static String libyanvillage2 = SHA(Main.MISSION + "libyanvillage\\" + Main.MISSIONS2);

    // Priboi Villa
    public static String PriboiVilla1 = SHA(Main.MISSION + "mplocation2\\LEVEL3\\" + Main.MISSIONS1);
    public static String PriboiVilla2 = SHA(Main.MISSION + "mplocation2\\LEVEL3\\" + Main.MISSIONS2);

    // Redstone
    public static String redstone1 = SHA(Main.MISSION + "redstone\\" + Main.MISSIONS1);
    public static String redstone2 = SHA(Main.MISSION + "redstone\\" + Main.MISSIONS2);

    // Sandstorm
    public static String sandstorm1 = SHA(Main.MISSION + "sandstorm\\" + Main.MISSIONS1);
    public static String sandstorm2 = SHA(Main.MISSION + "sandstorm\\" + Main.MISSIONS2);

    // Snowstone X
    public static String SnowstormX1 = SHA(Main.MISSION + "Snowstone X\\" + Main.MISSIONS1);
    public static String SnowstormX2 = SHA(Main.MISSION + "Snowstone X\\" + Main.MISSIONS2);

    // Timberland
    public static String timberland1 = SHA(Main.MISSION + "timberland\\" + Main.MISSIONS1);
    public static String timberland2 = SHA(Main.MISSION + "timberland\\" + Main.MISSIONS2);

    // Winterland
    public static String winterland1 = SHA(Main.MISSION + "winterland\\" + Main.MISSIONS1);
    public static String winterland2 = SHA(Main.MISSION + "winterland\\" + Main.MISSIONS2);

    // Island Assault
    public static String IslandAssault1 = SHA(Main.MISSION + "mplocation3\\LEVEL1\\" + Main.MISSIONS1);
    public static String IslandAssault2 = SHA(Main.MISSION + "mplocation3\\LEVEL1\\" + Main.MISSIONS2);

    // Prison Escape
    public static String prisonescape1 = SHA(Main.MISSION + "Prison Escape\\" + Main.MISSIONS1);
    public static String prisonescape2 = SHA(Main.MISSION + "Prison Escape\\" + Main.MISSIONS2);

    // Docklands
    public static String dockland1 = SHA(Main.MISSION + "docklands\\" + Main.MISSIONS1);
    public static String dockland2 = SHA(Main.MISSION + "docklands\\" + Main.MISSIONS2);

}
