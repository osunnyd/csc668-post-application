package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;
import ProductReader.*;
import PointOfSale.*;
import Main.*;

public class POS_GUI {

    private static final long serialVersionUID = 1L;
    BottomPanel bottomPanel;
    CenterPanel centerPanel;
    TopPanel topPanel;
    JFrame frame;

    public POS_GUI(PaymentListener paymentListener, ProductListener productListener, Catalog catalog) {
        setDefaults();
        addPanels(paymentListener, productListener, catalog);
        frame.setVisible(true);
    }

    private void setDefaults() {
        this.frame = new JFrame();
        frame.setTitle("POS");
        frame.setSize(800, 820);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
    }

    private void addPanels(PaymentListener paymentListener, ProductListener productListener, Catalog catalog) {
        this.topPanel = new TopPanel(productListener, catalog);
        this.centerPanel = new CenterPanel();
        this.bottomPanel = new BottomPanel(paymentListener);
        // sets panels to strict coordinates (x, y, width, height)
        topPanel.setBounds(0, 0, 800, 200);
        centerPanel.setBounds(0, 200, 800, 400);
        bottomPanel.setBounds(0, 600, 800, 200);

        frame.add(topPanel);
        frame.add(centerPanel);
        frame.add(bottomPanel);
    }

    public void resetGUI() {
        // clear out the GUI for next transaction
        bottomPanel.resetGUI();
        topPanel.resetGUI();
        centerPanel.resetGUI();
    }

    public String getName() {
        return topPanel.getName();
    }

    public UPC getUPCcode() {
        return topPanel.getUPCcode();
    }

    public Integer getQuantity() {
        return topPanel.getQuantity();
    }

    public void itemtoInvoice(Item item, int quantity) {
        centerPanel.itemtoInvoice(item, quantity);
    }

    public String getAmountDue() {
        return centerPanel.getAmountDue();
    }

    public String getDate() {
        return bottomPanel.getDate();
    }

    public String getPaymentType() {
        return bottomPanel.getPaymentType();
    }

    public String getAmountTendered() {
        return bottomPanel.getAmountTendered();
    }

    public void displayItemAdded() {
        JOptionPane.showMessageDialog(frame, "Item(s) added");
    }

    public void displayPaymentMessage(boolean status) {
        if (status == true) {
            JOptionPane.showMessageDialog(frame, "Payment Success");
        } else {
            JOptionPane.showMessageDialog(frame, "Payment Failed");
        }
    }
}