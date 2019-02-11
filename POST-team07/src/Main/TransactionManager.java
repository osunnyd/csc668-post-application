package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class TransactionManager {
  private ArrayList<String> receipts;

  public void parseTransactionFile(String fileName, Catalog catalog) throws IOException {
    this.receipts = receipts;
    FileReader fileReader = new FileReader(new File(fileName));
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String line;

    while ((line = bufferedReader.readLine()) != null) {
      boolean exit = true;
      String name = line;
      String date = (new Date()).toString();
      ArrayList<SalesLineItem> purchasedItems = new ArrayList<>();
      line = bufferedReader.readLine();

      while (exit) {
        if (!(line.substring(0, 1).equals("<"))) {
          addItemstoCostumerArray(line, purchasedItems);
        }

        if ((line.substring(0, 1).equals("<"))) {
          String tenderLine[] = line.split("\\s+");

          if (line.substring(3).equals("A")) {

            cashHandler(tenderLine, receipts);

          } else if (line.substring(3).equals("R")) {

            creditHandler(tenderLine, receipts);

          } else if (line.substring(3).equals("H")) {

            checkHandler(tenderLine, receipts);

          }
          exit = !exit;
        }
        line = bufferedReader.readLine();
      }
    }

    bufferedReader.close();
    fileReader.close();

  }

  void addItemstoCostumerArray(String line, ArrayList<SalesLinesItems> purchasedItems) {
    String itemUPCandQuantity[] = line.split("\\s+");
    UPC tempUpc = new UPC(itemUPCandQuantity[0]);
    Item tempItem = new Item();
    tempItem = catalog.getItem(tempUpc)

    if ((itemUPCandQuantity.length) == 2 && (tempItem.getUpc).equals("")) {

      purchasedItems.add(new SalesLineItem(itemUPCandQuantity[0], Integer.parseInt(itemUPCandQuantity[1])));

    } else if (itemUPCandQuantity.length == 1 && (tempItem.getUpc).equals("")) {

      purchasedItems.add(new SalesLineItem(itemUPCandQuantity[0], 1));

    }

  }

  void cashHandler(String tenderLine[], ArrayList<String> receipts) {
    String paymentType = "CASH";
    String amount = tenderLine[1].replace("$", "");
    amount = amount.replace(">", "");
    Customer tempCustomer = new Customer(name, date, paymentType, amount, purchasedItems);
    tempCustomer.calculateBill(catalog);
    tempCustomer.calculateChange();
    tempCustomer.generateReceipt();
    receipts.add(tempCustomer.getReceipt);
  }

  void checkHandler(String tenderLine[], ArrayList<String> receipts) {
    String paymentType = "CHECK";
    String amount = tenderLine[1].replace("$", "");
    amount = amount.replace(">", "");
    Customer tempCostumer = new Customer(name, date, paymentType, amount, purchasedItems);
    tempCustomer.calculateBill(catalog);
    tempCustomer.calculateChange();
    tempCustomer.generateReceipt();
    receipts.add(tempCustomer.getReceipt);
  }

  void creditHandler(String tenderLine[], ArrayList<String> receipts) {
    String paymentType = "CREDIT";
    String amount = tenderLine[1].replace("$", "");
    amount = amount.replace(">", "");
    Customer tempCustomer = new Customer(name, date, paymentType, amount, purchasedItems);
    tempCustomer.calculateBill(catalog);
    tempCustomer.calculateChange();
    tempCustomer.generateReceipt();
    receipts.add(tempCustomer.getReceipt);
  }


  public void printReceipts() {
    for (int i = 0; i < receipts.size(); i++) {
      System.out.println(receipts[i]);
    }
  }

  public ArrayList<String> getReceipts() {
    return receipts;
  }
}