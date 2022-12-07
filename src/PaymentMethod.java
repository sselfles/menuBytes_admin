/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gelay
 */
public class PaymentMethod {
    private String payment_info;
    private byte[] payment_qr;
    private String payment_availability;
    

    public PaymentMethod(String payment_info,byte[] payment_qr, String payment_availability) {
        this.payment_info = payment_info;
        this.payment_qr = payment_qr;
        this.payment_availability = payment_availability;
    }
    
    public PaymentMethod(String payment_availability) {
        this.payment_availability = payment_availability;
    }
    

    public String getPayment_info() {
        return payment_info;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }
    
    public byte[] getPayment_qr() {
        return payment_qr;
    }

    public void setPayment_qr(byte[] payment_qr) {
        this.payment_qr = payment_qr;
    }
    public String getPayment_availability() {
        return payment_availability;
    }

    public void setPayment_availability(String payment_availability) {
        this.payment_availability = payment_availability;
    }
}
