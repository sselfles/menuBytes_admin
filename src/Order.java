/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class Order {
    
    private String order_id;
    private String product_id;
    private String product_name;
    private String quantity;
    private String total_quantity;
    private String product_price;
    private String total_price;
    private String table_no;
    private String date;
    private String order_status;
    private String created_by;
    private String product_availability;

    public Order(String order_id, String product_name, String quantity, String product_price, String grand_total, String table_no, String date, String order_status) {
        this.order_id = order_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.product_price = product_price;
        this.total_price = grand_total;
        this.table_no = table_no;
        this.date = date;
        this.order_status = order_status;
    }

    public Order(String order_id, String created_by, String total_quantity, String order_status ) {
        this.order_id = order_id;
        this.created_by = created_by;
        this.total_quantity = total_quantity;
        this.order_status = order_status;
    }
    
    public Order(String order_id,String quantity, String product_name){
        this.order_id = order_id;
        this.quantity = quantity;
        this.product_name = product_name;
    }
    
    
    
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    
    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getProduct_availability() {
        return product_availability;
    }

    public void setProduct_availability(String product_availability) {
        this.product_availability = product_availability;
    }
    
    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getTable_no() {
        return table_no;
    }

    public void setTable_no(String table_no) {
        this.table_no = table_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }
    
    
}
