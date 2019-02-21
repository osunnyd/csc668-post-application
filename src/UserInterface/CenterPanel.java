package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Jarek

public class CenterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    protected JTextArea textArea;
    protected JLabel infoLabel;
    protected JLabel totalLabel;
    int totalDue;
    //JTable table;
    JScrollPane scrollPane;

  public CenterPanel() {
    setDefaults();
    addPanels();
  }
private void setDefaults(){
    setPreferredSize(new Dimension(400, 800));
    setBorder(BorderFactory.createTitledBorder("Invoice"));
    setLayout(new BorderLayout(10, 10));
    //Item                                                                    QTY                     UNIT_PRICE                     EXTENDED_PRICE"    
    infoLabel = new JLabel("Item                                                                    QTY                     UNIT_PRICE                     EXTENDED_PRICE");
    totalDue = 0;
    totalLabel = new JLabel("                                                                                                                                                TOTAL        $" + String.valueOf(totalDue));


    //JPanel totalPanel = new JPanel();

    textArea = new JTextArea(5, 20);
    String text = "";
    //String[][] data = {{"hello", "there"}};
    //String[] columnNames = {"this","one"};
    //JList jlist = new JList(data);
    //jlist.setLayoutOrientation(0);
    //jlist.setVisibleRowCount(0);
    //JTable table = new JTable(data, columnNames);
    
    textArea.append(text);
    textArea.setEditable(false);
  }

  private void addPanels(){
    //scrollPane = new JScrollPane(table);
    scrollPane = new JScrollPane(textArea);
    add(scrollPane, BorderLayout.CENTER);

    //add(jlist, BorderLayout.CENTER);
    //add(table, BorderLayout.CENTER);
    add(infoLabel, BorderLayout.NORTH);
    add(totalLabel, BorderLayout.PAGE_END);
  }
}