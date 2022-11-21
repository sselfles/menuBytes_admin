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
    private String amount_due;

    public GCash(String remarks, String amount_due) {
        this.remarks = remarks;
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
    
    
    
    
    
}
