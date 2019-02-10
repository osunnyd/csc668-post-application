package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Store
{
  Catalog catalog;
  Stock stock;
  boolean isOpen = false;

  // keeps track of UPC and quantity; assume quantity is infinite for now
  // HashMap<String, Integer> stock = new HashMap<>();

  public Store(Catalog catalog, Stock stock) {
    this.catalog = catalog;
    this.stock = stock;
  }
  

  public void printCatalog() {
    catalog.printCatalog();
    //System.out.println(catalog.toString());
  }

  public Item getItem (String itemUPC) {
    return catalog.getItem( new UPC( itemUPC ) );
  }

  public HashMap getStock() { return stock.getStock(); }

  boolean closeStore()
  {
    return isOpen = false;
  }

  boolean openStore()
  {
    return isOpen = true;
  }

}


