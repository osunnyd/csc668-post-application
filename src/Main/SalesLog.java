package Main;

// Saves all Transaction Receipts locally, and creates new database entries
// for authorized receipts
import java.util.ArrayList;

import Transaction.Transaction;
import Requests.StoreRequests.SaleRequest;

public class SalesLog {

  private ArrayList<String> receipts;
  private String URI;

  public SalesLog(String URI) {
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
    System.out.println(receipt);
    this.receipts.add(receipt);
  }

  private void saveTransactionToDatabase(Transaction transaction) {
    String transactionData = transaction.getSalesJSON();

    new SaleRequest(this.URI).createSale(transactionData);
  }

  public ArrayList<String> getReceipts() {
    return this.receipts;
  }
}
