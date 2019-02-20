package Main;

/*
Omar ALaniz, Sunny Wong
*/
import PointOfSale.*;
import java.io.File;
import java.util.HashMap;

//Sunny

public class Store {
  Catalog catalog;
  Stock stock;
  POS pos;
  boolean isOpen = false;

  public Store(Catalog catalog, Stock stock) {
    this.catalog = catalog;
    this.stock = stock;
  }

  public void printCatalog() {
    catalog.printCatalog();
  }

  public Item getItem(String itemUPC) {
    return catalog.getItem(new UPC(itemUPC));
  }

  public HashMap hashMapOFStock() {
    return stock.getStock();
  }

  public HashMap hashMapOfCatalog() {
    return catalog.getCatalog();
  }

  public boolean closeStore() {
    this.pos.buildReceipts();
    return isOpen = false;

  }

  public boolean openStore(String uri) {
    this.pos = new POS(catalog, uri);
    return isOpen = true;
  }

}
