
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gelay
 */
public class changeListener  implements ChangeListener {
    
    JTextField txt_cash_received;
    JLabel txtTotal_amount, lbl_change;
    
    public void stateChanged(ChangeEvent e) {
        float cashReceived = Integer.parseInt(txt_cash_received.getText());
                float totalAmount = Integer.parseInt(txtTotal_amount.getText());
                float change =cashReceived - totalAmount;
                lbl_change.setText(Float.toString(change));
//                lbl_change.setText(txt_cash_received.getText());
    }
    
}
