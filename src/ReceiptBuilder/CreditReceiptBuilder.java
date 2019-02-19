package ReceiptBuilder;

// Robert Quinones
import Main.Transaction;
import Main.Customer;

public class CreditReceiptBuilder extends ReceiptBuilder {

  @Override
  public String generateReceipt(Transaction transaction, Customer customer) {
    String header = super.generateReceiptHeader(transaction, customer);
    String footer = generateReceiptFooter(transaction);

    return (header + footer);
  }

  @Override
  public String generateReceiptFooter(Transaction transaction) {
    String receiptFooter = String.format("Total: $%1$.2f \n", transaction.getBillTotal());

    if (transaction.getPurchasedItems().isEmpty()) {
      receiptFooter += "No Items Purchased - Payment Rejected\n";

    } else {
      if (transaction.isAuthorized()) {
        receiptFooter += String.format("Paid by Credit - Card Number: %1$s", transaction.getAmountTendered());

      } else {
        receiptFooter += String.format("Paid by Credit - Card Number: %1$s - Payment Rejected",
            transaction.getAmountTendered());
      }

    }

    return receiptFooter;
  }
}