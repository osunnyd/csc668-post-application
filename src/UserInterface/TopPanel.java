package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopPanel extends JPanel implements ActionListener{

  private static final long serialVersionUID = 1L;
  JLabel nameLabel;
  JLabel upcLabel;
  JLabel qtyLabel;
  JButton enterButton;
  JTextField textfield;
  final JComboBox<String> upcDropdown;
  final JComboBox<Integer> qtyDropdown;

  public TopPanel() {
    setDefaults();
    //get and set upc codes
    //add panels
  }

  private void setDefaults(){
    setPreferredSize(new Dimension(800, 250));
    setBorder(BorderFactory.createLineBorder(Color.black));
    //setLayout(new BorderLayout(10, 10));
    //setLayout(new GridLayout)
    setLayout(null);
    nameLabel = new JLabel("Customer Name: ");
    upcLabel = new JLabel("UPC: ");
    qtyLabel = new JLabel("QTY: ");
    enterButton = new JButton("Enter!");
    textfield = new JTextField();

    String[] upcChoices = {"1234", "2345", "3456"};
    final JComboBox<String> upcDropdown = new JComboBox<String>(upcChoices);
    
    Integer[] quantity = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final JComboBox<Integer> qtyDropdown = new JComboBox<Integer>(quantity);

    //Static locations
    nameLabel.setBounds(50, 0, 50, 50);
    upcLabel.setBounds(250, 0, 50, 50);
    qtyLabel.setBounds(450, 0, 50, 50);
    enterButton.setBounds(650, 0, 100, 50);
    textfield.setBounds(200, 50, 50, 50);
    upcDropdown.setBounds(0, 50, 100, 50);
    qtyDropdown.setBounds(400, 50, 100, 50);

    //Flexible locations

    add(nameLabel);
    add(upcLabel);
    add(qtyLabel);
    add(enterButton);
    add(textfield);
    add(upcDropdown);
    add(qtyDropdown);
  }

}