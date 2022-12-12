/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class GCash{
    
    private String remarks; 
    private String discount_type; 
    private String discount_amount; 
    private String discount_id; 
    private String amount_due;

    public GCash(String remarks, String amount_due) {
        this.remarks = remarks;
        this.amount_due = amount_due;
    }

    public GCash(String discount_type, String discount_amount, String discount_id, String amount_due, String remarks) {
        this.remarks = remarks;
        this.discount_type = discount_type;
        this.discount_amount = discount_amount;
        this.discount_id = discount_id;
        this.amount_due = amount_due;
    }

    
    
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAmount_due() {
        return amount_due;
    }

    public void setAmount_due(String amount_due) {
        this.amount_due = amount_due;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }

    public String getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(String discount_id) {
        this.discount_id = discount_id;
    }
    
    
    
    
    
}
