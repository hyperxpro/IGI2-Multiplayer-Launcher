
package launcher;

import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class Settings_GUI extends javax.swing.JFrame {

    public Settings_GUI() {
        initComponents();
//        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/launcher/res/Logo.png")));
        restoreOldConfigurations();
        setVisible(true);
    }

    private void restoreOldConfigurations() {
        Settings settings = new Settings();
        settings.getSettings();

        String Theme = settings.getTheme();

        switch (settings.getTheme()) {
            case "com.alee.laf.WebLookAndFeel":
                Theme = "Launcher Theme X-1";
                break;
            case "com.sun.java.swing.plaf.windows.WindowsLookAndFeel":
                Theme = "Launcher Theme X-2";
                break;
            case "com.jtattoo.plaf.acryl.AcrylLookAndFeel":
                Theme = "Launcher Theme X-3";
                break;
            case "com.jtattoo.plaf.aero.AeroLookAndFeel":
                Theme = "Launcher Theme X-4";
                break;
            case "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel":
                Theme = "Launcher Theme X-5";
                break;
            case "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel":
                Theme = "Launcher Theme X-6";
                break;
            case "com.jtattoo.plaf.fast.FastLookAndFeel":
                Theme = "Launcher Theme X-7";
                break;
            case "com.jtattoo.plaf.graphite.GraphiteLookAndFeel":
                Theme = "Launcher Theme X-8";
                break;
            case "com.jtattoo.plaf.hifi.HiFiLookAndFeel":
                Theme = "Launcher Theme X-9";
                break;
            case "com.jtattoo.plaf.luna.LunaLookAndFeel":
                Theme = "Launcher Theme X-10";
                break;
            case "com.jtattoo.plaf.mcwin.McWinLookAndFeel":
                Theme = "Launcher Theme X-11";
                break;
            case "com.jtattoo.plaf.mint.MintLookAndFeel":
                Theme = "Launcher Theme X-12";
                break;
            case "com.jtattoo.plaf.noire.NoireLookAndFeel":
                Theme = "Launcher Theme X-13";
                break;
            case "com.jtattoo.plaf.smart.SmartLookAndFeel":
                Theme = "Launcher Theme X-14";
                break;
            case "com.jtattoo.plaf.texture.TextureLookAndFeel":
                Theme = "Launcher Theme X-15";
                break;
            case "com.sun.java.swing.plaf.motif.MotifLookAndFeel":
                Theme = "Launcher Theme X-16";
                break;
            default:
                break;
        }

        Theme_Chooser.setSelectedItem(Theme);
    }

    private boolean toRestart = false;

    public boolean isToRestart() {
        return toRestart;
    }

    public void setToRestart(boolean toRestart) {
        this.toRestart = toRestart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        Theme_Chooser = new javax.swing.JComboBox<>();
        Save_Button = new javax.swing.JButton();
        music_option = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        MusicLink_Field = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Settings");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("IGI-2 Multiplayer Launcher Settings");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Launcher UI Theme");

        Theme_Chooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Launcher Theme X-1", "Launcher Theme X-2", "Launcher Theme X-3", "Launcher Theme X-4", "Launcher Theme X-5", "Launcher Theme X-6", "Launcher Theme X-7", "Launcher Theme X-8", "Launcher Theme X-9", "Launcher Theme X-10", "Launcher Theme X-11", "Launcher Theme X-12", "Launcher Theme X-13", "Launcher Theme X-14", "Launcher Theme X-15", "Launcher Theme X-16" }));
        Theme_Chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Theme_ChooserActionPerformed(evt);
            }
        });

        Save_Button.setText("Save");
        Save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_ButtonActionPerformed(evt);
            }
        });

        music_option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Play Music Set By Launcher", "Play Your Own Music" }));
        music_option.setEnabled(false);
        music_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                music_optionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Play Music When Playing Game");
        jLabel4.setEnabled(false);

        MusicLink_Field.setEnabled(false);
        MusicLink_Field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MusicLink_FieldMouseClicked(evt);
            }
        });

        jLabel5.setText("Music Feature Is In Beta And Will Be Available In Launcher v9.7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(275, 275, 275))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(338, 338, 338)
                                        .addComponent(Save_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(MusicLink_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(347, 347, 347)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Theme_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(music_option, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(26, 26, 26)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(music_option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Theme_Chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MusicLink_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Save_Button))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 283, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int Close = JOptionPane.showConfirmDialog(null, "Save Settings And Exit?", "Message", JOptionPane.YES_NO_CANCEL_OPTION);

        if (Close == 0) {

            // Auto Close
            boolean AutoClose = false;

            // Theme
            String Theme = "com.alee.laf.WebLookAndFeel";

            switch (Theme_Chooser.getSelectedItem().toString()) {
                case "Launcher Theme X-1":
                    Theme = "com.alee.laf.WebLookAndFeel";
                    break;
                case "Launcher Theme X-2":
                    Theme = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                    break;
                case "Launcher Theme X-3":
                    Theme = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
                    break;
                case "Launcher Theme X-4":
                    Theme = "com.jtattoo.plaf.aero.AeroLookAndFeel";
                    break;
                case "Launcher Theme X-5":
                    Theme = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
                    break;
                case "Launcher Theme X-6":
                    Theme = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
                    break;
                case "Launcher Theme X-7":
                    Theme = "com.jtattoo.plaf.fast.FastLookAndFeel";
                    break;
                case "Launcher Theme X-8":
                    Theme = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
                    break;
                case "Launcher Theme X-9":
                    Theme = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
                    break;
                case "Launcher Theme X-10":
                    Theme = "com.jtattoo.plaf.luna.LunaLookAndFeel";
                    break;
                case "Launcher Theme X-11":
                    Theme = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
                    break;
                case "Launcher Theme X-12":
                    Theme = "com.jtattoo.plaf.mint.MintLookAndFeel";
                    break;
                case "Launcher Theme X-13":
                    Theme = "com.jtattoo.plaf.noire.NoireLookAndFeel";
                    break;
                case "Launcher Theme X-14":
                    Theme = "com.jtattoo.plaf.smart.SmartLookAndFeel";
                    break;
                case "Launcher Theme X-15":
                    Theme = "com.jtattoo.plaf.texture.TextureLookAndFeel";
                    break;
                case "Launcher Theme X-16":
                    Theme = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
                    break;
                default:
                    break;
            }

            // Music
            String MusicType = "No";

            switch (music_option.getSelectedItem().toString()) {
                case "No":
                    MusicType = "No";
                    break;
                case "Play Music Set By Launcher":
                    MusicType = "Launcher";
                    break;
                case "Play Your Own Music":
                    MusicType = "Self";
                    break;
                default:
                    break;
            }

            String MusicName = "No";

            switch (MusicType) {
                case "Self":
                    MusicName = MusicLink_Field.getText();
                    break;
                case "Launcher":
                    MusicName = "Launcher";
                    break;
                case "No":
                    MusicName = "No";
                    break;
                default:
                    break;
            }

            Settings settings = new Settings();
            settings.getSettings();

            if (!settings.getTheme().equals(Theme)) {
                setToRestart(true);
            }

            new Settings().saveSettings(AutoClose, Theme, MusicName, MusicType);

            new Main_GUI();
            dispose();
        }

        if (Close == 1) {

            if (isToRestart()) {
                JOptionPane.showMessageDialog(null, "You Have Changed Theme. Launcher must be restarted to set new Theme", "Launcher Needs Restart", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }

            new Main_GUI();
            dispose();
        }

    }//GEN-LAST:event_formWindowClosing

    private void Save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_ButtonActionPerformed

        // Auto Close
        boolean AutoClose = false;

        // Theme
        String Theme = "com.alee.laf.WebLookAndFeel";

        switch (Theme_Chooser.getSelectedItem().toString()) {
            case "Launcher Theme X-1":
                Theme = "com.alee.laf.WebLookAndFeel";
                break;
            case "Launcher Theme X-2":
                Theme = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                break;
            case "Launcher Theme X-3":
                Theme = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
                break;
            case "Launcher Theme X-4":
                Theme = "com.jtattoo.plaf.aero.AeroLookAndFeel";
                break;
            case "Launcher Theme X-5":
                Theme = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
                break;
            case "Launcher Theme X-6":
                Theme = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
                break;
            case "Launcher Theme X-7":
                Theme = "com.jtattoo.plaf.fast.FastLookAndFeel";
                break;
            case "Launcher Theme X-8":
                Theme = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
                break;
            case "Launcher Theme X-9":
                Theme = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
                break;
            case "Launcher Theme X-10":
                Theme = "com.jtattoo.plaf.luna.LunaLookAndFeel";
                break;
            case "Launcher Theme X-11":
                Theme = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
                break;
            case "Launcher Theme X-12":
                Theme = "com.jtattoo.plaf.mint.MintLookAndFeel";
                break;
            case "Launcher Theme X-13":
                Theme = "com.jtattoo.plaf.noire.NoireLookAndFeel";
                break;
            case "Launcher Theme X-14":
                Theme = "com.jtattoo.plaf.smart.SmartLookAndFeel";
                break;
            case "Launcher Theme X-15":
                Theme = "com.jtattoo.plaf.texture.TextureLookAndFeel";
                break;
            case "Launcher Theme X-16":
                Theme = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
                break;
            default:
                break;
        }

        // Music
        String MusicType = "No";

        switch (music_option.getSelectedItem().toString()) {
            case "No":
                MusicType = "No";
                break;
            case "Play Music Set By Launcher":
                MusicType = "Launcher";
                break;
            case "Play Your Own Music":
                MusicType = "Self";
                break;
            default:
                break;
        }

        String MusicName = "No";

        switch (MusicType) {
            case "Self":
                MusicName = MusicLink_Field.getText();
                break;
            case "Launcher":
                MusicName = "Launcher";
                break;
            case "No":
                MusicName = "No";
                break;
            default:
                break;
        }

        Settings settings = new Settings();
        settings.getSettings();

        if (!settings.getTheme().equals(Theme)) {
            setToRestart(true);
        }

        new Settings().saveSettings(AutoClose, Theme, MusicName, MusicType);

        if (isToRestart()) {
            JOptionPane.showMessageDialog(null, "You Have Changed Theme. Launcher must be restarted to set new Theme", "Launcher Needs Restart", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }

        new Main_GUI();
        dispose();

    }//GEN-LAST:event_Save_ButtonActionPerformed

    private void MusicLink_FieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MusicLink_FieldMouseClicked
        if (music_option.getSelectedItem().toString().equals("Play Your Own Music")) {
            MusicLink_Field.setText("");
        }
    }//GEN-LAST:event_MusicLink_FieldMouseClicked

    private void music_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_music_optionActionPerformed
        if (music_option.getSelectedItem().toString().equals("No")) {
            MusicLink_Field.setEnabled(false);
        }

        if (music_option.getSelectedItem().toString().equals("Play Music Set By Launcher")) {
            MusicLink_Field.setEnabled(false);
        }

        if (music_option.getSelectedItem().toString().equals("Play Your Own Music")) {
            MusicLink_Field.setEnabled(true);
            MusicLink_Field.setText("Enter Music Link");
        }
    }//GEN-LAST:event_music_optionActionPerformed

    private void Theme_ChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Theme_ChooserActionPerformed

    }//GEN-LAST:event_Theme_ChooserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MusicLink_Field;
    private javax.swing.JButton Save_Button;
    private javax.swing.JComboBox<String> Theme_Chooser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JComboBox<String> music_option;
    // End of variables declaration//GEN-END:variables
}
