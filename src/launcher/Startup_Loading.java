
package launcher;

/**
 *
 * @author Hyper
 */
public class Startup_Loading extends javax.swing.JFrame {

    public Startup_Loading() {
        initComponents();
        setVisible(true);
    }

    public void setProcess(String process) {
        process_name.setText(process);
    }

    public void setProcessTitle(String title) {
        process_title.setText(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loading_pane = new javax.swing.JPanel();
        loading_gif = new javax.swing.JLabel();
        process_title = new javax.swing.JLabel();
        process_name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Starting...");
        setUndecorated(true);

        loading_pane.setBackground(new java.awt.Color(250, 250, 250));

        loading_gif.setIcon(new javax.swing.ImageIcon("IGI-2 Multiplayer Launcher Files\\res\\Launcher.2.Launcher"));

        process_title.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        process_title.setText("Starting IGI-2 Multiplayer Launcher");

        process_name.setText("Starting...");

        javax.swing.GroupLayout loading_paneLayout = new javax.swing.GroupLayout(loading_pane);
        loading_pane.setLayout(loading_paneLayout);
        loading_paneLayout.setHorizontalGroup(
            loading_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loading_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loading_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loading_paneLayout.createSequentialGroup()
                        .addComponent(process_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loading_paneLayout.createSequentialGroup()
                        .addGap(0, 61, Short.MAX_VALUE)
                        .addComponent(process_title)
                        .addGap(59, 59, 59))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loading_paneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loading_gif, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        loading_paneLayout.setVerticalGroup(
            loading_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loading_paneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(process_title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loading_gif, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(process_name)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loading_pane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loading_pane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel loading_gif;
    private static javax.swing.JPanel loading_pane;
    private javax.swing.JLabel process_name;
    public javax.swing.JLabel process_title;
    // End of variables declaration//GEN-END:variables
}
