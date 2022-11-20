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
     
        private String returnUserNameAmountStatus = "Select \n" +
"user_name,\n" +
"SUM(orders.total) AS total_amount,\n" +
"IF((COUNT(IF(order_status.order_status=\"PENDING\" OR order_status.order_status=\"IN QUEUE\" OR order_status.order_status=\"PREPARING\" ,1,NULL))),\"PENDING\", \"\") AS status\n" +
"FROM user\n" +
"LEFT JOIN orders ON orders.created_by = user.user_name\n" +
"LEFT JOIN order_status ON order_status.order_id = orders.order_id\n" +
"WHERE user_type = \"customer\"\n" +
"GROUP BY user.user_id\n" +
"UNION\n" +
"Select \n" +
"user_name,\n" +
"SUM(orders.total) AS total_amount,\n" +
"IF((COUNT(IF(order_status.order_status=\"PENDING\" OR order_status.order_status=\"IN QUEUE\" OR order_status.order_status=\"PREPARING\" ,1,NULL))),\"PENDING\", \"\") AS status\n" +
"FROM user\n" +
"RIGHT JOIN orders ON orders.created_by = user.user_name\n" +
"RIGHT JOIN order_status ON order_status.order_id = orders.order_id\n" +
"WHERE user_type = \"customer\"\n" +
"GROUP BY user.user_id";

    public String getReturnUserNameAmountStatus() {
        return returnUserNameAmountStatus;
    }
        
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
    private String returnTotalAmountByTable ="SELECT\n" +
"SUM(orders.total) AS total_amount\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_status ON order_status.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by\n" +
"WHERE order_status != \"REJECTED\" \n" +
"AND orders.created_by = (?) \n" +
"AND (payment.payment_status IS NULL OR payment.payment_status = \"PENDING\")\n" +
"AND DATE(orders.created_at) = current_timestamp(); ";
    
    private String checkUsernameExistence = "SELECT user_id FROM user WHERE (user_name = (?) and user_type = 'cashier') OR (user_name = (?) and user_type = 'admin');";
    
    private String checkUsernamePassword = "SELECT user_id FROM user WHERE user_name = (?) AND password = (?);";
    
    private String retrieveOrderListQueue = "SELECT \n" +
            "orders.order_id, orders.created_by,orderitems.qty,order_status.order_status\n" +
            "FROM orders\n" +
            "JOIN\n" +
            "(SELECT order_id, SUM(quantity) AS qty FROM order_items WHERE order_items.product_id != (15) GROUP BY order_id)\n" +
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
    
    private String retrieveOrderBreakdownUsingOrderID = "SELECT order_items.order_id, order_items.quantity, \n" +
"(IF((order_items.product_bundle),CONCAT(\"B1G1 \",product.product_name),product.product_name)) AS Name,\n" +
"IF((product.product_bundle IS NULL),product.product_price,product.product_bundle)*order_items.quantity AS Price,\n" +
"order_items.has_addons, order_items.flavors\n" +
"FROM order_items\n" +
"INNER JOIN\n" +
"product ON order_items.product_id = product.product_id\n" +
"INNER JOIN\n" +
"orders ON order_items.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by\n" +
"WHERE order_items.order_id = (?);";

    private String updateOrderStatusByOrderID = "UPDATE order_status\n" +
"SET order_status = (?),\n" +
"updated_at = (?),\n" +
"updated_by = (SELECT user_name FROM user WHERE user_id = (?))\n" +
"WHERE order_id = (?);";

    private String retrieveProductsAccordingToCategory = "SELECT product.product_name, product.product_price, product.product_bundle\n" +
"FROM product WHERE product_category = (?) AND product_availability = \"available\";";
    
    private String retrieveAllProducts = "SELECT product_name, product_price, product_bundle\n" +
"FROM product WHERE product_availability = \"available\";";
    
    private String retrieveAmountDueTableName = "SELECT amount_due, created_by\n" +
"FROM payment WHERE\n" +
"created_by = (?) and payment_status = \"PENDING\"";

    public String getRetrieveAmountDueTableName() {
        return retrieveAmountDueTableName;
    }
    
    //"created_by = concat(created_by, \"_\") ,\n" +
    private String updateGCashPayment = "UPDATE payment\n" +
"SET \n" +
"payment_status = \"COMPLETE\",\n" +
"payment_amount = (?),\n" +
"remarks = (?),\n" +
"completed_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?) and payment_status = \"PENDING\";";
    
    private String rejectGCashPayment = "UPDATE payment\n" +
"SET \n" +
"created_by = concat(created_by, \"_\") ,\n" +
"payment_status = \"REJECTED\",\n" +
"payment_amount = (?),\n" +
"remarks = (?),\n" +
"completed_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?) and payment_status = \"PENDING\";";
    
    //"created_by = concat(created_by, \"_\") ,\n" +
     private String updateCashPayment = "UPDATE payment\n" +
"SET \n" +
"payment_status = \"COMPLETE\",\n" +
"payment_amount = (?),\n" +
"payment_change = (?),\n" +
"completed_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?) and payment_status = \"PENDING\";";

    public String getUpdateCashPayment() {
        return updateCashPayment;
    }
     
     
    //"created_by = concat(created_by, \"_\") ,\n" +
    private String updatePaidOrder = "UPDATE orders\n" +
"SET \n" +
"modified_at = current_timestamp()\n" +
"WHERE \n" +
"created_by = (?);";
    
    private String notifyCashierOfPayments = "SELECT payment.created_by, payment.payment_method, payment.payment_status\n" +
"FROM\n" +
"payment\n" +
"INNER JOIN orders ON orders.created_by = payment.created_by\n" +
"INNER JOIN order_status ON orders.order_id = order_status.order_id\n" +
"WHERE payment.payment_status = \"PENDING\"\n" +
"AND order_status.order_status != \"REJECTED\";";
    
    private String getSalesReportDefault = "SELECT \n" +
"DATE(orders.created_at),\n" +
"SUM(order_items.quantity),\n" +
"SUM(orders.total)\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_items ON orders.order_id = order_items.order_id\n" +
"GROUP BY DATE(orders.created_at)\n" +
";";
    
    private String getSalesReportDaily = "SELECT \n" +
"DATE(orders.created_at),\n" +
"SUM(order_items.quantity),\n" +
"SUM(orders.total)\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_items ON orders.order_id = order_items.order_id\n" +
"WHERE created_at between (?) and (?)\n" +
"GROUP BY DATE(orders.created_at)\n" +
";";
    
    private String getSalesReportWeekly = "SELECT\n" +
"CONCAT(DATE_FORMAT(DATE_ADD(orders.created_at, INTERVAL(1-DAYOFWEEK(orders.created_at)) DAY),'%Y/%m/%e'), ' TO ',    \n" +
" DATE_FORMAT(DATE_ADD(orders.created_at, INTERVAL(7-DAYOFWEEK(orders.created_at)) DAY),'%Y/%m/%e')) AS DateRange,\n" +
"SUM(order_items.quantity),\n" +
"SUM(orders.total)\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_items ON orders.order_id = order_items.order_id\n" +
"WHERE created_at between (?) and (?)\n" +
"GROUP BY DATE(orders.created_at);";
    
    private String getSalesReportMonthly = "SELECT\n" +
"month(created_at),\n" +
"SUM(order_items.quantity),\n" +
"SUM(orders.total)\n" +
"FROM orders\n" +
"INNER JOIN\n" +
"order_items ON orders.order_id = order_items.order_id\n" +
"WHERE month(orders.created_at) between (?) and (?)\n" +
"GROUP BY DATE(orders.created_at);";
    
    private String getTransactions = "SELECT\n" +
"DATE(created_at),\n" +
"order_id,\n" +
"created_by,\n" +
"total\n" +
"FROM orders;";
    
    //String order_id, String quantity, String product_name, String total_price, Boolean has_addOns, String flavors
    
    private String getTransactionBreakdown = "SELECT order_items.order_id, order_items.quantity, \n" +
"(IF((order_items.product_bundle),CONCAT(\"B1G1 \",product.product_name),product.product_name)) AS Name,\n" +
"IF((product.product_bundle IS NULL),product.product_price,product.product_bundle)*order_items.quantity AS Price,\n" +
"order_items.has_addons, order_items.flavors\n" +
"FROM order_items\n" +
"INNER JOIN\n" +
"product ON order_items.product_id = product.product_id\n" +
"INNER JOIN\n" +
"orders ON order_items.order_id = orders.order_id\n" +
"LEFT JOIN\n" +
"payment ON payment.created_by = orders.created_by\n" +
"WHERE order_items.order_id = (?);";
    
    private String getTransactionsDaily = "SELECT\n" +
"DATE(created_at),\n" +
"order_id,\n" +
"created_by,\n" +
"total\n" +
"FROM orders\n" +
"20";
    
    private String getTransactionsWeekly = "SELECT\n" +
"CONCAT(DATE_FORMAT(DATE_ADD(orders.created_at, INTERVAL(1-DAYOFWEEK(orders.created_at)) DAY),'%Y/%m/%e'), ' TO ',\n" +
"DATE_FORMAT(DATE_ADD(orders.created_at, INTERVAL(7-DAYOFWEEK(orders.created_at)) DAY),'%Y/%m/%e')) AS DateRange,\n" +
"order_id,\n" +
"created_by,\n" +
"SUM(total)\n" +
"FROM orders\n" +
"WHERE created_at between (?) and (?)\n" +
"GROUP BY DATE(orders.created_at);";
    
    private String getTransactionsMonthly = "SELECT\n" +
"month(orders.created_at),\n" +
"order_id,\n" +
"created_by,\n" +
"SUM(total)\n" +
"FROM orders\n" +
"WHERE created_at between (?) and (?)\n" +
"GROUP BY DATE(orders.created_at);";
    
    private String getLogReports = "SELECT\n" +
"DATE(payment.created_at),\n" +
"REPLACE(payment.created_by,\"_\",\" \"),\n" +
"CONCAT(\"Made a payment of \", payment.payment_amount)\n" +
"FROM payment\n" +
"WHERE payment_status = \"COMPLETED\"\n" +
"UNION ALL\n" +
"SELECT\n" +
"DATE(user.log_in),\n" +
"REPLACE(user.user_name,\"_\",\" \"),\n" +
"CONCAT(\"Logged in \", user.log_in)\n" +
"FROM user\n" +
"UNION ALL\n" +
"SELECT\n" +
"DATE(user.log_out),\n" +
"REPLACE(user.user_name,\"_\",\" \"),\n" +
"CONCAT(\"Logged out \", user.log_out)\n" +
"FROM user;";
    
    private String getLogReportsDaily = "SELECT\n" +
"DATE(payment.created_at),\n" +
"REPLACE(payment.created_by,\"_\",\" \"),\n" +
"CONCAT(\"Made a payment of \", payment.payment_amount)\n" +
"FROM payment\n" +
"WHERE DATE(payment.created_at) BETWEEN (?) AND (?) AND payment_status = \"COMPLETED\" \n" +
"UNION ALL\n" +
"SELECT\n" +
"DATE(user.log_in),\n" +
"REPLACE(user.user_name,\"_\",\" \"),\n" +
"CONCAT(\"Logged in \", user.log_in)\n" +
"FROM user\n" +
"WHERE user.deleted_at IS NULL AND DATE(user.log_in) between (?) and (?)\n" +
"UNION ALL\n" +
"SELECT\n" +
"DATE(user.log_out),\n" +
"REPLACE(user.user_name,\"_\",\" \"),\n" +
"CONCAT(\"Logged out \", user.log_out)\n" +
"FROM user\n" +
"WHERE user.deleted_at IS NULL AND DATE(user.log_out) between (?) and (?);";
    
    private String retrieveUsersList = "SELECT user_type, user_name, device_type FROM menubytes.user WHERE deleted_at IS NULL;";
    
    private String usernameDuplicateChecker = "SELECT user_name from user WHERE user_name = (?);";
    
    private String accountCreation = "INSERT INTO user (user_name, password, user_type, created_at, modified_by, device_type)\n" +
"VALUES ( (?), (?), (?), current_timestamp(), 'admin', (?));";
    
    private String updateUserInfo = "UPDATE user \n" +
"SET user_name = (?), user_type = (?), modified_at = current_timestamp(), modified_by = \"admin\", device_type = (?)\n" +
"WHERE user_name = (?);";
    
    private String updatePassword = "UPDATE user \n" +
"SET password = (?), modified_at = current_timestamp(), modified_by = \"admin\"\n" +
"WHERE user_name = (?);";
    
    private String deleteUser = "UPDATE user \n" +
"SET deleted_at = current_timestamp(), deleted_by = 'admin', modified_at = current_timestamp(), modified_by = \"admin\"\n" +
"WHERE user_name = (?);";
    
    private String retrieveProductsList = "SELECT product_id, product_name, product_price, product_availability\n" +
"FROM product;";
    
    private String productDuplicateChecker = "SELECT product_name FROM product WHERE product_name = (?);";
    
    private String addProduct = "INSERT INTO product (product_name, product_price, product_bundle, product_description, product_category, product_availability)\n" +
"VALUES ( (?), (?), (?), (?), (?), \"available\" );";
    
    private String addProductSolo = "INSERT INTO product (product_name, product_price, product_bundle, product_description, product_category, product_availability)\n" +
"VALUES ( (?), (?), NULL, (?), (?), \"available\" );";
    
    private String updateProduct = "UPDATE product SET\n" +
"product_name = (?), product_price = (?), product_bundle = (?), product_description = (?),\n" +
"product_category = (?), product_availability = (?)\n" +
"WHERE product_name = (?);";
    
    private String getProductInfo = "SELECT product_id, product_name, product_price, product_bundle, product_description, product_category, product_availability FROM product WHERE product_name = (?);";
    
    private String deleteProduct ="DELETE FROM product WHERE (product_name = (?));";
    
    private String retrivePendingPayments = "SELECT user.user_name, payment.amount_due, payment.payment_status\n" +
"from payment\n" +
"JOIN user \n" +
"WHERE user.deleted_at is null AND payment.payment_status = 'PENDING' AND user.user_type = 'customer';";
    
    private String retrieveKitchenLogs = "SELECT log_in, log_out FROM menubytes.user where user_name = \"kitchen\";";
    
    private String getProductByCategory = "SELECT product_name, product_price, product_category FROM product where product_name = (?);";
    
    private String getUsername = "SELECT \n" +
"IF(user_name = 'cashier', 'take-out', user_name) \n" +
"FROM user WHERE user_name != 'admin' AND user_name != 'kitchen' AND deleted_at IS NULL;";
    
    private String insertOrder = "INSERT INTO orders(user_id, total, created_at, created_by) \n" +
"VALUES(\n" +
"((SELECT user_id from user where user_id = (?))),\n" +
"(?),\n" +
"(current_timestamp()),\n" +
"((SELECT user_name from user where user_name = (?)))\n" +
");";
    
    private String insertOrderStatus = "INSERT INTO order_status(order_id, order_status, created_at, created_by)\n" +
"VALUES(\n" +
"(?),\n" +
"(?),\n" +
"((SELECT created_at FROM orders where order_id = (?))),\n" +
"((SELECT user_name from user where user_name = 'cashier')));";
    
    private String insertOrderItems = "INSERT INTO order_items(order_id,product_id,quantity,product_bundle,has_addons, flavors)\n" +
"VALUES((?),(?),(?),(?),(?),(?));";
    
    private String notifyPanel = "SELECT payment.created_by,\n" +
"IF((payment.payment_status=\"PENDING\"), \"Payment Request\",null)\n" +
"FROM payment\n" +
"WHERE payment_status = \"PENDING\"\n" +
"UNION\n" +
"SELECT\n" +
"(SELECT user_name FROM user WHERE user_id = (assistance.user_id)),\n" +
"IF(assistance_status, \"Assistance Request\",null)\n" +
"FROM assistance\n" +
"WHERE assistance_status = true;";

    private String updatePaymentSetting = "UPDATE payment_method SET\n" +
"payment_info = (?), \n" +
"payment_qr = (?), \n" +
"payment_availability = (?)\n" +
"WHERE payment_method_id = '1';";
        
    private String getPaymentSetting = "SELECT payment_info, payment_qr, payment_availability from payment_method;";
    
    
    public String getNotifyPanel() {
        return notifyPanel;
    }
      
    public String getRetrieveUsersList() {
        return retrieveUsersList;
    }
    
    public String usernameDuplicateChecker() {
        return usernameDuplicateChecker;
    }
    
    public String accountCreation() {
        return accountCreation;
    }
    
    public String updatePassword() {
        return updatePassword;
    }
    
    public String updateUserInfo() {
        return updateUserInfo;
    }
    
    public String deleteUser() {
        return deleteUser;
    }
    
    public String productDuplicateChecker() {
        return productDuplicateChecker;
    }
    
    public String addProduct() {
        return addProduct;
    }
    
    public String addProductSolo() {
        return addProductSolo;
    }
    
    public String updateProduct() {
        return updateProduct;
    }
    
    public String getProductInfo() {
        return getProductInfo;
    }
    
    public String deleteProduct() {
        return deleteProduct;
    }

    public String getRetrieveProductsList() {
        return retrieveProductsList;
    }
    
    

    public String getSalesReportDefault() {
        return getSalesReportDefault;
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
    
    public String rejectGCashPayment(){
        return rejectGCashPayment;
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
    
    public String getRetrivePendingPayments(){
        return this.retrivePendingPayments;
    }
    
    public String retrieveKitchenLogs(){
        return this.retrieveKitchenLogs;
    }
    
    public String getSalesReportDaily() {
        return this.getSalesReportDaily;
    }
    
    public String getSalesReportWeekly() {
        return this.getSalesReportWeekly;
    }
    
    public String getSalesReportMonthly() {
        return this.getSalesReportMonthly;
    }
    
    public String getTransactions(){
        return this.getTransactions;
    }
    
    public String getTransactionsDaily() {
        return this.getTransactionsDaily;
    }
    
    public String getTransactionsWeekly() {
        return this.getTransactionsWeekly;
    }
    
    public String getTransactionsMonthly() {
        return this.getTransactionsMonthly;
    }
    
    public String getLogReports(){
        return this.getLogReports;
    }
    
    public String getLogReportsDaily() {
        return this.getLogReportsDaily;
    }
    
    public String getSelectedProductInfo() {
        return this.getProductByCategory;
    }
    
    public String getTransactionBreakdown() {
        return this.getTransactionBreakdown;
    }
    
    public String getUsername() {
        return this.getUsername;
    }
    
    public String insertOrder(){
        return this.insertOrder;
    }
    
    public String insertOrderStatus(){
        return this.insertOrderStatus;
    }
    
    public String insertOrderItems() {
        return this.insertOrderItems;
    }
    
    public String updatePaymentSetting() {
        return this.updatePaymentSetting;
    }
    
    public String getPaymentSetting() {
        return this.getPaymentSetting;
    }
}
