/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gelay
 */
public class OrderItems {
    String quantity; 
    String product_name; 
    String total_price;
    Boolean has_addOns;
    String flavors;
    String total_amount;
    String total_quantity;
    
    public OrderItems  (String quantity, String product_name, String total_price) {
        this.quantity = quantity;
        this.product_name = product_name;
        this.total_price = total_price;
    }
    
    public OrderItems  (String total_amount) {
        this.total_amount = total_amount;
    }
    
    public String getProduct_name() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
    
    public String getTotal_amount() {
        return product_name;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }
    
    public String getTotal_quantity() {
        return total_quantity;
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
    
    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
    
    public Boolean getHas_addOns() {
        return has_addOns;
    }

    public void setHas_addOns(Boolean has_addOns) {
        this.has_addOns = has_addOns;
    }
    
    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }
}
