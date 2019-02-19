package Main;

import UserInterface.*;
import UserInterfaceController.*;
import Requests.Http.*;
import Requests.StoreRequests.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

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

          new UserInterfaceController();
          // Test to GET Data from Backend
          // String result = new ProductRequest(URI).getProducts();
          // System.out.println(result);

          // // Cash Sale
          // System.out.println("-----Testing a Cash Sale-----");
          // String cashTransactionData = "{ \"customer\": \"John Roberts\",
          // \"timeOfSale\": \"2019-02-11T06:46:51.623Z\", \"items\": [ { \"upc\":
          // \"1234\", \"quantity\": 2, \"price\": 123.45 } ], \"total\": 1234.56,
          // \"tendered\": { \"type\": \"CASH\", \"amount\": 1235.56 }, \"returned\": 1.00
          // }";
          // cashSale(cashTransactionData);
          // System.out.println("-----Ending Cash Sale-----\n");

          // // Check Sale
          // System.out.println("-----Testing a Check Sale-----");
          // String checkTransactionData = "{ \"customer\": \"John Roberts\",
          // \"timeOfSale\": \"2019-02-11T06:46:51.623Z\", \"items\": [ { \"upc\":
          // \"1234\", \"quantity\": 2, \"price\": 123.45 } ], \"total\": 1234.56,
          // \"tendered\": { \"type\": \"CHECK\", \"amount\": 1235.56 }, \"returned\":
          // 0.00 }";
          // String checkAuthorizationData = "{ \"amount\": 1234.56 }";
          // nonCashSale("CHECK", checkAuthorizationData, checkTransactionData);
          // System.out.println("-----Ending Check Sale-----\n");

          // // Credit Sale
          // System.out.println("-----Testing a Credit Sale-----");
          // String creditTransactionData = "{\"customer\":\"John
          // Roberts\",\"timeOfSale\":\"2019-02-11T06:46:51.623Z\",\"items\":[{\"upc\":\"1234\",\"quantity\":2,\"price\":123.45}],\"total\":1234.56,\"tendered\":{\"type\":\"CREDIT\",\"amount\":1235.56,\"cardNumber\":123456},\"returned\":0.00}";
          // String creditAuthorizationData = "{ \"amount\": 1234.56, \"cardNumber\":
          // 123456 }";
          // nonCashSale("CREDIT", creditAuthorizationData, creditTransactionData);
          // System.out.println("-----Ending Credit Sale-----\n");

          // Test Customer Changes - This will set everything and properly generate
          // receipt
          Customer customer = new Customer();
          customer.setDate((new Date()).toString());
          customer.setName("Robert Quinones");
          customer.getTransaction().addPurchasedItem(new SalesLineItem("1111", "Item 1", 1, 2.00f, 2.00f));
          customer.getTransaction().addPurchasedItem(new SalesLineItem("2222", "Item 2", 1, 3.00f, 3.00f));
          customer.getTransaction().setPaymentType("CREDIT");
          customer.getTransaction().setAmountTendered("33333");
          customer.getTransaction().calculateChange();
          customer.generateReceipt();
          System.out.println(customer.getReceipt());

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

  // PUT Item - In practice we will save this request to get more data from it
  // as of now we just need to display data for testing
  public static String createSale(String transactionData) {
    return new SaleRequest(URI).createSale(transactionData);
  }

  public static void saleResultInterpreter(String statusCode) {
    switch (statusCode) {
    case "201":
      System.out.println("201 - Sale Successfully Created");
      break;

    case "400":
      System.out.println("400 - Error in Sale Creation");
      break;

    default:
      System.out.println("500 - Server Error");
      break;
    }
  }

  // PUT Sale
  public static void cashSale(String transactionData) {
    String createSaleResult = createSale(transactionData);
    saleResultInterpreter(createSaleResult);
  }

  public static void nonCashSale(String paymentType, String authorizationData, String transactionData) {
    String authorization_result = new PaymentAuthorizationRequest(URI).authorizePayment(paymentType, authorizationData);

    switch (authorization_result) {
    case "202":
      String createSaleResult = createSale(transactionData);
      saleResultInterpreter(createSaleResult);
      break;

    case "400":
      System.out.println("400 - Error in Check Authorization");
      break;

    case "406":
      System.out.println("406 - Check Not Authorized");
      break;

    default:
      System.out.println(authorization_result + " You're not supposed to be here");
      break;
    }

    System.out.println();

    return;
  }
}