package NGO;

import ALLMAINFILES.NAVBar;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ngo_blood_collection extends javax.swing.JFrame {

    String f_id = null;

    public ngo_blood_collection(String g_id) {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\krishna\\Desktop\\KIIT\\UpdatedBloodBuddies\\src\\ALLMAINFILES\\blood-donation.png");
        this.setIconImage(icon);
        setBounds(-7, -7, 1600, 890);
        f_id = g_id;
        System.out.println(f_id);
        search.setForeground(Color.GRAY);

        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1.setBackground(new Color(83, 173, 202));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1.setBackground(new Color(255, 204, 204));
            }
        });

        search.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (search.getText().equals("Search")) {
                    search.setText("");
                    search.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (search.getText().isEmpty()) {
                    search.setForeground(Color.GRAY);
                    search.setText("Search");
                }
            }
        });
        try {
            String myUrl = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try ( Connection conn = DriverManager.getConnection(myUrl, "rootze", "root1717")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select camp_id,o_positive,o_negative,ab_positive,ab_negative,a_positive,a_negative,b_positive,b_negative from blood_collection where ngo_id='" + f_id + "'");
                Object columnHeaders[] = {"Camp ID", "O+ in unit", "O- in unit", "AB+ in unit", "AB- in unit", "A+ in unit", "A- in unit", "B+ in unit", "B- in unit"};
                ResultSetMetaData rsmd;
                DefaultTableModel dtm = new DefaultTableModel();
                rsmd = (ResultSetMetaData) rs.getMetaData();
                int count = rsmd.getColumnCount();
                dtm.setColumnIdentifiers(columnHeaders);
                while (rs.next()) {
                    Vector row = new Vector();
                    for (int i = 1; i <= count; i++) {
                        row.addElement(rs.getString(i));
                    }
                    dtm.addRow(row);
                }
                jTable1.setModel(dtm);
            }
        } catch (ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(this, e);
            System.out.println("NGO Blood Collection");
        }
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

        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button1 = new swing.Button();
        search = new javax.swing.JTextField();
        button2 = new swing.Button();
        l1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Collections");
        setBackground(new java.awt.Color(255, 255, 255));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Camp ID","O+ in unit","O- in unit","AB+ in unit","AB- in unit","A+ in unit","A- in unit","B+ in unit","B- in unit"}));
        combo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboItemStateChanged(evt);
            }
        });
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jTable1.setMaximumSize(new java.awt.Dimension(1500, 900));
        jTable1.setMinimumSize(new java.awt.Dimension(1500, 900));
        jTable1.setPreferredSize(new java.awt.Dimension(1500, 900));
        jScrollPane1.setViewportView(jTable1);

        button1.setBackground(new java.awt.Color(255, 204, 204));
        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setText("Find");
        button1.setFocusable(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(255, 204, 204));
        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setText("Back");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NGO/NormalSearch.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addGap(6, 6, 6))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(575, 575, 575)
                    .addComponent(l1)
                    .addContainerGap(1025, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(422, 422, 422)
                    .addComponent(l1)
                    .addContainerGap(478, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void filter(String fill, String text) {
        try {
            String myUrl = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try ( Connection conn = DriverManager.getConnection(myUrl, "rootze", "root1717")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select camp_id,o_positive,o_negative,ab_positive,ab_negative,a_positive,a_negative,b_positive,b_negative from blood_collection where ngo_id='" + f_id + "' and " + fill + " like '" + text + "%'");
                Object columnHeaders[] = {"Camp ID", "O+ in unit", "O- in unit", "AB+ in unit", "AB- in unit", "A+ in unit", "A- in unit", "B+ in unit", "B- in unit"};
                com.mysql.cj.jdbc.result.ResultSetMetaData rsmd;
                DefaultTableModel dtm = new DefaultTableModel();
                rsmd = (com.mysql.cj.jdbc.result.ResultSetMetaData) rs.getMetaData();
                int count = rsmd.getColumnCount();
                dtm.setColumnIdentifiers(columnHeaders);
                int rowcount = 0;
                while (rs.next()) {
                    Vector row = new Vector();
                    for (int i = 1; i <= count; i++) {
                        row.addElement(rs.getString(i));
                    }
                    dtm.addRow(row);
                    rowcount = rs.getRow();
                }
                if (rowcount < 1) {
                    JOptionPane.showMessageDialog(this, "No records found!", "Data", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                jTable1.setModel(dtm);
            }
        } catch (ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(this, e);
            System.out.println("NGO Blood Collection");
        }
    }

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        try {
            if (search.getText().isEmpty() || search.getText().equals("Search")) {
                JOptionPane.showMessageDialog(this, "What do you want to search?", "Search", JOptionPane.WARNING_MESSAGE);
                return;
            }
            System.out.println(combo.getSelectedItem());
            if (combo.getSelectedItem() == "Camp ID") {
                filter("camp_id", search.getText());
            }
            if (combo.getSelectedItem() == "O+ in unit") {
                filter("o_positive", search.getText());
            }
            if (combo.getSelectedItem() == "O- in unit") {
                filter("o_negative", search.getText());
            }
            if (combo.getSelectedItem() == "AB+ in unit") {
                filter("ab_positive", search.getText());
            }
            if (combo.getSelectedItem() == "AB- in unit") {
                filter("ab_negative", search.getText());
            }
            if (combo.getSelectedItem() == "A+ in unit") {
                filter("a_positive", search.getText());
            }
            if (combo.getSelectedItem() == "A- in unit") {
                filter("a_negative", search.getText());
            }
            if (combo.getSelectedItem() == "B+ in unit") {
                filter("b_positive", search.getText());
            }
            if (combo.getSelectedItem() == "B- in unit") {
                filter("b_negative", search.getText());
            }
        } catch (Exception e) {
            System.out.println("NGO Blood Collection");
        }

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        new ngo_blood_donation_details(f_id).setVisible(true);
        setVisible(false);


    }//GEN-LAST:event_button2ActionPerformed

    private void comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboItemStateChanged

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

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
                if ("FlatLaf Light".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String str = null;
                new ngo_blood_collection(str).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Button button2;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel l1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
