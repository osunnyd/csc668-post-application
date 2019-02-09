package Main;

import java.io.File;
import java.util.HashMap;

public class Store
{
  boolean isOpen = false;

  // keeps track of UPC and quantity; assume quantity is infinite for now
  HashMap<String, Integer> stock;

  //keeps track of UPC and what the Item is
  HashMap<String, Item> catalog;

  POS pos;
  SalesLog log;

  public Store(File products)
  {
    parseProducts(products);
  }


  void writeToLog(POS pos, SalesLog log)
  {
  }

  void parseProducts(File products)
  {

  }

  boolean closeStore()
  {
    return isOpen = false;
  }

  boolean openStore()
  {
    return isOpen = true;
  }

}

