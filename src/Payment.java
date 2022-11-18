/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class Payment {
    private String table_no;
    private String table_name;
    private String payment_method;
    private String total_amount;
    private String status;
    private String amount_due;
    

    public Payment(String table_no,String total_amount, String status) {
        this.table_no = table_no;
        this.total_amount = total_amount;
        this.status = status;
    }
    public Payment(String table_no,String payment_method, String total_amount, String status) {
        this.table_no = table_no;
        this.total_amount = total_amount;
        this.payment_method = payment_method;
        this.status = status;
    }

    public Payment(String amount_due,String table_no) {
        this.table_no = table_no;
        this.amount_due = amount_due;
    }
    

    public String getAmount_due() {
        return amount_due;
    }

    public void setAmount_due(String amount_due) {
        this.amount_due = amount_due;
    }
    
    

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    
    public String getTable_no() {
        return table_no;
    }

    public void setTable_no(String table_no) {
        this.table_no = table_no;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
}
