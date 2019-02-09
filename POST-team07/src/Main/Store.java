package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Store
{

  POS pos;
  SalesLog log;
  boolean isOpen = false;

  // keeps track of UPC and quantity; assume quantity is infinite for now
  HashMap<String, Integer> stock = new HashMap<>();

  //keeps track of UPC and what the Item is
  HashMap<String, Item> catalog = new HashMap<>();

  private ArrayList<String> items = new ArrayList<>();


  public Store(File products) throws IOException {
    parseProducts(products);
  }

  private void writeToLog(){} // to be implemented

  private void parseProducts(File products) throws IOException {

    String item;
    int itrOfItems = 0;

    FileReader readFile = new FileReader(products);
    BufferedReader lineBuffer = new BufferedReader(readFile);

    while ( (item= lineBuffer.readLine()) != null ) // split each product to their own line
    {
      items.add(item);
      itrOfItems++;
    }
    readFile.close();
    lineBuffer.close();
    parseItems(items);
  }

  private void parseItems(ArrayList items){
    String[] product;

    // parse each line by spaces
    for (int itrOfItems = 0; itrOfItems < items.size(); itrOfItems++){
      Item item = new Item();
      product = items.get(itrOfItems).toString().split("  +"); // splits by 2 spaces or more
      item.setUPC(product[0]);
      item.setDescription(product[1]);
      item.setPrice(Float.parseFloat(product[2]));
      catalog.put(item.getUPC(), item);
      stock.put(item.getUPC(), 900000); // assuming unlimited quantity for now
    }
  }

  boolean closeStore() {
    return isOpen = false;
  }

  boolean openStore() {
    return isOpen = true;
  }

}

