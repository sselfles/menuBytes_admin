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
"WHERE order_status = (?) AND orders.created_by = (?) AND DATE(orders.created_at) = curdate()\n" +
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
    
    private String retrieveOrderListQueue = "SELECT \n" +
"orders.order_id, orders.created_by,orderitems.qty,order_status.order_status\n" +
"FROM orders\n" +
"JOIN\n" +
"(SELECT order_id, SUM(quantity) AS qty FROM order_items GROUP BY order_id)\n" +
"AS orderitems ON orderitems.order_id = orders.order_id\n" +
"INNER JOIN\n" +
"order_status ON order_status.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.order_id = orders.order_id\n" +
"WHERE DATE(orders.created_at) = curdate()\n" +
"AND (payment.payment_id IS NULL OR payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")\n" +
"AND (order_status.order_status = \"PENDING\" or order_status.order_status = \"ACCEPTED\")\n" +
"; ";
    
    private String retrieveOrderBreakdownUsingOrderID = "SELECT order_items.order_id, order_items.quantity, "
            + "IF((order_items.product_bundle),CONCAT(\"B1G1 \",product.product_name),product.product_name) AS name\n" +
"FROM order_items\n" +
"INNER JOIN\n" +
"product ON order_items.product_id = product.product_id\n" +
"INNER JOIN\n" +
"orders ON order_items.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.order_id = orders.order_id\n" +
"WHERE order_items.order_id = (?) AND DATE(orders.created_at) = curdate()\n" +
"AND (payment.payment_id IS NULL OR payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")\n" +
"; ";

    private String updateOrderStatusByOrderID = "UPDATE order_status\n" +
"SET order_status = (?),\n" +
"updated_at = (?),\n" +
"updated_by = (SELECT user_name FROM user WHERE user_id = (?))\n" +
"WHERE order_id = (?);";

    private String retrieveProductsAccordingToCategory = "SELECT product.product_id, product.product_name, product.product_price, product.product_availability\n" +
"FROM product WHERE product_category = (?)\n" +
"UNION\n" +
"SELECT product_id, \n" +
"IF((product.product_bundle IS NULL),product.product_name,CONCAT(\"(B1G1) \",product.product_name)) AS name,\n" +
"IF((product.product_bundle IS NULL),product.product_price,product.product_bundle) AS price,product.product_availability\n" +
"FROM product WHERE product_category = (?)\n" +
"ORDER BY product_id;";

    public String getRetrieveProductsAccordingToCategory() {
        return retrieveProductsAccordingToCategory;
    }
    
    public String getUpdateOrderStatusByOrderID() {
        return updateOrderStatusByOrderID;
    }
    
    
    
    public String getRetrieveOrderListQueue() {
        return retrieveOrderListQueue;
    }

    public String getRetrieveOrderBreakdownUsingOrderID() {
        return retrieveOrderBreakdownUsingOrderID;
    }
    
    

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
