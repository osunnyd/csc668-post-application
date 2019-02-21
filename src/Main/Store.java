package Main;

/*
Omar ALaniz, Sunny Wong
*/
import ProductReader.*;
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

  public boolean closeStore() {
    this.pos.buildReceipts();
    return isOpen = false;

  }

  public boolean openStore(String uri) {
    this.pos = new POS(catalog, uri);
    return isOpen = true;
  }

}
