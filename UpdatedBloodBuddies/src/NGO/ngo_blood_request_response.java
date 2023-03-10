package NGO;

import ALLMAINFILES.NAVBar;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ngo_blood_request_response extends javax.swing.JFrame {

    String f_id = null;

    public ngo_blood_request_response(String g_id) {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\krishna\\Desktop\\KIIT\\UpdatedBloodBuddies\\src\\ALLMAINFILES\\blood-donation.png");
        this.setIconImage(icon);
        setBounds(-7, -7, 1600, 890);
        f_id = g_id;
        System.out.println(f_id);
        search.setForeground(Color.GRAY);

        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button3.setBackground(new Color(83, 173, 202));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button3.setBackground(new Color(255, 204, 204));
            }
        });

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
            try (Connection conn = DriverManager.getConnection(myUrl, "rootze", "root1717")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select requested_id,hospital_id,hos_name,phone,email,street,city,pincode,state,o_positive,o_negative,ab_positive,ab_negative,a_positive,a_negative,b_positive,b_negative,msg from hospital_blood_requested where status='Requested'");
                Object columnHeaders[] = {"Requested ID", "Hospital ID", "Hospital Name", "Phone", "E-Mail", "Street", "City", "Pincode", "State", "O+ in unit", "O- in unit", "AB+ in unit", "AB- in unit", "A+ in unit", "A- in unit", "B+ in unit", "B- in unit", "Message"};
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
            System.out.println("NGO Blood Request Response");
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
        button3 = new swing.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Blood Request Response");
        setBackground(new java.awt.Color(255, 255, 255));

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Requested ID", "Hospital ID", "Hospital Name", "Phone", "E-Mail", "Street", "City", "Pincode", "State", "O+ in unit", "O- in unit", "AB+ in unit", "AB- in unit", "A+ in unit", "A- in unit", "B+ in unit", "B- in unit", "Message"}));
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
                {1, "fd", 3, "dfgddf"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setMaximumSize(new java.awt.Dimension(1500, 900));
        jTable1.setMinimumSize(new java.awt.Dimension(1500, 900));
        jTable1.setPreferredSize(new java.awt.Dimension(1500, 900));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
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

        button2.setBackground(new java.awt.Color(255, 204, 204));
        button2.setForeground(new java.awt.Color(0, 0, 0));
        button2.setText("Back");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NGO/NormalSearch.png"))); // NOI18N

        button3.setBackground(new java.awt.Color(255, 204, 204));
        button3.setForeground(new java.awt.Color(0, 0, 0));
        button3.setText("Reload");
        button3.setFocusable(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGap(6, 6, 6))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(586, 586, 586)
                    .addComponent(l1)
                    .addContainerGap(1014, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(378, 378, 378)
                    .addComponent(l1)
                    .addContainerGap(390, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void blood_response(int o_p, int o_n, int ab_p, int ab_n, int a_p, int a_n, int b_p, int b_n, int req_id) {
        try {
            String myUrl1 = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn1 = DriverManager.getConnection(myUrl1, "rootze", "root1717")) {
                String sqlUpdate = "update blood_collection set o_positive=o_positive-?,o_negative=o_negative-?,ab_positive=ab_positive-?,ab_negative=ab_negative-?,a_positive=a_positive-?,a_negative=a_negative-?,b_positive=b_positive-?,b_negative=b_negative-? where camp_id=(select camp_id from ngo_table where ngo_id=(select ngo_id from hospital_blood_requested where requested_id=?))";
                PreparedStatement pstmt = conn1.prepareStatement(sqlUpdate);
                pstmt.setInt(1, o_p);
                pstmt.setInt(2, o_n);
                pstmt.setInt(3, ab_p);
                pstmt.setInt(4, ab_n);
                pstmt.setInt(5, a_p);
                pstmt.setInt(6, a_n);
                pstmt.setInt(7, b_p);
                pstmt.setInt(8, b_n);
                pstmt.setInt(9, req_id);
                pstmt.executeUpdate();
                conn1.close();
            }
        } catch (ClassNotFoundException | SQLException e) {
//            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("NGO Blood Request Response");
        }
    }

    private void filter(String fill, String text) {
        try {
            String myUrl = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(myUrl, "rootze", "root1717")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select requested_id,hospital_id,hos_name,phone,email,street,city,pincode,state,o_positive,o_negative,ab_positive,ab_negative,a_positive,a_negative,b_positive,b_negative,msg from hospital_blood_requested where status='Requested' and " + fill + " like '" + text + "%'");
                Object columnHeaders[] = {"Requested ID", "Hospital ID", "Hospital Name", "Phone", "E-Mail", "Street", "City", "Pincode", "State", "O+ in unit", "O- in unit", "AB+ in unit", "AB- in unit", "A+ in unit", "A- in unit", "B+ in unit", "B- in unit", "Message"};
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
            System.out.println("NGO Blood Request Response");
        }
    }

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        try {
            if (search.getText().isEmpty() || search.getText().equals("Search")) {
                JOptionPane.showMessageDialog(this, "What do you want to search?", "Search", JOptionPane.WARNING_MESSAGE);
                return;
            }
            System.out.println(combo.getSelectedItem());
            if (combo.getSelectedItem() == "Requested ID") {
                filter("requested_id", search.getText());
            }
            if (combo.getSelectedItem() == "Hospital ID") {
                filter("hospital_id", search.getText());
            }
            if (combo.getSelectedItem() == "Hospital Name") {
                filter("hos_name", search.getText());
            }
            if (combo.getSelectedItem() == "Phone") {
                filter("phone", search.getText());
            }
            if (combo.getSelectedItem() == "E-Mail") {
                filter("email", search.getText());
            }
            if (combo.getSelectedItem() == "Street") {
                filter("street", search.getText());
            }
            if (combo.getSelectedItem() == "City") {
                filter("city", search.getText());
            }
            if (combo.getSelectedItem() == "Pincode") {
                filter("pincode", search.getText());
            }
            if (combo.getSelectedItem() == "State") {
                filter("state", search.getText());
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
            if (combo.getSelectedItem() == "Message") {
                filter("msg", search.getText());
            }
        } catch (Exception e) {
            System.out.println("NGO Blood Request Response");
        }


    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        new ngo_blood_donation_details(f_id).setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_button2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:    
        int n_id = Integer.parseInt(f_id);
        try {
            String myUrl = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(myUrl, "rootze", "root1717")) {
                String sql = "SELECT ngo_name from ngo_table where ngo_id='" + n_id + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                String n_name = null;
                while (rs.next()) {
                    n_name = rs.getString(1);
                }
                try {
                    String buttons[] = {"Transfer", "Close"};
                    jTable1.setRowSelectionAllowed(true);
                    DefaultTableModel table_data_fetch = (DefaultTableModel) jTable1.getModel();
                    int selectedRowIndex = jTable1.getSelectedRow();
                    int requested_id = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 0).toString());
                    String second = table_data_fetch.getValueAt(selectedRowIndex, 1).toString();
                    String third = table_data_fetch.getValueAt(selectedRowIndex, 3).toString();
                    int o_p = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 9).toString());
                    int o_n = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 10).toString());
                    int ab_p = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 11).toString());
                    int ab_n = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 12).toString());
                    int a_p = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 13).toString());
                    int a_n = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 14).toString());
                    int b_p = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 15).toString());
                    int b_n = Integer.parseInt(table_data_fetch.getValueAt(selectedRowIndex, 16).toString());
                    int n = JOptionPane.showOptionDialog(
                            this,
                            "Requested ID:  " + requested_id + "\n" + "Hospital ID:   " + second
                            + "\n" + "Hospital Name:  " + third,
                            "Details",
                            JOptionPane.OK_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            buttons,
                            0);

                    if (n == 0) {
                        System.out.println("Tra");
                        try {
                            System.out.println("Tra");
                            try {
                                System.out.println("Tra");
                                String myUrl2 = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                try (Connection conn2 = DriverManager.getConnection(myUrl2, "rootze", "root1717")) {
                                    String sql2 = "SELECT o_positive,o_negative,ab_positive,ab_negative,a_positive,a_negative,b_positive,b_negative from blood_collection where ngo_id='" + f_id + "'";
                                    Statement stmt2 = conn2.createStatement();
                                    ResultSet rs2 = stmt2.executeQuery(sql2);
                                    while (rs2.next()) {
                                        int op = rs2.getInt(1);
                                        int on = rs2.getInt(2);
                                        int abp = rs2.getInt(3);
                                        int abn = rs2.getInt(4);
                                        int ap = rs2.getInt(5);
                                        int an = rs2.getInt(6);
                                        int bp = rs2.getInt(7);
                                        int bn = rs2.getInt(8);
                                        System.out.println(op + on + abp);
                                        if (op > o_p && on > o_n && abp > ab_p && abn > ab_n && ap > a_p && an > a_n && bp > b_p && bn > b_n) {
                                            blood_response(o_p, o_n, ab_p, ab_n, a_p, a_n, b_p, b_n, requested_id);
                                            JOptionPane.showMessageDialog(this, "Transfer it to the hospital!", "Transfer", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Not enough blood in collection to transfer!", "Transfer", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        }
                                        try {
                                            String myUrl1 = "jdbc:mysql://db4free.net:3306/project?zeroDateTimeBehavior=CONVERT_TO_NULL";
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            try (Connection conn1 = DriverManager.getConnection(myUrl1, "rootze", "root1717")) {
                                                String sqlUpdate = "update hospital_blood_requested "
                                                        + "set status='Transferred',"
                                                        + "ngo_id=?,"
                                                        + "ngo_name=? "
                                                        + "WHERE requested_id = ?";
                                                PreparedStatement pstmt = conn1.prepareStatement(sqlUpdate);
                                                pstmt.setInt(1, n_id);
                                                pstmt.setString(2, n_name);
                                                pstmt.setInt(3, requested_id);
                                                pstmt.executeUpdate();
                                                conn1.close();
                                            }
                                        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
//                                            JOptionPane.showMessageDialog(this, "Not enough blood in collection to transfer!", "Transfer", JOptionPane.WARNING_MESSAGE);
                                            JOptionPane.showMessageDialog(this, e, "Transfer", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        }
                                    }
                                    conn2.close();
                                } catch (Exception e) {
//                                    JOptionPane.showMessageDialog(this, "Not enough blood in collection to transfer!", "Transfer", JOptionPane.WARNING_MESSAGE);
                                    JOptionPane.showMessageDialog(this, e, "Transfer", JOptionPane.WARNING_MESSAGE);
                                    return;
                                }
                            } catch (ClassNotFoundException e) {
//                                JOptionPane.showMessageDialog(this, "Not enough blood in collection to transfer!", "Transfer", JOptionPane.WARNING_MESSAGE);
                                JOptionPane.showMessageDialog(this, e, "Transfer", JOptionPane.WARNING_MESSAGE);
                                return;
                            }

                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(this, e, "Transfer", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                } catch (HeadlessException | NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, e1, "Data", JOptionPane.WARNING_MESSAGE);
                    System.out.println("NGO Blood Request Response");
                }

                conn.close();
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e1) {
            JOptionPane.showMessageDialog(this, "Empty row!", "Data", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jTable1MouseClicked

    private void comboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboItemStateChanged

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        new ngo_blood_request_response(f_id).setVisible(true);
        setVisible(false);
        dispose();
    }//GEN-LAST:event_button3ActionPerformed

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
            java.util.logging.Logger.getLogger(ngo_blood_request_response.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_request_response.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_request_response.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ngo_blood_request_response.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ngo_blood_request_response(str).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Button button1;
    private swing.Button button2;
    private swing.Button button3;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel l1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
