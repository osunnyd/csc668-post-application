package UserInterface;

import javax.swing.*;

import UserInterfaceController.ProductListener;

import java.awt.*;
import java.awt.event.*;

//Jarek

public class TopPanel extends JPanel{

  private static final long serialVersionUID = 1L;
  ProductPanel productPanel;
  JLabel nameLabel;
  JTextField textfield;
  JPanel namePanel;

  public TopPanel(ProductListener productListener) {
    setDefaults();
    addPanels(productListener);
  }

  private void setDefaults(){
    setPreferredSize(new Dimension(800, 250));
    setLayout(new GridLayout(0, 2));
  }

  private void addPanels(ProductListener productListener){
    namePanel = new JPanel();

    nameLabel = new JLabel("Customer Name: ");
    textfield = new JTextField();
    
    nameLabel.setPreferredSize(new Dimension(150, 25));
    textfield.setPreferredSize(new Dimension(150, 25));
    
    namePanel.add(nameLabel,BorderLayout.WEST);
    namePanel.add(textfield, BorderLayout.CENTER);

    this.productPanel = new ProductPanel(productListener);

    add(namePanel);
    add(this.productPanel);
  }

  public String getName(){
    return textfield.getText();
  }

  public String getUPCcode(){
      return productPanel.getUPCcode();
  }

  public Integer getQuantity(){
      return productPanel.getQuantity();
  }

}