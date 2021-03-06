package AdminGUI;

import ProductManagerGUI.PMManageProductItem;
import assignment.Admin;
import assignment.FileIO;
import assignment.productManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class AdminManagePM extends javax.swing.JFrame {

    Admin admin;
    productManager PM = new productManager(null);

    public AdminManagePM(Admin Admin) throws IOException {
        initComponents();
        this.admin = Admin;
        JTable PMTable = this.ProductManagerTable;
        FileIO fileIO = new FileIO();
        File file = fileIO.searchFilePath("ProductManager.txt");
        String filepath = file.getAbsolutePath();
        String[] PMcolumnsName = {"PMID", "PMPassword", "PMName", "PMAddress", "PMEmail", "PMStatus"};
        fileIO.buildTable(file, PMTable, PMcolumnsName);
        TableColumn tcolPM = PMTable.getColumnModel().getColumn(1);
        PMTable.removeColumn(tcolPM);
    }

    public void ResetEverything() {
        DefaultTableModel model = (DefaultTableModel) ProductManagerTable.getModel();
        model.setRowCount(0);
        JTable PMTable = this.ProductManagerTable;
        FileIO fileIO = new FileIO();
        File file = fileIO.searchFilePath("ProductManager.txt");
        String[] PMcolumnsName = {"PMID", "PMPassword", "PMName", "PMAddress", "PMEmail", "PMStatus"};
        try {
            fileIO.buildTable(file, PMTable, PMcolumnsName);
        } catch (IOException ex) {
            Logger.getLogger(PMManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        TableColumn tcolPM = PMTable.getColumnModel().getColumn(1);
        PMTable.removeColumn(tcolPM);
        this.PMUserIDOutput.setText(null);
        this.PMPasswordOutput.setText(null);
        this.PMNameInput.setText(null);
        this.PMAddressInput.setText(null);
        this.PMEmailInput.setText(null);
        this.PMUserIDInput.setText("Enter UserID");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProfileButton = new javax.swing.JButton();
        ProductButton = new javax.swing.JButton();
        ManageProfileButton = new javax.swing.JButton();
        ManageProfileButton1 = new javax.swing.JButton();
        LogoutButton = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductManagerTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        SetStatusButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PMUserIDOutput = new javax.swing.JTextField();
        PMNameInput = new javax.swing.JTextField();
        PMAddressInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        PMEmailInput = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        PMPasswordOutput = new javax.swing.JPasswordField();
        ProductManagerDetailsLabel = new javax.swing.JLabel();
        PMUserIDInput = new javax.swing.JTextField();
        UserIDInputLabel = new javax.swing.JLabel();
        RefreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 32, 63));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconFile/AccountIconBig.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMIN");

        ProfileButton.setBackground(new java.awt.Color(255, 255, 255));
        ProfileButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ProfileButton.setForeground(new java.awt.Color(0, 32, 63));
        ProfileButton.setText("HOME");
        ProfileButton.setBorder(new javax.swing.border.MatteBorder(null));
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        ProductButton.setBackground(new java.awt.Color(255, 255, 255));
        ProductButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ProductButton.setForeground(new java.awt.Color(0, 32, 63));
        ProductButton.setText("MANAGE");
        ProductButton.setBorder(new javax.swing.border.MatteBorder(null));
        ProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductButtonActionPerformed(evt);
            }
        });

        ManageProfileButton.setBackground(new java.awt.Color(255, 255, 255));
        ManageProfileButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ManageProfileButton.setForeground(new java.awt.Color(0, 32, 63));
        ManageProfileButton.setText("EDIT PROFILE");
        ManageProfileButton.setBorder(new javax.swing.border.MatteBorder(null));
        ManageProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageProfileButtonActionPerformed(evt);
            }
        });

        ManageProfileButton1.setBackground(new java.awt.Color(255, 255, 255));
        ManageProfileButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ManageProfileButton1.setForeground(new java.awt.Color(0, 32, 63));
        ManageProfileButton1.setText("SYSTEM RECORDS");
        ManageProfileButton1.setBorder(new javax.swing.border.MatteBorder(null));
        ManageProfileButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageProfileButton1ActionPerformed(evt);
            }
        });

        LogoutButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconFile/logout.png"))); // NOI18N
        LogoutButton.setText("Back to Home");
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ManageProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ManageProfileButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogoutButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageProfileButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(LogoutButton)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ProductManagerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ProductManagerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductManagerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductManagerTable);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 32, 63));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MANAGE PRODUCT MANAGER");

        SetStatusButton.setText("SET STATUS");
        SetStatusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetStatusButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("ADDRESS:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("NAME:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("PASSWORD:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("USER ID:");

        PMUserIDOutput.setEditable(false);
        PMUserIDOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMUserIDOutputActionPerformed(evt);
            }
        });

        PMNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMNameInputActionPerformed(evt);
            }
        });

        PMAddressInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMAddressInputActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("EMAIL:");

        PMEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMEmailInputActionPerformed(evt);
            }
        });

        SearchButton.setText("Search");
        SearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchButtonMouseClicked(evt);
            }
        });
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        PMPasswordOutput.setEditable(false);

        ProductManagerDetailsLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ProductManagerDetailsLabel.setText("Product Manager Details");

        PMUserIDInput.setText("Enter UserID");
        PMUserIDInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PMUserIDInputMouseClicked(evt);
            }
        });
        PMUserIDInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PMUserIDInputActionPerformed(evt);
            }
        });

        UserIDInputLabel.setText("Input User ID:");

        RefreshButton.setText("REFRESH");
        RefreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(UserIDInputLabel)
                                .addGap(133, 133, 133)
                                .addComponent(PMUserIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SearchButton))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(SetStatusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(PMAddressInput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PMNameInput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PMPasswordOutput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PMUserIDOutput, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PMEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 92, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(ProductManagerDetailsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton)
                    .addComponent(PMUserIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserIDInputLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SetStatusButton)
                    .addComponent(RefreshButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProductManagerDetailsLabel)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PMUserIDOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PMPasswordOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(PMNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(PMAddressInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(PMEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateButton)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 760, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileButtonActionPerformed
        try {
            new AdminHome(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_ProfileButtonActionPerformed

    private void ProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductButtonActionPerformed
        new AdminManage(admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_ProductButtonActionPerformed

    private void ManageProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageProfileButtonActionPerformed
        new AdminEditProfile(admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_ManageProfileButtonActionPerformed

    private void ManageProfileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageProfileButton1ActionPerformed
        try {
            new AdminSystemInfo(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_ManageProfileButton1ActionPerformed

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        try {
            new AdminHome(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        FileIO pmFile = new FileIO();
        File file = pmFile.searchFilePath("ProductManager.txt");
        String filePath = file.getAbsolutePath();
        if (this.PMAddressInput.getText() != null
                || this.PMEmailInput.getText() != null
                || this.PMNameInput.getText() != null) {
            String newAddress = this.PMAddressInput.getText().trim();
            String newEmail = this.PMEmailInput.getText().trim();
            String newName = this.PMNameInput.getText().trim();

            if (!newName.isEmpty() && !newName.equals(this.PM.getUserName())) {
                this.PM.setUserName(newName);
            }
            if (!newEmail.isEmpty() && !newEmail.equals(this.PM.getUserEmail())) {
                this.PM.setUserEmail(newEmail);
            }
            if (!newAddress.isEmpty() && !newAddress.equals(this.PM.getUserAddress())) {
                this.PM.setUserAddress(newAddress);
            }
            String[] newDetails = {this.PM.getUserIdNum(), this.PM.getUserPassword(), newName, newAddress, newEmail, this.PM.getStatus()};

            try {
                if (FileIO.modifyFile(filePath, this.PMUserIDOutput.getText(), newDetails, 6)) {
                    JOptionPane.showMessageDialog(null, "Profile successfully updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "Profile failed to be updated!");
                }
            } catch (IOException ex) {
                Logger.getLogger(AdminEditProfile.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "No Input found!");
        }
        ResetEverything();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void PMUserIDOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMUserIDOutputActionPerformed

    }//GEN-LAST:event_PMUserIDOutputActionPerformed

    private void PMNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PMNameInputActionPerformed

    private void PMAddressInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMAddressInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PMAddressInputActionPerformed

    private void PMEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PMEmailInputActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        FileIO fileIO = new FileIO();
        File file = FileIO.searchFilePath("ProductManager.txt");

        try {
            if (PMUserIDInput.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ID input!");
            } else {
                if (!PMUserIDInput.getText().isEmpty()) {
                    String[] SearchedDetails = fileIO.retrieveDetails(file, PMUserIDInput.getText());
                    JTable PMTable = this.ProductManagerTable;
                    DefaultTableModel PMTableModel = new DefaultTableModel();
                    ProductManagerTable.setModel(PMTableModel);
                    if (SearchedDetails != null) {
                        String[] PMcolumnsName = {"ID", "Password", "Name", "Address", "Email", "Status"};
                        PMTableModel.setColumnIdentifiers(PMcolumnsName);
                        PMTableModel.addRow(SearchedDetails);
                        TableColumn tcolPM = PMTable.getColumnModel().getColumn(1);
                        PMTable.removeColumn(tcolPM);
                        JOptionPane.showMessageDialog(null, "ID found!");
                    } else {
                        JOptionPane.showMessageDialog(null, "ID not found!");
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void SetStatusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetStatusButtonActionPerformed
        File file = FileIO.searchFilePath("ProductManager.txt");
        String filePath = file.getAbsolutePath();
        if (!this.PMUserIDOutput.getText().isEmpty() && this.PM.getUserStatus().equals("Active")) {
            this.PM.setUserStatus("Inactive");
        } else if (!this.PMUserIDOutput.getText().isEmpty() && this.PM.getUserStatus().equals("Inactive")) {
            this.PM.setUserStatus("Active");
        }

        String[] newDetails = {this.PM.getUserIdNum(), this.PM.getUserPassword(), this.PM.getUserName(), this.PM.getUserAddress(), this.PM.getUserEmail(), this.PM.getUserStatus()};

        try {
            if (FileIO.modifyFile(filePath, this.PMUserIDOutput.getText(), newDetails, 6)) {
                JOptionPane.showMessageDialog(null, "Profile successfully updated!");
            } else {
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminEditProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResetEverything();
    }//GEN-LAST:event_SetStatusButtonActionPerformed

    private void ProductManagerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductManagerTableMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) ProductManagerTable.getModel();
            int selectedRowIndex = ProductManagerTable.getSelectedRow();
            productManager ProductM = new productManager(null);
            ProductM.setFileName("ProductManager.txt");
            FileIO getDetails = new FileIO();
            File filePath = getDetails.searchFilePath(ProductM.getFileName());
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
            String[] PMDetails = getDetails.retrieveDetails(filePath, primaryKey);
            this.PM.createObj(PMDetails);
            PMUserIDOutput.setText(PMDetails[0]);
            PMPasswordOutput.setText(PMDetails[1]);
            PMNameInput.setText(PMDetails[2]);
            PMAddressInput.setText(PMDetails[3]);
            PMEmailInput.setText(PMDetails[4]);
        } catch (FileNotFoundException ex) {
            System.out.println("No file found");
        }
    }//GEN-LAST:event_ProductManagerTableMouseClicked

    private void PMUserIDInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PMUserIDInputActionPerformed
        this.PMUserIDInput.setText(null);
    }//GEN-LAST:event_PMUserIDInputActionPerformed

    private void PMUserIDInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PMUserIDInputMouseClicked
        this.PMUserIDInput.setText(null);
    }//GEN-LAST:event_PMUserIDInputMouseClicked

    private void SearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMouseClicked
        FileIO fileIO = new FileIO();
        File file = FileIO.searchFilePath("ProductManager.txt");
        try {
            if (!PMUserIDInput.getText().isEmpty()) {
                String[] SearchedDetails = fileIO.retrieveDetails(file, PMUserIDInput.getText());
                JTable PMTable = this.ProductManagerTable;
                DefaultTableModel PMTable1 = new DefaultTableModel();
                ProductManagerTable.setModel(PMTable1);
                String[] PMcolumnsName = {"PMID", "PMPassword", "PMName", "PMAddress", "PMEmail", "PMStatus"};
                PMTable1.setColumnIdentifiers(PMcolumnsName);
                PMTable1.addRow(SearchedDetails);
                TableColumn tcolPM = PMTable.getColumnModel().getColumn(1);
                PMTable.removeColumn(tcolPM);
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SearchButtonMouseClicked

    private void RefreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RefreshButtonMouseClicked
        ResetEverything();
    }//GEN-LAST:event_RefreshButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AdminManagePM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminManagePM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminManagePM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminManagePM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminManagePM(null).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AdminManagePM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JButton ManageProfileButton;
    private javax.swing.JButton ManageProfileButton1;
    private javax.swing.JTextField PMAddressInput;
    private javax.swing.JTextField PMEmailInput;
    private javax.swing.JTextField PMNameInput;
    private javax.swing.JPasswordField PMPasswordOutput;
    private javax.swing.JTextField PMUserIDInput;
    private javax.swing.JTextField PMUserIDOutput;
    private javax.swing.JButton ProductButton;
    private javax.swing.JLabel ProductManagerDetailsLabel;
    public javax.swing.JTable ProductManagerTable;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton SetStatusButton;
    public javax.swing.JButton UpdateButton;
    private javax.swing.JLabel UserIDInputLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
