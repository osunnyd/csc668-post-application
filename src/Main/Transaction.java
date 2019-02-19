package Main;

// Robert Quinones
import java.util.ArrayList;

public class Transaction {

  private String paymentType;
  private String amountTendered;
  private String receipt;
  private String statusCode = "";
  private float billTotal = 0;
  private float change = 0;
  private ArrayList<SalesLineItem> purchasedItems;

  public Transaction() {
    this.paymentType = "";
    this.amountTendered = "";
    this.purchasedItems = new ArrayList<>();
  }

  public void addPurchasedItem(SalesLineItem salesLineItem) {
    this.purchasedItems.add(salesLineItem);

    updateBillTotal(salesLineItem.getSubtotal());
  }

  private void updateBillTotal(float total) {
    this.billTotal += total;
  }

  public void calculateChange() {
    if (paymentType.equals("CASH") || paymentType.equals("CHECK")) {
      float calculatedChange = Float.parseFloat(this.amountTendered) - this.billTotal;

      if (this.billTotal > 0 && calculatedChange > 0) {
        this.change = calculatedChange;
      }
    }
  }

  public boolean isCashPayment() {
    return this.paymentType.equals("CASH");
  }

  public boolean isCreditPayment() {
    return this.paymentType.equals("CREDIT");
  }

  public void generateReceipt(Customer customer) {
    this.receipt = new ReceiptBuilder(customer, this).getReceipt();
  }

  public float getBillTotal() {
    return this.billTotal;
  }

  public float getChange() {
    return this.change;
  }

  public String getPaymentType() {
    return this.paymentType;
  }

  public String getAmountTendered() {
    return this.amountTendered;
  }

  public String getStatusCode() {
    return this.statusCode;
  }

  public String getReceipt() {
    return this.receipt;
  }

  public ArrayList<SalesLineItem> getPurchasedItems() {
    return this.purchasedItems;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public void setAmountTendered(String amountTendered) {
    this.amountTendered = amountTendered;
  }

  public void setStatusCode(String code) {
    this.statusCode = code;
  }
}