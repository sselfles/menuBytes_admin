
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gelay
 */
public class product_details extends javax.swing.JFrame {

    /**
     * Creates new form product_details
     */
    public product_details() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        product_quantity = new javax.swing.JLabel();
        roundPanel1 = new roundPanel();
        jLabel15 = new javax.swing.JLabel();
        dec_quantity = new roundPanel();
        jLabel18 = new javax.swing.JLabel();
        product_total_amount = new javax.swing.JLabel();
        inc_quantity = new roundPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        shawarma = new javax.swing.JPanel();
        shawarma_product_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        solo = new javax.swing.JRadioButton();
        buy1Take1 = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addOn_allMeat = new javax.swing.JCheckBox();
        solo_price = new javax.swing.JLabel();
        buy1Take1_price = new javax.swing.JLabel();
        addOn_allMeat_price = new javax.swing.JLabel();
        chicken = new javax.swing.JPanel();
        chicken_product_name = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        solo1 = new javax.swing.JRadioButton();
        buy1Take2 = new javax.swing.JRadioButton();
        solo3 = new javax.swing.JRadioButton();
        solo4 = new javax.swing.JRadioButton();
        buy1Take4 = new javax.swing.JRadioButton();
        solo5 = new javax.swing.JRadioButton();
        others = new javax.swing.JPanel();
        others_product_name = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
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
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, 107, 51));

        product_quantity.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        product_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        product_quantity.setText("1");
        jPanel1.add(product_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 655, 60, 60));

        roundPanel1.setBackground(new java.awt.Color(255, 0, 0));
        roundPanel1.setRoundBottomLeft(50);
        roundPanel1.setRoundBottomRight(50);
        roundPanel1.setRoundTopLeft(50);
        roundPanel1.setRoundTopRight(50);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Add to Cart");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );

        jPanel1.add(roundPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 751, -1, -1));

        dec_quantity.setBackground(new java.awt.Color(255, 0, 0));
        dec_quantity.setRoundBottomLeft(50);
        dec_quantity.setRoundBottomRight(50);
        dec_quantity.setRoundTopLeft(50);
        dec_quantity.setRoundTopRight(50);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("-");

        javax.swing.GroupLayout dec_quantityLayout = new javax.swing.GroupLayout(dec_quantity);
        dec_quantity.setLayout(dec_quantityLayout);
        dec_quantityLayout.setHorizontalGroup(
            dec_quantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dec_quantityLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel18)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        dec_quantityLayout.setVerticalGroup(
            dec_quantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dec_quantityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(dec_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, -1, -1));

        product_total_amount.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        product_total_amount.setForeground(new java.awt.Color(255, 0, 0));
        product_total_amount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        product_total_amount.setText("-");
        jPanel1.add(product_total_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 202, 75));

        inc_quantity.setBackground(new java.awt.Color(255, 0, 0));
        inc_quantity.setRoundBottomLeft(50);
        inc_quantity.setRoundBottomRight(50);
        inc_quantity.setRoundTopLeft(50);
        inc_quantity.setRoundTopRight(50);
        inc_quantity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inc_quantityMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("+");

        javax.swing.GroupLayout inc_quantityLayout = new javax.swing.GroupLayout(inc_quantity);
        inc_quantity.setLayout(inc_quantityLayout);
        inc_quantityLayout.setHorizontalGroup(
            inc_quantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inc_quantityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inc_quantityLayout.setVerticalGroup(
            inc_quantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inc_quantityLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(inc_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 670, 40));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        shawarma.setBackground(new java.awt.Color(255, 255, 255));
        shawarma.setOpaque(false);

        shawarma_product_name.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        shawarma_product_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shawarma_product_name.setText("Pork Samgyupsal Rice Bowl");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setText("Choose Type");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Pick one ( 1 )");

        solo.setBackground(new java.awt.Color(255, 255, 255));
        solo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        solo.setText("     Solo");
        solo.setOpaque(false);

        buy1Take1.setBackground(new java.awt.Color(255, 255, 255));
        buy1Take1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        buy1Take1.setText("     Buy 1 Take 1");
        buy1Take1.setOpaque(false);
        buy1Take1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy1Take1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Choose Add Ons");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Optional");

        addOn_allMeat.setBackground(new java.awt.Color(255, 255, 255));
        addOn_allMeat.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        addOn_allMeat.setText("     Shawarma All Meat");
        addOn_allMeat.setActionCommand("");
        addOn_allMeat.setOpaque(false);

        solo_price.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        solo_price.setForeground(new java.awt.Color(153, 153, 153));
        solo_price.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        solo_price.setText("55.00");

        buy1Take1_price.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        buy1Take1_price.setForeground(new java.awt.Color(153, 153, 153));
        buy1Take1_price.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        buy1Take1_price.setText("89.00");

        addOn_allMeat_price.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        addOn_allMeat_price.setForeground(new java.awt.Color(153, 153, 153));
        addOn_allMeat_price.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        addOn_allMeat_price.setText("10.00");

        javax.swing.GroupLayout shawarmaLayout = new javax.swing.GroupLayout(shawarma);
        shawarma.setLayout(shawarmaLayout);
        shawarmaLayout.setHorizontalGroup(
            shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, shawarmaLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(shawarma_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(shawarmaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(shawarmaLayout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(shawarmaLayout.createSequentialGroup()
                            .addComponent(solo)
                            .addGap(354, 354, 354)
                            .addComponent(solo_price, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(shawarmaLayout.createSequentialGroup()
                            .addComponent(buy1Take1)
                            .addGap(282, 282, 282)
                            .addComponent(buy1Take1_price, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(shawarmaLayout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(shawarmaLayout.createSequentialGroup()
                            .addComponent(addOn_allMeat)
                            .addGap(218, 218, 218)
                            .addComponent(addOn_allMeat_price, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        shawarmaLayout.setVerticalGroup(
            shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shawarmaLayout.createSequentialGroup()
                .addComponent(shawarma_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 441, Short.MAX_VALUE))
            .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(shawarmaLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(solo)
                        .addComponent(solo_price, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buy1Take1)
                        .addComponent(buy1Take1_price, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(57, 57, 57)
                    .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(shawarmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(addOn_allMeat)
                        .addComponent(addOn_allMeat_price, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("tab1", shawarma);

        chicken.setBackground(new java.awt.Color(255, 255, 255));
        chicken.setOpaque(false);

        chicken_product_name.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        chicken_product_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chicken_product_name.setText("Pork Samgyupsal Rice Bowl");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setText("Choose Flavors");

        solo1.setBackground(new java.awt.Color(255, 255, 255));
        solo1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        solo1.setText("      Garlic Parmesan");
        solo1.setOpaque(false);

        buy1Take2.setBackground(new java.awt.Color(255, 255, 255));
        buy1Take2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        buy1Take2.setText("      Buffalo");
        buy1Take2.setOpaque(false);
        buy1Take2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy1Take2ActionPerformed(evt);
            }
        });

        solo3.setBackground(new java.awt.Color(255, 255, 255));
        solo3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        solo3.setText("      Soy Garlic");
        solo3.setOpaque(false);

        solo4.setBackground(new java.awt.Color(255, 255, 255));
        solo4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        solo4.setText("      Salted Egg");
        solo4.setOpaque(false);

        buy1Take4.setBackground(new java.awt.Color(255, 255, 255));
        buy1Take4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        buy1Take4.setText("      Bulgogi");
        buy1Take4.setOpaque(false);
        buy1Take4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy1Take4ActionPerformed(evt);
            }
        });

        solo5.setBackground(new java.awt.Color(255, 255, 255));
        solo5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        solo5.setText("      Sesame Honey Glazed");
        solo5.setOpaque(false);

        javax.swing.GroupLayout chickenLayout = new javax.swing.GroupLayout(chicken);
        chicken.setLayout(chickenLayout);
        chickenLayout.setHorizontalGroup(
            chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chickenLayout.createSequentialGroup()
                .addGroup(chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(chickenLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(chickenLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(chickenLayout.createSequentialGroup()
                                .addGroup(chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(solo3)
                                    .addComponent(solo1)
                                    .addComponent(buy1Take2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(solo5)
                                    .addComponent(solo4)
                                    .addComponent(buy1Take4)))))
                    .addGroup(chickenLayout.createSequentialGroup()
                        .addContainerGap(63, Short.MAX_VALUE)
                        .addComponent(chicken_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        chickenLayout.setVerticalGroup(
            chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chickenLayout.createSequentialGroup()
                .addComponent(chicken_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(chickenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chickenLayout.createSequentialGroup()
                        .addComponent(solo1)
                        .addGap(18, 18, 18)
                        .addComponent(buy1Take2)
                        .addGap(27, 27, 27)
                        .addComponent(solo3))
                    .addGroup(chickenLayout.createSequentialGroup()
                        .addComponent(solo4)
                        .addGap(18, 18, 18)
                        .addComponent(buy1Take4)
                        .addGap(27, 27, 27)
                        .addComponent(solo5)))
                .addGap(0, 217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", chicken);

        others.setBackground(new java.awt.Color(255, 255, 255));
        others.setOpaque(false);

        others_product_name.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        others_product_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        others_product_name.setText("Pork Samgyupsal Rice Bowl");

        javax.swing.GroupLayout othersLayout = new javax.swing.GroupLayout(others);
        others.setLayout(othersLayout);
        othersLayout.setHorizontalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, othersLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(others_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        othersLayout.setVerticalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(othersLayout.createSequentialGroup()
                .addComponent(others_product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 441, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", others);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 670, 570));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_background.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 690, 870));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 870));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        close();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void inc_quantityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inc_quantityMouseClicked
        int productQuantity = Integer.parseInt(product_quantity.getText());
        productQuantity++;
        product_quantity.setText(String.valueOf(productQuantity));
    }//GEN-LAST:event_inc_quantityMouseClicked

    private void buy1Take1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy1Take1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buy1Take1ActionPerformed

    private void buy1Take2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy1Take2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buy1Take2ActionPerformed

    private void buy1Take4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy1Take4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buy1Take4ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
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
            java.util.logging.Logger.getLogger(product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(product_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new product_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addOn_allMeat;
    private javax.swing.JLabel addOn_allMeat_price;
    private javax.swing.JRadioButton buy1Take1;
    private javax.swing.JLabel buy1Take1_price;
    private javax.swing.JRadioButton buy1Take2;
    private javax.swing.JRadioButton buy1Take4;
    private javax.swing.JPanel chicken;
    private javax.swing.JLabel chicken_product_name;
    private roundPanel dec_quantity;
    private roundPanel inc_quantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel others;
    private javax.swing.JLabel others_product_name;
    private javax.swing.JLabel product_quantity;
    private javax.swing.JLabel product_total_amount;
    private roundPanel roundPanel1;
    private javax.swing.JPanel shawarma;
    private javax.swing.JLabel shawarma_product_name;
    private javax.swing.JRadioButton solo;
    private javax.swing.JRadioButton solo1;
    private javax.swing.JRadioButton solo3;
    private javax.swing.JRadioButton solo4;
    private javax.swing.JRadioButton solo5;
    private javax.swing.JLabel solo_price;
    // End of variables declaration//GEN-END:variables
}
