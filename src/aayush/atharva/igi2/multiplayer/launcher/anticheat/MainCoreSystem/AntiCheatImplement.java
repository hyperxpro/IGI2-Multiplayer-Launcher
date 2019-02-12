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

import aayush.atharva.igi2.multiplayer.launcher.anticheat.algorithm.filesverification.maps.*;
import java.io.File;
import javax.swing.JOptionPane;
import launcher.Main;

public class AntiCheatImplement {

    public static void anticheatdo() {

        try {

            // -------------------------------------------------------------------------------Delete WEAPONS---------------------------------------------------------------------------
            File weaponsammo = new File(Main.WeaponsDir + "\\ammo.qvm");
            weaponsammo.delete();

            File weaponsqvm = new File(Main.WeaponsDir + "\\Weapon.qvm");
            weaponsqvm.delete();

            File weaponsres = new File(Main.WeaponsDir + "\\Weapons.res");
            weaponsres.delete();

            // ------------------------------------------------------------------------Delete HUMAMPLAYER-----------------------------------------------------------------------------
            File humanplayerqvm = new File(Main.HumanplayerDir + "\\humanplayer.qvm");
            humanplayerqvm.delete();

            // ------------------------------------------------------------------------Delete igi2_game.exe-----------------------------------------------------------------------
            File igi2game = new File(Main.GameFile);
            igi2game.delete();

            // ------------------------------------------------------------------------Delete Mission Files-----------------------------------------------------------------------
            // Dockbeta Map
            dockbeta.main();

            //Dockside Map
            dockside.main();

            // Factory Map
            factory.main();

            //JungleX Map
            junglex.main();

            //Libyan Village
            libyanvillage.main();

            // PriboiVilla
            priboivilla.main();

            //Bridge Dentsr 
            bridgedenstr.main();

            //Snowstone X
            snowstormx.main();

            // winterland
            winterland.main();

            // sandstorm
            sandstorm.main();

            // redstone
            redstone.main();

            // forestraid
            forestraid.main();

            // chinesetemple
            chinesetemple.main();

            // timberland
            timberland.main();

            // Dockland
            dockland.main();

            // Island Assault
            island_assault.main();

            // Prison Escape
            prison_escape.main();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Client Game Verification Service. Please Try Again\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 104", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
