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
