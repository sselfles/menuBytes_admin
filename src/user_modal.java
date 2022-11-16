
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gelay
 */
public class user_modal extends javax.swing.JFrame {

    /**
     * Creates new form user_modal
     */
    String usernamePassword;
    String oldUsername;
    String updateUserType;
    String updateUsername;
    String updateDeviceType;
    
    admin_dashboard ad = new admin_dashboard();
    
    public user_modal() {
        initComponents();
    }
    
    public user_modal(int index) {
        initComponents();
        jTabbedPane1.setSelectedIndex(index);
    }
    
    public user_modal (int index, String userType, String username, String deviceType) {
        initComponents();
        
        this.oldUsername = username;
        
        jTabbedPane1.setSelectedIndex(index);
        edit_cb_userType.setSelectedItem(userType);
        edit_txt_username.setText(username);
        edit_cb_deviceType.setSelectedItem(deviceType);
    }
    
    public user_modal(int index, String username) {
        initComponents();
        this.usernamePassword = username;
        
        jTabbedPane1.setSelectedIndex(index);
    }
    
    
    
    public void usernameDuplicateChecker(String username) {
        String password = String.valueOf(txt_password.getPassword());
        String userType = cb_userType.getSelectedItem().toString();
        String deviceType = cb_deviceType.getSelectedItem().toString();
        
            if(usernameDuplicateCheckerQuery(username).isEmpty()){
                
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a password.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if (userType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a user type.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if (deviceType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a device type.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if(username!=null && password !=null && userType!= null && deviceType != null){
                    DatabaseConnection.getInstance().accountCreation(username, password, userType, deviceType);
                    JOptionPane.showMessageDialog(null, username + " is successfully created.", "Account Creation Successful", JOptionPane.PLAIN_MESSAGE);
                    
                    admin_dashboard ad = new admin_dashboard();
                    ad.addRowToUserList();
                    
                    close();
                }
                
            }
            else {
                JOptionPane.showMessageDialog(null, "A duplicate username detected.\nKindly choose another username.", "Account Duplicate Detected", JOptionPane.PLAIN_MESSAGE);
            }
    }
    
    public void updatePassword(String username) {
        System.out.println("update " +username);
        
        String password = String.valueOf(reset_new_password.getPassword());
        String newPassword = String.valueOf(new_password.getPassword());
        
                
                if (password.isEmpty() || newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if (!password.equals(newPassword)) {
                    JOptionPane.showMessageDialog(null, "The password entered on both fields do not match.\nPlease enter them again.", "Passwords do not match", JOptionPane.PLAIN_MESSAGE);
                    
                }else if(password !=null && newPassword !=null){
                    DatabaseConnection.getInstance().updatePassword(newPassword, username);
                    JOptionPane.showMessageDialog(null, "Successfully reset password for " + username, "Account Reset Password Successful", JOptionPane.PLAIN_MESSAGE);
                    
                    admin_dashboard ad = new admin_dashboard();
                    ad.addRowToUserList();
                    
                    close();
                }
               
    }
    
    public ArrayList usernameDuplicateCheckerQuery(String username){
        ArrayList<User> userList = new ArrayList<User>();
        userList = DatabaseConnection.getInstance().usernameDuplicateChecker(username);
        
        return userList;
    }
    
    public void usernameExistChecker(String userType, String username, String deviceType) {
        
        
            if(!usernameDuplicateCheckerQuery(oldUsername).isEmpty()){
                
                if (updateUserType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a username.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if (updateUsername.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a user type.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if (updateDeviceType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a device type.", "Missing Field", JOptionPane.PLAIN_MESSAGE);
                    
                }else if(updateUserType!=null && updateUsername!= null && updateDeviceType != null){
                    DatabaseConnection.getInstance().updateUserInfo(updateUsername, updateUserType, updateDeviceType, oldUsername);
                    JOptionPane.showMessageDialog(null, updateUsername + " is successfully updated.", "Account Creation Successful", JOptionPane.PLAIN_MESSAGE);
                   
                    admin_dashboard ad = new admin_dashboard();
                    ad.addRowToUserList();
                    
                    close();
                }
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Please check the username and enter the username you wish to edit.", "Account Not Found", JOptionPane.PLAIN_MESSAGE);
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
        add_user = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cb_userType = new javax.swing.JComboBox<>();
        cb_deviceType = new javax.swing.JComboBox<>();
        txt_username = new javax.swing.JTextField();
        btn_add = new roundPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        edit_user = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        edit_cb_userType = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        edit_txt_username = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        edit_cb_deviceType = new javax.swing.JComboBox<>();
        btn_edit = new roundPanel();
        jLabel13 = new javax.swing.JLabel();
        reset_password = new javax.swing.JPanel();
        reset_new_password = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        submit_password_rest = new roundPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        new_password = new javax.swing.JPasswordField();
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
            .addGap(0, 670, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 670, 30));

        add_user.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Add User");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Type of User :");

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel4.setText("Username :");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel5.setText("Password :");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel7.setText("Type of Device :");

        cb_userType.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cb_userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "cashier", "customer" }));

        cb_deviceType.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        cb_deviceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPUTER", "TABLET", "MOBILE" }));
        cb_deviceType.setToolTipText("");

        txt_username.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        btn_add.setBackground(new java.awt.Color(255, 0, 0));
        btn_add.setRoundBottomLeft(30);
        btn_add.setRoundBottomRight(30);
        btn_add.setRoundTopLeft(30);
        btn_add.setRoundTopRight(30);
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ADD");

        javax.swing.GroupLayout btn_addLayout = new javax.swing.GroupLayout(btn_add);
        btn_add.setLayout(btn_addLayout);
        btn_addLayout.setHorizontalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        btn_addLayout.setVerticalGroup(
            btn_addLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        txt_password.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        javax.swing.GroupLayout add_userLayout = new javax.swing.GroupLayout(add_user);
        add_user.setLayout(add_userLayout);
        add_userLayout.setHorizontalGroup(
            add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_userLayout.createSequentialGroup()
                .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_userLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48)
                        .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_userType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_deviceType, 0, 325, Short.MAX_VALUE)
                            .addComponent(txt_username)
                            .addComponent(txt_password)))
                    .addGroup(add_userLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(add_userLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        add_userLayout.setVerticalGroup(
            add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_userType))
                .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(add_userLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel4)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, add_userLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(add_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_deviceType))
                .addGap(69, 69, 69)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jTabbedPane1.addTab("tab1", add_user);

        edit_user.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel9.setText("Type of User :");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Edit User");

        edit_cb_userType.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        edit_cb_userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "cashier", "customer" }));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel11.setText("Username :");

        edit_txt_username.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setText("Type of Device :");

        edit_cb_deviceType.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        edit_cb_deviceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPUTER", "TABLET", "MOBILE" }));
        edit_cb_deviceType.setToolTipText("");

        btn_edit.setBackground(new java.awt.Color(255, 0, 0));
        btn_edit.setRoundBottomLeft(30);
        btn_edit.setRoundBottomRight(30);
        btn_edit.setRoundTopLeft(30);
        btn_edit.setRoundTopRight(30);
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("EDIT");

        javax.swing.GroupLayout btn_editLayout = new javax.swing.GroupLayout(btn_edit);
        btn_edit.setLayout(btn_editLayout);
        btn_editLayout.setHorizontalGroup(
            btn_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        btn_editLayout.setVerticalGroup(
            btn_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout edit_userLayout = new javax.swing.GroupLayout(edit_user);
        edit_user.setLayout(edit_userLayout);
        edit_userLayout.setHorizontalGroup(
            edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edit_userLayout.createSequentialGroup()
                .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(edit_userLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel12)
                        .addGap(46, 46, 46)
                        .addComponent(edit_cb_deviceType, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(edit_userLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(edit_userLayout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(edit_userLayout.createSequentialGroup()
                            .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addComponent(jLabel9))
                            .addGap(86, 86, 86)
                            .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(edit_cb_userType, 0, 324, Short.MAX_VALUE)
                                .addComponent(edit_txt_username)))
                        .addGroup(edit_userLayout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(50, Short.MAX_VALUE)))
        );
        edit_userLayout.setVerticalGroup(
            edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edit_userLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(edit_cb_deviceType))
                .addGap(293, 293, 293))
            .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(edit_userLayout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(edit_cb_userType))
                    .addGroup(edit_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(edit_userLayout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(jLabel11)
                            .addGap(75, 75, 75))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, edit_userLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edit_txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(67, 67, 67)))
                    .addGap(221, 221, 221)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)))
        );

        jTabbedPane1.addTab("tab1", edit_user);

        reset_password.setOpaque(false);

        reset_new_password.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        reset_new_password.setText("Password");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel14.setText("Password :");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Reset Password");

        submit_password_rest.setBackground(new java.awt.Color(255, 0, 0));
        submit_password_rest.setRoundBottomLeft(30);
        submit_password_rest.setRoundBottomRight(30);
        submit_password_rest.setRoundTopLeft(30);
        submit_password_rest.setRoundTopRight(30);
        submit_password_rest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submit_password_restMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("SUBMIT");

        javax.swing.GroupLayout submit_password_restLayout = new javax.swing.GroupLayout(submit_password_rest);
        submit_password_rest.setLayout(submit_password_restLayout);
        submit_password_restLayout.setHorizontalGroup(
            submit_password_restLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
        );
        submit_password_restLayout.setVerticalGroup(
            submit_password_restLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel17.setText("New Password :");

        new_password.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        new_password.setText("Password");

        javax.swing.GroupLayout reset_passwordLayout = new javax.swing.GroupLayout(reset_password);
        reset_password.setLayout(reset_passwordLayout);
        reset_passwordLayout.setHorizontalGroup(
            reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reset_passwordLayout.createSequentialGroup()
                .addGroup(reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reset_passwordLayout.createSequentialGroup()
                        .addGroup(reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reset_passwordLayout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(submit_password_rest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reset_passwordLayout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(reset_passwordLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reset_passwordLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(reset_new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(reset_passwordLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(57, 57, 57))
        );
        reset_passwordLayout.setVerticalGroup(
            reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reset_passwordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(reset_new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(reset_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(new_password, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(286, 286, 286)
                .addComponent(submit_password_rest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", reset_password);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 670, 720));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_background.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 680, 765));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        close();
        view_cart vc = new view_cart();
        dashboard db = new dashboard();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btn_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMouseClicked
        
        usernameDuplicateChecker(txt_username.getText());
    }//GEN-LAST:event_btn_addMouseClicked

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        
        this.updateUserType = edit_cb_userType.getSelectedItem().toString();
        this.updateUsername = edit_txt_username.getText();
        this.updateDeviceType = edit_cb_deviceType.getSelectedItem().toString();
        
        usernameExistChecker(this.updateUserType, this.updateUsername, this.updateDeviceType);
    }//GEN-LAST:event_btn_editMouseClicked

    private void submit_password_restMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submit_password_restMouseClicked
        updatePassword(this.usernamePassword);
    }//GEN-LAST:event_submit_password_restMouseClicked

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
                new user_modal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add_user;
    private roundPanel btn_add;
    private roundPanel btn_edit;
    private javax.swing.JComboBox<String> cb_deviceType;
    private javax.swing.JComboBox<String> cb_userType;
    private javax.swing.JComboBox<String> edit_cb_deviceType;
    private javax.swing.JComboBox<String> edit_cb_userType;
    private javax.swing.JTextField edit_txt_username;
    private javax.swing.JPanel edit_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField new_password;
    private javax.swing.JPasswordField reset_new_password;
    private javax.swing.JPanel reset_password;
    private roundPanel submit_password_rest;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
