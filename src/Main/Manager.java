package Main;

import UserInterface.*;
import PointOfSale.*;
import Transaction.Transaction;
import Customer.Customer;
import Transaction.TransactionManager;
import Main.SalesLog;

import java.io.File;
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
          new POS();

          SalesLog salesLog = new SalesLog(URI);
          // Test to GET Data from Backend
          // String result = new ProductRequest(URI).getProducts();
          // System.out.println(result);

          // Cash Transaction Start
          System.out.println("\n\nStarting Cash Sale");
          Transaction cashTransaction = new Transaction();
          cashTransaction.setCustomer(new Customer("John Roberts", "2019-02-11T06:46:51.623Z"));
          cashTransaction.addPurchasedItem(new SalesLineItem("1234", "Item 1", 2, 123.45f, 123.45f));
          cashTransaction.setPaymentType("CASH");
          cashTransaction.setAmountTendered("124.45");

          // Calculate Change, Authorize Payment, Generate Receipt
          TransactionManager transactionManager = new TransactionManager(cashTransaction, URI);

          // Overwrite existing old transaction with its processed self
          cashTransaction = transactionManager.processTransaction();

          // Save Transaction
          salesLog.logTransaction(cashTransaction);
          // Cash Transaction End

          // Check Transaction Start
          System.out.println("\n\nStarting Check Sale");
          Transaction checkTransaction = new Transaction();
          checkTransaction.setCustomer(new Customer("John Roberts", "2019-02-11T06:46:51.623Z"));
          checkTransaction.addPurchasedItem(new SalesLineItem("1234", "Item 1", 2, 123.45f, 123.45f));
          checkTransaction.setPaymentType("CHECK");
          checkTransaction.setAmountTendered("123.45");

          // Calculate Change, Authorize Payment, Generate Receipt
          transactionManager = new TransactionManager(checkTransaction, URI);

          // Overwrite existing old transaction with its processed self
          checkTransaction = transactionManager.processTransaction();

          // Save Transaction
          salesLog.logTransaction(checkTransaction);
          // Check Transaction End

          // Credit Transaction Start
          System.out.println("\n\nStarting Credit Sale");
          Transaction creditTransaction = new Transaction();
          creditTransaction.setCustomer(new Customer("John Roberts", "2019-02-11T06:46:51.623Z"));
          creditTransaction.addPurchasedItem(new SalesLineItem("1234", "Item 1", 2, 123.45f, 123.45f));
          creditTransaction.setPaymentType("CREDIT");
          creditTransaction.setAmountTendered("12345");

          // Calculate Change, Authorize Payment, Generate Receipt
          transactionManager = new TransactionManager(creditTransaction, URI);

          // Overwrite existing old transaction with its processed self
          cashTransaction = transactionManager.processTransaction();

          // Save Transaction
          salesLog.logTransaction(creditTransaction);
          // Credit Transaction End

          System.out.println("\n\n-----Print Sales Log-----");
          ArrayList<String> receipts = salesLog.getReceipts();
          for (int i = 0; i < receipts.size(); i++) {
            System.out.println("-----Start of Receipt-----\n" + receipts.get(i) + "\n-----End of Receipt-----\n");
          }

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      } else

      {
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

  // public static void processTransactions(File transactions) {
  //   store.openStore(transactions);
  // }

  public static void closeStore() {
    store.closeStore();
  }
}