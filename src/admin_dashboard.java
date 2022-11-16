


import com.itextpdf.text.BaseColor;
import static com.itextpdf.text.BaseColor.BLACK;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfTable;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
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
public class admin_dashboard extends javax.swing.JFrame {

    Color defaultColor, clickedColor;
    
    user_modal userModal = new user_modal();
    menu_modal menuModal = new menu_modal();
    payment_modal paymentModal = new payment_modal();
    int index;
    
    public admin_dashboard() {
        initComponents();
        defaultColor = new Color(227,0,0);
        clickedColor = new Color(255,0,0);
    }
    
    public void addRowToSalesReport() {
        if (cmb_sales.getSelectedIndex() == 0) {
            DefaultTableModel model = (DefaultTableModel)sales_report_list.getModel();
            model.setRowCount(0);
            if(!salesReport().isEmpty()){
                ArrayList<Report> reportArrayList = salesReport();
                Object rowData[] = new Object[4];
                
                for(int position = 0; position < reportArrayList.size(); position++){
                    rowData[0] = reportArrayList.get(position).getDate();
                    rowData[1] = reportArrayList.get(position).getTotal_quantity();
                    rowData[2] = reportArrayList.get(position).getTotal_amount();
                    model.addRow(rowData);
                }
            }
        }
        
        if (cmb_sales.getSelectedIndex() == 1) {
        
        }
        
        if (cmb_sales.getSelectedIndex() == 2) {
        
        }
    }
    
    public ArrayList salesReport(){
        ArrayList<Report> salesReport = new ArrayList<Report>();
        salesReport = DatabaseConnection.getInstance().getSalesReportDaily();
        return salesReport;
    }
    
    public void addRowToTransaction() {
        if (cmb_transactions.getSelectedIndex() == 0) {
            DefaultTableModel model = (DefaultTableModel)transaction_list.getModel();
            model.setRowCount(0);
            if(!salesReport().isEmpty()){
                ArrayList<Report> reportArrayList = salesReport();
                Object rowData[] = new Object[4];
                
                for(int position = 0; position < reportArrayList.size(); position++){
                    rowData[0] = reportArrayList.get(position).getDate();
                    rowData[1] = reportArrayList.get(position).getOrder_id();
                    rowData[1] = reportArrayList.get(position).getTable_name();
                    rowData[3] = reportArrayList.get(position).getTotal_amount();
                    model.addRow(rowData);
                }
            }
        }
        
        if (cmb_transactions.getSelectedIndex() == 1) {
        
        }
        
        if (cmb_transactions.getSelectedIndex() == 2) {
        
        }
    }
    
    public ArrayList transactionsReport(){
        ArrayList<Report> transactionsReport = new ArrayList<Report>();
        transactionsReport = DatabaseConnection.getInstance().getTransactions();
        return transactionsReport;
    }
    
    public void addRowToLogReports() {
        DefaultTableModel model = (DefaultTableModel)log_reports_list.getModel();
            model.setRowCount(0);
            if(!salesReport().isEmpty()){
                ArrayList<LogReport> logsArrayList = salesReport();
                Object rowData[] = new Object[4];
                
                for(int position = 0; position < logsArrayList.size(); position++){
                    rowData[0] = logsArrayList.get(position).getDate();
                    rowData[1] = logsArrayList.get(position).getTable_name();
                    rowData[1] = logsArrayList.get(position).getDescription();
                    model.addRow(rowData);
                }
            }
    }
    
    public ArrayList logReport(){
        ArrayList<LogReport> logReport = new ArrayList<LogReport>();
        logReport = DatabaseConnection.getInstance().getLogReports();
        return logReport;
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

        sidePane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        account_management = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        product_management = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        payment_settings = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        sales_reports = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        transactions = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        log_reports = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        user_tab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        user_list = new javax.swing.JTable();
        btn_addUser = new roundPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_editUser = new roundPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_resetPassword = new roundPanel();
        jLabel10 = new javax.swing.JLabel();
        btn_deleteUser = new roundPanel();
        jLabel14 = new javax.swing.JLabel();
        product_tab = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        user_list1 = new javax.swing.JTable();
        btn_addMenu = new roundPanel();
        jLabel16 = new javax.swing.JLabel();
        btn_editMenu = new roundPanel();
        jLabel17 = new javax.swing.JLabel();
        btn_deleteMenu = new roundPanel();
        jLabel19 = new javax.swing.JLabel();
        payment_tab = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        btn_editPayment = new roundPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        gcash_qr = new javax.swing.JLabel();
        gcash_availability = new javax.swing.JLabel();
        gcash_number = new javax.swing.JLabel();
        sales_reports_tab = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        sales_report_list = new javax.swing.JTable();
        btn_viewReceipt = new roundPanel();
        sales_view = new javax.swing.JLabel();
        cmb_sales = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        sales_tabbedPane = new javax.swing.JTabbedPane();
        daily_weekly_tab = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        monthly_tab = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        transactions_tab = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        transaction_list = new javax.swing.JTable();
        btn_viewReceipt1 = new roundPanel();
        sales_view1 = new javax.swing.JLabel();
        cmb_transactions = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        sales_tabbedPane1 = new javax.swing.JTabbedPane();
        daily_weekly_tab3 = new javax.swing.JPanel();
        jDateChooser7 = new com.toedter.calendar.JDateChooser();
        jDateChooser8 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        monthly_tab3 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jMonthChooser7 = new com.toedter.calendar.JMonthChooser();
        jMonthChooser8 = new com.toedter.calendar.JMonthChooser();
        log_reports_tab = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        log_reports_list = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        log_tabbedPAne = new javax.swing.JTabbedPane();
        daily_weekly_tab1 = new javax.swing.JPanel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        btn_viewReceipt2 = new roundPanel();
        log_view = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("6.14FoodHub ADMIN ");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePane.setBackground(new java.awt.Color(198, 0, 0));
        sidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainlogo_thumbnail.png"))); // NOI18N
        sidePane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 340, 210));

        account_management.setBackground(new java.awt.Color(227, 0, 0));
        account_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account_managementMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                account_managementMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                account_managementMouseReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("User Account Management");

        javax.swing.GroupLayout account_managementLayout = new javax.swing.GroupLayout(account_management);
        account_management.setLayout(account_managementLayout);
        account_managementLayout.setHorizontalGroup(
            account_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, account_managementLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        account_managementLayout.setVerticalGroup(
            account_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePane.add(account_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 360, 70));

        product_management.setBackground(new java.awt.Color(227, 0, 0));
        product_management.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_managementMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                product_managementMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                product_managementMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product Management");

        javax.swing.GroupLayout product_managementLayout = new javax.swing.GroupLayout(product_management);
        product_management.setLayout(product_managementLayout);
        product_managementLayout.setHorizontalGroup(
            product_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, product_managementLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        product_managementLayout.setVerticalGroup(
            product_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        sidePane.add(product_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 360, 70));

        payment_settings.setBackground(new java.awt.Color(227, 0, 0));
        payment_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payment_settingsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                payment_settingsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                payment_settingsMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Payment Settings");

        javax.swing.GroupLayout payment_settingsLayout = new javax.swing.GroupLayout(payment_settings);
        payment_settings.setLayout(payment_settingsLayout);
        payment_settingsLayout.setHorizontalGroup(
            payment_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, payment_settingsLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        payment_settingsLayout.setVerticalGroup(
            payment_settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        sidePane.add(payment_settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 360, 70));

        sales_reports.setBackground(new java.awt.Color(227, 0, 0));
        sales_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_reportsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sales_reportsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                sales_reportsMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sales Reports");

        javax.swing.GroupLayout sales_reportsLayout = new javax.swing.GroupLayout(sales_reports);
        sales_reports.setLayout(sales_reportsLayout);
        sales_reportsLayout.setHorizontalGroup(
            sales_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sales_reportsLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        sales_reportsLayout.setVerticalGroup(
            sales_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        sidePane.add(sales_reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 360, 70));

        transactions.setBackground(new java.awt.Color(227, 0, 0));
        transactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transactionsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                transactionsMouseReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Transactions");

        javax.swing.GroupLayout transactionsLayout = new javax.swing.GroupLayout(transactions);
        transactions.setLayout(transactionsLayout);
        transactionsLayout.setHorizontalGroup(
            transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionsLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        transactionsLayout.setVerticalGroup(
            transactionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        sidePane.add(transactions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 360, 70));

        log_reports.setBackground(new java.awt.Color(227, 0, 0));
        log_reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                log_reportsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                log_reportsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                log_reportsMouseReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Log Reports");

        javax.swing.GroupLayout log_reportsLayout = new javax.swing.GroupLayout(log_reports);
        log_reports.setLayout(log_reportsLayout);
        log_reportsLayout.setHorizontalGroup(
            log_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, log_reportsLayout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        log_reportsLayout.setVerticalGroup(
            log_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        sidePane.add(log_reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 360, 70));

        logout.setBackground(new java.awt.Color(227, 0, 0));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_logo.png"))); // NOI18N
        jLabel13.setText("        Logout");

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutLayout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        sidePane.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 930, 360, 70));

        getContentPane().add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 1020));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 840, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1920, 10));

        user_tab.setOpaque(false);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel6.setText("USER ACCOUNT MANAGEMENT");

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator1.setPreferredSize(new java.awt.Dimension(0, 5));

        user_list.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        user_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Administrator", "admin", "PC /Laptop"},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Type of User", "Username", "Device"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_list.setGridColor(new java.awt.Color(230, 0, 0));
        user_list.setIntercellSpacing(new java.awt.Dimension(10, 10));
        user_list.setRowHeight(80);
        user_list.setSelectionBackground(new java.awt.Color(255, 171, 171));
        user_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        user_list.setShowVerticalLines(false);
        user_list.setSurrendersFocusOnKeystroke(true);
        user_list.getTableHeader().setResizingAllowed(false);
        user_list.getTableHeader().setReorderingAllowed(false);

        btn_addUser.setBackground(new java.awt.Color(255, 0, 0));
        btn_addUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_addUser.setRoundBottomLeft(30);
        btn_addUser.setRoundBottomRight(30);
        btn_addUser.setRoundTopLeft(30);
        btn_addUser.setRoundTopRight(30);
        btn_addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addUserMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Add");

        javax.swing.GroupLayout btn_addUserLayout = new javax.swing.GroupLayout(btn_addUser);
        btn_addUser.setLayout(btn_addUserLayout);
        btn_addUserLayout.setHorizontalGroup(
            btn_addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_addUserLayout.setVerticalGroup(
            btn_addUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        btn_editUser.setBackground(new java.awt.Color(255, 0, 0));
        btn_editUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_editUser.setRoundBottomLeft(30);
        btn_editUser.setRoundBottomRight(30);
        btn_editUser.setRoundTopLeft(30);
        btn_editUser.setRoundTopRight(30);
        btn_editUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editUserMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Edit");

        javax.swing.GroupLayout btn_editUserLayout = new javax.swing.GroupLayout(btn_editUser);
        btn_editUser.setLayout(btn_editUserLayout);
        btn_editUserLayout.setHorizontalGroup(
            btn_editUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_editUserLayout.setVerticalGroup(
            btn_editUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        btn_resetPassword.setBackground(new java.awt.Color(255, 0, 0));
        btn_resetPassword.setForeground(new java.awt.Color(255, 255, 255));
        btn_resetPassword.setRoundBottomLeft(30);
        btn_resetPassword.setRoundBottomRight(30);
        btn_resetPassword.setRoundTopLeft(30);
        btn_resetPassword.setRoundTopRight(30);
        btn_resetPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_resetPasswordMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reset");

        javax.swing.GroupLayout btn_resetPasswordLayout = new javax.swing.GroupLayout(btn_resetPassword);
        btn_resetPassword.setLayout(btn_resetPasswordLayout);
        btn_resetPasswordLayout.setHorizontalGroup(
            btn_resetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_resetPasswordLayout.setVerticalGroup(
            btn_resetPasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        btn_deleteUser.setBackground(new java.awt.Color(255, 0, 0));
        btn_deleteUser.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteUser.setRoundBottomLeft(30);
        btn_deleteUser.setRoundBottomRight(30);
        btn_deleteUser.setRoundTopLeft(30);
        btn_deleteUser.setRoundTopRight(30);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Delete");

        javax.swing.GroupLayout btn_deleteUserLayout = new javax.swing.GroupLayout(btn_deleteUser);
        btn_deleteUser.setLayout(btn_deleteUserLayout);
        btn_deleteUserLayout.setHorizontalGroup(
            btn_deleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_deleteUserLayout.setVerticalGroup(
            btn_deleteUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout user_tabLayout = new javax.swing.GroupLayout(user_tab);
        user_tab.setLayout(user_tabLayout);
        user_tabLayout.setHorizontalGroup(
            user_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_tabLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(user_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(user_tabLayout.createSequentialGroup()
                        .addComponent(btn_addUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btn_editUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btn_resetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btn_deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(user_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(user_list, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        user_tabLayout.setVerticalGroup(
            user_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(user_tabLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(user_list, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(user_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_addUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_resetPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        if (user_list.getColumnModel().getColumnCount() > 0) {
            user_list.getColumnModel().getColumn(0).setResizable(false);
            user_list.getColumnModel().getColumn(0).setPreferredWidth(10);
            user_list.getColumnModel().getColumn(1).setResizable(false);
            user_list.getColumnModel().getColumn(2).setResizable(false);
            user_list.getColumnModel().getColumn(2).setPreferredWidth(800);
        }

        jTabbedPane1.addTab("tab1", user_tab);

        product_tab.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel15.setText("PRODUCT MANAGEMENT");

        jSeparator2.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 5));

        user_list1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        user_list1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"001", "testing product name", "110.00", "Available"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Price", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        user_list1.setGridColor(new java.awt.Color(230, 0, 0));
        user_list1.setIntercellSpacing(new java.awt.Dimension(10, 10));
        user_list1.setRowHeight(80);
        user_list1.setSelectionBackground(new java.awt.Color(255, 171, 171));
        user_list1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        user_list1.setShowVerticalLines(false);
        user_list1.setSurrendersFocusOnKeystroke(true);
        user_list1.getTableHeader().setResizingAllowed(false);
        user_list1.getTableHeader().setReorderingAllowed(false);

        btn_addMenu.setBackground(new java.awt.Color(255, 0, 0));
        btn_addMenu.setForeground(new java.awt.Color(255, 255, 255));
        btn_addMenu.setRoundBottomLeft(30);
        btn_addMenu.setRoundBottomRight(30);
        btn_addMenu.setRoundTopLeft(30);
        btn_addMenu.setRoundTopRight(30);
        btn_addMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addMenuMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Add");

        javax.swing.GroupLayout btn_addMenuLayout = new javax.swing.GroupLayout(btn_addMenu);
        btn_addMenu.setLayout(btn_addMenuLayout);
        btn_addMenuLayout.setHorizontalGroup(
            btn_addMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_addMenuLayout.setVerticalGroup(
            btn_addMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        btn_editMenu.setBackground(new java.awt.Color(255, 0, 0));
        btn_editMenu.setForeground(new java.awt.Color(255, 255, 255));
        btn_editMenu.setRoundBottomLeft(30);
        btn_editMenu.setRoundBottomRight(30);
        btn_editMenu.setRoundTopLeft(30);
        btn_editMenu.setRoundTopRight(30);
        btn_editMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMenuMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Edit");

        javax.swing.GroupLayout btn_editMenuLayout = new javax.swing.GroupLayout(btn_editMenu);
        btn_editMenu.setLayout(btn_editMenuLayout);
        btn_editMenuLayout.setHorizontalGroup(
            btn_editMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_editMenuLayout.setVerticalGroup(
            btn_editMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        btn_deleteMenu.setBackground(new java.awt.Color(255, 0, 0));
        btn_deleteMenu.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteMenu.setRoundBottomLeft(30);
        btn_deleteMenu.setRoundBottomRight(30);
        btn_deleteMenu.setRoundTopLeft(30);
        btn_deleteMenu.setRoundTopRight(30);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Delete");

        javax.swing.GroupLayout btn_deleteMenuLayout = new javax.swing.GroupLayout(btn_deleteMenu);
        btn_deleteMenu.setLayout(btn_deleteMenuLayout);
        btn_deleteMenuLayout.setHorizontalGroup(
            btn_deleteMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btn_deleteMenuLayout.setVerticalGroup(
            btn_deleteMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout product_tabLayout = new javax.swing.GroupLayout(product_tab);
        product_tab.setLayout(product_tabLayout);
        product_tabLayout.setHorizontalGroup(
            product_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_tabLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(product_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(product_tabLayout.createSequentialGroup()
                        .addComponent(btn_addMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btn_editMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btn_deleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(product_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(user_list1, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        product_tabLayout.setVerticalGroup(
            product_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(product_tabLayout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(user_list1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(product_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_addMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_deleteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        if (user_list1.getColumnModel().getColumnCount() > 0) {
            user_list1.getColumnModel().getColumn(0).setResizable(false);
            user_list1.getColumnModel().getColumn(1).setResizable(false);
            user_list1.getColumnModel().getColumn(1).setPreferredWidth(500);
            user_list1.getColumnModel().getColumn(2).setResizable(false);
            user_list1.getColumnModel().getColumn(2).setPreferredWidth(30);
            user_list1.getColumnModel().getColumn(3).setResizable(false);
        }

        jTabbedPane1.addTab("tab1", product_tab);

        payment_tab.setOpaque(false);

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel27.setText("PAYMENT SETTINGS");

        jSeparator5.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator5.setPreferredSize(new java.awt.Dimension(0, 5));

        btn_editPayment.setBackground(new java.awt.Color(255, 0, 0));
        btn_editPayment.setForeground(new java.awt.Color(255, 255, 255));
        btn_editPayment.setRoundBottomLeft(30);
        btn_editPayment.setRoundBottomRight(30);
        btn_editPayment.setRoundTopLeft(30);
        btn_editPayment.setRoundTopRight(30);
        btn_editPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editPaymentMouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Edit");

        javax.swing.GroupLayout btn_editPaymentLayout = new javax.swing.GroupLayout(btn_editPayment);
        btn_editPayment.setLayout(btn_editPaymentLayout);
        btn_editPaymentLayout.setHorizontalGroup(
            btn_editPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );
        btn_editPaymentLayout.setVerticalGroup(
            btn_editPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
        );

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel31.setText("GCASH PAYMENT SETTINGS");

        jLabel32.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel32.setText("Availability: ");

        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel33.setText("Gcash Number : ");

        gcash_qr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gcash_qr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/qr.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gcash_qr, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 563, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(gcash_qr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
        );

        gcash_availability.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        gcash_availability.setText("AVAILABLE");

        gcash_number.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        gcash_number.setText("09294422127");

        javax.swing.GroupLayout payment_tabLayout = new javax.swing.GroupLayout(payment_tab);
        payment_tab.setLayout(payment_tabLayout);
        payment_tabLayout.setHorizontalGroup(
            payment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payment_tabLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(payment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payment_tabLayout.createSequentialGroup()
                        .addGroup(payment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gcash_availability, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gcash_number, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))
                    .addGroup(payment_tabLayout.createSequentialGroup()
                        .addGroup(payment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        payment_tabLayout.setVerticalGroup(
            payment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payment_tabLayout.createSequentialGroup()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(payment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payment_tabLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel33)
                        .addGap(55, 55, 55)
                        .addComponent(gcash_number)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel32)
                        .addGap(48, 48, 48)
                        .addComponent(gcash_availability))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(btn_editPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", payment_tab);

        sales_reports_tab.setOpaque(false);
        sales_reports_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel23.setText("SALES REPORTS");
        sales_reports_tab.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 0, 822, 120));

        jSeparator4.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 5));
        sales_reports_tab.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 447, 25));

        jScrollPane1.setBorder(null);

        sales_report_list.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        sales_report_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08/03/2019", "3", "460"},
                {"08/04/2019", "1", "110"},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date ", "Quantity Sales", "Total Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sales_report_list.setGridColor(new java.awt.Color(230, 0, 0));
        sales_report_list.setIntercellSpacing(new java.awt.Dimension(10, 10));
        sales_report_list.setRowHeight(80);
        sales_report_list.setSelectionBackground(new java.awt.Color(255, 171, 171));
        sales_report_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        sales_report_list.setShowVerticalLines(false);
        sales_report_list.setSurrendersFocusOnKeystroke(true);
        sales_report_list.getTableHeader().setResizingAllowed(false);
        sales_report_list.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(sales_report_list);
        if (sales_report_list.getColumnModel().getColumnCount() > 0) {
            sales_report_list.getColumnModel().getColumn(0).setResizable(false);
            sales_report_list.getColumnModel().getColumn(0).setPreferredWidth(400);
            sales_report_list.getColumnModel().getColumn(1).setResizable(false);
            sales_report_list.getColumnModel().getColumn(2).setResizable(false);
        }

        sales_reports_tab.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 1440, 610));

        btn_viewReceipt.setBackground(new java.awt.Color(255, 0, 0));
        btn_viewReceipt.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewReceipt.setRoundBottomLeft(30);
        btn_viewReceipt.setRoundBottomRight(30);
        btn_viewReceipt.setRoundTopLeft(30);
        btn_viewReceipt.setRoundTopRight(30);

        sales_view.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        sales_view.setForeground(new java.awt.Color(255, 255, 255));
        sales_view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sales_view.setText("View");
        sales_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_viewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_viewReceiptLayout = new javax.swing.GroupLayout(btn_viewReceipt);
        btn_viewReceipt.setLayout(btn_viewReceiptLayout);
        btn_viewReceiptLayout.setHorizontalGroup(
            btn_viewReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sales_view, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        btn_viewReceiptLayout.setVerticalGroup(
            btn_viewReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sales_view, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        sales_reports_tab.add(btn_viewReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1265, 870, 250, 70));

        cmb_sales.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cmb_sales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly" }));
        cmb_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_salesActionPerformed(evt);
            }
        });
        sales_reports_tab.add(cmb_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 447, 68));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        sales_reports_tab.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 770, 40));

        daily_weekly_tab.setOpaque(false);

        jDateChooser1.setDateFormatString("yy/MM/dd hh:mm:ss");
        jDateChooser1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jDateChooser2.setDateFormatString("yy/MM/dd hh:mm:ss");
        jDateChooser2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("to");

        javax.swing.GroupLayout daily_weekly_tabLayout = new javax.swing.GroupLayout(daily_weekly_tab);
        daily_weekly_tab.setLayout(daily_weekly_tabLayout);
        daily_weekly_tabLayout.setHorizontalGroup(
            daily_weekly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daily_weekly_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        daily_weekly_tabLayout.setVerticalGroup(
            daily_weekly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daily_weekly_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(daily_weekly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        sales_tabbedPane.addTab("tab1", daily_weekly_tab);

        monthly_tab.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("to");

        jMonthChooser1.setBackground(new java.awt.Color(255, 255, 255));
        jMonthChooser1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jMonthChooser2.setBackground(new java.awt.Color(255, 255, 255));
        jMonthChooser2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        javax.swing.GroupLayout monthly_tabLayout = new javax.swing.GroupLayout(monthly_tab);
        monthly_tab.setLayout(monthly_tabLayout);
        monthly_tabLayout.setHorizontalGroup(
            monthly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthly_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMonthChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
        );
        monthly_tabLayout.setVerticalGroup(
            monthly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthly_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(monthly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monthly_tabLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monthly_tabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(monthly_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMonthChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMonthChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        sales_tabbedPane.addTab("tab1", monthly_tab);

        sales_reports_tab.add(sales_tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 680, 100));

        jTabbedPane1.addTab("tab1", sales_reports_tab);

        transactions_tab.setOpaque(false);
        transactions_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel26.setText("TRANSACTIONS");
        transactions_tab.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 0, 822, 120));

        jSeparator8.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator8.setPreferredSize(new java.awt.Dimension(0, 5));
        transactions_tab.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 447, 25));

        jScrollPane2.setBorder(null);

        transaction_list.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        transaction_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08/03/2019", "001", "Table 1", "110"},
                {"08/04/2019", "5", "Table 1", "460"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date ", "Order Number", "Username", "Total Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transaction_list.setGridColor(new java.awt.Color(230, 0, 0));
        transaction_list.setIntercellSpacing(new java.awt.Dimension(10, 10));
        transaction_list.setRowHeight(80);
        transaction_list.setSelectionBackground(new java.awt.Color(255, 171, 171));
        transaction_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        transaction_list.setShowVerticalLines(false);
        transaction_list.setSurrendersFocusOnKeystroke(true);
        transaction_list.getTableHeader().setResizingAllowed(false);
        transaction_list.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(transaction_list);
        if (transaction_list.getColumnModel().getColumnCount() > 0) {
            transaction_list.getColumnModel().getColumn(0).setResizable(false);
            transaction_list.getColumnModel().getColumn(0).setPreferredWidth(400);
            transaction_list.getColumnModel().getColumn(1).setResizable(false);
            transaction_list.getColumnModel().getColumn(2).setResizable(false);
            transaction_list.getColumnModel().getColumn(3).setResizable(false);
            transaction_list.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        transactions_tab.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 1440, 610));

        btn_viewReceipt1.setBackground(new java.awt.Color(255, 0, 0));
        btn_viewReceipt1.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewReceipt1.setRoundBottomLeft(30);
        btn_viewReceipt1.setRoundBottomRight(30);
        btn_viewReceipt1.setRoundTopLeft(30);
        btn_viewReceipt1.setRoundTopRight(30);

        sales_view1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        sales_view1.setForeground(new java.awt.Color(255, 255, 255));
        sales_view1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sales_view1.setText("View");
        sales_view1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sales_view1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_viewReceipt1Layout = new javax.swing.GroupLayout(btn_viewReceipt1);
        btn_viewReceipt1.setLayout(btn_viewReceipt1Layout);
        btn_viewReceipt1Layout.setHorizontalGroup(
            btn_viewReceipt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sales_view1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        btn_viewReceipt1Layout.setVerticalGroup(
            btn_viewReceipt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sales_view1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        transactions_tab.add(btn_viewReceipt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1265, 870, 250, 70));

        cmb_transactions.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cmb_transactions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly" }));
        cmb_transactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_transactionsActionPerformed(evt);
            }
        });
        transactions_tab.add(cmb_transactions, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 447, 68));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        transactions_tab.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 770, 40));

        daily_weekly_tab3.setOpaque(false);

        jDateChooser7.setDateFormatString("yy/MM/dd hh:mm:ss");
        jDateChooser7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jDateChooser8.setDateFormatString("yy/MM/dd hh:mm:ss");
        jDateChooser8.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("to");

        javax.swing.GroupLayout daily_weekly_tab3Layout = new javax.swing.GroupLayout(daily_weekly_tab3);
        daily_weekly_tab3.setLayout(daily_weekly_tab3Layout);
        daily_weekly_tab3Layout.setHorizontalGroup(
            daily_weekly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daily_weekly_tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jDateChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        daily_weekly_tab3Layout.setVerticalGroup(
            daily_weekly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daily_weekly_tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(daily_weekly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jDateChooser8, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jDateChooser7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        sales_tabbedPane1.addTab("tab1", daily_weekly_tab3);

        monthly_tab3.setOpaque(false);

        jLabel36.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("to");

        jMonthChooser7.setBackground(new java.awt.Color(255, 255, 255));
        jMonthChooser7.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jMonthChooser8.setBackground(new java.awt.Color(255, 255, 255));
        jMonthChooser8.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        javax.swing.GroupLayout monthly_tab3Layout = new javax.swing.GroupLayout(monthly_tab3);
        monthly_tab3.setLayout(monthly_tab3Layout);
        monthly_tab3Layout.setHorizontalGroup(
            monthly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthly_tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jMonthChooser7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMonthChooser8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
        );
        monthly_tab3Layout.setVerticalGroup(
            monthly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monthly_tab3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(monthly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monthly_tab3Layout.createSequentialGroup()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monthly_tab3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(monthly_tab3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jMonthChooser7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMonthChooser8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        sales_tabbedPane1.addTab("tab1", monthly_tab3);

        transactions_tab.add(sales_tabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 680, 100));

        jTabbedPane1.addTab("tab1", transactions_tab);

        log_reports_tab.setOpaque(false);
        log_reports_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel25.setText("LOG REPORTS");
        log_reports_tab.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 0, 822, 120));

        jSeparator6.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jSeparator6.setPreferredSize(new java.awt.Dimension(0, 5));
        log_reports_tab.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 447, 25));

        log_reports_list.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        log_reports_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"05/23/22", "table1", "Made a payment of 890.00"},
                {"11/12/22", "kitchen", "Logged in on 11/12/22 12:22:33"},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date & Time", "Username", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        log_reports_list.setGridColor(new java.awt.Color(230, 0, 0));
        log_reports_list.setIntercellSpacing(new java.awt.Dimension(10, 10));
        log_reports_list.setRowHeight(80);
        log_reports_list.setSelectionBackground(new java.awt.Color(255, 171, 171));
        log_reports_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        log_reports_list.setShowVerticalLines(false);
        log_reports_list.setSurrendersFocusOnKeystroke(true);
        log_reports_list.getTableHeader().setResizingAllowed(false);
        log_reports_list.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(log_reports_list);
        if (log_reports_list.getColumnModel().getColumnCount() > 0) {
            log_reports_list.getColumnModel().getColumn(0).setResizable(false);
            log_reports_list.getColumnModel().getColumn(0).setPreferredWidth(400);
            log_reports_list.getColumnModel().getColumn(1).setResizable(false);
            log_reports_list.getColumnModel().getColumn(2).setResizable(false);
            log_reports_list.getColumnModel().getColumn(2).setPreferredWidth(600);
        }

        log_reports_tab.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 1430, 590));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        log_reports_tab.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 770, 40));

        daily_weekly_tab1.setOpaque(false);

        jDateChooser3.setDateFormatString("yy/MM/dd hh:mm:ss");
        jDateChooser3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jDateChooser4.setDateFormatString("yy/MM/dd hh:mm:ss");
        jDateChooser4.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("to");

        javax.swing.GroupLayout daily_weekly_tab1Layout = new javax.swing.GroupLayout(daily_weekly_tab1);
        daily_weekly_tab1.setLayout(daily_weekly_tab1Layout);
        daily_weekly_tab1Layout.setHorizontalGroup(
            daily_weekly_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daily_weekly_tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        daily_weekly_tab1Layout.setVerticalGroup(
            daily_weekly_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(daily_weekly_tab1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(daily_weekly_tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        log_tabbedPAne.addTab("tab1", daily_weekly_tab1);

        log_reports_tab.add(log_tabbedPAne, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 680, 100));

        btn_viewReceipt2.setBackground(new java.awt.Color(255, 0, 0));
        btn_viewReceipt2.setForeground(new java.awt.Color(255, 255, 255));
        btn_viewReceipt2.setRoundBottomLeft(30);
        btn_viewReceipt2.setRoundBottomRight(30);
        btn_viewReceipt2.setRoundTopLeft(30);
        btn_viewReceipt2.setRoundTopRight(30);

        log_view.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        log_view.setForeground(new java.awt.Color(255, 255, 255));
        log_view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        log_view.setText("View");
        log_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                log_viewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btn_viewReceipt2Layout = new javax.swing.GroupLayout(btn_viewReceipt2);
        btn_viewReceipt2.setLayout(btn_viewReceipt2Layout);
        btn_viewReceipt2Layout.setHorizontalGroup(
            btn_viewReceipt2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(log_view, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        btn_viewReceipt2Layout.setVerticalGroup(
            btn_viewReceipt2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(log_view, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        log_reports_tab.add(btn_viewReceipt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1265, 870, 250, 70));

        jTabbedPane1.addTab("tab1", log_reports_tab);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 1560, 1000));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -6, 1920, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void account_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_managementMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_account_managementMouseClicked

    private void account_managementMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_managementMousePressed
        account_management.setBackground(clickedColor);
        product_management.setBackground(defaultColor);
        payment_settings.setBackground(defaultColor);
        sales_reports.setBackground(defaultColor);
        transactions.setBackground(defaultColor);
        log_reports.setBackground(defaultColor);
        logout.setBackground(defaultColor);
    }//GEN-LAST:event_account_managementMousePressed

    private void account_managementMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account_managementMouseReleased

    }//GEN-LAST:event_account_managementMouseReleased

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        login li = new login();
        li.setVisible(true);
        close();
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
        account_management.setBackground(defaultColor);
        product_management.setBackground(defaultColor);
        payment_settings.setBackground(defaultColor);
        sales_reports.setBackground(defaultColor);
        transactions.setBackground(defaultColor);
        log_reports.setBackground(defaultColor);
        logout.setBackground(clickedColor);
    }//GEN-LAST:event_logoutMousePressed

    private void product_managementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_managementMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_product_managementMouseClicked

    private void product_managementMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_managementMousePressed
        account_management.setBackground(defaultColor);
        product_management.setBackground(clickedColor);
        payment_settings.setBackground(defaultColor);
        sales_reports.setBackground(defaultColor);
        transactions.setBackground(defaultColor);
        log_reports.setBackground(defaultColor);
        logout.setBackground(defaultColor);
    }//GEN-LAST:event_product_managementMousePressed

    private void product_managementMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_managementMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_product_managementMouseReleased

    private void payment_settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_settingsMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_payment_settingsMouseClicked

    private void payment_settingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_settingsMousePressed
        account_management.setBackground(defaultColor);
        product_management.setBackground(defaultColor);
        payment_settings.setBackground(clickedColor);
        sales_reports.setBackground(defaultColor);
        transactions.setBackground(defaultColor);
        log_reports.setBackground(defaultColor);
        logout.setBackground(defaultColor);
    }//GEN-LAST:event_payment_settingsMousePressed

    private void payment_settingsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_settingsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_payment_settingsMouseReleased

    private void sales_reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_reportsMouseClicked
        jTabbedPane1.setSelectedIndex(3);
        
        addRowToSalesReport();
    }//GEN-LAST:event_sales_reportsMouseClicked

    private void sales_reportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_reportsMousePressed
        account_management.setBackground(defaultColor);
        product_management.setBackground(defaultColor);
        payment_settings.setBackground(defaultColor);
        sales_reports.setBackground(clickedColor);
        transactions.setBackground(defaultColor);
        log_reports.setBackground(defaultColor);
        logout.setBackground(defaultColor);
    }//GEN-LAST:event_sales_reportsMousePressed

    private void sales_reportsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_reportsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_sales_reportsMouseReleased

    private void btn_addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addUserMouseClicked
        index = 0;
        userModal.setVisible(true);
        userModal.selectTab(index);
    }//GEN-LAST:event_btn_addUserMouseClicked

    private void btn_editUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editUserMouseClicked
        index = 1;
        userModal.setVisible(true);
        userModal.selectTab(index);
    }//GEN-LAST:event_btn_editUserMouseClicked

    private void btn_resetPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resetPasswordMouseClicked
        index = 2;
        userModal.setVisible(true);
        userModal.selectTab(index);
    }//GEN-LAST:event_btn_resetPasswordMouseClicked

    private void btn_addMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addMenuMouseClicked
        index = 0;
        menuModal.setVisible(true);
        menuModal.selectTab(index);
    }//GEN-LAST:event_btn_addMenuMouseClicked

    private void btn_editMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMenuMouseClicked
        index = 1;
        menuModal.setVisible(true);
        menuModal.selectTab(index);
    }//GEN-LAST:event_btn_editMenuMouseClicked

    private void btn_editPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editPaymentMouseClicked
        paymentModal.setVisible(true);
    }//GEN-LAST:event_btn_editPaymentMouseClicked

    private void transactionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionsMouseClicked
        jTabbedPane1.setSelectedIndex(4);
        addRowToTransaction();
    }//GEN-LAST:event_transactionsMouseClicked

    private void transactionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionsMousePressed
        account_management.setBackground(defaultColor);
        product_management.setBackground(defaultColor);
        payment_settings.setBackground(defaultColor);
        sales_reports.setBackground(defaultColor);
        transactions.setBackground(clickedColor);
        log_reports.setBackground(defaultColor);
        logout.setBackground(defaultColor);
    }//GEN-LAST:event_transactionsMousePressed

    private void transactionsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionsMouseReleased

    private void log_reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_reportsMouseClicked
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_log_reportsMouseClicked

    private void log_reportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_reportsMousePressed
        account_management.setBackground(defaultColor);
        product_management.setBackground(defaultColor);
        payment_settings.setBackground(defaultColor);
        sales_reports.setBackground(defaultColor);
        transactions.setBackground(defaultColor);
        log_reports.setBackground(clickedColor);
        logout.setBackground(defaultColor);
    }//GEN-LAST:event_log_reportsMousePressed

    private void log_reportsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_reportsMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_log_reportsMouseReleased

    private void cmb_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_salesActionPerformed
        int selectedIndex = cmb_sales.getSelectedIndex();
        
        if(selectedIndex == 0 || selectedIndex == 1) sales_tabbedPane.setSelectedIndex(0);
        else if (selectedIndex == 2 ) sales_tabbedPane.setSelectedIndex(1);
    }//GEN-LAST:event_cmb_salesActionPerformed

    private void sales_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_viewMouseClicked
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        String datetime= dtf.format(now);
        
        String dateOfSalesReport = "Sales Report (" + datetime + ")"+(".pdf");
        Document doc = new Document();
        String saveFolderPath = "C:\\Users\\Gelay\\Documents\\menuBytes_admin\\src\\Reports";
              
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(saveFolderPath+"\\"+dateOfSalesReport));
            
            doc.open();
            //Logo
//            Path path = Paths.get(ClassLoader.getSystemResource("mainlogo_thumbnail.png").toURI());
//            Image img = Image.getInstance(path.toAbsolutePath().toString());
//            img.setSpacingAfter(TOP_ALIGNMENT);
//            doc.add(img);
            
            //Header
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//            Chunk chunk = new Chunk("SALES REPORT", font);
//
//            doc.add(chunk);
            
            int columnCount = 3;
            PdfPTable receiptTable = new PdfPTable(columnCount);
            
            receiptTable.addCell("Date");
            receiptTable.addCell("Quality Sales");
            receiptTable.addCell("Total Sales");
            System.out.println(sales_report_list.getRowCount());
            for(int rowCount = 0; rowCount < sales_report_list.getRowCount(); rowCount++){
                
                String date = sales_report_list.getValueAt(rowCount, 0).toString();
                String quality = sales_report_list.getValueAt(rowCount, 1).toString();
                String total = sales_report_list.getValueAt(rowCount, 2).toString();
                
                receiptTable.addCell(date);
                receiptTable.addCell(quality);
                receiptTable.addCell(total);
            }
            
            doc.add(receiptTable);
            doc.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (URISyntaxException ex) {
//            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        catch (IOException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sales_viewMouseClicked

    private void sales_view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sales_view1MouseClicked
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        String datetime= dtf.format(now);
        
        String dateOfSalesReport = "Transactions Report (" + datetime + ")"+(".pdf");
        Document doc = new Document();
        String saveFolderPath = "C:\\Users\\Gelay\\Documents\\menuBytes_admin\\src\\Reports";
              
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(saveFolderPath+"\\"+dateOfSalesReport));
            
            doc.open();
            //Logo
//            Path path = Paths.get(ClassLoader.getSystemResource("mainlogo_thumbnail.png").toURI());
//            Image img = Image.getInstance(path.toAbsolutePath().toString());
//            img.setSpacingAfter(TOP_ALIGNMENT);
//            doc.add(img);
            
            //Header
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//            Chunk chunk = new Chunk("SALES REPORT", font);
//
//            doc.add(chunk);
            
            int columnCount = 4;
            PdfPTable receiptTable = new PdfPTable(columnCount);
            
            receiptTable.addCell("Date");
            receiptTable.addCell("Order Number");
            receiptTable.addCell("Username");
            receiptTable.addCell("Total Amount");
            
            System.out.println(transaction_list.getRowCount());
            for(int rowCount = 0; rowCount < transaction_list.getRowCount(); rowCount++){
                
                String date = transaction_list.getValueAt(rowCount, 0).toString();
                String orderNum = transaction_list.getValueAt(rowCount, 1).toString();
                String username = transaction_list.getValueAt(rowCount, 2).toString();
                String total = transaction_list.getValueAt(rowCount, 3).toString();
                
                receiptTable.addCell(date);
                receiptTable.addCell(orderNum);
                receiptTable.addCell(username);
                receiptTable.addCell(total);
            }
            
            doc.add(receiptTable);
            doc.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (URISyntaxException ex) {
//            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        catch (IOException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sales_view1MouseClicked

    private void cmb_transactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_transactionsActionPerformed
        addRowToTransaction();
    }//GEN-LAST:event_cmb_transactionsActionPerformed

    private void log_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_log_viewMouseClicked
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        String datetime= dtf.format(now);
        
        String dateOfSalesReport = "Logs Report (" + datetime + ")"+(".pdf");
        Document doc = new Document();
        String saveFolderPath = "C:\\Users\\Gelay\\Documents\\menuBytes_admin\\src\\Reports";
              
        
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(saveFolderPath+"\\"+dateOfSalesReport));
            
            doc.open();
            //Logo
//            Path path = Paths.get(ClassLoader.getSystemResource("mainlogo_thumbnail.png").toURI());
//            Image img = Image.getInstance(path.toAbsolutePath().toString());
//            img.setSpacingAfter(TOP_ALIGNMENT);
//            doc.add(img);
            
            //Header
//            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
//            Chunk chunk = new Chunk("SALES REPORT", font);
//
//            doc.add(chunk);
            
            int columnCount = 3;
            PdfPTable receiptTable = new PdfPTable(columnCount);
            
            receiptTable.addCell("Date");
            receiptTable.addCell("Username");
            receiptTable.addCell("Description");
            System.out.println(log_reports_list.getRowCount());
            for(int rowCount = 0; rowCount < log_reports_list.getRowCount(); rowCount++){
                
                String date = log_reports_list.getValueAt(rowCount, 0).toString();
                String username = log_reports_list.getValueAt(rowCount, 1).toString();
                String description = log_reports_list.getValueAt(rowCount, 2).toString();
                
                receiptTable.addCell(date);
                receiptTable.addCell(username);
                receiptTable.addCell(description);
            }
            
            doc.add(receiptTable);
            doc.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (URISyntaxException ex) {
//            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        } 
        catch (IOException ex) {
            Logger.getLogger(admin_dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_log_viewMouseClicked

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
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel account_management;
    private javax.swing.JLabel background;
    private roundPanel btn_addMenu;
    private roundPanel btn_addUser;
    private roundPanel btn_deleteMenu;
    private roundPanel btn_deleteUser;
    private roundPanel btn_editMenu;
    private roundPanel btn_editPayment;
    private roundPanel btn_editUser;
    private roundPanel btn_resetPassword;
    private roundPanel btn_viewReceipt;
    private roundPanel btn_viewReceipt1;
    private roundPanel btn_viewReceipt2;
    private javax.swing.JComboBox<String> cmb_sales;
    private javax.swing.JComboBox<String> cmb_transactions;
    private javax.swing.JPanel daily_weekly_tab;
    private javax.swing.JPanel daily_weekly_tab1;
    private javax.swing.JPanel daily_weekly_tab3;
    private javax.swing.JLabel gcash_availability;
    private javax.swing.JLabel gcash_number;
    private javax.swing.JLabel gcash_qr;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser7;
    private com.toedter.calendar.JDateChooser jDateChooser8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private com.toedter.calendar.JMonthChooser jMonthChooser7;
    private com.toedter.calendar.JMonthChooser jMonthChooser8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel log_reports;
    private javax.swing.JTable log_reports_list;
    private javax.swing.JPanel log_reports_tab;
    private javax.swing.JTabbedPane log_tabbedPAne;
    private javax.swing.JLabel log_view;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel monthly_tab;
    private javax.swing.JPanel monthly_tab3;
    private javax.swing.JPanel payment_settings;
    private javax.swing.JPanel payment_tab;
    private javax.swing.JPanel product_management;
    private javax.swing.JPanel product_tab;
    private javax.swing.JTable sales_report_list;
    private javax.swing.JPanel sales_reports;
    private javax.swing.JPanel sales_reports_tab;
    private javax.swing.JTabbedPane sales_tabbedPane;
    private javax.swing.JTabbedPane sales_tabbedPane1;
    private javax.swing.JLabel sales_view;
    private javax.swing.JLabel sales_view1;
    private javax.swing.JPanel sidePane;
    private javax.swing.JTable transaction_list;
    private javax.swing.JPanel transactions;
    private javax.swing.JPanel transactions_tab;
    private javax.swing.JTable user_list;
    private javax.swing.JTable user_list1;
    private javax.swing.JPanel user_tab;
    // End of variables declaration//GEN-END:variables
}
