/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class Report {
    
    private String date;
    private String order_id;
    private String table_name;
    private String total_amount;
    private String total_quantity;
    private String description;
    

    public Report(String date, String order_id, String table_name, String total_amount) {
        this.date = date;
        this.order_id = order_id;
        this.table_name = table_name;
        this.total_amount = total_amount;
    }
    
    public Report(String date, String total_quantity, String total_amount){
        this.date = date;
        this.total_quantity = total_quantity;
        this.total_amount = total_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
    
    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
