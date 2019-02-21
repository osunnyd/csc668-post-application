package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import PointOfSale.*;

public class BottomPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private PaymentPanel paymentPanel;
    private JLabel dateLabel;

    public BottomPanel(PaymentListener paymentListener) {
        setDefaults();
        setDate();
        addPaymentPanel(paymentListener);
    }

    private void setDefaults() {
        setLayout(new GridLayout(0, 2));
    }

    private void setDate() {
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BorderLayout());
        dateLabel = new JLabel(new Date().toString());
        datePanel.add(dateLabel, BorderLayout.CENTER);
        add(datePanel);
    }

    private void addPaymentPanel(PaymentListener paymentListener) {
        this.paymentPanel = new PaymentPanel(paymentListener);
        add(this.paymentPanel);
    }
    public void resetGUI(){
        dateLabel.setText(new Date().toString());
        paymentPanel.resetGUI();
    }

    public String getPaymentType() {
        return paymentPanel.getCustomerPaymentType();
    }

    public String getDate(){
        return dateLabel.getText();
    }

    public String getAmountTendered() {
        return paymentPanel.getAmountTendered();
    }

}