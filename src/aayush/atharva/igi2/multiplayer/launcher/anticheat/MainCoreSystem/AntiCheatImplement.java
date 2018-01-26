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
