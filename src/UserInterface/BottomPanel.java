package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import UserInterfaceController.*;

public class BottomPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    PaymentPanel paymentPanel;

    public BottomPanel(PaymentListener paymentListener) {
        setDefaults();
        addPaymentPanel(paymentListener);
    }

    private void setDefaults() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new GridLayout(0, 2));
        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel(new Date().toString());
        datePanel.add(dateLabel);
        add(datePanel);

    }

    private void addPaymentPanel(PaymentListener paymentListener) {
        this.paymentPanel = new PaymentPanel(paymentListener);
        add(this.paymentPanel);
    }

    public String getPaymentType() {
        return paymentPanel.getCustomerPaymentType();
    }

    public String getAmountTendered() {
        return paymentPanel.getAmountTendered();
    }

}