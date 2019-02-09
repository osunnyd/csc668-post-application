package Main;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Store {
  boolean isOpen = false;

  // keeps track of UPC and quantity; assume quantity is infinite for now
  HashMap<String, Integer> stock;

  //keeps track of UPC and what the Item is
  HashMap<String, Item> catalog;

  POS pos;
  SalesLog log;
  private String[] items;

  public Store(File products) throws IOException {
    parseProducts(products);
  }

  void writeToLog(POS pos, SalesLog log) {
  }

  private void parseProducts(File products) throws IOException {

    String item;
    int itrOfItems = 0;

    FileReader readFile = new FileReader(products);
    BufferedReader lineBuffer = new BufferedReader(readFile);

    while ( (item= lineBuffer.readLine()) != null )
    {
      items[itrOfItems] = item;
      itrOfItems++;
    }
      readFile.close();
      lineBuffer.close();
    }

    private void parseItems(String[] items){
      Item item = new Item();

      String[] product;

      for (int itrOfItems = 0; itrOfItems < items.length; itrOfItems++){
        product = items[itrOfItems].split(" ", 3);
        item.setUPC(product[0]);
        item.setDescription(product[1]);
        item.setPrice(Float.parseFloat(product[2]));
      }
    }

  boolean closeStore() {
    return isOpen = false;
  }

  boolean openStore() {
    return isOpen = true;
  }

}

