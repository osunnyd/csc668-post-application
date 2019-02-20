package UserInterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import PointOfSale.*;

public class PaymentPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox paymentTypeDropdown;
    private TextField amountField;
    private JButton payButton;

    public PaymentPanel(PaymentListener paymentListener) {
        setDefaults();
        setPaymentTypeDropdown();
        setAmountField();
        setPayButton(paymentListener);
    }

    private void setDefaults(){
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createTitledBorder("Payment"));
        setLayout(new BorderLayout(10, 10));
    }

    private void setPaymentTypeDropdown() {
        JPanel paymentTypePanel = new JPanel();
        String[] paymentType = { "CREDIT", "CHECK", "CASH" };
        paymentTypeDropdown = new JComboBox(paymentType);
        paymentTypeDropdown.setSelectedIndex(0);
        JLabel paymentTypeLabel = new JLabel("Payment type");
        paymentTypePanel.add(paymentTypeLabel);
        paymentTypePanel.add(paymentTypeDropdown);
        add(paymentTypePanel, BorderLayout.LINE_START);
    }

    private void setAmountField() {
        JPanel amountPanel = new JPanel();
        JLabel amountLabel = new JLabel("Amount");
        amountField = new TextField("", 10);
        amountPanel.add(amountLabel);
        amountPanel.add(amountField);
        add(amountPanel, BorderLayout.CENTER);
    }

    private void setPayButton(PaymentListener paymentListener) {
        this.payButton = new JButton("Pay");
        add(payButton, BorderLayout.PAGE_END);
        payButton.addActionListener(paymentListener);
    }

    public void resetGUI(){
        paymentTypeDropdown.setSelectedIndex(0);
        amountField.setText("");
    }

    public String getCustomerPaymentType() {
        return (String) paymentTypeDropdown.getSelectedItem();
    }

    public String getAmountTendered() {
        return amountField.getText();
    }

}