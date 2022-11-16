
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gelay
 */
public class menu_modal extends javax.swing.JFrame {

    /**
     * Creates new form user_modal
     */
    JFileChooser chooser = new JFileChooser();
    
    String oldName;
    String availability;
    
    public menu_modal() {
        initComponents();
        
    }
    
    public menu_modal(int index, String oldName, String availability) {
        this.oldName = oldName;
        this.availability = availability;
        initComponents();
        jTabbedPane1.setSelectedIndex(index);
        getProductInfo();
    }
    
    public menu_modal( int index, String oldName, String productPrice, String availability ) {
        initComponents();
        this.oldName = oldName;
        
        
    }
    
    public void selectTab(int index){
        jTabbedPane1.setSelectedIndex(index);
    }
    
    public ArrayList getProductInfo(String username){
        ArrayList<ProductInfo> productInfo = new ArrayList<ProductInfo>();
        productInfo = DatabaseConnection.getInstance().getProductInfo(username);
        return productInfo;
    }
    
    public void getProductInfo() {
        System.out.println("here "+this.oldName);
            if(!getProductInfo(this.oldName).isEmpty()){
                ArrayList<ProductInfo> productInfo = getProductInfo(this.oldName);
                
                edit_cb_category.setSelectedItem(productInfo.get(0).getProduct_category().toString());
                toggle_availability.setText(this.availability);
                edit_product_name.setText(productInfo.get(0).getProduct_name().toString());
                edit_description.setText(productInfo.get(0).getProduct_description().toString());
                edit_product_price.setText(productInfo.get(0).getProduct_price().toString());
                edit_bundled_price.setText(productInfo.get(0).getBundle());
                
            }
    }
    
    public ArrayList productDuplicateCheckerQuery(String username){
        ArrayList<Product> userList = new ArrayList<Product>();
        userList = DatabaseConnection.getInstance().productDuplicateChecker(username);
        
        return userList;
    }
    
    public void productDuplicateChecker(String productName, String productPrice, String bundledPrice, String productDescription, String productCateory) {
        System.out.println(bundledPrice);
        
            if(productDuplicateCheckerQuery(productName).isEmpty()){
                
                if (productName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product name.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productPrice.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product price.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productDescription.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the description.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productCateory.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product category.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if( bundledPrice != null &&productName!=null && productPrice!= null && productDescription != null && productCateory != null){
                        DatabaseConnection.getInstance().addProduct(productName, productPrice, bundledPrice, productDescription, productCateory);
                        JOptionPane.showMessageDialog(null, productName + " is successfully added.", "Product Successfully Added", JOptionPane.PLAIN_MESSAGE);

                        admin_dashboard ad = new admin_dashboard();
                        ad.addRowToProductList();

                        close();
                    }
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Please check the product details.", "Duplicate product detected", JOptionPane.PLAIN_MESSAGE);
            }
    }
    
    public void soloProductDuplicateChecker(String productName, String productPrice, String productDescription, String productCateory) {
        
        
            if(productDuplicateCheckerQuery(productName).isEmpty()){
                
                if (productName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product name.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productPrice.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product price.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productDescription.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the description.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productCateory.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product category.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productName!=null && productPrice!= null && productDescription != null && productCateory != null) {
                        System.out.println("No bundle");
                        DatabaseConnection.getInstance().addProductSolo(productName, productPrice, productDescription, productCateory);
                        JOptionPane.showMessageDialog(null, productName + " is successfully added.", "Product Successfully Added", JOptionPane.PLAIN_MESSAGE);

                        admin_dashboard ad = new admin_dashboard();
                        ad.addRowToProductList();

                        close();
                    }
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Please check the product details.", "Duplicate product detected", JOptionPane.PLAIN_MESSAGE);
            }
    }
    
    public void updateProductCheckerupdateProduct( String productName, String productPrice, String bundledPrice, String productDescription, String productCateory, String availability, String oldName ) {
        
        
            if(!productDuplicateCheckerQuery(productName).isEmpty()){
                
                if (productName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product name.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productPrice.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product price.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productDescription.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the description.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productCateory.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter the product category.", "Missing Field", JOptionPane.PLAIN_MESSAGE);

                    }else if (productName!=null && productPrice!= null && productDescription != null && productCateory != null) {
                        System.out.println("No bundle");
                        DatabaseConnection.getInstance().updateProduct(productName, productPrice, bundledPrice, productDescription, productCateory, availability, this.oldName);
                        JOptionPane.showMessageDialog(null, productName + " is successfully added.", "Product Successfully Added", JOptionPane.PLAIN_MESSAGE);

                        admin_dashboard ad = new admin_dashboard();
                        ad.addRowToProductList();

                        close();
                    }
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Please check the product details.", "Duplicate product detected", JOptionPane.PLAIN_MESSAGE);
            }
    }
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
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
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        add_product = new javax.swing.JPanel();
        btn_upload1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_userType = new javax.swing.JComboBox<>();
        product_bundled_price = new javax.swing.JTextField();
        btn_addProduct = new roundPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        file_name = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_product_name = new javax.swing.JTextField();
        product_price = new javax.swing.JTextField();
        edit_product = new javax.swing.JPanel();
        btn_upload2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        edit_cb_category = new javax.swing.JComboBox<>();
        edit_bundled_price = new javax.swing.JTextField();
        btn_editProduct = new roundPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        edit_description = new javax.swing.JTextArea();
        file_name1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        edit_product_name = new javax.swing.JTextField();
        edit_product_price = new javax.swing.JTextField();
        toggle_availability = new javax.swing.JToggleButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Settings");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_logo.png"))); // NOI18N
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1300, 30));

        add_product.setOpaque(false);
        add_product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_upload1.setBackground(new java.awt.Color(255, 0, 0));
        btn_upload1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_upload1.setForeground(new java.awt.Color(255, 255, 255));
        btn_upload1.setText("Upload Image");
        btn_upload1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_upload1MouseClicked(evt);
            }
        });
        add_product.add(btn_upload1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 166, 45));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add Product");
        add_product.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 13, 1300, 73));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Category :");
        add_product.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 134, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel4.setText("Product Name :");
        add_product.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 198, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel5.setText("Product Description :");
        add_product.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 259, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel7.setText("Product Price :");
        add_product.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 479, -1, -1));

        cb_userType.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cb_userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "shawarma", "bowl", "wings", "beverage", "additional", " " }));
        add_product.add(cb_userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 325, -1));

        product_bundled_price.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        add_product.add(product_bundled_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 818, 55));

        btn_addProduct.setBackground(new java.awt.Color(255, 0, 0));
        btn_addProduct.setRoundBottomLeft(30);
        btn_addProduct.setRoundBottomRight(30);
        btn_addProduct.setRoundTopLeft(30);
        btn_addProduct.setRoundTopRight(30);
        btn_addProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addProductMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADD");

        javax.swing.GroupLayout btn_addProductLayout = new javax.swing.GroupLayout(btn_addProduct);
        btn_addProduct.setLayout(btn_addProductLayout);
        btn_addProductLayout.setHorizontalGroup(
            btn_addProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        btn_addProductLayout.setVerticalGroup(
            btn_addProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        add_product.add(btn_addProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, -1, -1));

        description.setColumns(20);
        description.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        description.setLineWrap(true);
        description.setTabSize(0);
        jScrollPane1.setViewportView(description);

        add_product.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 818, 104));

        file_name.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        file_name.setText("-");
        add_product.add(file_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 321, 40));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel9.setText("Product Image :");
        add_product.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 395, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel10.setText("Product Bundled Price :");
        add_product.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        txt_product_name.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        add_product.add(txt_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 818, 55));

        product_price.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        add_product.add(product_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 818, 55));

        jTabbedPane1.addTab("tab1", add_product);

        edit_product.setOpaque(false);
        edit_product.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_upload2.setBackground(new java.awt.Color(255, 0, 0));
        btn_upload2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_upload2.setForeground(new java.awt.Color(255, 255, 255));
        btn_upload2.setText("Upload Image");
        btn_upload2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_upload2MouseClicked(evt);
            }
        });
        edit_product.add(btn_upload2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 390, 166, 45));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Edit Product");
        edit_product.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 13, 1300, 73));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setText("Category :");
        edit_product.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 134, -1, -1));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel13.setText("Product Name :");
        edit_product.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 198, -1, -1));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel21.setText("Product Description :");
        edit_product.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 259, -1, -1));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel22.setText("Product Price :");
        edit_product.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 479, -1, -1));

        edit_cb_category.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        edit_cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "shawarma", "bowl", "wings", "beverage", "additional", " " }));
        edit_product.add(edit_cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 325, -1));

        edit_bundled_price.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        edit_product.add(edit_bundled_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 818, 55));

        btn_editProduct.setBackground(new java.awt.Color(255, 0, 0));
        btn_editProduct.setRoundBottomLeft(30);
        btn_editProduct.setRoundBottomRight(30);
        btn_editProduct.setRoundTopLeft(30);
        btn_editProduct.setRoundTopRight(30);
        btn_editProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editProductMouseClicked(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("EDIT");

        javax.swing.GroupLayout btn_editProductLayout = new javax.swing.GroupLayout(btn_editProduct);
        btn_editProduct.setLayout(btn_editProductLayout);
        btn_editProductLayout.setHorizontalGroup(
            btn_editProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        btn_editProductLayout.setVerticalGroup(
            btn_editProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        edit_product.add(btn_editProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, -1, -1));

        edit_description.setColumns(20);
        edit_description.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        edit_description.setLineWrap(true);
        edit_description.setTabSize(0);
        jScrollPane3.setViewportView(edit_description);

        edit_product.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 818, 104));

        file_name1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        file_name1.setText("-");
        edit_product.add(file_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 321, 40));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel24.setText("Product Image :");
        edit_product.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 395, -1, -1));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel25.setText("Product Bundled Price :");
        edit_product.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        edit_product_name.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        edit_product.add(edit_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 818, 55));

        edit_product_price.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        edit_product.add(edit_product_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 818, 55));

        toggle_availability.setBackground(new java.awt.Color(0, 255, 51));
        toggle_availability.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        toggle_availability.setSelected(true);
        toggle_availability.setText("available");
        toggle_availability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggle_availabilityActionPerformed(evt);
            }
        });
        edit_product.add(toggle_availability, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 130, -1, -1));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel26.setText("Availability :");
        edit_product.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, -1, -1));

        jTabbedPane1.addTab("tab1", edit_product);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1300, 770));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_background.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 1310, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1315, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        close();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btn_upload1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_upload1MouseClicked
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif", "bmp"));
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getName();
        
        file_name.setText(fileName);
    }//GEN-LAST:event_btn_upload1MouseClicked

    private void btn_addProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addProductMouseClicked
        String productName = txt_product_name.getText();
        String productPrice = product_price.getText();
        String bundledPrice = product_bundled_price.getText();
        String productDescription = description.getText();
        String productCateory = cb_userType.getSelectedItem().toString();
        
        System.out.println("bundle " + bundledPrice);
        if (bundledPrice.isEmpty()) {
            soloProductDuplicateChecker(productName, productPrice, productDescription, productCateory);
        }else {
            productDuplicateChecker(productName, productPrice, bundledPrice, productDescription, productCateory);
        }
        
    }//GEN-LAST:event_btn_addProductMouseClicked

    private void btn_upload2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_upload2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_upload2MouseClicked

    private void btn_editProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editProductMouseClicked
        String productName = edit_product_name.getText();
        String productPrice = edit_product_price.getText();
        String bundledPrice = edit_bundled_price.getText();
        String productDescription = edit_description.getText();
        String productCategory = edit_cb_category.getSelectedItem().toString();
        String availability = toggle_availability.getText();
        
        updateProductCheckerupdateProduct( productName, productPrice, bundledPrice, productDescription, productCategory, availability, this.oldName );
    }//GEN-LAST:event_btn_editProductMouseClicked

    private void toggle_availabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggle_availabilityActionPerformed
        if (toggle_availability.getText().equals("available")){ 
            toggle_availability.setText("unavailable"); 
            toggle_availability.setBackground(Color.red);
        }
        else {
            toggle_availability.setText("available"); 
            toggle_availability.setBackground(Color.green);
        }
    }//GEN-LAST:event_toggle_availabilityActionPerformed

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
            java.util.logging.Logger.getLogger(user_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_modal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_product;
    private roundPanel btn_addProduct;
    private roundPanel btn_editProduct;
    private javax.swing.JButton btn_upload1;
    private javax.swing.JButton btn_upload2;
    private javax.swing.JComboBox<String> cb_userType;
    private javax.swing.JTextArea description;
    private javax.swing.JTextField edit_bundled_price;
    private javax.swing.JComboBox<String> edit_cb_category;
    private javax.swing.JTextArea edit_description;
    private javax.swing.JPanel edit_product;
    private javax.swing.JTextField edit_product_name;
    private javax.swing.JTextField edit_product_price;
    private javax.swing.JLabel file_name;
    private javax.swing.JLabel file_name1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField product_bundled_price;
    private javax.swing.JTextField product_price;
    private javax.swing.JToggleButton toggle_availability;
    private javax.swing.JTextField txt_product_name;
    // End of variables declaration//GEN-END:variables
}
