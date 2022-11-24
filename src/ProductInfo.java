/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class ProductInfo {
    private String product_id;
    private String product_name;
    private String product_price;
    private String product_availability;
    private String product_category;
    private String product_description;
    private String product_image;
    private String bundle;
    private String quantity;
    private boolean product_bundle;
    private boolean has_addons;
    private String flavors;
    
    public ProductInfo(String product_id, String product_name, String product_price, String bundle, String product_description, String product_category, String product_availability) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.bundle = bundle;
        this.product_description = product_description;
        this.product_category = product_category;
        this.product_image = product_availability;
    }
    
    public ProductInfo(String product_name, String product_price, String bundle, String product_description, String product_category, String product_availability) {
        
        this.product_name = product_name;
        this.product_price = product_price;
        this.bundle = bundle;
        this.product_description = product_description;
        this.product_category = product_category;
        this.product_image = product_availability;
    }
    
    public ProductInfo(String product_name, String product_price, String bundle){
        this.product_name = product_name;
        this.product_price = product_price;
        this.bundle = bundle;
    }
    
//                  (orderID, product_id, quantity, product_bundle, addons, flavors);

    public ProductInfo(String product_id, String quantity, boolean product_bundle, boolean has_addons, String flavors) {
        this.product_id = product_id;
        this.quantity = quantity;
        this.product_bundle = product_bundle;
        this.has_addons = has_addons;
        this.flavors = flavors;
    }

    
    public String getFlavors() {
        return flavors;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }
    
    

    public boolean isProduct_bundle() {
        return product_bundle;
    }

    public void setProduct_bundle(boolean product_bundle) {
        this.product_bundle = product_bundle;
    }

    public boolean isHas_addons() {
        return has_addons;
    }

    public void setHas_addons(boolean has_addons) {
        this.has_addons = has_addons;
    }
    
    
    

    
    
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
    

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }
    
    
    
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_availability() {
        return product_availability;
    }

    public void setProduct_availability(String product_availability) {
        this.product_availability = product_availability;
    }
    
    public String getBundle() {
        return bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }
}
