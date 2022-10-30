/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class SqlStatements {
    private SqlStatements(){}
    private static SqlStatements instance;
	public static SqlStatements getInstance(){
		if(null!=instance){
                return instance;
            }
            else{
                instance = new SqlStatements();
                return instance;
            }
	}
        
    private String returnOrdersAccordingToStatusTableNo = "SELECT order_items.order_id,\n" +
" product.product_name, \n" +
" order_items.quantity,\n" +
"IF(order_items.product_bundle,product.product_bundle,product.product_price) AS price,\n" +
"cast(((IF(order_items.product_bundle,product.product_bundle,product.product_price))*(cast(order_items.quantity as decimal(13,2)))) as decimal(13,2))\n" +
"AS total,\n" +
"orders.created_by,\n" +
"DATE(orders.created_at) AS date,\n" +
"order_status.order_status\n" +
"FROM order_items \n" +
"INNER JOIN \n" +
"product ON product.product_id = order_items.product_id\n" +
"INNER JOIN\n" +
"orders ON orders.order_id = order_items.order_id\n" +
"INNER JOIN\n" +
"order_status ON order_status.order_id = order_items.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.order_id = orders.order_id\n" +
"WHERE order_status = (?) AND orders.created_by = (?)\n" +
"AND (payment.payment_id IS NULL OR payment.payment_status IS NULL OR payment.payment_status = \"PENDING\"); ";
    
    private String returnTotalAmountByTable ="SELECT \n" +
"SUM(orders.total) AS total_amount\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_status ON order_status.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.order_id = orders.order_id\n" +
"WHERE order_status = (?) AND orders.created_by = (?) \n" +
"AND (payment.payment_id IS NULL OR payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")\n" +
"AND DATE(orders.created_at) = curdate(); ";
    
    private String checkUsernameExistence = "SELECT user_id FROM user WHERE user_name = (?);";
    
    private String checkUsernamePassword = "SELECT user_id FROM user WHERE user_name = (?) AND password = (?);";

    public String getCheckUsernameExistence() {
        return checkUsernameExistence;
    }

    public String getCheckUsernamePassword() {
        return checkUsernamePassword;
    }

    public String getReturnTotalAmountByTable() {
        return returnTotalAmountByTable;
    }
    
    public String getReturnOrdersAccordingToStatusTableNo(){
        return this.returnOrdersAccordingToStatusTableNo;
    }
}
