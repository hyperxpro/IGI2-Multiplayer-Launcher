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
package launcher;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyper
 */
public class Main_PlayersGUI extends javax.swing.JFrame {

    List<Player> players;
    Server server;
    String ServerData;
    String Server_Name;
    int Server_Current_Players;
    int Server_Max_Players;
    boolean Refresh_ERROR = false;
    public static boolean isServerJoinButtonPressed = false;

    public Main_PlayersGUI(Server server) {
        initComponents();
        this.server = server;
        setTitle(server.name + "  |  Players : " + server.numpl + "/" + server.maxpl);
        new UpdatePlayers(this).start();
        join_button.setText("Join " + server.name);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        server_name = new javax.swing.JLabel();
        server_player = new javax.swing.JLabel();
        server_map = new javax.swing.JLabel();
        refresh_button = new javax.swing.JButton();
        join_button = new javax.swing.JButton();
        refresh_log = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Player Name", "Score", "Ping"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Player Name", "Score", "Ping"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        server_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        server_name.setText("Server Name:");

        server_player.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        server_player.setText("Players:");

        server_map.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        server_map.setText("Map:");

        refresh_button.setText("Refresh Server Status");
        refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_buttonActionPerformed(evt);
            }
        });

        join_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        join_button.setText("Join ");
        join_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                join_buttonActionPerformed(evt);
            }
        });

        refresh_log.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(server_map, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(server_player, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(server_name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(refresh_log, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(join_button, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(347, 347, 347))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(server_name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(server_player)
                    .addComponent(refresh_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(server_map)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(join_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(refresh_log)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        new Main_GUI();
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_buttonActionPerformed
        if (Main.ServerUpdateQuery > 10) {
            refresh_log.setBackground(Color.red);
            refresh_log.setText("You Can Refresh Server 10 Times Per Minute");
        } else {
            refresh_log.setText(" ");
            try {
                updateTable();
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_refresh_buttonActionPerformed

    private void join_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_join_buttonActionPerformed

        File file = new File("Multiplayer.log");

        // Create Multiplayer.log File Not Exists
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }

        // Flush Multiplayer.log File
        try {
            FileOutputStream flusher = new FileOutputStream(file);
            flusher.write(("").getBytes());
            flusher.close();
        } catch (Exception ex) {
            // Ignore
        }

        // Prepare Join
        if (this.server.PasswordStatus.contains("AEPEM")) {
            if (!isServerJoinButtonPressed) {
                new Join(this.server.ip, String.valueOf(this.server.port), generateJoinerID(), this.server.name).start();
            }
        } else if (this.server.PasswordStatus.contains("Yes")) {
            if (!isServerJoinButtonPressed) {
                new ManualPasswordJoin(this.server.ip, String.valueOf(this.server.port)).start();
            }
        }

    }//GEN-LAST:event_join_buttonActionPerformed

    public void updateTable() throws IOException {
        this.ServerData = this.server.updateServerStatus();
        this.players = this.server.getPlayers();

        int IGI = 0;
        int Cons = 0;

        refresh_log.setText("");

        if (this.players == null || ServerData == null) {
            refresh_log.setText("[ERROR] Unable To Update Server Status");
            refresh_log.setForeground(Color.red);
            Refresh_ERROR = true;
        } else if (this.players != null || ServerData != null) {

            if (Refresh_ERROR) {
                refresh_log.setText("[SUCCESS] Server Status Updated Successfully");
                refresh_log.setForeground(Color.green);
                Refresh_ERROR = false;
            }

            Properties Data = new Properties();
            InputStream input = new ByteArrayInputStream(ServerData.getBytes(StandardCharsets.UTF_8.name()));
            Data.load(input);

            server_name.setText(Data.getProperty("ServerName"));
            server_map.setText(Data.getProperty("ServerMapAndTime"));
            server_player.setText(Data.getProperty("ServerPlayer"));

            Main.ServerUpdateQuery++;

            for (int i = 0; i < 34; i++) {
                this.jTable1.setValueAt(null, i, 0);
                this.jTable1.setValueAt(null, i, 1);
                this.jTable1.setValueAt(null, i, 2);
                this.jTable1.setValueAt(null, i, 3);
                this.jTable2.setValueAt(null, i, 0);
                this.jTable2.setValueAt(null, i, 1);
                this.jTable2.setValueAt(null, i, 2);
                this.jTable2.setValueAt(null, i, 3);
            }

            for (Player player : this.players) {
                if (player != null) {
                    if (player.getTeam().equals("0")) {
                        this.jTable1.setValueAt(player.getID(), IGI, 0);
                        this.jTable1.setValueAt(player.getNick(), IGI, 1);
                        this.jTable1.setValueAt(player.getStats(), IGI, 2);
                        this.jTable1.setValueAt(player.getPing(), IGI, 3);
                        IGI++;
                    } else {
                        this.jTable2.setValueAt(player.getID(), Cons, 0);
                        this.jTable2.setValueAt(player.getNick(), Cons, 1);
                        this.jTable2.setValueAt(player.getStats(), Cons, 2);
                        this.jTable2.setValueAt(player.getPing(), Cons, 3);
                        Cons++;
                    }
                }
            }
        }
    }

    public static String SHA(String Filename) {
        StringBuffer hexString = null;
        FileInputStream fis = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            fis = new FileInputStream(Filename);

            byte[] dataBytes = new byte[1024];

            int nread = 0;

            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }

            byte[] mdbytes = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            hexString = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
            }

            return hexString.toString().trim();
        } catch (FileNotFoundException e) {
            if (Filename.contains("igi2_game")) {
                JOptionPane.showMessageDialog(null, "igi2_game.exe File Not Found. Your Anti-Virus Might Detected It As False-Positive Virus\nAnd Removed It. Put igi2_game.exe in Your Anti-Virus Whitelist or Exception List\nAnd Try Running IGI-2 Multiplayer Launcher As Administrator");
                System.exit(1);
            } else {
                JOptionPane.showMessageDialog(null, "File \"" + Filename + "\" Not Found.\nPlease Run Launcher As Administrator Try Again Or Reinstall IGI-2 Multiplayer Essentials.\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Error 100 | Files Not Found", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Files. Make Sure All Files Are Correctly Installed And Launcher Have Administrator Rights.\nIf Problem Still Persists, Contact Support at: aayush@igi2.co.in for further help.", "Error 100", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, "Unable To Process Algorithm On Game Files.\nMake Sure Launcher Have Administrator Rights To Access Game Files\nContact Support at: \"aayush@igi2.co.in\" for further help.", "Unable To Access File", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    // Ignore
                }
            }
        }
        return null;
    }

    private String generateJoinerID() {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");
        sdf.setTimeZone(TimeZone.getTimeZone("IST"));

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
        }

        md.update(sdf.format(new Date()).getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton join_button;
    private javax.swing.JButton refresh_button;
    private javax.swing.JLabel refresh_log;
    public javax.swing.JLabel server_map;
    public javax.swing.JLabel server_name;
    public javax.swing.JLabel server_player;
    // End of variables declaration//GEN-END:variables
}
