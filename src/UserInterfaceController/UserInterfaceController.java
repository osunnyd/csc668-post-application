package UserInterfaceController;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import java.util.Observable;
import Main.*;
import UserInterface.*;

//TODO: This is where a customer object will be instantiated and updated
//TODO: When the Pay button is pressed, send Customer object to POS class for processing
public class UserInterfaceController implements Observer {
    private PaymentListener paymentListener;
    private Customer customer;
    private POS_GUI pos_GUI;

    public UserInterfaceController(){
        addListeners();
        this.pos_GUI = new POS_GUI(paymentListener);

    }

    private void addListeners(){
        //TODO: add listeners for each point of interest
        this.paymentListener = new PaymentListener();
        this.paymentListener.addObserver(this);

    }

    public PaymentListener getPaymentListener(){
        return this.paymentListener;
    }




    @Override
    public void update(Observable listener, Object object){

        
        if(listener instanceof PaymentListener){

            System.out.println("payment event received from GUI");
            System.out.println(pos_GUI.getPaymentType());
            System.out.println(pos_GUI.getAmountTendered());

        }
    }



}