package Main;

import java.io.File;
import java.io.FileNotFoundException;
//Jarek

/*
Manager is in charge of starting initialization.
-Initialize Catalog
-Set up Posts
-Open the store
*/

public class Manager {
  String name;
  Store store;
  Stock stock;
  Catalog catalog;

  // Moved from Driver.main
  public static void main(String[] args) {
    if (args.length > 2) {
      System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

    } else {
      File products = new File(args[0]);
      File transactions = new File(args[1]);
      Manager manager = new Manager("John Doe");

      manager.openStore(products);
      manager.processTransactions(transactions);
      manager.closeStore();
    }
  }

  Manager(String name) {
    this.name = name;
  }

  public void openStore(File products) {
    try {
      this.catalog = new Catalog(products);
      this.stock = new Stock(products);
      this.store = new Store(catalog, stock);

    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public void processTransactions(File transactions) {
    store.openStore(transactions);
  }

  public void closeStore() {
    store.closeStore();
  }

}
