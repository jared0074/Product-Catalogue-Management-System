package LoginGUI;

import AdminGUI.AdminHome;
import ProductManagerGUI.PMHome;
import SupplierGUI.SupplierHome;
import assignment.Admin;
import assignment.LoginValidation;
import assignment.Supplier;
import assignment.productManager;
import assignment.FileIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginInterface extends javax.swing.JFrame {

    public LoginInterface() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LoginMenuPanel = new javax.swing.JPanel();
        PasswordInput = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        PasswordLabel = new javax.swing.JLabel();
        LoginIDInput = new javax.swing.JTextField();
        UserIcon = new javax.swing.JLabel();
        LoginIDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN MENU");
        setBackground(new java.awt.Color(51, 255, 204));

        LoginMenuPanel.setBackground(new java.awt.Color(0, 32, 63));
        LoginMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordInputActionPerformed(evt);
            }
        });
        LoginMenuPanel.add(PasswordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 170, -1));

        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });
        LoginMenuPanel.add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        PasswordLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("Password");
        LoginMenuPanel.add(PasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));

        LoginIDInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginIDInputActionPerformed(evt);
            }
        });
        LoginMenuPanel.add(LoginIDInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 170, -1));

        UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconFile/AccountIconBig.png"))); // NOI18N
        LoginMenuPanel.add(UserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, -1));

        LoginIDLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        LoginIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        LoginIDLabel.setText("Login ID");
        LoginMenuPanel.add(LoginIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LoginMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LoginMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginIDInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginIDInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginIDInputActionPerformed

    private void PasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordInputActionPerformed


    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        LoginValidation check = new LoginValidation();
        char checkPos;
        String loginUserID = LoginIDInput.getText();
        String loginUserPassword = PasswordInput.getText();
        char[] LoginUserIDchar = loginUserID.toCharArray();
        try {
            if (loginUserID.equals(null)){
                JOptionPane.showMessageDialog(null,"No Input Detected!");
            }
            else{
            switch (LoginUserIDchar[0]) {
                case 'A':
                    checkPos = 'A';
                    Admin Admin = new Admin(null);
                    Admin.setFileName("Admin.txt");
                    try {
                        boolean checkValidation = check.checkValidation(Admin.getFileName(), checkPos, loginUserID, loginUserPassword);
                        if (checkValidation == true) {
                            JOptionPane.showMessageDialog(null, "Successful Login");
                            FileIO read = new FileIO();
                            File filePath = FileIO.searchFilePath(Admin.getFileName());
                            String[] details = read.retrieveDetails(filePath, loginUserID);
                            Admin.createObj(details);
                            AdminHome AdminPage = new AdminHome(Admin);
                            read.writeLoginRecords("Admin", loginUserID, "Login", "Success");
                            AdminPage.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
                            FileIO read = new FileIO();
                            read.writeLoginRecords("Admin", loginUserID, "Login", "Fail");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 'P':
                    checkPos = 'P';
                    productManager PM = new productManager(null);
                    PM.setFileName("ProductManager.txt");
                     {
                        try {
                            boolean checkValidation = check.checkValidation(PM.getFileName(), checkPos, loginUserID, loginUserPassword);
                            if (checkValidation == true) {
                                JOptionPane.showMessageDialog(null, "Successful Login");
                                FileIO read = new FileIO();
                                File filePath = FileIO.searchFilePath(PM.getFileName());
                                String[] details = read.retrieveDetails(filePath, loginUserID);
                                PM.createObj(details);
                                PMHome PMPage = new PMHome(PM);
                                read.writeLoginRecords("Product Manager", loginUserID, "Login", "Success");
                                PMPage.setVisible(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
                                FileIO read = new FileIO();
                                read.writeLoginRecords("Product Manager", loginUserID, "Login", "Fail");
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case 'S':
                    checkPos = 'S';
                    Supplier SP = new Supplier(null);
                    SP.setFileName("Supplier.txt");
                     {
                        try {
                            boolean checkValidation = check.checkValidation(SP.getFileName(), checkPos, loginUserID, loginUserPassword);
                            if (checkValidation == true) {
                                JOptionPane.showMessageDialog(null, "Successful Login");
                                FileIO read = new FileIO();
                                File filePath = FileIO.searchFilePath(SP.getFileName());
                                String[] details = read.retrieveDetails(filePath, loginUserID);
                                SP.createObj(details);
                                SupplierHome SupplierPage = new SupplierHome(SP);
                                read.writeLoginRecords("Supplier", loginUserID, "Login", "Success");
                                SupplierPage.setVisible(true);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
                                FileIO read = new FileIO();
                                read.writeLoginRecords("Supplier", loginUserID, "Login", "Fail");
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Username!");
                    FileIO read = new FileIO();
                     {
                        try {
                            read.writeLoginRecords("Invalid", loginUserID, "Login", "Fail");
                        } catch (IOException ex) {
                            Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }}
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, "No input detected!");
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginInterface().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JTextField LoginIDInput;
    private javax.swing.JLabel LoginIDLabel;
    private javax.swing.JPanel LoginMenuPanel;
    private javax.swing.JPasswordField PasswordInput;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UserIcon;
    // End of variables declaration//GEN-END:variables
}
