
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tmjp
 */
public class view_cart extends javax.swing.JFrame{

    /**
     * Creates new form view_cart
     */
    private String table_no;
    private String total;
    String username;
    //WAG GALAWIN ang arraylist na tohsqxs
     private static ArrayList<Order> orderArrayList = new ArrayList<>();
   
    
    public void setTableNo(String table_no)
    {
        this.table_no = table_no;
    } 
    
    public String getTableNo(){
        return this.table_no;
    }
    
    public void setTotal(String total)
    {
        this.total = total;
    } 
    
    public String getTotal(){
        return this.total;
    }

    public view_cart(String table_no, String username) {
        initComponents();
        //Data to be displayed in the JTable
        this.table_no = table_no;
        this.username = username;
        setSubtotal(table_no);
        addRowToPendingJtable();  
        addRowToCompletedJtable();
        
        System.out.println("view cart CALLED");
        ArrayList<Cash> CashArrayList = new ArrayList<>(); 
        System.out.println("table_no: "+table_no);
        CashArrayList = DatabaseConnection.getInstance().getCashPaymentAmountReceived(table_no);
        if(!DatabaseConnection.getInstance().getCashPaymentAmountReceived(table_no).isEmpty()){
            if(CashArrayList.get(0).getDiscount_amount()!=null){
            txtDiscount.setText(CashArrayList.get(0).getDiscount_amount());
            }
            txtTotal_amount.setText(CashArrayList.get(0).getAmount_due());
        }
        
        ArrayList<GCash> gCashArrayList = new ArrayList<>();
        if(!DatabaseConnection.getInstance().getGCashAmountRemarks(table_no).isEmpty()){
                gCashArrayList = DatabaseConnection.getInstance().getGCashAmountRemarks(table_no);
                if(gCashArrayList.get(0).getDiscount_amount()!=null){
                txtDiscount.setText(gCashArrayList.get(0).getDiscount_amount());
                }
                txtTotal_amount.setText(gCashArrayList.get(0).getAmount_due());
        }

    }
    
    public view_cart(String table_no, String total, String username) {
        initComponents();
        //Data to be displayed in the JTable
        this.table_no = table_no;
        this.username = username;
        lbl_username.setText(table_no);
        gcash_username.setText(table_no);
        txt_amount_due_cash.setText(total);
        Double VAT = (Double.valueOf(total)/ 1.12) * 0.12;
        txtVat.setText(String.format("%.2f", VAT));
        txtSubtotal.setText(total);
        txtTotal_amount.setText(total);
        
        
        
    }
    
    public void cleargcashtextfields(){
        amount.setText("");
        ref_number.setText("");
        txtTotal_amount.setText("0.00");
        txtVat.setText("0.00");
        txtSubtotal.setText("0.00");
    }
    
    public void clearCashTextFields(){
        txt_cash_received.setText("0.00");
        lbl_change.setText("0.00");
        txt_amount_due_cash.setText("0.00");
        lbl_username.setText("-");
        txtTotal_amount.setText("0.00");
        txtVat.setText("0.00");
        txtSubtotal.setText("0.00");
    }
    
//    public void displayPaymentInfo(){
//        if(!getPaymentMethodInfo().isEmpty()){
//            ArrayList<PaymentMethod> paymentArrayList = getPaymentMethodInfo();
//            
//            ImageIcon format = new ImageIcon(paymentArrayList.get(0).getPayment_qr());
//            Image mm;
//            mm = format.getImage();
//            Image img2 = mm.getScaledInstance(format.getIconWidth(), 480, Image.SCALE_SMOOTH);
//            ImageIcon image = new ImageIcon(img2);
//            
//            gcash_qr.setIcon(image);
//        }
//    }
    
    public ArrayList getPaymentMethodInfo(){
        ArrayList<PaymentMethod> paymentListQueue = new ArrayList<PaymentMethod>();
        paymentListQueue = DatabaseConnection.getInstance().getPaymentMethodInfo();
        return paymentListQueue;
    }
    
    public String getGcashAvailability(){
        ArrayList<PaymentMethod> paymentArrayList = new ArrayList<PaymentMethod>();
        paymentArrayList = DatabaseConnection.getInstance().getGcashAvailability();
        String availability = paymentArrayList.get(0).getPayment_availability();
        return availability;
    }
    
    public view_cart() {
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

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JLabel();
        txtVat = new javax.swing.JLabel();
        txtTotal_amount = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDiscount = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        backgground = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btn_gcash = new javax.swing.JButton();
        btn_cash = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        default_payment_info = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        gcash_payment_info = new javax.swing.JPanel();
        gcash_username = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        ref_number = new javax.swing.JTextField();
        gcash_received = new javax.swing.JButton();
        gcash_reject = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        gcash_discountType = new javax.swing.JComboBox<>();
        gcash_discountAmount = new javax.swing.JTextField();
        gcash_idNumber = new javax.swing.JTextField();
        cash_payment_info = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_amount_due_cash = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_cash_received = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lbl_change = new javax.swing.JLabel();
        recieved_cash = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        cmbDiscountType_Cash = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtDiscountAmount_Cash = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtIDNumber_Cash = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_pending_orders = new javax.swing.JButton();
        btn_completed_orders = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pending_orders_tab = new javax.swing.JPanel();
        list_pending_orders = new javax.swing.JScrollPane();
        tbl_pending_orders = new javax.swing.JTable();
        completed_orders_tav = new javax.swing.JPanel();
        list_completed_orders = new javax.swing.JScrollPane();
        tbl_completed_orders = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cart");
        setBackground(new java.awt.Color(255, 255, 255));
        setName("Cart"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Subtotal :");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("VAT :");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("TOTAL AMOUNT :");

        txtSubtotal.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtSubtotal.setText("0.00");

        txtVat.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtVat.setText("0.00");

        txtTotal_amount.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        txtTotal_amount.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Discount :");

        txtDiscount.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtDiscount.setText("0.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 480, 210));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, 480, 170));

        backgground.setBackground(new java.awt.Color(255, 255, 255));
        backgground.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 5, true));
        backgground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(255, 51, 51), new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        btn_gcash.setBackground(new java.awt.Color(238, 0, 0));
        btn_gcash.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_gcash.setForeground(new java.awt.Color(255, 255, 255));
        btn_gcash.setText("Gcash Payment");
        btn_gcash.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 0, 0), 1, true));
        btn_gcash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_gcashMouseClicked(evt);
            }
        });

        btn_cash.setBackground(new java.awt.Color(238, 0, 0));
        btn_cash.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_cash.setForeground(new java.awt.Color(255, 255, 255));
        btn_cash.setText("Cash Payment");
        btn_cash.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(220, 0, 0), 1, true));
        btn_cash.setMaximumSize(new java.awt.Dimension(107, 23));
        btn_cash.setMinimumSize(new java.awt.Dimension(107, 23));
        btn_cash.setPreferredSize(new java.awt.Dimension(107, 23));
        btn_cash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cashMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btn_gcash, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(btn_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_gcash, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btn_cash, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 100));

        jTabbedPane2.setRequestFocusEnabled(false);

        default_payment_info.setBackground(new java.awt.Color(255, 255, 255));
        default_payment_info.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout default_payment_infoLayout = new javax.swing.GroupLayout(default_payment_info);
        default_payment_info.setLayout(default_payment_infoLayout);
        default_payment_infoLayout.setHorizontalGroup(
            default_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        default_payment_infoLayout.setVerticalGroup(
            default_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", default_payment_info);

        gcash_payment_info.setBackground(new java.awt.Color(255, 255, 255));
        gcash_payment_info.setOpaque(false);

        gcash_username.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        gcash_username.setText("-");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("Ref. No : ");

        amount.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        amount.setOpaque(false);

        ref_number.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ref_number.setOpaque(false);

        gcash_received.setBackground(new java.awt.Color(0, 255, 102));
        gcash_received.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gcash_received.setForeground(new java.awt.Color(255, 255, 255));
        gcash_received.setText("Received");
        gcash_received.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        gcash_received.setOpaque(false);
        gcash_received.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gcash_receivedMouseClicked(evt);
            }
        });

        gcash_reject.setBackground(new java.awt.Color(255, 0, 0));
        gcash_reject.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        gcash_reject.setForeground(new java.awt.Color(255, 255, 255));
        gcash_reject.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        gcash_reject.setLabel("Void");
        gcash_reject.setOpaque(false);
        gcash_reject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gcash_rejectMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel16.setText("Amount :");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel17.setText("ID Number:");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel18.setText("Username :");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setText("Discount Type:");

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel20.setText("Discount Amount:");

        gcash_discountType.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        gcash_discountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PWD", "Senior Citizen", "Government" }));
        gcash_discountType.setSelectedIndex(-1);
        gcash_discountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gcash_discountTypeActionPerformed(evt);
            }
        });

        gcash_discountAmount.setEditable(false);

        javax.swing.GroupLayout gcash_payment_infoLayout = new javax.swing.GroupLayout(gcash_payment_info);
        gcash_payment_info.setLayout(gcash_payment_infoLayout);
        gcash_payment_infoLayout.setHorizontalGroup(
            gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gcash_payment_infoLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(gcash_payment_infoLayout.createSequentialGroup()
                        .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gcash_discountType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(gcash_payment_infoLayout.createSequentialGroup()
                                .addComponent(gcash_username, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(gcash_discountAmount)
                            .addComponent(gcash_idNumber)))
                    .addGroup(gcash_payment_infoLayout.createSequentialGroup()
                        .addComponent(gcash_received, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gcash_reject, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gcash_payment_infoLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(ref_number, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gcash_payment_infoLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(83, 83, 83))
        );
        gcash_payment_infoLayout.setVerticalGroup(
            gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gcash_payment_infoLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gcash_username, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gcash_discountType, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gcash_discountAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gcash_idNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ref_number, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(gcash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gcash_received, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gcash_reject, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", gcash_payment_info);

        cash_payment_info.setBackground(new java.awt.Color(255, 255, 255));
        cash_payment_info.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel12.setText("Username :");

        lbl_username.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_username.setText("-");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setText("Amount Due : ");

        txt_amount_due_cash.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        txt_amount_due_cash.setText("0.00");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel14.setText("Cash Received :");

        txt_cash_received.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txt_cash_received.setText("0.00");
        txt_cash_received.setToolTipText("");
        txt_cash_received.setOpaque(false);
        txt_cash_received.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cash_receivedFocusLost(evt);
            }
        });
        txt_cash_received.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cash_receivedActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setText("Change :");

        lbl_change.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lbl_change.setText("0.00");
        lbl_change.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                lbl_changeCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });

        recieved_cash.setBackground(new java.awt.Color(255, 0, 0));
        recieved_cash.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        recieved_cash.setForeground(new java.awt.Color(255, 255, 255));
        recieved_cash.setText("Received");
        recieved_cash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recieved_cashMouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel21.setText("Discount Type :");

        cmbDiscountType_Cash.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cmbDiscountType_Cash.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PWD", "Senior Citizen", "Government" }));
        cmbDiscountType_Cash.setSelectedIndex(-1);
        cmbDiscountType_Cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiscountType_CashActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setText("Discount Amount :");

        txtDiscountAmount_Cash.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel23.setText("ID Number:");

        javax.swing.GroupLayout cash_payment_infoLayout = new javax.swing.GroupLayout(cash_payment_info);
        cash_payment_info.setLayout(cash_payment_infoLayout);
        cash_payment_infoLayout.setHorizontalGroup(
            cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cash_payment_infoLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(recieved_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cash_payment_infoLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cash_payment_infoLayout.createSequentialGroup()
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(txtIDNumber_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cash_payment_infoLayout.createSequentialGroup()
                                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_change, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cash_received, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_amount_due_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cash_payment_infoLayout.createSequentialGroup()
                                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbl_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDiscountType_Cash, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDiscountAmount_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        cash_payment_infoLayout.setVerticalGroup(
            cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cash_payment_infoLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbDiscountType_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cash_payment_infoLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtDiscountAmount_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cash_payment_infoLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtIDNumber_Cash, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_amount_due_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_cash_received, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cash_payment_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_change, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(recieved_cash, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane2.addTab("tab3", cash_payment_info);

        jPanel2.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 73, 660, 720));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_background.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 690, 690));

        backgground.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 17, 690, 800));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_pending_orders.setBackground(new java.awt.Color(255, 0, 0));
        btn_pending_orders.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_pending_orders.setForeground(new java.awt.Color(255, 255, 255));
        btn_pending_orders.setText("Pending Orders");
        btn_pending_orders.setBorder(null);
        btn_pending_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pending_ordersMouseClicked(evt);
            }
        });

        btn_completed_orders.setBackground(new java.awt.Color(255, 255, 255));
        btn_completed_orders.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        btn_completed_orders.setForeground(new java.awt.Color(255, 0, 0));
        btn_completed_orders.setText("Completed Orders");
        btn_completed_orders.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 5, 5, 1, new java.awt.Color(255, 0, 0)));
        btn_completed_orders.setMaximumSize(new java.awt.Dimension(107, 23));
        btn_completed_orders.setMinimumSize(new java.awt.Dimension(107, 23));
        btn_completed_orders.setPreferredSize(new java.awt.Dimension(107, 23));
        btn_completed_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_completed_ordersMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back_logo.png"))); // NOI18N
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_pending_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(btn_completed_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pending_orders, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btn_completed_orders, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        backgground.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 510, 120));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        pending_orders_tab.setBackground(new java.awt.Color(255, 255, 255));
        pending_orders_tab.setOpaque(false);

        list_pending_orders.setBackground(new java.awt.Color(255, 255, 255));
        list_pending_orders.setBorder(null);
        list_pending_orders.setOpaque(false);

        tbl_pending_orders.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tbl_pending_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Qty", "Product", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tbl_pending_orders.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_pending_orders.setIntercellSpacing(new java.awt.Dimension(10, 10));
        tbl_pending_orders.setRowHeight(40);
        tbl_pending_orders.setRowSelectionAllowed(false);
        tbl_pending_orders.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_pending_orders.setShowVerticalLines(false);
        tbl_pending_orders.setSurrendersFocusOnKeystroke(true);
        tbl_pending_orders.getTableHeader().setResizingAllowed(false);
        tbl_pending_orders.getTableHeader().setReorderingAllowed(false);
        list_pending_orders.setViewportView(tbl_pending_orders);
        if (tbl_pending_orders.getColumnModel().getColumnCount() > 0) {
            tbl_pending_orders.getColumnModel().getColumn(0).setResizable(false);
            tbl_pending_orders.getColumnModel().getColumn(1).setResizable(false);
            tbl_pending_orders.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_pending_orders.getColumnModel().getColumn(2).setResizable(false);
            tbl_pending_orders.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_pending_orders.getColumnModel().getColumn(3).setResizable(false);
            tbl_pending_orders.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout pending_orders_tabLayout = new javax.swing.GroupLayout(pending_orders_tab);
        pending_orders_tab.setLayout(pending_orders_tabLayout);
        pending_orders_tabLayout.setHorizontalGroup(
            pending_orders_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pending_orders_tabLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(list_pending_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        pending_orders_tabLayout.setVerticalGroup(
            pending_orders_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pending_orders_tabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list_pending_orders, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", pending_orders_tab);

        completed_orders_tav.setBackground(new java.awt.Color(255, 255, 255));
        completed_orders_tav.setOpaque(false);

        list_completed_orders.setBackground(new java.awt.Color(255, 255, 255));
        list_completed_orders.setBorder(null);
        list_completed_orders.setOpaque(false);

        tbl_completed_orders.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tbl_completed_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Qty", "Product", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
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
        tbl_completed_orders.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_completed_orders.setIntercellSpacing(new java.awt.Dimension(10, 10));
        tbl_completed_orders.setRowHeight(40);
        tbl_completed_orders.setRowSelectionAllowed(false);
        tbl_completed_orders.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_completed_orders.setShowVerticalLines(false);
        tbl_completed_orders.setSurrendersFocusOnKeystroke(true);
        tbl_completed_orders.getTableHeader().setResizingAllowed(false);
        tbl_completed_orders.getTableHeader().setReorderingAllowed(false);
        list_completed_orders.setViewportView(tbl_completed_orders);
        if (tbl_completed_orders.getColumnModel().getColumnCount() > 0) {
            tbl_completed_orders.getColumnModel().getColumn(0).setResizable(false);
            tbl_completed_orders.getColumnModel().getColumn(1).setResizable(false);
            tbl_completed_orders.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbl_completed_orders.getColumnModel().getColumn(2).setResizable(false);
            tbl_completed_orders.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_completed_orders.getColumnModel().getColumn(3).setResizable(false);
            tbl_completed_orders.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout completed_orders_tavLayout = new javax.swing.GroupLayout(completed_orders_tav);
        completed_orders_tav.setLayout(completed_orders_tavLayout);
        completed_orders_tavLayout.setHorizontalGroup(
            completed_orders_tavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, completed_orders_tavLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(list_completed_orders, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        completed_orders_tavLayout.setVerticalGroup(
            completed_orders_tavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(completed_orders_tavLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list_completed_orders, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", completed_orders_tav);

        backgground.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 500));

        getContentPane().add(backgground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    
    public ArrayList ListOrders(String status){
        ArrayList<Order> orderArrayList = new ArrayList<Order>();
        orderArrayList = DatabaseConnection.getInstance().returnOrdersAccordingToStatusTableNo(status, table_no);
        return orderArrayList;
    }
    
    public ArrayList ListPendingOrders(){
        ArrayList<Order> orderArrayList = new ArrayList<Order>();
        System.out.println(table_no);
        orderArrayList = DatabaseConnection.getInstance().returnOrdersAccordingToStatusTableNoPending(table_no);
        return orderArrayList;
    }
    
    public void addRowToPendingJtable(){
        DefaultTableModel model = (DefaultTableModel)tbl_pending_orders.getModel();
        if(!ListPendingOrders().isEmpty()){
        ArrayList<Order> orderArrayList = ListPendingOrders();
        Object rowData[] = new Object[4];
        for(int position = 0; position < orderArrayList.size(); position++){
            rowData[0] = orderArrayList.get(position).getOrder_id();
            rowData[1] = orderArrayList.get(position).getQuantity();
            rowData[2] = orderArrayList.get(position).getProduct_name();
            rowData[3] = orderArrayList.get(position).getProduct_price();
            model.addRow(rowData);
        }
        }
    }
    
   
   
    public void addRowToCompletedJtable(){
        DefaultTableModel model = (DefaultTableModel)tbl_completed_orders.getModel();
        if(!ListOrders("COMPLETED").isEmpty()){
        ArrayList<Order> orderArrayList = ListOrders("COMPLETED");
        this.orderArrayList = orderArrayList;
        Object rowData[] = new Object[4];
        for(int position = 0; position < orderArrayList.size(); position++){
            rowData[0] = orderArrayList.get(position).getOrder_id();
            rowData[1] = orderArrayList.get(position).getQuantity();
            rowData[2] = orderArrayList.get(position).getProduct_name();
            rowData[3] = orderArrayList.get(position).getProduct_price();
            model.addRow(rowData);
        }
        }
    }
    
    public void setSubtotal(String status){
        String subTotal = null;
        subTotal = DatabaseConnection.getInstance().returnTotalAmountByTable(table_no);
        System.out.println(subTotal);
        if(subTotal!=null){
            Double VAT = (Double.valueOf(subTotal)/ 1.12) * 0.12;
            txtVat.setText(String.format("%.2f", VAT));
            txtSubtotal.setText(subTotal);
//            txtTotal_amount.setText(subTotal);
        }
    }
    
    public void setValues(String total) {
        Double VAT = (Double.valueOf(total)/ 1.12) * 0.12;
        txtVat.setText(String.format("%.2f", VAT));
        txtSubtotal.setText(total);
        txtTotal_amount.setText(total);
    }


    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        close();
    }//GEN-LAST:event_jLabel6MouseClicked

    
    
    private void btn_gcashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gcashMouseClicked
        System.out.println("getGcashAvailability() " + getGcashAvailability());
            if (getGcashAvailability().equals("AVAILABLE")){
                jTabbedPane2.setSelectedIndex(1);
                ArrayList<GCash> gCashArrayList = new ArrayList<>();
                /*GCASH Displat Ref #*/
                if(!DatabaseConnection.getInstance().getGCashAmountRemarks(table_no).isEmpty()){
                    gCashArrayList = DatabaseConnection.getInstance().getGCashAmountRemarks(table_no);
                    if(gCashArrayList.get(0).getDiscount_type()!=null){
                        if(gCashArrayList.get(0).getDiscount_type().equals("pwd")){
                    gcash_discountType.setSelectedIndex(0);
                        }
                        if(gCashArrayList.get(0).getDiscount_type().equals("senior")){
                            gcash_discountType.setSelectedIndex(1);
                        }
                        if(gCashArrayList.get(0).getDiscount_type().equals("government")){
                            gcash_discountType.setSelectedIndex(2);
                        }
                    }
                    amount.setText(gCashArrayList.get(0).getAmount_due());
                    gcash_discountAmount.setText(gCashArrayList.get(0).getDiscount_amount());
                    gcash_idNumber.setText(gCashArrayList.get(0).getDiscount_id());
                    ref_number.setText(gCashArrayList.get(0).getRemarks());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "GCash payment is unavailable at the moment.", "Hold up!", JOptionPane.PLAIN_MESSAGE);
            }
    }//GEN-LAST:event_btn_gcashMouseClicked

    private void btn_cashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cashMouseClicked
        jTabbedPane2.setSelectedIndex(2);
            ArrayList<Payment> payment = new ArrayList<>();
            ArrayList<Cash> CashArrayList = new ArrayList<>(); 
            CashArrayList = DatabaseConnection.getInstance().getCashPaymentAmountReceived(table_no);
            if(!DatabaseConnection.getInstance().getCashPaymentAmountReceived(table_no).isEmpty()){
                if(CashArrayList.get(0).getDiscount_amount()!= null){
                txtDiscount.setText(CashArrayList.get(0).getDiscount_amount());
                }
                txtTotal_amount.setText(CashArrayList.get(0).getAmount_due());
                
                lbl_username.setText(table_no);
                if(CashArrayList.get(0).getDiscount_type()!=null){
                    if(CashArrayList.get(0).getDiscount_type().equals("pwd")){
                        cmbDiscountType_Cash.setSelectedIndex(0);
                    }
                    if(CashArrayList.get(0).getDiscount_type().equals("senior")){
                        cmbDiscountType_Cash.setSelectedIndex(1);
                    }
                    if(CashArrayList.get(0).getDiscount_type().equals("government")){
                        cmbDiscountType_Cash.setSelectedIndex(2);
                    }
                }
                
                
                txtDiscountAmount_Cash.setText(CashArrayList.get(0).getDiscount_amount());
                txtIDNumber_Cash.setText(CashArrayList.get(0).getDiscount_id());
                txt_amount_due_cash.setText(CashArrayList.get(0).getAmount_due());
                txt_cash_received.setText(CashArrayList.get(0).getPayment_amount());

                double amountDue = Double.parseDouble(txt_amount_due_cash.getText());
                double cashReceived = Double.parseDouble(txt_cash_received.getText());

                lbl_change.setText(String.format("%.2f", cashReceived - amountDue));
            }
            txt_amount_due_cash.setText(txtTotal_amount.getText());
        
        
        
        
    }//GEN-LAST:event_btn_cashMouseClicked

    private void btn_pending_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pending_ordersMouseClicked
        jTabbedPane1.setSelectedIndex(0);
        setSubtotal("PENDING");
        btn_pending_orders.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        btn_pending_orders.setBackground(Color.red);
        btn_pending_orders.setForeground(Color.white);
        
        btn_completed_orders.setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, Color.red));
        btn_completed_orders.setBackground(Color.white);
        btn_completed_orders.setForeground(Color.black);
    }//GEN-LAST:event_btn_pending_ordersMouseClicked

    private void btn_completed_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_completed_ordersMouseClicked
        jTabbedPane1.setSelectedIndex(1);
        setSubtotal("COMPLETED");
        
        btn_completed_orders.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.red));
        btn_completed_orders.setBackground(Color.red);
        btn_completed_orders.setForeground(Color.white);
        
        btn_pending_orders.setBorder(BorderFactory.createMatteBorder(1, 5, 5, 1, Color.red));
        btn_pending_orders.setBackground(Color.white);
        btn_pending_orders.setForeground(Color.black);
        
    }//GEN-LAST:event_btn_completed_ordersMouseClicked
    
    public void printInvoice(String payment_id){
        try{
            JasperDesign jasper = JRXmlLoader.load("C:\\Users\\Gelay\\Documents\\menuBytes_admin\\src\\Transactions Receipt.jrxml");
            
            HashMap<String, Object> params = new HashMap<>();
            params.put("orderId", payment_id);
            System.out.println(payment_id);
            
            JasperReport jasperReport = JasperCompileManager.compileReport(jasper);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, DatabaseConnection.getConnection());
            
            JasperViewer.viewReport(jasperPrint, false);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void gcash_receivedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gcash_receivedMouseClicked
        // TODO add your handling code here:
        if (!amount.getText().isEmpty()) {
            Double amountDue = Double.parseDouble(txtTotal_amount.getText());
            Double amountPaid = Double.parseDouble(amount.getText());

            if (amountDue <= amountPaid) {
                if (this.table_no.equals("take-out") || this.table_no.equals("dine-in")){
                String cashier = "cashier";

                    String payment_method = "GCash";
                    String payment_amount = amount.getText();
                    String amount_due = txtTotal_amount.getText();
                    String payment_status = "COMPLETED";
                    String remarks = ref_number.getText();
                
                    int orderID = DatabaseConnection.getInstance().insertOrder(cashier, this.table_no, amount_due);

                    dashboard.checkout(cashier, this.table_no, orderID);
                    
                    //Get payment_id nito
                    int paymentID = DatabaseConnection.getInstance().insertPayment(payment_amount, amount_due, payment_method, payment_status, this.table_no, remarks, null, txtSubtotal.getText(), gcash_idNumber.getText(), gcash_discountAmount.getText(), gcash_discountType.getSelectedItem().toString(), this.username);
                    
                    
                    //No need for loop since 1 order lang toh
                    DatabaseConnection.getInstance().insertIntoPaymentTransactions(String.valueOf(paymentID), String.valueOf(orderID));
                    printInvoice(String.valueOf(paymentID));
                    cleargcashtextfields();
                    JOptionPane.showMessageDialog(null, "GCash payment received successfully.", "Payment Successful!.", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    String amount = this.amount.getText().toString();
                    String reference_no = this.ref_number.getText().toString();

                     //Update Payment Status to Complete WAG GALAWIN
                    String payment_id = DatabaseConnection.getInstance().returnPaymentIDByTable(table_no);

                    DatabaseConnection.getInstance().updateGCashPayment(amount, reference_no, table_no, this.username);

                    //Insert Payment ID and Order ID to payment_transactions table, WAG GALAWIN ANG QUERY
                    if(payment_id != null){
                        if(!orderArrayList.isEmpty()){
                            for(int position = 0; position < orderArrayList.size(); position++){
                            DatabaseConnection.getInstance().insertIntoPaymentTransactions(payment_id, orderArrayList.get(position).getOrder_id());
                            } 
                            printInvoice(payment_id);
                        }
                    }

                    //Updating of modified_at, WAG GALAWIN ANG QUERY
                    cleargcashtextfields();
                    DatabaseConnection.getInstance().updatePaidOrder(table_no);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Total amount and amount paid do not match!\nPlease check and enter them again.", "Payment amount do not match.", JOptionPane.PLAIN_MESSAGE);
            }
           
        } else {
            JOptionPane.showMessageDialog(null, "Please enter payment amount.", "Payment amount is missing!", JOptionPane.PLAIN_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_gcash_receivedMouseClicked

    double cash_received = 0;
    double amount_due = 0;
    double change = 0;
    
    private void lbl_changeCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lbl_changeCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_changeCaretPositionChanged
    
    public String computeChange(){
        Double amountDue = Double.parseDouble(txt_amount_due_cash.getText());
        Double amountReceived = Double.parseDouble(txt_cash_received.getText());
        
        return String.format("%.2f", amountReceived-amountDue);
    }
    
    //CASH Payment RECEIVED
    private void recieved_cashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recieved_cashMouseClicked
        // TODO add your handling code here:
        
        String received = txt_cash_received.getText().toString();
        String change = lbl_change.getText().toString();
        
        float cashReceived = Float.parseFloat(txt_cash_received.getText());
        float totalAmount = Float.parseFloat(txtTotal_amount.getText());
        
        if(cashReceived >= totalAmount){
            
            if (this.table_no.equals("take-out") || this.table_no.equals("dine-in")){
                String cashier = "cashier";

                String payment_method = "Cash";
                String payment_amount = txt_cash_received.getText();
                String amount_due = txtTotal_amount.getText();
                String payment_status = "COMPLETED";
                String remarks = null;
                
                System.out.println("Cash payment received successfully.");
                
                int orderID = DatabaseConnection.getInstance().insertOrder(cashier, this.table_no, amount_due);

                dashboard.checkout(cashier, this.table_no, orderID);
                
                
                //Get payment_id nito
                int payment_id = DatabaseConnection.getInstance().insertPayment(payment_amount, amount_due, payment_method, payment_status, this.table_no, remarks, computeChange(), txtSubtotal.getText(), txtIDNumber_Cash.getText(), txtDiscountAmount_Cash.getText(), cmbDiscountType_Cash.getSelectedItem().toString(), this.username);
                 
                //Get order_id from this transaction
                
                //No need for loop since 1 order lang toh
                DatabaseConnection.getInstance().insertIntoPaymentTransactions(String.valueOf(payment_id), String.valueOf(orderID));
                printInvoice(String.valueOf(payment_id));
                
                clearCashTextFields();
                JOptionPane.showMessageDialog(null, "Cash payment received successfully.", "Payment Successful!.", JOptionPane.PLAIN_MESSAGE);
            }
            else {
                System.out.println("CASH PAYMENT COMPLETED");
                //WAG GALAWIN
                String payment_id = DatabaseConnection.getInstance().returnPaymentIDByTable(table_no);
               
                DatabaseConnection.getInstance().updateCashPayment(received, change, table_no, this.username);
                //Insert Payment ID and Order ID to payment_transactions table, WAG GALAWIN ANG QUERY
                if(payment_id != null){
                    if(!orderArrayList.isEmpty()){
                        for(int position = 0; position < orderArrayList.size(); position++){
                        DatabaseConnection.getInstance().insertIntoPaymentTransactions(payment_id, orderArrayList.get(position).getOrder_id());
                        } 
                        printInvoice(payment_id);
                    }
                }
                clearCashTextFields();
                DatabaseConnection.getInstance().updatePaidOrder(table_no);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Cash Received and Total Amount do not match!\n Kindly check the amount and enter them again.", "Transaction Error", JOptionPane.PLAIN_MESSAGE);
        }
        
    }//GEN-LAST:event_recieved_cashMouseClicked

    private void txt_cash_receivedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cash_receivedFocusLost
        
    }//GEN-LAST:event_txt_cash_receivedFocusLost

    private void txt_cash_receivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cash_receivedActionPerformed
        Action action = new AbstractAction()
        {   
            @Override
            public void actionPerformed(ActionEvent e)
            {
                float cashReceived = Float.parseFloat(txt_cash_received.getText());

                float totalAmount = Float.parseFloat(txtTotal_amount.getText());

                float change = cashReceived - totalAmount;
                if (change > 0 ) {
                    lbl_change.setText(String.format("%.2f", change));
                }
                
                if(cashReceived < totalAmount) {
                    JOptionPane.showMessageDialog(null, "Cash Received and Total Amount do not match!\n Kindly check the amount and enter them again.", "Transaction Error", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
        };
        txt_cash_received.addActionListener(action);
    }//GEN-LAST:event_txt_cash_receivedActionPerformed

    private void gcash_rejectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gcash_rejectMouseClicked
        String amount = this.amount.getText().toString();
        String reference_no = this.ref_number.getText().toString();
        DatabaseConnection.getInstance().rejectGCashPayment(amount, reference_no, table_no);
        cleargcashtextfields();
    }//GEN-LAST:event_gcash_rejectMouseClicked

    private void gcash_discountTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gcash_discountTypeActionPerformed
        int index = gcash_discountType.getSelectedIndex();
        Double subtotal = Double.parseDouble(txtSubtotal.getText());
        
        if ((index >= 0) && !txtTotal_amount.getText().equals(String.valueOf(subtotal - (subtotal*0.2)))){
            
            Double total_amount = Double.parseDouble(txtTotal_amount.getText());
            String discountAmount = String.format("%.2f", total_amount*.2);
            gcash_discountAmount.setText(discountAmount);
            txtTotal_amount.setText(String.valueOf(total_amount - (total_amount*0.2)));
        }
    }//GEN-LAST:event_gcash_discountTypeActionPerformed

    private void cmbDiscountType_CashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiscountType_CashActionPerformed
        int index = cmbDiscountType_Cash.getSelectedIndex();
        Double subtotal = Double.parseDouble(txtSubtotal.getText());
        if (index >=0 && !txtTotal_amount.getText().equals(String.valueOf(subtotal - (subtotal*0.2)))){
            Double total_amount = Double.parseDouble(txtTotal_amount.getText());
            String discountAmount = String.format("%.2f", total_amount*.2);
            
            txtDiscountAmount_Cash.setText(discountAmount);
            txtTotal_amount.setText(String.valueOf(total_amount - (total_amount*0.2)));
            txt_amount_due_cash.setText(String.valueOf(total_amount - (total_amount*0.2)));
        }
    }//GEN-LAST:event_cmbDiscountType_CashActionPerformed
    
    public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
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
            java.util.logging.Logger.getLogger(view_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_cart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_cart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private javax.swing.JPanel backgground;
    private javax.swing.JButton btn_cash;
    private javax.swing.JButton btn_completed_orders;
    private javax.swing.JButton btn_gcash;
    private javax.swing.JButton btn_pending_orders;
    private javax.swing.JPanel cash_payment_info;
    private javax.swing.JComboBox<String> cmbDiscountType_Cash;
    private javax.swing.JPanel completed_orders_tav;
    private javax.swing.JPanel default_payment_info;
    private javax.swing.JTextField gcash_discountAmount;
    private javax.swing.JComboBox<String> gcash_discountType;
    private javax.swing.JTextField gcash_idNumber;
    private javax.swing.JPanel gcash_payment_info;
    private javax.swing.JButton gcash_received;
    private javax.swing.JButton gcash_reject;
    private javax.swing.JLabel gcash_username;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_change;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JScrollPane list_completed_orders;
    private javax.swing.JScrollPane list_pending_orders;
    private javax.swing.JPanel pending_orders_tab;
    private javax.swing.JButton recieved_cash;
    private javax.swing.JTextField ref_number;
    private javax.swing.JTable tbl_completed_orders;
    private javax.swing.JTable tbl_pending_orders;
    private javax.swing.JLabel txtDiscount;
    private javax.swing.JTextField txtDiscountAmount_Cash;
    private javax.swing.JTextField txtIDNumber_Cash;
    private javax.swing.JLabel txtSubtotal;
    private javax.swing.JLabel txtTotal_amount;
    private javax.swing.JLabel txtVat;
    private javax.swing.JLabel txt_amount_due_cash;
    private javax.swing.JTextField txt_cash_received;
    // End of variables declaration//GEN-END:variables

    
}
