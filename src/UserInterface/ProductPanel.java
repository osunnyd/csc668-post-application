package UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import PointOfSale.*;
import ProductReader.*;
import Main.*;
import java.util.ArrayList;

//Jarek

public class ProductPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    JLabel upcLabel;
    JLabel qtyLabel;
    JButton enterButton;
    JComboBox<String> upcDropdown;
    JComboBox<Integer> qtyDropdown;
    Catalog catalog;
    ArrayList<UPC> upcArrayList;


    public ProductPanel(ProductListener productListener, Catalog catalog){
        //catalog = this.catalog;
        setDefaults();
        getUPCcodes(catalog);
        addPanels();
        setListeners(productListener);
    }

    private void setDefaults(){
        setPreferredSize(new Dimension(200, 800));
        setBorder(BorderFactory.createTitledBorder("Product"));
        setLayout(new BorderLayout(10, 10));
        
        upcLabel = new JLabel("UPC:");
        qtyLabel = new JLabel("QTY:");
        enterButton = new JButton("Enter");
    }


    private void getUPCcodes(Catalog catalog){

        upcArrayList = catalog.getUPCs();
        ArrayList<String> tempArrayList = new ArrayList();
        for(int i = 0; i < upcArrayList.size(); i++){
            tempArrayList.add(upcArrayList.get(i).getUPC());
        }

        Integer[] quantityChoices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] upcChoices = tempArrayList.toArray(new String[tempArrayList.size()]);
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
    
    private void setListeners(ProductListener productListener){
        enterButton.addActionListener(productListener);
    }


    //getters for UI listener calls
    public UPC getUPCcode(){
        //return (String) upcDropdown.getSelectedItem();
        int temp = upcDropdown.getSelectedIndex();
        return upcArrayList.get(temp);
    }

    public Integer getQuantity(){
        return (Integer) qtyDropdown.getSelectedItem();
    }


}