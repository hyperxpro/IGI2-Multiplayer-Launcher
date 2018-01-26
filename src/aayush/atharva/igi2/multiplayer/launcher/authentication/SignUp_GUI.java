package aayush.atharva.igi2.multiplayer.launcher.authentication;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import launcher.StartUpProcess;

public class SignUp_GUI extends javax.swing.JFrame {

    public SignUp_GUI() {
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        confirm_password = new javax.swing.JLabel();
        first_password = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        signup_btn = new javax.swing.JButton();
        signin_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        mp_name = new javax.swing.JTextField();
        terms_and_conditions = new javax.swing.JCheckBox();
        T_C_Button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        last_password = new javax.swing.JPasswordField();

        password.setBackground(new java.awt.Color(36, 47, 65));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("jPasswordField1");
        password.setBorder(null);
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome To IGI-2 Multiplayer Launcher");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sign Up For IGI-2 Multiplayer Launcher");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 320, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 380, 10));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Your Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 210, 38));

        name.setBackground(new java.awt.Color(36, 47, 65));
        name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Enter Your Name");
        name.setToolTipText("Enter Your First Name");
        name.setBorder(null);
        name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameMouseClicked(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel2.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 371, 28));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 371, 10));

        confirm_password.setBackground(new java.awt.Color(36, 47, 65));
        confirm_password.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        confirm_password.setForeground(new java.awt.Color(255, 255, 255));
        confirm_password.setText("Confirm Password");
        confirm_password.setToolTipText("");
        jPanel2.add(confirm_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 200, -1));

        first_password.setBackground(new java.awt.Color(36, 47, 65));
        first_password.setForeground(new java.awt.Color(255, 255, 255));
        first_password.setText("jPasswordField1");
        first_password.setBorder(null);
        first_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                first_passwordMouseClicked(evt);
            }
        });
        first_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(first_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 371, 30));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 371, 10));

        signup_btn.setBackground(new java.awt.Color(97, 212, 195));
        signup_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signup_btn.setText("Sign Up");
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        jPanel2.add(signup_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 180, 40));

        signin_button.setBackground(new java.awt.Color(97, 212, 195));
        signin_button.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        signin_button.setText("Already Have Accout? Sign In");
        signin_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signin_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(signin_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 640, 230, -1));

        jLabel5.setBackground(new java.awt.Color(36, 47, 65));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password");
        jLabel5.setToolTipText("");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 115, -1));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 371, 10));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 139, 30));

        username.setBackground(new java.awt.Color(36, 47, 65));
        username.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Enter Your Username");
        username.setToolTipText("Enter Your Email");
        username.setBorder(null);
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 371, 28));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 371, 10));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("IGI-2 Multiplayer Name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 210, 30));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 371, 10));

        mp_name.setBackground(new java.awt.Color(36, 47, 65));
        mp_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        mp_name.setForeground(new java.awt.Color(255, 255, 255));
        mp_name.setText("Enter Your IGI-2 Multiplayer Name");
        mp_name.setToolTipText("Enter Your IGI-2 Multiplayer Name");
        mp_name.setBorder(null);
        mp_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mp_nameMouseClicked(evt);
            }
        });
        mp_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mp_nameActionPerformed(evt);
            }
        });
        jPanel2.add(mp_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 371, 28));

        terms_and_conditions.setBackground(new java.awt.Color(36, 47, 65));
        terms_and_conditions.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        terms_and_conditions.setForeground(new java.awt.Color(255, 255, 255));
        terms_and_conditions.setText("    I Accept Terms And Conditions      ");
        terms_and_conditions.setBorder(null);
        terms_and_conditions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terms_and_conditionsActionPerformed(evt);
            }
        });
        jPanel2.add(terms_and_conditions, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 250, -1));

        T_C_Button.setBackground(new java.awt.Color(97, 212, 195));
        T_C_Button.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        T_C_Button.setText("View Terms & Conditions");
        T_C_Button.setToolTipText("");
        T_C_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_C_ButtonActionPerformed(evt);
            }
        });
        jPanel2.add(T_C_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 200, -1));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 139, 30));

        email.setBackground(new java.awt.Color(36, 47, 65));
        email.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Enter Your Email");
        email.setToolTipText("Enter Your Email");
        email.setBorder(null);
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailMouseClicked(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 371, 28));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 371, 10));

        last_password.setBackground(new java.awt.Color(36, 47, 65));
        last_password.setForeground(new java.awt.Color(255, 255, 255));
        last_password.setText("jPasswordField1");
        last_password.setBorder(null);
        last_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                last_passwordMouseClicked(evt);
            }
        });
        last_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                last_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(last_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 371, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameMouseClicked
        if (name.getText().equals("Enter Your Name")) {
            name.setText("");
        }
    }//GEN-LAST:event_nameMouseClicked

    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed

        if (!first_password.getText().equals(last_password.getText())) {
            JOptionPane.showMessageDialog(null, "The password which you entered didn't match.\nPlease make sure you enter same password.", "Password Not Match", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!terms_and_conditions.isSelected()) {
            JOptionPane.showMessageDialog(null, "You didn't accepted Terms And Conditions.", "Cannot Continue", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check Characters
        {

            String Password = first_password.getText();
            String Name = name.getText();
            String Email = email.getText();
            String MP_Name = mp_name.getText();
            String Username = username.getText();
            String Characters = "\\ / : * ? \" < > |";

            // Space Filtering
            if (Password.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Your Password should not contain SPACE", "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Email.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Your Email should not contain SPACE", "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Username.contains(" ")) {
                JOptionPane.showMessageDialog(null, "Your Username should not contain SPACE", "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Characters Filtering
            if (Password.contains("\\") || Password.contains("/") || Password.contains(":") || Password.contains("*") || Password.contains("?") || Password.contains("\"") || Password.contains("<") || Password.contains(">") || Password.contains("|")) {
                JOptionPane.showMessageDialog(null, "Your Password should not contain any of the following characters:\n" + Characters, "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Name.contains("\\") || Name.contains("/") || Name.contains(":") || Name.contains("*") || Name.contains("?") || Name.contains("\"") || Name.contains("<") || Name.contains(">") || Name.contains("|")) {
                JOptionPane.showMessageDialog(null, "Your First Name should not contain any of the following characters:\n" + Characters, "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Email.contains("\\") || Email.contains("/") || Email.contains(":") || Email.contains("*") || Email.contains("?") || Email.contains("\"") || Email.contains("<") || Email.contains(">") || Email.contains("|")) {
                JOptionPane.showMessageDialog(null, "Your Email should not contain any of the following characters:\n" + Characters, "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (Username.contains("\\") || Username.contains("/") || Username.contains(":") || Username.contains("*") || Username.contains("?") || Username.contains("\"") || Username.contains("<") || Username.contains(">") || Username.contains("|") || Username.contains("@")) {
                JOptionPane.showMessageDialog(null, "Your Username should not contain any of the following characters:\n" + Characters + " @", "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (MP_Name.contains("\\") || MP_Name.contains("/") || MP_Name.contains(":") || MP_Name.contains("*") || MP_Name.contains("?") || MP_Name.contains("\"") || MP_Name.contains("<") || MP_Name.contains(">") || MP_Name.contains("|") || MP_Name.contains("[") || MP_Name.contains("]")) {
                JOptionPane.showMessageDialog(null, "Your Multiplayer Name should not contain any of the following characters:\n" + Characters, "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }

        }

        try {
            new SignUp(name.getText(), mp_name.getText(), email.getText(), username.getText(), first_password.getText(), getComputerName(), System.getProperty("os.name")).SignUp();
        } catch (IOException ex) {
        }

    }//GEN-LAST:event_signup_btnActionPerformed

       private String getComputerName() {
        Map<String, String> env = System.getenv();
        if (env.containsKey("COMPUTERNAME")) {
            return env.get("COMPUTERNAME");
        } else if (env.containsKey("HOSTNAME")) {
            return env.get("HOSTNAME");
        } else {
            return "Unknown Computer";
        }
    }
    
    
    private void signin_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signin_buttonActionPerformed
        new SignIn_GUI();
        dispose();
    }//GEN-LAST:event_signin_buttonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed

    }//GEN-LAST:event_passwordActionPerformed

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        if (username.getText().equals("Enter Your Username")) {
            username.setText("");
        }
    }//GEN-LAST:event_usernameMouseClicked

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        if (name.getText().equals("Enter Your Name")) {
            name.setText("");
        }
    }//GEN-LAST:event_nameActionPerformed

    private void first_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first_passwordActionPerformed

    }//GEN-LAST:event_first_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
    }//GEN-LAST:event_usernameActionPerformed

    private void mp_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mp_nameMouseClicked
        if (mp_name.getText().equals("Enter Your IGI-2 Multiplayer Name")) {
            mp_name.setText("");
        }
    }//GEN-LAST:event_mp_nameMouseClicked

    private void mp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mp_nameActionPerformed
        if (mp_name.getText().equals("Enter Your IGI-2 Multiplayer Name")) {
            mp_name.setText("");
        }
    }//GEN-LAST:event_mp_nameActionPerformed

    private void terms_and_conditionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terms_and_conditionsActionPerformed

    }//GEN-LAST:event_terms_and_conditionsActionPerformed

    private void T_C_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_C_ButtonActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("https://www.igi-2.com/Docs/IGI-2_Multiplayer_Launcher_Terms_And_Conditions.txt").toURI());
        } catch (MalformedURLException ex) {
        } catch (URISyntaxException | IOException ex) {
        }
    }//GEN-LAST:event_T_C_ButtonActionPerformed

    private void first_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_first_passwordMouseClicked
        first_password.setText("");
    }//GEN-LAST:event_first_passwordMouseClicked

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked
        password.setText("");
    }//GEN-LAST:event_passwordMouseClicked

    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        if (email.getText().equals("Enter Your Email")) {
            email.setText("");
        }
    }//GEN-LAST:event_emailMouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        if (email.getText().equals("Enter Your Email")) {
            email.setText("");
        }
    }//GEN-LAST:event_emailActionPerformed

    private void last_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_last_passwordMouseClicked
        last_password.setText("");
    }//GEN-LAST:event_last_passwordMouseClicked

    private void last_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_last_passwordActionPerformed

    }//GEN-LAST:event_last_passwordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton T_C_Button;
    private javax.swing.JLabel confirm_password;
    private static javax.swing.JTextField email;
    private static javax.swing.JPasswordField first_password;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private static javax.swing.JPasswordField last_password;
    private static javax.swing.JTextField mp_name;
    private static javax.swing.JTextField name;
    public static javax.swing.JPasswordField password;
    public static javax.swing.JButton signin_button;
    private javax.swing.JButton signup_btn;
    public static javax.swing.JCheckBox terms_and_conditions;
    private static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
