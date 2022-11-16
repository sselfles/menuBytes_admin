/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class Product {
    private String product_id;
    private String product_name;
    private String product_price;
    private String product_availability;
    private String product_category;
    private String product_description;
    private String product_image;

    public Product(String product_id, String product_name, String product_price, String product_availability) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_availability = product_availability;
    }
    
    public Product(String product_category, String product_name, String product_description, String product_price, String product_availability, String product_image) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_availability = product_availability;
        this.product_category = product_category;
        this.product_description = product_description;
        this.product_image = product_image;
    }

    public Product(String product_category, String product_name, String product_description, String product_price, String product_availability) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_availability = product_availability;
        this.product_category = product_category;
        this.product_description = product_description;
    }
    
    public Product(String product_name, String product_price, String product_category) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_category = product_category;
    }

    public Product(String product_name) {
        this.product_name = product_name;
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
}
