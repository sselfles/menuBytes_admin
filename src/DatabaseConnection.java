
import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class DatabaseConnection {
    
    	private static DatabaseConnection instance;
        
	private DatabaseConnection(){}
        
	public static DatabaseConnection getInstance(){
		if(null!=instance){
                return instance;
            }
            else{
                instance = new DatabaseConnection();
                return instance;
            }
	}

     private String getDateTime(){
         String datetime=null;
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
           LocalDateTime now = LocalDateTime.now();  
           datetime= dtf.format(now);
           return datetime;
     }
     

    public Connection getConnection() {
        Connection connection = null;
        try {
//            connection = DriverManager.getConnection("jdbc:mysql://192.168.254.126:3306/menubytes",
//                    "admin", "admin");
                connection = DriverManager.getConnection("jdbc:mysql://192.168.100.77:3306/menubytes",
                                    "admin", "admin");
        } catch (SQLException ex) {
            System.out.println("CONNECTION ERROR: "+ex.getMessage());
        }
        return connection;
    }
    
    public static  void disconnect(ResultSet rs, PreparedStatement stat, Connection cn){
        try{
        if(rs!=null) rs.close();
        }catch(SQLException sqlEx){
            System.out.println("Error: disconnect1");
        }
        try{
        if(stat!=null) stat.close();
        }catch(SQLException sqlEx){
            System.out.println("Error: disconnect1");
        }
        try{
        if(cn!=null) cn.close();
        }catch(SQLException sqlEx){
            System.out.println("Error: disconnect1");
        }
    }
    
     public ArrayList<Order> returnOrdersAccordingToStatusTableNo(String status,String table_no)  {
        Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getReturnOrdersAccordingToStatusTableNo());
        preparedStatement.setString(1, status);
        preparedStatement.setString(2, table_no);
            System.out.println(getDateTime());
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database returnOrdersAccordingToStatusTableNo(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      orderArrayList.add(new Order(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3), 
                              resultSet.getString(4), 
                              resultSet.getString(5), 
                              resultSet.getString(6), 
                              resultSet.getString(7),
                              resultSet.getString(8)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
     
      public ArrayList<Order> returnOrdersAccordingToStatusTableNoPending(String table_no)  {
        Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getReturnOrdersAccordingToStatusTableNoPending());
        
        preparedStatement.setString(1, table_no);
            System.out.println(getDateTime());
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database PENDING ORDERS(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      orderArrayList.add(new Order(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3), 
                              resultSet.getString(4), 
                              resultSet.getString(5), 
                              resultSet.getString(6), 
                              resultSet.getString(7),
                              resultSet.getString(8)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
     
     public ArrayList<Payment> returnUserNameAmountStatus(){
         Connection connection = null;
        ArrayList<Payment> paymentArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getReturnUserNameAmountStatus());
            System.out.println(getDateTime());
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrivePendingPayments(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      paymentArrayList.add(new Payment(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3)

                      ));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paymentArrayList;
     }
     
     public String returnTotalAmountByTable(String table_no) {
        Connection connection = null;
        String total_amount = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getReturnTotalAmountByTable());
        preparedStatement.setString(1, table_no);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database returnTotalAmountByTable(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                   total_amount = resultSet.getString(1);
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total_amount;
     }
     
     public String checkUsernameExistence(String username){
         Connection connection = null;
         String user_id = null;
                 try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getCheckUsernameExistence());
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, username);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database checkUsernameExistence(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                   user_id = resultSet.getString(1);
            }}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return user_id;
     }
     
     public String checkUsernamePassword(String username, String password){
         Connection connection = null;
         String user_id = null;
                          try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getCheckUsernamePassword());
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database checkUsernamePassword(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                   user_id = resultSet.getString(1);
            }}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return user_id;
     }
    public ArrayList<Order> retrieveOrderListQueue() {
        Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveOrderListQueue());
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveOrderListQueue(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      orderArrayList.add(new Order(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3), 
                              resultSet.getString(4)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
     
        public ArrayList<Order> retrieveOrderBreakdownUsingOrderID(String order_id) {
                Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getTransactionBreakdown());
        preparedStatement.setInt(1, Integer.valueOf(order_id));
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("getTransactionBreakdown: No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      orderArrayList.add(new Order(
                                resultSet.getString(1), 
                                resultSet.getString(2), 
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getBoolean(5),
                                resultSet.getString(6)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
        
     public void updateOrderStatusByOrderID(String order_status, String user_id, String order_id) {
         Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getUpdateOrderStatusByOrderID());
        preparedStatement.setString(1, order_status);
        preparedStatement.setString(2, getDateTime());
        preparedStatement.setInt(3, Integer.valueOf(user_id));
        preparedStatement.setInt(4, Integer.valueOf(order_id));
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ArrayList<ProductInfo> retrieveProductsAccordingToCategory(String product_category) {
        Connection connection = null;
        ArrayList<ProductInfo> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveProductsAccordingToCategory());
        preparedStatement.setString(1, product_category);  
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveProductsAccordingToCategory(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              orderArrayList.add(new ProductInfo(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
     
     public ArrayList<ProductInfo> retrieveAllProducts() {
        Connection connection = null;
        ArrayList<ProductInfo> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveAllProducts()); 
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveAllProducts(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              orderArrayList.add(new ProductInfo(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
     
     public void updateGCashPayment(String amount, String referenceno, String table_no) {
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getUpdateGCashPayment()); 
        preparedStatement.setDouble(1, Double.valueOf(amount));
        preparedStatement.setString(2, referenceno);
        preparedStatement.setString(3, table_no);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void rejectGCashPayment(String amount, String referenceno, String table_no) {
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().rejectGCashPayment()); 
        preparedStatement.setDouble(1, Double.valueOf(amount));
        preparedStatement.setString(2, referenceno);
        preparedStatement.setString(3, table_no);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatePaidOrder(String table_no) {
          Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getUpdatePaidOrder()); 
        preparedStatement.setString(1, table_no);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ArrayList<Payment> notifyCashierOfPayments() {
        Connection connection = null;
        ArrayList<Payment> payments = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getNotifyCashierOfPayments()); 
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database notifyCashierOfPayments(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              payments.add(new Payment(
                              resultSet.getString(1), 
                              resultSet.getString(2)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payments;
     }
     
     public ArrayList<Payment> retrieveAmountDueTableName(String table_name){
             Connection connection = null;
            ArrayList<Payment> payments  = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveAmountDueTableName()); 
        preparedStatement.setString(1, table_name);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveAmountDueTableName(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              payments.add(new Payment(
                              resultSet.getString(1), 
                              resultSet.getString(2)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payments;
     }
     
     public void updateCashPayment(String amount, String change, String table_no){
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getUpdateCashPayment()); 
        preparedStatement.setDouble(1, Double.valueOf(amount));
        preparedStatement.setDouble(2, Double.valueOf(change));
        preparedStatement.setString(3, table_no);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    public  ArrayList<Report> getSalesReportDefault(){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getSalesReportDefault()); 
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<Report> getSalesReportDaily(String from_date, String to_date){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getSalesReportDaily()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<Report> getSalesReportWeekly(String from_date, String to_date){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getSalesReportWeekly()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<Report> getSalesReportMonthly(String from_date, String to_date){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getSalesReportMonthly()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<Report> getTransactions(){
        Connection connection = null;
        ArrayList<Report> transactionsReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getTransactions()); 
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getTransactions(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              transactionsReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3),
                                      resultSet.getString(4)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3) + resultSet.getString(4));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return transactionsReports;
    }
    
    public ArrayList<Order> getTransactionBreakdown(String order_id) {
        Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getTransactionBreakdown());
        preparedStatement.setInt(1, Integer.valueOf(order_id));
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("getTransactionBreakdown: No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      orderArrayList.add(new Order(
                                resultSet.getString(1), 
                                resultSet.getString(2), 
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getBoolean(5),
                                resultSet.getString(6)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
    
    public  ArrayList<Report> getTransactionsDaily(String from_date, String to_date){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getTransactionsDaily()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getTransactionsDaily(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<Report> getTransactionsWeekly(String from_date, String to_date){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getTransactionsWeekly()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<Report> getTransactionsMonthly(String from_date, String to_date){
        Connection connection = null;
        ArrayList<Report> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getTransactionsMonthly()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new Report(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<LogReport> getLogReports(){
        Connection connection = null;
        ArrayList<LogReport> logReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getLogReports()); 
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getLogReports(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              logReports.add(new LogReport(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return logReports;
    }
    
    public  ArrayList<LogReport> getLogReportsDaily(String from_date, String to_date){
        Connection connection = null;
        ArrayList<LogReport> salesReports = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getLogReportsDaily()); 
        preparedStatement.setString(1, from_date);
        preparedStatement.setString(2, to_date);
        preparedStatement.setString(3, from_date);
        preparedStatement.setString(4, to_date);
        preparedStatement.setString(5, from_date);
        preparedStatement.setString(6, to_date);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database getSalesReportDefault(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              salesReports.add(new LogReport(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
                              
            System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salesReports;
    }
    
    public  ArrayList<User> retrieveUsersList(){
        Connection connection = null;
        ArrayList<User> usersArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveUsersList()); 
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveUsersList(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              usersArrayList.add(new User(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usersArrayList;
    }
    
    public  ArrayList<User> usernameDuplicateChecker( String user_name){
        Connection connection = null;
        ArrayList<User> usersArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().usernameDuplicateChecker()); 
        preparedStatement.setString(1, user_name);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveUsersList(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              usersArrayList.add(new User(
                                      resultSet.getString(1)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usersArrayList;
    }
    
    public  void accountCreation( String user_name, String password, String user_type, String device_type ){
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().accountCreation()); 
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, user_type);
        preparedStatement.setString(4, device_type);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateUserInfo( String user_name, String user_type, String device_type, String oldUsername ) {
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().updateUserInfo()); 
        preparedStatement.setString(1, user_name);
        preparedStatement.setString(2, user_type);
        preparedStatement.setString(3, device_type);
        preparedStatement.setString(4, oldUsername);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePassword( String password, String user_name ) {
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().updatePassword()); 
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, user_name);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUser( String user_name ) {
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().deleteUser()); 
        preparedStatement.setString(1, user_name);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  ArrayList<Product> retrieveProductList(){
        Connection connection = null;
        ArrayList<Product> productsArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveProductsList()); 
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveUsersList(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              productsArrayList.add(new Product(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3),
                                      resultSet.getString(4)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productsArrayList;
    }
    
    public  ArrayList<Product> productDuplicateChecker( String user_name ){
        Connection connection = null;
        ArrayList<Product> productArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().productDuplicateChecker()); 
        preparedStatement.setString(1, user_name);
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database productDuplicateChecker(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              productArrayList.add(new Product(
                                      resultSet.getString(1)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productArrayList;
    }
    
    public  void addProduct( String productName, String productPrice, String bundledPrice, String productDescription, FileInputStream productImage, String productCateory ){
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().addProduct()); 
        preparedStatement.setString(1, productName);
        preparedStatement.setDouble(2, Double.valueOf(productPrice));
        preparedStatement.setDouble(3, Double.valueOf(bundledPrice));
        preparedStatement.setString(4, productDescription);
        preparedStatement.setBlob(5, productImage);
        preparedStatement.setString(6, productCateory);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void addProductSolo( String productName, String productPrice, String productDescription, FileInputStream productImage, String productCateory ){
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().addProductSolo()); 
        preparedStatement.setString(1, productName);
        preparedStatement.setDouble(2, Double.valueOf(productPrice));
        preparedStatement.setString(3, productDescription);
        preparedStatement.setBlob(4, productImage);
        preparedStatement.setString(5, productCateory);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void updateProduct( String productName, String productPrice, String bundledPrice, String productDescription, String productCateory, String availability, String oldName ){
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().updateProduct()); 
        preparedStatement.setString(1, productName);
        preparedStatement.setDouble(2, Double.valueOf(productPrice));
        if (bundledPrice != null){
                preparedStatement.setDouble(3, Double.valueOf(bundledPrice));
            }
            else {
                preparedStatement.setNull(3, Types.NULL);
            }
        preparedStatement.setString(4, productDescription);
        preparedStatement.setString(5, productCateory);
        preparedStatement.setString(6, availability);
        preparedStatement.setString(7, oldName);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void updateProductWithImage ( String productName, String productPrice, String bundledPrice, String productDescription, FileInputStream product_image, String productCateory, String availability, String oldName ){
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().updateProduct()); 
        preparedStatement.setString(1, productName);
        preparedStatement.setDouble(2, Double.valueOf(productPrice));
        if (bundledPrice != null){
                preparedStatement.setDouble(3, Double.valueOf(bundledPrice));
            }
            else {
                preparedStatement.setNull(3, Types.NULL);
            }
        preparedStatement.setString(4, productDescription);
        preparedStatement.setBlob(5, product_image);
        preparedStatement.setString(6, productCateory);
        preparedStatement.setString(7, availability);
        preparedStatement.setString(8, oldName);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  ArrayList<ProductInfo> getProductInfo(String oldName){
        Connection connection = null;
        ArrayList<ProductInfo> productArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getProductInfo()); 
        preparedStatement.setString(1, oldName);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveUsersList(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              productArrayList.add(new ProductInfo(
                                      resultSet.getString(1), 
                                      resultSet.getString(2), 
                                      resultSet.getString(3),
                                        resultSet.getString(4),
                                        resultSet.getString(5),
                                        resultSet.getString(6),
                                        resultSet.getString(7)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productArrayList;
    }
    
    public void deleteProduct( String product_name ) {
        Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().deleteProduct()); 
        preparedStatement.setString(1, product_name);
        preparedStatement.executeUpdate();
            disconnect(null, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<User> retrieveKitchenLogs(){
        Connection connection = null;
        ArrayList<User> userLogArrayList = new ArrayList<User>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().retrieveKitchenLogs()); 
        
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveKitchenLogs(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              userLogArrayList.add(new User(
                                      resultSet.getString(1), 
                                      resultSet.getString(2)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userLogArrayList;
    }
    
    public ArrayList<Product> getSelectedProductInfo(String product_name) {
        Connection connection = null;
        ArrayList<Product> productArrayList = new ArrayList<Product>();
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getProductInfo()); 
            preparedStatement.setString(1, product_name);
            
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("Database getSelectedProductInfo(): No Data Retrieved!");
            }
            else{
                while(resultSet.next()){
                                  productArrayList.add(new Product(
                                          resultSet.getString(1), 
                                          resultSet.getString(2),
                                          resultSet.getString(3)));
                }
            }
            disconnect(resultSet, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productArrayList;
    }
    
    public ArrayList<User> getUsername() {
        Connection connection = null;
        ArrayList<User> userArrayList = new ArrayList<User>();
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getUsername()); 
            
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("Database getUsername(): No Data Retrieved!");
            }
            else{
                while(resultSet.next()){
                                  userArrayList.add(new User(
                                          resultSet.getString(1)));
                }
            }
            disconnect(resultSet, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userArrayList;
    }
    
    public int insertOrder(String user_id, String total){
	Connection connection = null;
        int order_id = 0;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().insertOrder(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user_id);
            preparedStatement.setDouble(2,Double.valueOf(total));
            preparedStatement.setString(3, user_id);
            preparedStatement.executeUpdate();
            
            ResultSet resultSet;
            resultSet = preparedStatement.getGeneratedKeys();
                    if (!resultSet.isBeforeFirst()) {
                        System.out.println("insertOrder : NO ID_DATA FOUND");
                    } else {
                        System.out.println("insertOrder : ID_DATA FOUND");}
                    if(resultSet.next()){
                        order_id = resultSet.getInt(1);
                    }
            disconnect(resultSet, preparedStatement, connection);
            
            insertOrderStatus(order_id);
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order_id;
    }
    
    public void insertOrderStatus(int order_id){
	Connection connection = null;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().insertOrderStatus());
            preparedStatement.setInt(1, Integer.valueOf(order_id));
            preparedStatement.setString(2, "IN QUEUE");
            preparedStatement.setInt(3, Integer.valueOf(order_id));
            preparedStatement.executeUpdate();
            
            
            disconnect(null, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertOrderItems(int order_id, String product_id, String quantity, Boolean product_bundle, Boolean has_addons, String flavors){
	Connection connection = null;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().insertOrderItems());
            preparedStatement.setInt(1, Integer.valueOf(order_id));
            preparedStatement.setString(2,product_id);
            preparedStatement.setString(3, quantity);
            preparedStatement.setBoolean(4,Boolean.valueOf(product_bundle));
            preparedStatement.setBoolean(5, Boolean.valueOf(has_addons));
            
            if (flavors != null){
                preparedStatement.setString(6, flavors);
            }
            else {
                preparedStatement.setNull(6, Types.NULL);
            }
            
            preparedStatement.executeUpdate();
            
            
            disconnect(null, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public ArrayList<Notification> notifyPanel() {
        Connection connection = null;
        ArrayList<Notification> notificationArrayList = new ArrayList<Notification>();
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getNotifyPanel()); 
            
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("Database getUsername(): No Data Retrieved!");
            }
            else{
                while(resultSet.next()){
                                 notificationArrayList.add(new Notification(resultSet.getString(1), resultSet.getString(2)
                                 ));
                }
            }
            disconnect(resultSet, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return notificationArrayList;
    }
    
    public void removeNotification(String completed_at, String username){
	Connection connection = null;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().removeNotification());
            preparedStatement.setString(1, completed_at);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            
            System.out.println("Image successfully uploaded.");
            
            disconnect(null, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePaymentSetting(String payment_info, String payment_availability){
	Connection connection = null;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().updatePaymentSettingWithImage());
            preparedStatement.setString(1, payment_info);
            preparedStatement.setString(2, payment_availability);
            preparedStatement.executeUpdate();
            
            System.out.println("Image successfully uploaded.");
            
            disconnect(null, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void updatePaymentSettingWithImage(String payment_info, FileInputStream payment_qr, String payment_availability){
	Connection connection = null;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().updatePaymentSettingWithImage());
            preparedStatement.setString(1, payment_info);
            preparedStatement.setBlob(2,payment_qr);
            preparedStatement.setString(3, payment_availability);
            preparedStatement.executeUpdate();
            
            System.out.println("Image successfully uploaded.");
            
            disconnect(null, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public ArrayList<PaymentMethod> getPaymentMethodInfo() {
        Connection connection = null;
        ArrayList<PaymentMethod> paymentArrayList = new ArrayList<PaymentMethod>();
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getPaymentSetting()); 
            
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("Database getUsername(): No Data Retrieved!");
            }
            else{
                while(resultSet.next()){
                                  paymentArrayList.add(new PaymentMethod(
                                            resultSet.getString(1),
                                            resultSet.getBytes(2),
                                            resultSet.getString(3)));
                }
            }
            disconnect(resultSet, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return paymentArrayList;
    }
    
    public void insertPayment(String payment_amount, String amount_due, String payment_method, String payment_status, String remarks){
	Connection connection = null;
          
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().insertPayment());
            preparedStatement.setString(1, payment_amount);
            preparedStatement.setString(2, amount_due);
            preparedStatement.setString(3, payment_method);
            preparedStatement.setString(4, payment_status);
            
            if (remarks != null){
                preparedStatement.setString(6, remarks);
            }
            else {
                preparedStatement.setNull(6, Types.NULL);
            }
            
            preparedStatement.executeUpdate();
            
            
            disconnect(null, preparedStatement, connection);
                  
        }

        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<GCash> getGCashAmountRemarks(String table_name) {
        Connection connection = null;
        ArrayList<GCash> gCashArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getgCashAmountRemarks());
        preparedStatement.setString(1, table_name);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("getTransactionBreakdown: No Data Retrieved!");}
        else{
            while(resultSet.next()){
                gCashArrayList.add(new GCash(resultSet.getString(2), resultSet.getString(1)));
            }}
            disconnect(resultSet, preparedStatement, connection);
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gCashArrayList;
     }

 }
