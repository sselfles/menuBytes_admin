
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            connection = DriverManager.getConnection("jdbc:mysql://aws-simplified.ccnp1cnd7apy.ap-northeast-1.rds.amazonaws.com:3306/menubytes",
                    "admin", "P0Y9aixM7jUZr6Cg");
        } catch (SQLException ex) {
            System.out.println("CONNECTION ERROR: "+ex.getMessage());
        }
        return connection;
    }
    
    
    
     public ArrayList<Order> returnOrdersAccordingToStatusTableNo(String status,String table_no) {
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
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
     
     public String returnTotalAmountByTable(String status, String table_no){
        Connection connection = null;
        String total_amount = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getReturnTotalAmountByTable());
        preparedStatement.setString(1, status);
        preparedStatement.setString(2, table_no);
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database returnTotalAmountByTable(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                   total_amount = resultSet.getString(1);
            }}
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
    public ArrayList<Order> retrieveOrderListQueue(){
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
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
     
        public ArrayList<Order> retrieveOrderBreakdownUsingOrderID(String order_id){
        Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveOrderBreakdownUsingOrderID());
        preparedStatement.setInt(1, Integer.valueOf(order_id));
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("retrieveOrderBreakdownUsingOrderID: No Data Retrieved!");}
        else{
            while(resultSet.next()){
                      orderArrayList.add(new Order(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3)));
            }}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
        
     public void updateOrderStatusByOrderID(String order_status, String user_id, String order_id){
         Connection connection = null;
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getUpdateOrderStatusByOrderID());
        preparedStatement.setString(1, order_status);
        preparedStatement.setString(2, getDateTime());
        preparedStatement.setInt(3, Integer.valueOf(user_id));
        preparedStatement.setInt(4, Integer.valueOf(order_id));
        preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ArrayList<Product> retrieveProductsAccordingToCategory(String product_category){
        Connection connection = null;
        ArrayList<Product> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getRetrieveProductsAccordingToCategory());
        preparedStatement.setString(1, product_category);
        preparedStatement.setString(2, product_category);      
        ResultSet resultSet;
        resultSet = preparedStatement.executeQuery();
        if (!resultSet.isBeforeFirst()){
            System.out.println("Database retrieveOrderListQueue(): No Data Retrieved!");}
        else{
            while(resultSet.next()){
                              orderArrayList.add(new Product(
                              resultSet.getString(1), 
                              resultSet.getString(2), 
                              resultSet.getString(3), 
                              resultSet.getString(4)));
            }}
        }
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
     }
}