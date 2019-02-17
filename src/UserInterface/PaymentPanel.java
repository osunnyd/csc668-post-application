package UserInterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import UserInterfaceController.*;

public class PaymentPanel extends JPanel{

    private static final long serialVersionUID = 1L;
    UserInterfaceController controller;
    JComboBox paymentTypeDropdown;
    TextField amountField;
    JButton payButton;

    public PaymentPanel(UserInterfaceController controller) {
        this.controller = controller;
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createTitledBorder("Payment"));
        setLayout(new BorderLayout(10, 10));
        setPaymentTypeDropdown();
        setAmountField();
        setPayButton(this.controller);
    }

    private void setPaymentTypeDropdown() {
        JPanel panel = new JPanel();
        String[] paymentType = { "CREDIT", "CHECK", "CASH" };
        paymentTypeDropdown = new JComboBox(paymentType);
        paymentTypeDropdown.setSelectedIndex(0);
        JLabel paymentTypeLabel = new JLabel("Payment type");
        panel.add(paymentTypeLabel);
        panel.add(paymentTypeDropdown);
        add(panel, BorderLayout.LINE_START);
    }

    private void setAmountField() {
        JPanel amountPanel = new JPanel();
        JLabel amountLabel = new JLabel("Amount");
        amountField = new TextField("", 10);
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);
        add(amountPanel, BorderLayout.CENTER);
    }

    private void setPayButton(UserInterfaceController controller) {
        this.payButton = new JButton("Pay");
        add(payButton, BorderLayout.PAGE_END);
        payButton.addActionListener(controller.getPaymentListener());
    }

    public String getCustomerPaymentType(){
        return (String)paymentTypeDropdown.getSelectedItem();
    }

}