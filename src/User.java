/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natania
 */
public class User {
    private String user_id;
    private String user_type;
    private String user_name;
    private String user_password;
    private String device_type;
    private String log_in;
    private String log_out;
    String password;

    public User(String user_id, String user_type, String user_name, String user_password, String device_type) {
        this.user_id = user_id;
        this.user_type = user_type;
        this.user_name = user_name;
        this.user_password = user_password;
        this.device_type = device_type;
    }
    //Also used for getVerificationPassword
    public User(String user_name) {
        this.user_name = user_name;
    }
    
     public User(String user_name, String password, String user_type, String device_type) {
        this.password = password;
        this.user_type = user_type;
        this.user_name = user_name;
        this.device_type = device_type;
    }
    

//    public User(String user_type, String user_name, String user_password, String device_type) {
//        this.user_type = user_type;
//        this.user_name = user_name;
//        this.user_password = user_password;
//        this.device_type = device_type;
//    }

    public User(String user_type, String user_name, String device_type) {
        this.user_type = user_type;
        this.user_name = user_name;
        this.device_type = device_type;
    }
    
    public User(String log_in, String log_out){
        this.log_in = log_in;
        this.log_out = log_out;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }
    
    public String getLog_out(){
        return log_out;
    }
    
    public void setLog_out(String log_out){
        this.log_out = log_out;
    }
    
    public String getLog_in(){
        return log_in;
    }
    
    public void setLog_in(String log_in){
        this.log_in = log_in;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    
}
