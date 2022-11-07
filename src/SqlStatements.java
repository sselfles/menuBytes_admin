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
     //REVISE:DONE   
    private String returnOrdersAccordingToStatusTableNo = "SELECT order_items.order_id,\n" +
"product.product_name,\n" +
"order_items.quantity,\n" +
"IF(order_items.product_bundle,product.product_bundle,product.product_price) AS price,\n" +
"cast(((IF(order_items.product_bundle,product.product_bundle,product.product_price))*(cast(order_items.quantity as decimal(13,2)))) as decimal(13,2))\n" +
"AS total,\n" +
"orders.created_by,\n" +
"DATE(orders.created_at) AS date,\n" +
"order_status.order_status\n" +
"FROM order_items \n" +
"INNER JOIN\n" +
"product ON product.product_id = order_items.product_id\n" +
"INNER JOIN\n" +
"orders ON orders.order_id = order_items.order_id\n" +
"INNER JOIN\n" +
"order_status ON order_status.order_id = order_items.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by \n" +
"WHERE order_status.order_status=(?) AND orders.created_by = (?) \n" +
"AND (payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")";
    
    //REVISE:DONE
    private String returnTotalAmountByTable ="SELECT \n" +
"SUM(orders.total) AS total_amount\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_status ON order_status.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by \n" +
"WHERE order_status != \"REJECTED\" \n" +
"AND orders.created_by = (?) \n" +
"AND (payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")\n" +
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
"INNER JOIN\n" +
"user on user.user_id = user.user_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by\n" +
"WHERE order_status != \"REJECTED\" AND order_status != \"COMPLETED\"\n" +
"AND EXISTS (SELECT user_name FROM user WHERE user.user_name = orders.created_by)\n" +
"AND DATE(orders.created_at) = curdate() \n" +
"GROUP BY orders.order_id;";
    
    private String retrieveOrderBreakdownUsingOrderID = "SELECT order_items.order_id, order_items.quantity, "
            + "IF((order_items.product_bundle),CONCAT(\"B1G1 \",product.product_name),product.product_name) AS name\n" +
"FROM order_items\n" +
"INNER JOIN\n" +
"product ON order_items.product_id = product.product_id\n" +
"INNER JOIN\n" +
"orders ON order_items.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by\n" +
"WHERE order_items.order_id = (?) AND DATE(orders.created_at) = curdate()\n" +
"AND (payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")";

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
    
    private String retrieveAllProducts = "SELECT product.product_id, product.product_name, product.product_price, product.product_availability\n" +
"FROM product\n" +
"UNION\n" +
"SELECT product_id, \n" +
"IF((product.product_bundle IS NULL),product.product_name,CONCAT(\"(B1G1) \",product.product_name)) AS name,\n" +
"IF((product.product_bundle IS NULL),product.product_price,product.product_bundle) AS price,product.product_availability\n" +
"FROM product\n" +
"ORDER BY product_id;";
    
    private String retrieveAmountDueTableName = "SELECT amount_due, created_by\n" +
"FROM payment WHERE\n" +
"created_by = (?) and payment_status = \"PENDING\"";

    public String getRetrieveAmountDueTableName() {
        return retrieveAmountDueTableName;
    }
    
    private String updateGCashPayment = "UPDATE payment\n" +
"SET \n" +
"created_by = concat(created_by, \"_\") ,\n" +
"payment_status = \"COMPLETE\",\n" +
"payment_amount = (?),\n" +
"remarks = (?),\n" +
"completed_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?) and payment_status = \"PENDING\";";
    
     private String updateCashPayment = "UPDATE payment\n" +
"SET \n" +
"created_by = concat(created_by, \"_\") ,\n" +
"payment_status = \"COMPLETE\",\n" +
"payment_amount = (?),\n" +
"payment_change = (?),\n" +
"completed_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?) and payment_status = \"PENDING\";";

    public String getUpdateCashPayment() {
        return updateCashPayment;
    }
     
     
    
    private String updatePaidOrder = "UPDATE orders\n" +
"SET \n" +
"created_by = concat(created_by, \"_\") ,\n" +
"modified_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?);";
    
    private String notifyCashierOfPayments = "SELECT payment.created_by, payment.payment_method, SUM(orders.total), payment.payment_status\n" +
"FROM\n" +
"payment\n" +
"INNER JOIN orders ON orders.created_by = payment.created_by\n" +
"INNER JOIN order_status ON orders.order_id = order_status.order_id\n" +
"WHERE payment.payment_status = \"PENDING\"\n" +
"AND order_status.order_status != \"REJECTED\";";
    
    private String getSalesReportDaily = "SELECT DATE(orders.created_at), orders.order_id, orders.created_by, orders.total\n" +
"FROM orders\n" +
"INNER JOIN payment \n" +
"ON orders.created_by = payment.created_by\n" +
"WHERE payment.payment_status = \"COMPLETE\" GROUP BY order_id;";

    public String getGetSalesReportDaily() {
        return getSalesReportDaily;
    }

    public String getNotifyCashierOfPayments() {
        return notifyCashierOfPayments;
    }
    
    

    public String getUpdatePaidOrder() {
        return updatePaidOrder;
    }
    
    

    public String getUpdateGCashPayment() {
        return updateGCashPayment;
    }
    

    public String getRetrieveAllProducts() {
        return retrieveAllProducts;
    }

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
