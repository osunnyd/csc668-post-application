package UserInterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import UserInterfaceController.*;

public class ProductPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JLabel upcLabel;
    JLabel qtyLabel;
    JButton enterButton;
    String[] upcChoices;
    JComboBox<String> upcDropdown;
    Integer[] quantityChoices;
    JComboBox<Integer> qtyDropdown;


    public ProductPanel(){
        setDefaults();
    }

    private void setDefaults(){
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createTitledBorder("Product"));
        setLayout(new BorderLayout(10, 10));
        Integer[] quantityChoices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] upcChoices = {"1234", "2345", "3456"};
        qtyDropdown = new JComboBox<Integer>(quantityChoices);
        upcDropdown = new JComboBox<String>(upcChoices);
        upcLabel = new JLabel("UPC:");
        qtyLabel = new JLabel("QTY:");
        enterButton = new JButton("Enter");

        upcLabel.setBounds(100, 0, 50, 50);
        qtyLabel.setBounds(100, 0, 50, 50);
        enterButton.setBounds(50, 0, 100, 50);
        upcDropdown.setBounds(0, 50, 50, 50);
        qtyDropdown.setBounds(50, 50, 100, 50);

        add(upcLabel);
        add(qtyLabel);
        add(enterButton);
        add(upcDropdown);
        add(qtyDropdown);
    }
    

}