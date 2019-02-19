package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;

import PointOfSale.*;

public class POS_GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    BottomPanel bottomPanel;
    CenterPanel centerPanel;
    TopPanel topPanel;
    public POS_GUI(PaymentListener paymentListener, ProductListener productListener) {
        // this.controller = new UserInterfaceController();
        setDefaults();
        addPanels(paymentListener, productListener);
        setVisible(true);
    }

    private void setDefaults() {
        setTitle("POS");
        setSize(800, 820);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
    }

    private void addPanels(PaymentListener paymentListener, ProductListener productListener) {
        this.topPanel = new TopPanel(productListener);
        this.centerPanel = new CenterPanel();
        this.bottomPanel = new BottomPanel(paymentListener);
        // sets panels to strict coordinates (x, y, width, height)
        topPanel.setBounds(0, 0, 800, 200);
        centerPanel.setBounds(0, 200, 800, 400);
        bottomPanel.setBounds(0, 600, 800, 200);

        add(topPanel);
        add(centerPanel);
        add(bottomPanel);

    }

    public String getPaymentType() {
        return bottomPanel.getPaymentType();
    }

    public String getAmountTendered() {
        return bottomPanel.getAmountTendered();
    }

    public String getUPCcode(){
        return topPanel.getUPCcode();
    }

    public Integer getQuantity(){
        return topPanel.getQuantity();
    }

    //public String get stuff from PANEL FUNCTIONS for User interface controller

}