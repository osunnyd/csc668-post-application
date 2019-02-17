package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observer;

import UserInterfaceController.*;


public class POS_GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    BottomPanel bottomPanel;
    UserInterfaceController controller;

    public POS_GUI() {
        this.controller = new UserInterfaceController();
        setDefaults();
        addPanels(controller);
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

    private void addPanels(UserInterfaceController controller) {
        TopPanel topPanel = new TopPanel();
        CenterPanel centerPanel = new CenterPanel();
        bottomPanel = new BottomPanel(controller);
        //sets panels to strict coordinates (x, y, width, height)
        topPanel.setBounds(0, 0, 800, 200);
        centerPanel.setBounds(0, 200, 800, 400);
        bottomPanel.setBounds(0, 600, 800, 200);

        add(topPanel);
        add(centerPanel);
        add(bottomPanel);

    }


}