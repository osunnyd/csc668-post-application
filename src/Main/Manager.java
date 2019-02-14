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
  static String name = "John Doe";
  static Store store;
  static Stock stock;
  static Catalog catalog;

  // Moved from Driver.main
  public static void main(String[] args) {
    if (args.length > 2) {
      System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

    } else {
      File products = new File(args[0]);
      File transactions = new File(args[1]);

      openStore(products);
      processTransactions(transactions);
      closeStore();
    }
  }

  public static void openStore(File products) {
    try {
      catalog = new Catalog(products);
      stock = new Stock(products);
      store = new Store(catalog, stock);

    } catch (Exception error) {
      System.out.println(error);
    }
  }

  public static void processTransactions(File transactions) {
    store.openStore(transactions);
  }

  public static void closeStore() {
    store.closeStore();
  }
}
