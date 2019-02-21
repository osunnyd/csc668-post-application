package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ProductReader.*;


//Jarek

public class CenterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    protected JTextArea textArea;
    protected JLabel infoLabel;
    protected JLabel totalLabel;
    float totalDue;
    JScrollPane scrollPane;

  public CenterPanel() {
    setDefaults();
    addPanels();
  }

  private void setDefaults(){
    setPreferredSize(new Dimension(400, 800));
    setBorder(BorderFactory.createTitledBorder("Invoice"));
    setLayout(new BorderLayout(10, 10));
    infoLabel = new JLabel("Item                                                                    QTY                     UNIT_PRICE                     EXTENDED_PRICE");
    totalDue = 0.f;
    totalLabel = new JLabel("                                                                                                                                                TOTAL        $" + String.valueOf(totalDue));

    textArea = new JTextArea(5, 20);
    String text = "";
    textArea.append(text);
    textArea.setEditable(false);
  }

  private void addPanels(){
    scrollPane = new JScrollPane(textArea);
    add(scrollPane, BorderLayout.CENTER);
    add(infoLabel, BorderLayout.NORTH);
    add(totalLabel, BorderLayout.PAGE_END);
  }

  public void itemtoInvoice(Item item, int quantity){
    String itemprice = String.valueOf(item.getPrice());
    String subtotal = String.valueOf(item.getPrice() *(float) quantity);
    textArea.append(item.getDescription() + "                                                ");
    textArea.append(addSpace(20 - item.getDescription().length()));
    textArea.append(String.valueOf(quantity) + "                                ");
    textArea.append(itemprice + "                                                ");
    textArea.append(subtotal + "                                                \n");
    totalDue = totalDue + (item.getPrice() * (float) quantity);
    update();
  }

  private void update(){
    totalLabel.setText("                                                                                                                                           TOTAL        $" + String.valueOf(totalDue));
  }

  public void resetGUI(){
    totalDue = 0.f;
    textArea.setText("");
    totalLabel.setText("                                                                                                                                           TOTAL        $" + String.valueOf(totalDue));
  }

  public String getAmountDue(){
    return String.valueOf(totalDue);
  }

  private String addSpace(int difference){
    String extraSpace = "";

    for(int i = 0; i < difference ; i++){
      extraSpace = extraSpace + " ";
    }

    return extraSpace;
  }
}