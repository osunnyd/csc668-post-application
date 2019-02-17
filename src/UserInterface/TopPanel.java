package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopPanel extends JPanel {

  private static final long serialVersionUID = 1L;

  public TopPanel() {
    setPreferredSize(new Dimension(800, 250));
    setBorder(BorderFactory.createLineBorder(Color.black));
    //setLayout(new BorderLayout(10, 10));
    setLayout(null);
    JLabel nameLabel = new JLabel("Customer Name: ");
    JLabel upcLabel = new JLabel("UPC: ");
    JLabel qtyLabel = new JLabel("QTY: ");
    JButton enterButton = new JButton("Enter!");
    JTextField textfield = new JTextField();

    //future UPC codes with references
    String[] choices = {"1234", "2345", "3456"};
    final JComboBox<String> upcDropdown = new JComboBox<String>(choices);
    
    Integer[] quantity = {1, 2, 3};
    final JComboBox<Integer> qtyDropdown = new JComboBox<Integer>(quantity);


    nameLabel.setBounds(50, 0, 50, 50);
    upcLabel.setBounds(250, 0, 50, 50);
    qtyLabel.setBounds(450, 0, 50, 50);
    enterButton.setBounds(650, 0, 100, 50);
    textfield.setBounds(200, 50, 50, 50);
    upcDropdown.setBounds(0, 50, 100, 50);
    qtyDropdown.setBounds(400, 50, 100, 50);

    add(nameLabel);
    add(upcLabel);
    add(qtyLabel);
    add(enterButton);
    add(textfield);
    add(upcDropdown);
    add(qtyDropdown);

  }
}