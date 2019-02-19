package Main;

// Robert Quinones

import java.util.ArrayList;

public class ReceiptBuilder {
  private Customer customer;
  private Transaction transaction;
  private String receipt;

  public ReceiptBuilder(Customer customerData, Transaction transactionData) {
    this.customer = customerData;
    this.transaction = transactionData;
    this.receipt = "";

    generateReceipt();
  }

  public void generateReceipt() {
    generateReceiptHeader();
    generateReceiptFooter();
  }

  private void generateReceiptHeader() {
    this.receipt += String.format("%1$s\t%2$s\n", this.customer.getName(), this.customer.getDate());

    ArrayList<SalesLineItem> purchasedItems = this.transaction.getPurchasedItems();

    if (purchasedItems.isEmpty()) {
      this.receipt += "<NO ITEMS>\n";

    } else {
      for (int index = 0; index < purchasedItems.size(); index++) {
        SalesLineItem currentItem = purchasedItems.get(index);

        // $s - String, $.2f - Float to 2 Decimal Points
        this.receipt += String.format("<%1$s %2$s @ $%3$.2f - $%4$.2f>\n", currentItem.getDescription(),
            currentItem.getQuantity(), currentItem.getUnitPrice(), currentItem.getSubtotal());
      }
    }

    this.receipt += "-----\n";
  }

  private void generateReceiptFooter() {
    this.receipt += String.format("Total: $%1$.2f \n", this.transaction.getBillTotal());

    if (this.receipt.contains("<NO ITEMS>\n")) {
      this.receipt += "No Items Purchased - Payment Rejected\n";

    } else {

      if (isCashPayment()) {
        generateCashPaymentFooter();

      } else {
        String statusCode = this.transaction.getStatusCode();

        if (isCreditPayment()) {
          generateNonCashPaymentFooter(statusCode, "Credit Card");

        } else {
          generateNonCashPaymentFooter(statusCode, "Check");

        }
      }
    }
  }

  private void generateCashPaymentFooter() {
    if (this.transaction.getChange() < 0) {
      this.receipt += String.format("Amount Tendered: $%1$s\nPaid by Cash - Payment Rejected",
          this.transaction.getAmountTendered());

    } else {
      this.receipt += String.format("Amount Tendered: $%1$s\nAmount Returned: $%2$.2f",
          this.transaction.getAmountTendered(), this.transaction.getChange());

    }
  }

  private void generateNonCashPaymentFooter(String statusCode, String paymentType) {
    if (statusCode.equals("406")) {
      this.receipt += String.format("Paid by %1$s - Payment Rejected", paymentType);

    } else {
      this.receipt += String.format("Paid by %1$s %2$s \n", paymentType, this.transaction.getAmountTendered());

    }
  }

  public boolean isCashPayment() {
    return this.transaction.getPaymentType().equals("CASH");
  }

  public boolean isCreditPayment() {
    return this.transaction.getPaymentType().equals("CREDIT");
  }

  public String getReceipt() {
    return this.receipt;
  }
}