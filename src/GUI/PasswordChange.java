/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yanukadeneth
 */
public class PasswordChange extends javax.swing.JFrame {

    /**
     * Creates new form PasswordChange
     */
    Statement stmt;
    String uname;
    private final static Logger logr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public PasswordChange() {
        initComponents();
        DBConnection();
    }

    public PasswordChange(String username) {
        initComponents();
        lbl_uname.setText(username);
        uname = username;
        DBConnection();
    }

    private void DBConnection() {

        //DB Connection
        try {
            DatabaseConnection dbcon = new DatabaseConnection();
            Connection con = DriverManager.getConnection(dbcon.GETDBURL(), dbcon.GETDBUSERNAME(), dbcon.GETDBPASSWORD());
            stmt = con.createStatement();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error : Database Connection Failed", JOptionPane.ERROR_MESSAGE);
            logr.log(Level.SEVERE, "Database Connection Failed", ex.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_uname = new javax.swing.JLabel();
        pass1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        pass2 = new javax.swing.JPasswordField();
        btn_confirm = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtbox_forgotpass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("New Password : ");

        jLabel2.setText("Username : ");

        lbl_uname.setText("jLabel3");

        jLabel4.setText("Confirm New Password : ");

        btn_confirm.setText("Confirm");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel3.setText("Forgot Password Hint : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_uname))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_confirm)
                                .addGap(18, 18, 18)
                                .addComponent(btn_reset)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cancel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pass2)
                                    .addComponent(pass1)
                                    .addComponent(txtbox_forgotpass, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_cancel, btn_confirm, btn_reset});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_uname))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtbox_forgotpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_confirm)
                    .addComponent(btn_reset)
                    .addComponent(btn_cancel))
                .addGap(35, 35, 35))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_cancel, btn_confirm, btn_reset});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        String p1 = String.valueOf(pass1.getPassword());
        String p2 = String.valueOf(pass2.getPassword());
        String forgottxt = txtbox_forgotpass.getText();

        if (p1.length() < 8) {
            JOptionPane.showMessageDialog(rootPane, "Password length must be greater than 8", "Error : Length", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (forgottxt.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Please Enter a Forgot Password Hint", "Error : Hint Required", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (forgottxt.equalsIgnoreCase(p1) || forgottxt.equalsIgnoreCase(p2)) {
            JOptionPane.showMessageDialog(rootPane, "Password Hint should not contain the password", "Error : Hint must not be password", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!(p1.equals(p2))) {
            JOptionPane.showMessageDialog(rootPane, "Passwords are not equal", "Error : Both Passwords are not the same", JOptionPane.ERROR_MESSAGE);
        } else {

            try {

                PassEncryption pe = new PassEncryption();
                String en_pw = PassEncryption.generateSecurePassword(p1, pe.GetSalt());

                String qry1 = "UPDATE USERS\n"
                        + "SET PASSWORD = " + "'" + en_pw + "'" + "\n"
                        + "WHERE USERNAME = " + "'" + uname + "'";
                String qry2 = "UPDATE USERS\n"
                        + "SET FORGOTPASSHINT = " + "'" + forgottxt + "'" + "\n"
                        + "WHERE USERNAME = " + "'" + uname + "'";
                String qry3 = "UPDATE USERS\n"
                        + "SET RESETPASS = " + false + "\n"
                        + "WHERE USERNAME = " + "'" + uname + "'";

                stmt.executeUpdate(qry1);
                stmt.executeUpdate(qry2);
                stmt.executeUpdate(qry3);

                logr.config(uname + " : Updated Password and Password Hint Sucessfully");

                JOptionPane.showMessageDialog(rootPane, "Changed Password Sucessfully!", "Successful", JOptionPane.INFORMATION_MESSAGE);
                new Login_GUI().setVisible(true);
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error : Password Updation", JOptionPane.ERROR_MESSAGE);
                logr.severe(uname + " : Password Updation System Failed!");
            }

        }


    }//GEN-LAST:event_btn_confirmActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        pass1.setText("");
        pass2.setText("");
        txtbox_forgotpass.setText("");
        pass1.requestFocus();
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        new Login_GUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        Logman lm = new Logman();
        lm.SetupLogger(logr);

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
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordChange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JButton btn_reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_uname;
    private javax.swing.JPasswordField pass1;
    private javax.swing.JPasswordField pass2;
    private javax.swing.JTextField txtbox_forgotpass;
    // End of variables declaration//GEN-END:variables

}
