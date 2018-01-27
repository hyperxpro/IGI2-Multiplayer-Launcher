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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.swing.JOptionPane;

public class WHOIS extends javax.swing.JFrame {

    public WHOIS() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        whois_output = new javax.swing.JTextArea();
        player_name = new javax.swing.JTextField();
        Find_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("IGI-2 Multiplayer WHOIS Database");

        jLabel1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 16)); // NOI18N
        jLabel1.setText("IGI-2 Multiplayer Launcher WHOIS Database");

        whois_output.setEditable(false);
        whois_output.setColumns(20);
        whois_output.setRows(5);
        whois_output.setWrapStyleWord(true);
        jScrollPane1.setViewportView(whois_output);

        player_name.setText("Enter Multiplayer Name Of The Player");
        player_name.setToolTipText("Enter Multiplayer Name Of The Player Whose Info You Want To Get");
        player_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                player_nameMouseClicked(evt);
            }
        });

        Find_btn.setText("Find");
        Find_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Find_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(player_name, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                        .addComponent(Find_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Find_btn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
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

    private void player_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_player_nameMouseClicked
        if (player_name.getText().equals("Enter Multiplayer Name Of The Player")) {
            player_name.setText("");
        }
    }//GEN-LAST:event_player_nameMouseClicked

    private void Find_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Find_btnActionPerformed

        {

            InputStream input = null;

            try {
                String Response = new ServerConnector("Query=WHOIS_INFO_REQUEST" + "\n" + "MP_Name=" + player_name.getText() + "\n" + "Identity=" + Main.UserIdentity).Server();

                Properties ResponseData = new Properties();
                input = new ByteArrayInputStream(Response.getBytes(StandardCharsets.UTF_8.name()));
                ResponseData.load(input);

                if (ResponseData.getProperty("Response").equals("Player_Not_Found")) {
                    JOptionPane.showMessageDialog(null, player_name.getText() + " Not Found In Database\nNOTE:Multiplayer Name is character sensitive.", "Player Not Found", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                whois_output.setText("");

                String Display = "Name: " + ResponseData.getProperty("Name") + "\n"
                        + "Username: " + ResponseData.getProperty("Username") + "\n"
                        + "Multiplayer Name: " + ResponseData.getProperty("MP_Name") + "\n"
                        + "Account Ray ID: " + ResponseData.getProperty("Account_Ray_ID") + "\n"
                        + "Joined IGI-2 Multiplayer Launcher On: " + ResponseData.getProperty("Join_Time");

                whois_output.setText(Display);

            } catch (UnsupportedEncodingException ex) {
            } catch (IOException ex) {
            } finally {
                try {
                    input.close();
                } catch (IOException ex) {
                }
            }
        }
        
    }//GEN-LAST:event_Find_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Find_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField player_name;
    private javax.swing.JTextArea whois_output;
    // End of variables declaration//GEN-END:variables
}
