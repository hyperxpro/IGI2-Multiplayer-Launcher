/*
 * IGI-2 Multiplayer Launcher
 * ________________________________________
 * End-User License Agreement ("Agreement")
 *
 * Last updated: 12-February-2019
 *
 * Please read this End-User License Agreement ("Agreement") carefully before clicking the "I Agree" button, downloading or using IGI-2 Multiplayer Launcher ("Application").
 *
 * By clicking the "I Agree" button, downloading or using the Application, you are agreeing to be bound by the terms and conditions of this Agreement.
 *
 * If you do not agree to the terms of this Agreement, do not click on the "I Agree" button and do not download or use the Application.
 *
 * License
 *
 * Aayush Atharva grants you a revocable, non-exclusive, non-transferable, limited license to download, install, modify and use the Application solely for your personal, non-commercial purposes strictly in accordance with the terms of this Agreement. 
 *
 * Restrictions
 *
 * You agree not to, and you will not permit others to:
 *
 * a) license, sell, rent, lease, assign, distribute, transmit, host, outsource, disclose or otherwise commercially exploit the Application or make the Application available to any third party.
 *
 *
 * Modifications to Application
 *
 * Aayush Atharva reserves the right to modify, suspend or discontinue, temporarily or permanently, the Application or any service to which it connects, with or without notice and without liability to you.
 *
 *
 * Term and Termination
 *
 * This Agreement shall remain in effect until terminated by you or Aayush Atharva.
 *
 * Aayush Atharva may, in its sole discretion, at any time and for any or no reason, suspend or terminate this Agreement with or without prior notice.
 *
 * This Agreement will terminate immediately, without prior notice from Aayush Atharva, in the event that you fail to comply with any provision of this Agreement. You may also terminate this Agreement by deleting the Application and all copies thereof from any device where itÃ¢â‚¬â„¢s stored.
 *
 * Upon termination of this Agreement, you shall cease all use of the Application and delete all copies of the Application from any device where itÃ¢â‚¬â„¢s stored.
 *
 * Severability
 *
 * If any provision of this Agreement is held to be unenforceable or invalid, such provision will be changed and interpreted to accomplish the objectives of such provision to the greatest extent possible under applicable law and the remaining provisions will continue in full force and effect.
 *
 * Amendments to this Agreement
 *
 * Aayush Atharva reserves the right, at its sole discretion, to modify or replace this Agreement at any time. If a revision is material I will provide at least 7 days notice prior to any new terms taking effect. What constitutes a material change will be determined at our sole discretion.
 *
 * Contact Information
 *
 * If you have any questions about this Agreement, please contact me.
 *
 *
 * Aayush Atharva
 * Email: aayush@aayushatharva.com
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
