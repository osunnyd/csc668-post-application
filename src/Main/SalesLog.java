package Main;

// Saves all Transaction Receipts locally, and creates new database entries
// for authorized receipts
import java.util.ArrayList;

import Transaction.Transaction;
import Requests.StoreRequests.SaleRequest;

public class SalesLog {

  private ArrayList<String> receipts;
  private String URI;

  SalesLog(String URI) {
    this.URI = URI;
    this.receipts = new ArrayList<>();
  }

  public void logTransaction(Transaction transaction) {
    saveTransactionReceiptToLog(transaction.getReceipt());

    if (transaction.isAuthorized()) {
      saveTransactionToDatabase(transaction);
    }
  }

  private void saveTransactionReceiptToLog(String receipt) {
    this.receipts.add(receipt);
  }

  private void saveTransactionToDatabase(Transaction transaction) {
    // TODO MAKE THIS STRING FROM TRANSACTION
    // DEBUG
    String paymentType = transaction.getPaymentType();
    String transactionData = "";

    switch (paymentType) {
    case "CASH":
      transactionData = "{ \"customer\": \"John Roberts\"," + "\"timeOfSale\": \"2019-02-11T06:46:51.623Z\", "
          + "\"items\": [ { \"upc\": \"1234\", \"quantity\": 1, \"price\": 123.45 } ]," + "\"total\": 123.45,"
          + "\"tendered\": { \"type\": \"CASH\", \"amount\": 124.45 }, " + "\"returned\": 1.00}";
      break;

    case "CHECK":
      transactionData = "{ \"customer\": \"John Roberts\"," + "\"timeOfSale\": \"2019-02-11T06:46:51.623Z\", "
          + "\"items\": [ { \"upc\": \"1234\", \"quantity\": 1, \"price\": 123.45 } ]," + "\"total\": 123.45,"
          + "\"tendered\": { \"type\": \"CHECK\", \"amount\": 123.45 }, " + "\"returned\": 0.00 }";
      break;

    case "CREDIT":
      transactionData = "{ \"customer\":\"John Roberts\", " + "\"timeOfSale\":\"2019-02-11T06:46:51.623Z\", "
          + "\"items\":[{\"upc\":\"1234\",\"quantity\":1,\"price\":123.45}]," + "\"total\":123.45, "
          + "\"tendered\":{\"type\":\"CREDIT\",\"amount\":123.45,\"cardNumber\":12345}," + "\"returned\":0.00}";
      break;
    }

    new SaleRequest(this.URI).createSale(transactionData);
  }

  public ArrayList<String> getReceipts() {
    return this.receipts;
  }
}
