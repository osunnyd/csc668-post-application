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

  public void parseTransactionFile(String fileName, HashMap catalog) throws IOException {
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
          String itemUPCandQuantity[] = line.split("\\s+");
          if ((itemUPCandQuantity.length) == 2 && catalog.containsKey(itemUPCandQuantity[0])) {
            purchasedItems.add(new SalesLineItem(itemUPCandQuantity[0], Integer.parseInt(itemUPCandQuantity[1])));
          } else if (itemUPCandQuantity.length == 1 && catalog.containsKey(itemUPCandQuantity[0]) {
            purchasedItems.add(new SalesLineItem(itemUPCandQuantity[0], 1));
          }
        }

        if ((line.substring(0, 1).equals("<"))) {
          String tenderLine[] = line.split("\\s+");
          if (line.substring(3).equals("A")) {
            String paymentType = "CASH";
            String amount = tenderLine[1].replace("$", "");
            amount = amount.replace(">", "");
            Customer temp = new Customer(name, date, paymentType, amount, purchasedItems);
            receipts.add(temp.generateReceipt);
          } else if (line.substring(3).equals("R")) {
            String paymentType = "CREDIT";
            String amount = tenderLine[1].replace("$", "");
            amount = amount.replace(">", "");
            Customer temp = new Customer(name, date, paymentType, amount, purchasedItems);
            receipts.add(temp.generateReceipt);
          } else if (line.substring(3).equals("H")) {
            String paymentType = "CHECK";
            String amount = tenderLine[1].replace("$", "");
            amount = amount.replace(">", "");
            Customer temp = new Customer(name, date, paymentType, amount, purchasedItems);
            receipts.add(temp.generateReceipt);
          }
          exit = !exit;
        }
        line = bufferedReader.readLine();
      }
    }
    bufferedReader.close();
    fileReader.close();
  }

}