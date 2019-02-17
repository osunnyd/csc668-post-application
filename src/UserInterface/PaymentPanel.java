package UserInterface;

import javax.swing.*;

import javafx.scene.control.ComboBox;

import java.awt.*;
import java.awt.event.*;

public class PaymentPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    JComboBox paymentTypeDropdown;
    TextField amountField;
    JButton payButton;

    public PaymentPanel() {
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createTitledBorder("Payment"));
        setLayout(new BorderLayout(10, 10));

        setPaymentTypeDropdown();
        setAmountField();
        setPayButton();
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

    private void setPayButton() {
        payButton = new JButton("Pay");
        add(payButton, BorderLayout.PAGE_END);
        payButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: add validation for payment
        // TODO: add payment success/failure popup
        Object paymentAction = e.getSource();
        if (paymentAction.equals(payButton)) {
            System.out.println((String) paymentTypeDropdown.getSelectedItem());
            System.out.println(amountField.getText());
            System.out.println("pay pressed");
        }

    }
}