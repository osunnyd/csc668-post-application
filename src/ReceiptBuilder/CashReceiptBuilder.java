package ReceiptBuilder;

// Robert Quinones

import Transaction.Transaction;
import Customer.Customer;

public class CashReceiptBuilder extends ReceiptBuilder {

  @Override
  public String generateReceipt(Transaction transaction, Customer customer) {
    String header = super.generateReceiptHeader(transaction, customer);
    String footer = generateReceiptFooter(transaction);

    return (header + "\n" + footer);
  }

  @Override
  public String generateReceiptFooter(Transaction transaction) {

    String receiptFooter = String.format("Total: $%1$.2f \n", transaction.getBillTotal());

    if (transaction.getPurchasedItems().isEmpty()) {
      receiptFooter += "No Items Purchased - Payment Rejected\n";

    } else {
      if (transaction.isAuthorized()) {
        receiptFooter += String.format("Amount Tendered: $%1$s\nAmount Returned: $%2$.2f",
            transaction.getAmountTendered(), transaction.getChange());

      } else {
        receiptFooter += String.format("Amount Tendered: $%1$s\nPaid by Cash - Payment Rejected",
            transaction.getAmountTendered());
      }

    }

    return receiptFooter;
  }
}