package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import UserInterfaceController.*;

public class BottomPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    PaymentPanel paymentPanel;
    UserInterfaceController controller;

    public BottomPanel(UserInterfaceController controller) {
        this.controller = controller;
        setDefaults();
        addPaymentPanel(controller);
    }

    private void setDefaults(){
        //setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new GridLayout(0, 2));
        JPanel datePanel = new JPanel();
        //datePanel.setPreferredSize(new Dimension(200, 300));
        JLabel dateLabel = new JLabel(new Date().toString());
        //add(label, BorderLayout.LINE_START);
        datePanel.add(dateLabel);
        add(datePanel);

    }

    private void addPaymentPanel(UserInterfaceController controller){
        this.paymentPanel = new PaymentPanel(controller);
        add(this.paymentPanel);
    }


}