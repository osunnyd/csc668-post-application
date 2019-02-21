package Main;

/*
Omar ALaniz, Sunny Wong
*/
import java.io.File;
import java.util.HashMap;

import PointOfSale.*;
import Products.Stock;
import Products.Catalog;
import Products.Item;

public class Store {
  Catalog catalog;
  Stock stock;
  POS pos;
  boolean isOpen = false;

  public Store(Catalog catalog, Stock stock) {
    this.catalog = catalog;
    this.stock = stock;
  }


  public Item getItem(String itemUPC) {
    return catalog.getItem(new UPC(itemUPC));
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
