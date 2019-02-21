package UserInterface;

import javax.swing.*;

import PointOfSale.ProductListener;

import java.awt.*;
import java.awt.event.*;

import Main.*;
import ProductReader.*;
//Jarek

public class TopPanel extends JPanel{

  private static final long serialVersionUID = 1L;
  ProductPanel productPanel;
  JLabel nameLabel;
  JTextField textfield;
  JPanel namePanel;

  public TopPanel(ProductListener productListener, Catalog catalog) {
    setDefaults();
    addPanels(productListener, catalog);
  }

  private void setDefaults(){
    setPreferredSize(new Dimension(800, 250));
    setLayout(new GridLayout(0, 2));
  }

  private void addPanels(ProductListener productListener, Catalog catalog){
    namePanel = new JPanel();
    //namePanel.setLayout(new BorderLayout());

    nameLabel = new JLabel("Customer Name:");
    textfield = new JTextField();
    
    nameLabel.setPreferredSize(new Dimension(150, 25));
    textfield.setPreferredSize(new Dimension(200, 25));
    
    namePanel.add(nameLabel,BorderLayout.WEST);
    namePanel.add(textfield, BorderLayout.CENTER);

    this.productPanel = new ProductPanel(productListener, catalog);

    add(namePanel);
    add(this.productPanel);
  }

  public String getName(){
    return textfield.getText();
  }

  public UPC getUPCcode(){
      return productPanel.getUPCcode();
  }

  public Integer getQuantity(){
      return productPanel.getQuantity();
  }

  public void resetGUI(){
    textfield.setText("");
  }
}