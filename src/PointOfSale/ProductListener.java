package PointOfSale;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

public class ProductListener extends Observable implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        if (event instanceof JButton) {
            // System.out.println("pay button pressed");
            setChanged();
            notifyObservers();
        }
    }

}