
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
     public ArrayList<Order> returnOrdersAccordingToStatusTableNo(String status,String table_no) {/*This block of code is a test only. Use as reference and delete after*/
        Connection connection = null;
        ArrayList<Order> orderArrayList = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlStatements.getInstance().getReturnOrdersAccordingToStatusTableNo());
        preparedStatement.setString(1, status);
        preparedStatement.setString(2, table_no);
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
    
}
