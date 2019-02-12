package Main;

import java.io.File;
import java.util.HashMap;

public class Store
{
  Catalog catalog;
  Stock stock;
  POS pos;
  boolean isOpen = false;

  // keeps track of UPC and quantity; assume quantity is infinite for now
  // HashMap<String, Integer> stock = new HashMap<>();

  public Store(Catalog catalog, Stock stock) {
    this.catalog = catalog;
    this.stock = stock;
  }
  

  public void printCatalog() {
    catalog.printCatalog();
  }

  public Item getItem (String itemUPC) {
    return catalog.getItem( new UPC( itemUPC ) );
  }

  public HashMap hashMapOFStock() { return stock.getStock(); }

  public HashMap hashMapOfCatalog() { return catalog.getCatalog(); }

  public boolean closeStore()
  {
    pos.buildReceipts();
    return isOpen = false;

  }

  public boolean openStore( File transactions) {
    pos = new POS( catalog, transactions );
    return isOpen = true;
  }

}


