package ReceiptBuilder;

// Robert Quinones
import Transaction.Transaction;
import Customer.Customer;
import Main.SalesLineItem;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class ReceiptBuilder {
  public static final HashMap<String, ReceiptBuilder> receiptBuilders = new HashMap<String, ReceiptBuilder>();

  static {
    receiptBuilders.put("CASH", new CashReceiptBuilder());
    receiptBuilders.put("CREDIT", new CreditReceiptBuilder());
    receiptBuilders.put("CHECK", new CheckReceiptBuilder());
  }

  public static ReceiptBuilder getReceiptBuilder(String paymentType) {
    return receiptBuilders.get(paymentType);
  }

  public static boolean containsReceiptBuilder(String paymentType) {
    return receiptBuilders.containsKey(paymentType);
  }

  public abstract String generateReceipt(Transaction transaction, Customer customer);

  public abstract String generateReceiptFooter(Transaction transaction);

  public String generateReceiptHeader(Transaction transaction, Customer customer) {
    String receiptHeader = String.format("%1$s\t%2$s\n", customer.getName(), customer.getDate());

    ArrayList<SalesLineItem> purchasedItems = transaction.getPurchasedItems();

    if (purchasedItems.isEmpty()) {
      receiptHeader += "<NO ITEMS>\n";

    } else {
      for (int index = 0; index < purchasedItems.size(); index++) {
        SalesLineItem currentItem = purchasedItems.get(index);

        // $s - String, $.2f - Float to 2 Decimal Points
        receiptHeader += String.format("<%1$s %2$s @ $%3$.2f - $%4$.2f>\n", currentItem.getDescription(),
            currentItem.getQuantity(), currentItem.getUnitPrice(), currentItem.getSubtotal());
      }
    }

    receiptHeader += "-----\n";

    return receiptHeader;
  }

}