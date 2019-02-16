package Main;

import Http.*;
import UserInterface.*;

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
  static String URI;
  static Boolean debugOn = true;

  public static void main(String[] args) {
    if (args.length > 1) {
      System.out.println("Invalid Amount of Command Line Arguments. Please try again.");

    } else {
      // Set URI
      URI = args[0];
      System.out.println("This is the URI " + URI);
      if (debugOn) {
        try {

          new POS_GUI();
          // Test to GET Data from Backend
          // String result = getProducts();
          // System.out.println(result);

          // Authorize Check
          String check_payment_data = "{ \"amount\": 1234.56 }";
          String check_result = authorizePayment("CHECK".toLowerCase(), check_payment_data);
          System.out.println("Check Result: " + check_result + "\n");

          // Authorize Credit
          String credit_payment_data = "{ \"amount\": 1234.56, \"cardNumber\": 123456 }";
          String credit_result = authorizePayment("CREDIT".toLowerCase(), credit_payment_data);
          System.out.println("Credit Result: " + credit_result);

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      } else {
        // openStore(products);
        // processTransactions(transactions);
        // closeStore();
      }
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

  // We can change this to be in Catalog or something - Debug
  // GET PRODUCTS
  public static String getProducts() {
    try {
      return new Get(URI + "/products").execute();

    } catch (Exception ex) {
      ex.printStackTrace();

      return "Connection to " + URI + "/products has failed.";
    }
  }

  // POST CHECK
  public static String authorizePayment(String type, String paymentData) {
    try {
      return new Post(URI + "/payments/" + type).execute(paymentData);
    } catch (Exception ex) {
      // Exceptions are thrown where No Body & Non-200 response is present
      return "406";
    }
  }
}
