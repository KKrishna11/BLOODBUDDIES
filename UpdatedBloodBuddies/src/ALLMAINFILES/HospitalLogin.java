package ALLMAINFILES;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;


public class HospitalLogin extends javax.swing.JFrame {

    public HospitalLogin() {
        initComponents();
          Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\krishna\\Desktop\\KIIT\\UpdatedBloodBuddies\\src\\ALLMAINFILES\\blood-donation.png");
        setIconImage(icon);
        setBounds(-6, -6, 1600, 900);
        Socket sock = new Socket();
        InetSocketAddress addr = new InetSocketAddress("www.google.com", 80);
        try {
            sock.connect(addr, 3000);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, "Please connect to Internet,Otherwise data won't get updated on any page!");
        } finally {
            try {
                sock.close();
            } catch (IOException e) {
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginAndRegister1 = new HosLoginAndRegister.LoginAndRegister();
        panel1 = new java.awt.Panel();
        button1 = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BLOOD BANK MANAGEMENT SYSTEM");

        loginAndRegister1.setBackground(new java.awt.Color(255, 153, 153));
        loginAndRegister1.setPreferredSize(new java.awt.Dimension(1600, 900));
        loginAndRegister1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                loginAndRegister1FocusLost(evt);
            }
        });
        loginAndRegister1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginAndRegister1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginAndRegister1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginAndRegister1MouseReleased(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 153, 153));

        button1.setBackground(new java.awt.Color(255, 51, 51));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Back");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginAndRegister1, javax.swing.GroupLayout.PREFERRED_SIZE, 1433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loginAndRegister1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        dispose();        // TODO add your handling code here:
        new SelectionPage().setVisible(true);
    }//GEN-LAST:event_button1ActionPerformed

    private void loginAndRegister1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginAndRegister1MouseEntered
        // TODO add your handling code here:
        String stat=loginAndRegister1.l1.getText();
        System.out.println("Me"+stat);
        if("Login".equals(stat)){
            setVisible(false);
        }
    }//GEN-LAST:event_loginAndRegister1MouseEntered

    private void loginAndRegister1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginAndRegister1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_loginAndRegister1MouseClicked

    private void loginAndRegister1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginAndRegister1MouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_loginAndRegister1MouseReleased

    private void loginAndRegister1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginAndRegister1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_loginAndRegister1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospitalLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HospitalLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private HosLoginAndRegister.LoginAndRegister loginAndRegister1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}