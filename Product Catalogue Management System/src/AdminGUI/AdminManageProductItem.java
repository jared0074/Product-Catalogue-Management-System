package AdminGUI;

import AdminGUI.AdminEditProfile;
import ProductManagerGUI.PMManageProductItem;
import assignment.Admin;
import assignment.FileIO;
import assignment.ProductCategory;
import assignment.ProductItem;
import assignment.Supplier;
import assignment.productManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminManageProductItem extends javax.swing.JFrame {

    Admin admin;
    productManager ProductManager;
    ProductItem productItem;
    ProductCategory category;
    Supplier supplier;

    public AdminManageProductItem(Admin AD) throws IOException {
        this.productItem = new ProductItem();
        initComponents();
        this.admin = AD;
        this.category = new ProductCategory();
        this.supplier = new Supplier(null);
        JTable ItemTable = this.ProductTable;
        FileIO fileIO = new FileIO();
        File file = fileIO.searchFilePath("ProductItem.txt");
        String filepath = file.getAbsolutePath();
        String[] ItemcolumnsName = {"ID", "Brand", "Name", "CategoryID", "Quantity", "Retail Price", "Description", "ImagePath", "SupplierID"};
        fileIO.buildTable(file, ItemTable, ItemcolumnsName);
        TableColumn tcolPM = ItemTable.getColumnModel().getColumn(7);
        ItemTable.removeColumn(tcolPM);
        CategoryComboBoxItems();
        SupplierComboBoxItems();
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(ImageOutputLabel.getWidth(), ImageOutputLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public void ResetEverything() {
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        model.setRowCount(0);
        JTable ItemTable = this.ProductTable;
        FileIO fileIO = new FileIO();
        File file = fileIO.searchFilePath("ProductItem.txt");
        String[] ItemcolumnsName = {"ID", "Brand", "Name", "CategoryID", "Quantity", "Retail Price", "Description", "ImagePath", "SupplierID"};
        try {
            fileIO.buildTable(file, ItemTable, ItemcolumnsName);
        } catch (IOException ex) {
            Logger.getLogger(PMManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        TableColumn tcolPM = ItemTable.getColumnModel().getColumn(7);
        ItemTable.removeColumn(tcolPM);
        this.ProductIDOutput.setText(null);
        this.BrandInput.setText(null);
        this.CategoryIDComboBox.setSelectedItem(null);
        this.DescriptionInput.setText(null);
        this.ImageInput.setText(null);
        this.ImageOutputLabel.setIcon(null);
        this.PriceInput.setText(null);
        this.ProductNameInput.setText(null);
        this.QuantityInput.setText(null);
        this.SupplierComboBox.setSelectedItem(null);
        this.ProductIDInput.setText("Enter Product ID");
    }

    public void CategoryComboBoxItems() {
        FileIO fileIO = new FileIO();
        File CategoryFile = fileIO.searchFilePath("ProductCategory.txt");
        ArrayList<String> AllDetails = null;
        try {
            CategoryIDComboBox.removeAllItems();
            AllDetails = fileIO.retrieveAllDetails(CategoryFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PMManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < AllDetails.size(); i++) {
            String record[] = AllDetails.get(i).split("\t");
            if (!record[0].isEmpty()) {
                CategoryIDComboBox.addItem(record[0]);
            }
        }
    }

    public void SupplierComboBoxItems() {
        FileIO fileIO = new FileIO();
        ArrayList<String> AllDetails = null;
        File SupplierFile = fileIO.searchFilePath("Supplier.txt");
        try {
            SupplierComboBox.removeAllItems();
            AllDetails = fileIO.retrieveAllDetails(SupplierFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PMManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < AllDetails.size(); i++) {
            String record[] = AllDetails.get(i).split("\t");
            if (!record[0].isEmpty()) {
                SupplierComboBox.addItem(record[0]);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProfileButton = new javax.swing.JButton();
        ProductButton = new javax.swing.JButton();
        ManageProfileButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JLabel();
        ManageProfileButton1 = new javax.swing.JButton();
        SidePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        ProductLabel = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        RemoveButton = new javax.swing.JButton();
        QuantityLabel = new javax.swing.JLabel();
        DescriptionInput = new javax.swing.JTextField();
        ProductItemLabel = new javax.swing.JLabel();
        ProductIDOutput = new javax.swing.JTextField();
        ProductNameLabel = new javax.swing.JLabel();
        ProductNameInput = new javax.swing.JTextField();
        DescriptionLabel = new javax.swing.JLabel();
        CategoryIDLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        BrandLabel = new javax.swing.JLabel();
        QuantityInput = new javax.swing.JTextField();
        PriceInput = new javax.swing.JTextField();
        BrandInput = new javax.swing.JTextField();
        SupplierInfoLabel = new javax.swing.JLabel();
        ImageLabel = new javax.swing.JLabel();
        UploadButton = new javax.swing.JButton();
        ImageInput = new javax.swing.JTextField();
        ImageOutputLabel = new javax.swing.JLabel();
        CategoryIDComboBox = new javax.swing.JComboBox<>();
        SupplierComboBox = new javax.swing.JComboBox<>();
        SearchProductLabel = new javax.swing.JLabel();
        ProductIDInput = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 32, 63));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        LogoutButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconFile/logout.png"))); // NOI18N
        LogoutButton.setText("Back to Home");
        LogoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutButtonMouseClicked(evt);
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
                            .addComponent(ManageProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(ProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ManageProfileButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogoutButton)))
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
                .addComponent(ProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageProfileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ManageProfileButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(LogoutButton)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        SidePanel.setBackground(new java.awt.Color(255, 255, 255));
        SidePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProductTable);

        SidePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 710, 140));

        ProductLabel.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        ProductLabel.setForeground(new java.awt.Color(0, 32, 63));
        ProductLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProductLabel.setText("PRODUCT ");
        SidePanel.add(ProductLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 420, 60));

        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });
        SidePanel.add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 540, 120, -1));

        UpdateButton.setText("UPDATE");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });
        SidePanel.add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 160, -1));

        RemoveButton.setText("REMOVE");
        RemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveButtonActionPerformed(evt);
            }
        });
        SidePanel.add(RemoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 160, -1));

        QuantityLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        QuantityLabel.setText("QUANTITY:");
        SidePanel.add(QuantityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, -1, 20));

        DescriptionInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionInputActionPerformed(evt);
            }
        });
        SidePanel.add(DescriptionInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 220, 120));

        ProductItemLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        ProductItemLabel.setText("PRODUCT ID:");
        SidePanel.add(ProductItemLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, 20));
        SidePanel.add(ProductIDOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 230, -1));

        ProductNameLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        ProductNameLabel.setText("PRODUCT NAME:");
        SidePanel.add(ProductNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 110, 20));

        ProductNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameInputActionPerformed(evt);
            }
        });
        SidePanel.add(ProductNameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 230, -1));

        DescriptionLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        DescriptionLabel.setText("DESCRIPTION:");
        SidePanel.add(DescriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, 20));

        CategoryIDLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        CategoryIDLabel.setText("CATEGORY ID:");
        SidePanel.add(CategoryIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, 20));

        PriceLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        PriceLabel.setText("PRICE:");
        SidePanel.add(PriceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, 20));

        BrandLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        BrandLabel.setText("BRAND:");
        SidePanel.add(BrandLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 120, 20));
        SidePanel.add(QuantityInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 70, -1));
        SidePanel.add(PriceInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 80, -1));
        SidePanel.add(BrandInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 210, -1));

        SupplierInfoLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        SupplierInfoLabel.setText("SUPPLIER ID:");
        SidePanel.add(SupplierInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, -1, 20));

        ImageLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        ImageLabel.setText("IMAGE:");
        SidePanel.add(ImageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, 20));

        UploadButton.setText("UPLOAD");
        UploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadButtonActionPerformed(evt);
            }
        });
        SidePanel.add(UploadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 80, 20));

        ImageInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImageInputActionPerformed(evt);
            }
        });
        SidePanel.add(ImageInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 170, 20));
        SidePanel.add(ImageOutputLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 180, 140));

        CategoryIDComboBox.setMaximumRowCount(100);
        CategoryIDComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoryIDComboBoxMouseClicked(evt);
            }
        });
        SidePanel.add(CategoryIDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 100, -1));

        SupplierComboBox.setMaximumRowCount(100);
        SupplierComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierComboBoxMouseClicked(evt);
            }
        });
        SidePanel.add(SupplierComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 100, -1));

        SearchProductLabel.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        SearchProductLabel.setText("SEARCH PRODUCT:");
        SidePanel.add(SearchProductLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        ProductIDInput.setText("Enter Product ID");
        ProductIDInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProductIDInputMouseClicked(evt);
            }
        });
        SidePanel.add(ProductIDInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 330, -1));

        SearchButton.setText("SEARCH");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        SidePanel.add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 120, -1));

        RefreshButton.setText("REFRESH");
        RefreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RefreshButtonMouseClicked(evt);
            }
        });
        SidePanel.add(RefreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 110, 30));

        getContentPane().add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 760, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileButtonActionPerformed
        try {
            new AdminHome(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
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

    private void LogoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutButtonMouseClicked
        try {
            new AdminHome(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_LogoutButtonMouseClicked

    private void ManageProfileButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageProfileButton1ActionPerformed
        try {
            new AdminSystemInfo(admin).setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(AdminManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_ManageProfileButton1ActionPerformed

    private void ProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductTableMouseClicked
        try {
            DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
            int selectedRowIndex = ProductTable.getSelectedRow();
            ProductItem Item = new ProductItem();
            Item.fileName = "ProductItem.txt";
            FileIO getDetails = new FileIO();
            File filePath = getDetails.searchFilePath(Item.fileName);
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
            String[] ItemDetails = getDetails.retrieveDetails(filePath, primaryKey);

            ProductIDOutput.setText(ItemDetails[0]);
            BrandInput.setText(ItemDetails[1]);
            ProductNameInput.setText(ItemDetails[2]);
            CategoryIDComboBox.setSelectedItem(ItemDetails[3]);
            QuantityInput.setText(ItemDetails[4]);
            PriceInput.setText(ItemDetails[5]);
            DescriptionInput.setText(ItemDetails[6]);
            ImageInput.setText(ItemDetails[7]);
            SupplierComboBox.setSelectedItem(ItemDetails[8]);
            File file = new File(ItemDetails[7]);
            if (!file.toString().equals(null)) {
                if (getFileExtension(file.getName()).equals("jpg") || getFileExtension(file.getName()).equals("jpeg") || getFileExtension(file.getName()).equals("png")) {
                    String filepath = file.getAbsolutePath();
                    ImageInput.setText(file.getAbsolutePath());
                    ImageOutputLabel.setIcon(ResizeImage(filepath));
                } else {
                    JOptionPane.showMessageDialog(null, "No image found.");
                }
                this.productItem.itemID = ItemDetails[0];
                this.productItem.itemBrand = ItemDetails[1];
                this.productItem.itemName = ItemDetails[2];
                this.productItem.itemCategoryID = ItemDetails[3];
                this.productItem.itemQuantity = Integer.parseInt(ItemDetails[4]);
                this.productItem.itemPrice = Double.parseDouble(ItemDetails[5]);
                this.productItem.itemDescription = ItemDetails[6];
                this.productItem.itemImagePath = ItemDetails[7];
                this.productItem.itemSupplierID = ItemDetails[8];
            }

            CategoryComboBoxItems();
            SupplierComboBoxItems();

        } catch (FileNotFoundException ex) {
            System.out.println("Error in finding File");
        }
    }//GEN-LAST:event_ProductTableMouseClicked

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        FileIO fileIO = new FileIO();
        String primaryKey = this.ProductIDOutput.getText().trim();
        File file = fileIO.searchFilePath("ProductItem.txt");

        String filePath = file.getAbsolutePath();

        if (this.productItem.itemID != null
                || this.productItem.itemID != null
                || this.productItem.itemCategoryID != null
                || this.productItem.itemBrand != null
                || this.productItem.itemDescription != null
                || this.productItem.itemSupplierID != null
                || this.productItem.itemImagePath != null
                || this.QuantityInput.getText().equals(null)
                || this.PriceInput.getText().equals(null)) {
            String newID = this.ProductIDOutput.getText().trim();
            String newName = this.ProductNameInput.getText().trim();
            String newCategoryID = (String) this.CategoryIDComboBox.getSelectedItem();
            String newBrand = this.BrandInput.getText().trim();
            int newQuantity = Integer.parseInt(this.QuantityInput.getText().trim());
            double newPrice = Double.parseDouble(this.PriceInput.getText().trim());
            String newDescription = this.DescriptionInput.getText().trim();
            String newSupplierID = (String) this.SupplierComboBox.getSelectedItem();
            String newImagePath = this.ImageInput.getText().trim();
            this.productItem.itemID = newID;
            this.productItem.itemName = newName;
            this.productItem.itemCategoryID = newCategoryID;
            this.productItem.itemBrand = newBrand;
            this.productItem.itemQuantity = newQuantity;
            this.productItem.itemPrice = newPrice;
            this.productItem.itemDescription = newDescription;
            this.productItem.itemSupplierID = newSupplierID;
            this.productItem.itemImagePath = newImagePath;

            String[] newDetails = {this.productItem.itemID, this.productItem.itemBrand, this.productItem.itemName,
                this.productItem.itemCategoryID,
                Integer.toString(this.productItem.itemQuantity), Double.toString(this.productItem.itemPrice),
                this.productItem.itemDescription, this.productItem.itemImagePath, this.productItem.itemSupplierID};

            if (primaryKey != "") {
                JOptionPane.showMessageDialog(null, "No ID added!");
            } else {
                ArrayList<String> AllDetails = null;
                try {
                    AllDetails = fileIO.retrieveAllDetails(file);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(AdminManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < AllDetails.size(); i++) {
                    String record[] = AllDetails.get(i).split("\t");
                    if (!record[0].equals(this.productItem.itemID)) {
                        if (fileIO.writeDetails(file, newDetails, 9)) {
                            JOptionPane.showMessageDialog(null, "Item succesfully added!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Item not added...");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please change your itemID!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please input all areas.");
        }

        ResetEverything();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        FileIO fileIO = new FileIO();
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();

        if (this.productItem.itemID != null
                || this.productItem.itemID != null
                || this.productItem.itemCategoryID != null
                || this.productItem.itemBrand != null
                || this.productItem.itemDescription != null
                || this.productItem.itemSupplierID != null
                || this.productItem.itemImagePath != null
                || this.QuantityInput.getText().equals(null)
                || this.PriceInput.getText().equals(null)) {
            int selectedRowIndex = ProductTable.getSelectedRow();
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
            File file = fileIO.searchFilePath("ProductItem.txt");
            String filePath = file.getAbsolutePath();
            String newID = this.ProductIDOutput.getText().trim();
            String newName = this.ProductNameInput.getText().trim();
            String newCategoryID = (String) this.CategoryIDComboBox.getSelectedItem();
            String newBrand = this.BrandInput.getText().trim();
            int newQuantity = Integer.parseInt(this.QuantityInput.getText().trim());
            double newPrice = Double.parseDouble(this.PriceInput.getText().trim());
            String newDescription = this.DescriptionInput.getText().trim();
            String newSupplierID = (String) this.SupplierComboBox.getSelectedItem();
            String newImagePath = this.ImageInput.getText().trim();

            if (!newID.isEmpty() && !newID.equals(this.productItem.itemID)) {
                this.productItem.itemID = newID;
            }
            if (!newName.isEmpty() && !newName.equals(this.productItem.itemName)) {
                this.productItem.itemName = newName;
            }
            if (!newCategoryID.isEmpty() && !newCategoryID.equals(this.productItem.itemCategoryID)) {
                this.productItem.itemCategoryID = newCategoryID;
            }
            if (!newBrand.isEmpty() && !newBrand.equals(this.productItem.itemBrand)) {
                this.productItem.itemBrand = newBrand;
            }
            if (newQuantity != this.productItem.itemQuantity) {
                this.productItem.itemQuantity = newQuantity;
            }
            if (newPrice != this.productItem.itemPrice) {
                this.productItem.itemPrice = newPrice;
            }
            if (!newDescription.isEmpty() && !newDescription.equals(this.productItem.itemDescription)) {
                this.productItem.itemDescription = newDescription;
            }
            if (!newSupplierID.isEmpty() && !newSupplierID.equals(this.productItem.itemSupplierID)) {
                this.productItem.itemSupplierID = newSupplierID;
            }
            if (!newImagePath.isEmpty() && !newImagePath.equals(this.productItem.itemImagePath)) {
                this.productItem.itemImagePath = newImagePath;
            }

            String[] newDetails = {this.productItem.itemID, this.productItem.itemBrand, this.productItem.itemName,
                this.productItem.itemCategoryID,
                Integer.toString(this.productItem.itemQuantity), Double.toString(this.productItem.itemPrice),
                this.productItem.itemDescription, this.productItem.itemImagePath, this.productItem.itemSupplierID};

            try {
                if (FileIO.modifyFile(filePath, primaryKey, newDetails, 9)) {
                    JOptionPane.showMessageDialog(null, "Item succesfully updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "Item not updated...");
                }
            } catch (IOException ex) {
                Logger.getLogger(AdminEditProfile.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Something wrong");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Input all areas or choose a record!");
        }

        ResetEverything();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed
        FileIO fileIO = new FileIO();
        DefaultTableModel model = (DefaultTableModel) ProductTable.getModel();
        if (this.productItem.itemID != null
                || this.productItem.itemID != null
                || this.productItem.itemCategoryID != null
                || this.productItem.itemBrand != null
                || this.productItem.itemDescription != null
                || this.productItem.itemSupplierID != null
                || this.productItem.itemImagePath != null
                || this.QuantityInput.getText().equals(null)
                || this.PriceInput.getText().equals(null)) {
        int selectedRowIndex = ProductTable.getSelectedRow();
        String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);
        File file = fileIO.searchFilePath("ProductItem.txt");
        String filePath = file.getAbsolutePath();
        try {
            if (fileIO.removeDetail(filePath, primaryKey, 9)) {
                JOptionPane.showMessageDialog(null, "Item removed!");
            } else {
                JOptionPane.showMessageDialog(null, "Item failed to be removed!");
            }
        } catch (IOException ex) {
            Logger.getLogger(PMManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
        }}else{
            JOptionPane.showMessageDialog(null,"Please select a row in the table!");
        }
        ResetEverything();
    }//GEN-LAST:event_RemoveButtonActionPerformed

    private void DescriptionInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionInputActionPerformed

    }//GEN-LAST:event_DescriptionInputActionPerformed

    private void ProductNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameInputActionPerformed

    }//GEN-LAST:event_ProductNameInputActionPerformed

    private void UploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        if (!file.toString().isEmpty()) {
            if (getFileExtension(file.getName()).equals("jpg") || getFileExtension(file.getName()).equals("jpeg") || getFileExtension(file.getName()).equals("png")) {
                String filepath = file.getAbsolutePath();
                ImageInput.setText(file.getAbsolutePath());
                ImageOutputLabel.setIcon(ResizeImage(filepath));
            } else {
                JOptionPane.showMessageDialog(null, "Please Import Correct File Type ( jpeg , png , jpg )");
            }
        }
    }//GEN-LAST:event_UploadButtonActionPerformed

    private void ImageInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImageInputActionPerformed

    }//GEN-LAST:event_ImageInputActionPerformed

    private void CategoryIDComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoryIDComboBoxMouseClicked

    }//GEN-LAST:event_CategoryIDComboBoxMouseClicked

    private void SupplierComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierComboBoxMouseClicked

    }//GEN-LAST:event_SupplierComboBoxMouseClicked

    private void ProductIDInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProductIDInputMouseClicked
        this.ProductIDInput.setText(null);
    }//GEN-LAST:event_ProductIDInputMouseClicked

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchButtonActionPerformed

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
                    new AdminManageProductItem(null).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AdminManageProductItem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField BrandInput;
    private javax.swing.JLabel BrandLabel;
    private javax.swing.JComboBox<String> CategoryIDComboBox;
    private javax.swing.JLabel CategoryIDLabel;
    private javax.swing.JTextField DescriptionInput;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextField ImageInput;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JLabel ImageOutputLabel;
    private javax.swing.JLabel LogoutButton;
    private javax.swing.JButton ManageProfileButton;
    private javax.swing.JButton ManageProfileButton1;
    private javax.swing.JTextField PriceInput;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JButton ProductButton;
    private javax.swing.JTextField ProductIDInput;
    private javax.swing.JTextField ProductIDOutput;
    private javax.swing.JLabel ProductItemLabel;
    private javax.swing.JLabel ProductLabel;
    private javax.swing.JTextField ProductNameInput;
    private javax.swing.JLabel ProductNameLabel;
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JTextField QuantityInput;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton RemoveButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel SearchProductLabel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JComboBox<String> SupplierComboBox;
    private javax.swing.JLabel SupplierInfoLabel;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton UploadButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
