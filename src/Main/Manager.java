package Main;

import Requests.StoreRequests.ProductRequest;
import UserInterface.*;
import PointOfSale.*;
import ProductReader.*;
import Transaction.Transaction;
import Customer.Customer;
import Transaction.TransactionManager;
import Main.SalesLog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//Jarek, Robert

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
  static String URI;
  static Boolean debugOn = false;

  public static void main(String[] args) {
    if (args.length > 1) {
      System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

    } else {

      // Set URI
      try {
        URI = args[0];
        catalog = new Catalog(URI);
        store = new Store(catalog, new Stock());
        store.openStore(URI);
        // new POS(catalog);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}