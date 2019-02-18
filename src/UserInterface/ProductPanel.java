package UserInterface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import UserInterfaceController.*;

//Jarek

public class ProductPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JLabel upcLabel;
    JLabel qtyLabel;
    JButton enterButton;
    JComboBox<String> upcDropdown;
    JComboBox<Integer> qtyDropdown;


    public ProductPanel(){
        setDefaults();
        getUPCcodes();
        addPanels();
    }

    private void setDefaults(){
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createTitledBorder("Product"));
        setLayout(new BorderLayout(10, 10));
        
        upcLabel = new JLabel("UPC:");
        qtyLabel = new JLabel("QTY:");
        enterButton = new JButton("Enter");
    }


    private void getUPCcodes(){
        Integer[] quantityChoices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] upcChoices = {"1234", "2345", "3456"};
        qtyDropdown = new JComboBox<Integer>(quantityChoices);
        upcDropdown = new JComboBox<String>(upcChoices);
    }

    private void addPanels(){
        JPanel upcPanel = new JPanel();
        upcPanel.add(upcLabel);
        upcPanel.add(upcDropdown);
        
        JPanel qtyPanel = new JPanel();
        qtyPanel.add(qtyLabel);
        qtyPanel.add(qtyDropdown);
        
        add(upcPanel, BorderLayout.LINE_START);
        add(qtyPanel, BorderLayout.CENTER);
        add(enterButton, BorderLayout.PAGE_END);
    }
    

}