package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TopPanel extends JPanel{

  private static final long serialVersionUID = 1L;
  ProductPanel productPanel;
  JLabel nameLabel;
  JTextField textfield;

  public TopPanel() {
    setDefaults();
    //get and set upc codes
    //add panels
  }

  private void setDefaults(){
    setPreferredSize(new Dimension(800, 250));
    setBorder(BorderFactory.createLineBorder(Color.black));
    setLayout(new GridLayout(0, 2));
    //setLayout(null);
    JPanel namePanel = new JPanel();
    nameLabel = new JLabel("Customer Name: ");
    textfield = new JTextField();
    
    nameLabel.setPreferredSize(new Dimension(150, 25));
    textfield.setPreferredSize(new Dimension(150, 25));
    
    namePanel.add(nameLabel,BorderLayout.WEST);
    namePanel.add(textfield, BorderLayout.CENTER);

    this.productPanel = new ProductPanel();

    add(namePanel);
    add(this.productPanel);
  }
}