
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JFileChooser;
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
public class payment_modal extends javax.swing.JFrame {

    /**
     * Creates new form payment_modal
     */
    JFileChooser chooser = new JFileChooser();
    
    public payment_modal() {
        initComponents();
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
        edit_product = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_productName = new javax.swing.JTextField();
        roundPanel3 = new roundPanel();
        jLabel19 = new javax.swing.JLabel();
        file_name = new javax.swing.JLabel();
        btn_upload = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        toggle_availability = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        edit_product.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Edit GCASH Payment Settings");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel16.setText("GCASH Number :");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel18.setText("QR Code :");

        txt_productName.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        roundPanel3.setBackground(new java.awt.Color(255, 0, 0));
        roundPanel3.setRoundBottomLeft(30);
        roundPanel3.setRoundBottomRight(30);
        roundPanel3.setRoundTopLeft(30);
        roundPanel3.setRoundTopRight(30);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("EDIT");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        file_name.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        file_name.setText("-");

        btn_upload.setBackground(new java.awt.Color(255, 0, 0));
        btn_upload.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_upload.setForeground(new java.awt.Color(255, 255, 255));
        btn_upload.setText("Upload Image");
        btn_upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_uploadMouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel20.setText("Availability :");

        toggle_availability.setBackground(new java.awt.Color(0, 255, 51));
        toggle_availability.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        toggle_availability.setSelected(true);
        toggle_availability.setText("AVAILABLE\n\n");
        toggle_availability.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggle_availabilityMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout edit_productLayout = new javax.swing.GroupLayout(edit_product);
        edit_product.setLayout(edit_productLayout);
        edit_productLayout.setHorizontalGroup(
            edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_productLayout.createSequentialGroup()
                .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edit_productLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel20)
                            .addComponent(jLabel18))
                        .addGap(223, 223, 223)
                        .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toggle_availability, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, edit_productLayout.createSequentialGroup()
                                    .addComponent(file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_upload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txt_productName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))))
                    .addGroup(edit_productLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(edit_productLayout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(401, Short.MAX_VALUE))
        );
        edit_productLayout.setVerticalGroup(
            edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_productLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(toggle_availability, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txt_productName, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(edit_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(file_name)
                    .addComponent(btn_upload, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(edit_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_background.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 1060, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 680));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        close();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void toggle_availabilityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toggle_availabilityMouseClicked
        if(toggle_availability.isSelected()){
            toggle_availability.setBackground(Color.green);
            toggle_availability.setText("AVAILABLE");
        } else {
            toggle_availability.setBackground(Color.red);
            toggle_availability.setText("UNAVAILABLE");
        }
    }//GEN-LAST:event_toggle_availabilityMouseClicked

    private void btn_uploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_uploadMouseClicked
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif", "bmp"));
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String fileName = file.getName();
        
        file_name.setText(fileName);
    }//GEN-LAST:event_btn_uploadMouseClicked

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
            java.util.logging.Logger.getLogger(payment_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(payment_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(payment_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(payment_modal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new payment_modal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_upload;
    private javax.swing.JPanel edit_product;
    private javax.swing.JLabel file_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private roundPanel roundPanel3;
    private javax.swing.JToggleButton toggle_availability;
    private javax.swing.JTextField txt_productName;
    // End of variables declaration//GEN-END:variables
}
