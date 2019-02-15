package Main;

import Http.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

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
          // Test to GET Data from Backend
          // String result = getProducts();
          // System.out.println(result);

          // Cash Sale
          System.out.println("Testing a Cash Sale");
          cashSale();
          System.out.println();

          // Check Sale
          System.out.println("Testing a Check Sale");
          checkSale();
          System.out.println();

          // Credit Sale
          System.out.println("Testing a Credit Sale");
          creditSale();
          System.out.println();

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

  // PUT Item
  public static void createSale(String DATA) {
    try {
      String result = new Put(URI + "/sales").execute(DATA);
      System.out.println(result);

      if (result.contains("id")) {
        System.out.println("201 - Successful Sale");
      }

      if (result.contains("error")) {
        System.out.println("400 - Error in Sale Object sent to API");
      }
    } catch (MalformedURLException mex) {
      System.out.println("MalformedURLException");
      mex.printStackTrace();
    } catch (IOException iex) {
      System.out.println("IOException");
      iex.printStackTrace();
    }

    return;
  }

  // PUT Sale
  public static void cashSale() {
    String CASH_DATA = "{ \"customer\": \"John Roberts\", \"timeOfSale\": \"2019-02-11T06:46:51.623Z\", \"items\": [ { \"upc\": \"1234\", \"quantity\": 2, \"price\": 123.45 } ], \"total\": 1234.56, \"tendered\": { \"type\": \"CASH\", \"amount\": 1235.56 }, \"returned\": 1.00 }";

    createSale(CASH_DATA);
    System.out.println("Cash Sale Created\n");
  }

  // Check Sale
  public static void checkSale() {
    String CHECK_DATA = "{ \"customer\": \"John Roberts\", \"timeOfSale\": \"2019-02-11T06:46:51.623Z\", \"items\": [ { \"upc\": \"1234\", \"quantity\": 2, \"price\": 123.45 } ], \"total\": 1234.56, \"tendered\": { \"type\": \"CHECK\", \"amount\": 1235.56 }, \"returned\": 0.00 }";

    // Authorize Check
    String check_payment_data = "{ \"amount\": 1234.56 }";
    String check_result = authorizePayment("CHECK".toLowerCase(), check_payment_data);
    switch (check_result) {
    case "202":
      createSale(CHECK_DATA);
      break;

    case "400":
      System.out.println("400 - Error in Check Authorization");
      break;

    case "406":
      System.out.println("406 - Check Not Authorized");
      break;
    default:
      System.out.println("You're not supposed to be here");
      break;
    }
    System.out.println();
    return;
  }

  // CRedit Sale
  public static void creditSale() {
    String CREDIT_DATA = "{\"customer\":\"John Roberts\",\"timeOfSale\":\"2019-02-11T06:46:51.623Z\",\"items\":[{\"upc\":\"1234\",\"quantity\":2,\"price\":123.45}],\"total\":1234.56,\"tendered\":{\"type\":\"CREDIT\",\"amount\":1235.56,\"cardNumber\":123456},\"returned\":0.00}";

    // Authorize Check
    String credit_payment_data = "{ \"amount\": 1234.56, \"cardNumber\": 123456 }";

    String credit_result = authorizePayment("CREDIT".toLowerCase(), credit_payment_data);
    switch (credit_result) {
    case "202":
      createSale(CREDIT_DATA);
      break;

    case "400":
      System.out.println("400 - Error in Credit Authorization");
      break;

    case "406":
      System.out.println("406 - Credit Not Authorized");
      break;
    default:
      System.out.println("You're not supposed to be here");
      break;
    }
    System.out.println();
    return;
  }
}
// {"customer":"John
// Roberts","timeOfSale":"2019-02-11T06:46:51.623Z\",\"items\":[{\"upc\":\"1234\",\"quantity\":2,\"price\":123.45}],\"total\":1234.56,\"tendered\":{\"type\":\"CREDIT\",\"amount\":1235.56,\"cardNumber\":123456},\"returned\":0.00}