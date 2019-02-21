package Transaction;

// Robert Quinones
import java.util.ArrayList;
import ReceiptBuilder.ReceiptBuilder;
import Customer.Customer;
import Main.SalesLineItem;
import Transaction.JSONBuilder.JsonBuilder;

public class Transaction {

  private String paymentType;
  private String amountTendered;
  private String receipt;
  private String statusCode = "";
  private float billTotal = 0;
  private float change = 0;
  private ArrayList<SalesLineItem> purchasedItems;
  private boolean isAuthorized;
  private Customer customer;

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
    if (isCashPayment() || isCheckPayment()) {
      float calculatedChange = Float.parseFloat(this.amountTendered) - this.billTotal;

      if (this.billTotal > 0 && calculatedChange > 0) {
        this.change = calculatedChange;
      }
    }
  }

  public boolean isCashPayment() {
    return this.paymentType.equals("CASH");
  }

  public boolean isCheckPayment() {
    return this.paymentType.equals("CHECK");
  }

  public boolean isAuthorized() {
    return this.isAuthorized;
  }

  public void generateReceipt() {
    ReceiptBuilder receiptBuilder = ReceiptBuilder.getReceiptBuilder(this.paymentType);
    this.receipt = receiptBuilder.generateReceipt(this, this.customer);
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

  public Customer getCustomer() {
    return this.customer;
  }

  public ArrayList<SalesLineItem> getPurchasedItems() {
    return this.purchasedItems;
  }

  public String getAuthorizationJSON() {
    return JsonBuilder.getJsonBuilder(this.paymentType).getAuthorizationJSON(this);
  }

  public String getSalesJSON() {
    return JsonBuilder.getJsonBuilder(this.paymentType).createSaleJSON(this);
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
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

  public void setAuthorization(boolean authorization) {
    this.isAuthorized = authorization;
  }
}