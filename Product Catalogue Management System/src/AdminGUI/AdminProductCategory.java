package AdminGUI;

import assignment.productManager;
import AdminGUI.AdminEditProfile;
import ProductManagerGUI.PMManageProductItem;
import ProductManagerGUI.PMProductCategory;
import assignment.Admin;
import assignment.FileIO;
import assignment.ProductCategory;
import assignment.ProductItem;
import assignment.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminProductCategory extends javax.swing.JFrame {
    Admin admin;
    productManager ProductManager;
    ProductItem productItem;
    ProductCategory category;
    Supplier supplier;
    
    public AdminProductCategory(Admin AD) throws IOException {
        initComponents();
        this.admin = AD;
        this.category = new ProductCategory();
        JTable CTTable = this.CategoryTable;
        FileIO fileIO = new FileIO();
        File file = fileIO.searchFilePath("ProductCategory.txt");
        String filepath = file.getAbsolutePath();
        String[] ItemcolumnsName = {"ID", "Name", "Description"};
        fileIO.buildTable(file, CTTable, ItemcolumnsName);
    }

    public void ResetEverything() {
        DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
        model.setRowCount(0);
        JTable CTTable = this.CategoryTable;
        FileIO fileIO = new FileIO();
        File file = fileIO.searchFilePath("ProductCategory.txt");
        String[] ItemcolumnsName = {"ID", "Name", "Description"};
        try {
            fileIO.buildTable(file, CTTable, ItemcolumnsName);
        } catch (IOException ex) {
            Logger.getLogger(PMProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.CategoryIDInput.setText(null);
        this.CategoryNameInput.setText(null);
        this.DescriptionInput.setText(null);
        this.SearchCategoryInput.setText("Enter Category ID");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        CategoryTable = new javax.swing.JTable();
        ProductCategoryLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        DescriptionLabel = new javax.swing.JLabel();
        SearchCategoryIDLabel = new javax.swing.JLabel();
        CategoryIDInput = new javax.swing.JTextField();
        NameLabel = new javax.swing.JLabel();
        CategoryNameInput = new javax.swing.JTextField();
        DescriptionInput = new javax.swing.JTextField();
        CategoryDetailsLabel = new javax.swing.JLabel();
        SearchCategoryInput = new javax.swing.JTextField();
        CategoryIDLabel = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HomeButton = new javax.swing.JButton();
        ManageButton = new javax.swing.JButton();
        EditProfileButton = new javax.swing.JButton();
        BacktoHomeButton = new javax.swing.JLabel();
        SystemRecordsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        CategoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(CategoryTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 690, 210));

        ProductCategoryLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        ProductCategoryLabel.setForeground(new java.awt.Color(0, 32, 63));
        ProductCategoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductCategoryLabel.setText("PRODUCT CATEGORY");
        jPanel1.add(ProductCategoryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 420, 60));

        AddButton.setText("ADD");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
        });
        jPanel1.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 120, -1));

        UpdateButton.setText("UPDATE");
        UpdateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateButtonMouseClicked(evt);
            }
        });
        jPanel1.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 160, -1));

        RemoveButton.setText("REMOVE");
        RemoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveButtonMouseClicked(evt);
            }
        });
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RemoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 460, 160, -1));

        DescriptionLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        DescriptionLabel.setText("DESCRIPTION:");
        jPanel1.add(DescriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 120, 30));

        SearchCategoryIDLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        SearchCategoryIDLabel.setText("Search Category:");
        jPanel1.add(SearchCategoryIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 120, 30));
        jPanel1.add(CategoryIDInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 250, 30));

        NameLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        NameLabel.setText("NAME:");
        jPanel1.add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 70, 30));

        CategoryNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryNameInputActionPerformed(evt);
            }
        });
        jPanel1.add(CategoryNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 250, 30));

        DescriptionInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionInputActionPerformed(evt);
            }
        });
        jPanel1.add(DescriptionInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 250, 40));

        CategoryDetailsLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        CategoryDetailsLabel.setText("CATEGORY DETAILS");
        jPanel1.add(CategoryDetailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        SearchCategoryInput.setText("Enter Category ID");
        SearchCategoryInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchCategoryInputMouseClicked(evt);
            }
        });
        SearchCategoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCategoryInputActionPerformed(evt);
            }
        });
        jPanel1.add(SearchCategoryInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 220, 30));

        CategoryIDLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        CategoryIDLabel.setText("CATEGORY ID:");
        jPanel1.add(CategoryIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 120, 30));

        SearchButton.setText("SEARCH");
        SearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchButtonMouseClicked(evt);
            }
        });
        jPanel1.add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 760, 600));

        jPanel2.setBackground(new java.awt.Color(0, 32, 63));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconFile/AccountIconBig.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMIN");

        HomeButton.setBackground(new java.awt.Color(255, 255, 255));
        HomeButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        HomeButton.setForeground(new java.awt.Color(0, 32, 63));
        HomeButton.setText("HOME");
        HomeButton.setBorder(new javax.swing.border.MatteBorder(null));
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        ManageButton.setBackground(new java.awt.Color(255, 255, 255));
        ManageButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ManageButton.setForeground(new java.awt.Color(0, 32, 63));
        ManageButton.setText("MANAGE");
        ManageButton.setBorder(new javax.swing.border.MatteBorder(null));
        ManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageButtonActionPerformed(evt);
            }
        });

        EditProfileButton.setBackground(new java.awt.Color(255, 255, 255));
        EditProfileButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        EditProfileButton.setForeground(new java.awt.Color(0, 32, 63));
        EditProfileButton.setText("EDIT PROFILE");
        EditProfileButton.setBorder(new javax.swing.border.MatteBorder(null));
        EditProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfileButtonActionPerformed(evt);
            }
        });

        BacktoHomeButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BacktoHomeButton.setForeground(new java.awt.Color(255, 255, 255));
        BacktoHomeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconFile/logout.png"))); // NOI18N
        BacktoHomeButton.setText("Back to Home");
        BacktoHomeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BacktoHomeButtonMouseClicked(evt);
            }
        });

        SystemRecordsButton.setBackground(new java.awt.Color(255, 255, 255));
        SystemRecordsButton.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        SystemRecordsButton.setForeground(new java.awt.Color(0, 32, 63));
        SystemRecordsButton.setText("SYSTEM RECORDS");
        SystemRecordsButton.setBorder(new javax.swing.border.MatteBorder(null));
        SystemRecordsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SystemRecordsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EditProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(ManageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HomeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SystemRecordsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BacktoHomeButton)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(EditProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SystemRecordsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(BacktoHomeButton)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        try {
            new AdminHome(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void ManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageButtonActionPerformed
        new AdminManage(admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_ManageButtonActionPerformed

    private void EditProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProfileButtonActionPerformed
        new AdminEditProfile(admin).setVisible(true);
        dispose();
    }//GEN-LAST:event_EditProfileButtonActionPerformed

    private void BacktoHomeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BacktoHomeButtonMouseClicked
        try {
            new AdminHome(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_BacktoHomeButtonMouseClicked

    private void SystemRecordsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SystemRecordsButtonActionPerformed
        try {
            new AdminSystemInfo(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminProductCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_SystemRecordsButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void CategoryNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryNameInputActionPerformed

    private void DescriptionInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionInputActionPerformed

    private void SearchCategoryInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCategoryInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchCategoryInputActionPerformed

    private void SearchCategoryInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchCategoryInputMouseClicked
        this.SearchCategoryInput.setText(null);
    }//GEN-LAST:event_SearchCategoryInputMouseClicked

    private void SearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonMouseClicked

    private void CategoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryTableMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
            int selectedRowIndex = CategoryTable.getSelectedRow();
            ProductItem Item = new ProductItem();
            Item.fileName = "ProductCategory.txt";
            FileIO getDetails = new FileIO();
            File filePath = getDetails.searchFilePath(Item.fileName);
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
            String[] ItemDetails = getDetails.retrieveDetails(filePath, primaryKey);

            CategoryIDInput.setText(ItemDetails[0]);
            CategoryNameInput.setText(ItemDetails[1]);
            DescriptionInput.setText(ItemDetails[2]);

            this.category.CategoryID = ItemDetails[0];
            this.category.CategoryName = ItemDetails[1];
            this.category.CategoryDescription = ItemDetails[2];

        } catch (FileNotFoundException ex) {
            System.out.println("Error in finding File");
        }
    }//GEN-LAST:event_CategoryTableMouseClicked

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        FileIO fileIO = new FileIO();
        String primaryKey = this.CategoryIDInput.getText().trim();
        File file = fileIO.searchFilePath("ProductCategory.txt");

        String filePath = file.getAbsolutePath();
        String newID = this.CategoryIDInput.getText().trim();
        String newName = this.CategoryNameInput.getText().trim();
        String newDescription = this.DescriptionInput.getText().trim();

        this.category.CategoryID = newID;
        this.category.CategoryName = newName;
        this.category.CategoryDescription = newDescription;

        String[] newDetails = {this.category.CategoryID, this.category.CategoryName,
            this.category.CategoryDescription};

        if (fileIO.writeDetails(file, newDetails, 3)) {
            JOptionPane.showMessageDialog(null, "Item succesfully added!");
        } else {
            JOptionPane.showMessageDialog(null, "Item not added...");
        }
        ResetEverything();
    }//GEN-LAST:event_AddButtonMouseClicked

    private void UpdateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateButtonMouseClicked
        FileIO fileIO = new FileIO();
        DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
        int selectedRowIndex = CategoryTable.getSelectedRow();
        String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
        File file = fileIO.searchFilePath("ProductCategory.txt");

        String filePath = file.getAbsolutePath();
        String newID = this.CategoryIDInput.getText().trim();
        String newName = this.CategoryNameInput.getText().trim();
        String newDescription = this.DescriptionInput.getText().trim();

        if (!newID.isEmpty() && !newID.equals(this.category.CategoryID)) {
            this.category.CategoryID = newID;
        }
        if (!newName.isEmpty() && !newName.equals(this.category.CategoryName)) {
            this.category.CategoryName = newName;
        }
        if (!newDescription.isEmpty() && !newDescription.equals(this.category.CategoryDescription)) {
            this.category.CategoryDescription = newDescription;
        }

        String[] newDetails = {this.category.CategoryID,this.category.CategoryName, this.category.CategoryDescription};

        try {
            if (FileIO.modifyFile(filePath, primaryKey, newDetails, 3)) {
                JOptionPane.showMessageDialog(null, "Item succesfully updated!");
            } else {
                JOptionPane.showMessageDialog(null, "Item not updated...");
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminEditProfile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something wrong");
        }
        ResetEverything();
    }//GEN-LAST:event_UpdateButtonMouseClicked

    private void RemoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveButtonMouseClicked
         FileIO fileIO = new FileIO();
        DefaultTableModel model = (DefaultTableModel) CategoryTable.getModel();
        int selectedRowIndex =CategoryTable.getSelectedRow();//get catrgoryIDInput
        String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
        File file = fileIO.searchFilePath("ProductCategory.txt");
        String filePath = file.getAbsolutePath();
        try {
            if(fileIO.removeDetail(filePath,primaryKey,3)){
                JOptionPane.showMessageDialog(null,"Item removed!");
            }else{
                JOptionPane.showMessageDialog(null,"Item failed to be removed!");
            }
        } catch (IOException ex) {
            Logger.getLogger(PMManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        ResetEverything();
    }//GEN-LAST:event_RemoveButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AdminProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminProductCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdminProductCategory(null).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AdminProductCategory.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel BacktoHomeButton;
    private javax.swing.JLabel CategoryDetailsLabel;
    private javax.swing.JTextField CategoryIDInput;
    private javax.swing.JLabel CategoryIDLabel;
    private javax.swing.JTextField CategoryNameInput;
    private javax.swing.JTable CategoryTable;
    private javax.swing.JTextField DescriptionInput;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JButton EditProfileButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton ManageButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel ProductCategoryLabel;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SearchCategoryIDLabel;
    private javax.swing.JTextField SearchCategoryInput;
    private javax.swing.JButton SystemRecordsButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
