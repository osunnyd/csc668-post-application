package Main;

/*
   Robert Quinones
   Hold Customer Transaction Data, Generate Change, and Receipts
*/
import java.util.ArrayList;

public class Customer {
  private String name;
  private String date;
  private String paymentType;
  private String amountTendered;
  private String receipt;
  private String statusCode = "";
  private float billTotal = 0;
  private float change = 0;
  private ArrayList<SalesLineItem> purchasedItems;

  public Customer() {
    this.name = "";
    this.date = "";
    this.paymentType = "";
    this.amountTendered = "";
    this.purchasedItems = new ArrayList<>();
  }

  public Customer(String name, String date, String paymentType, String amountTendered,
      ArrayList<SalesLineItem> purchasedItems) {

    this.name = name;
    this.date = date;
    this.paymentType = paymentType;
    this.amountTendered = amountTendered;
    this.purchasedItems = purchasedItems;
  }

  public void calculateBill(Catalog productCatalog) {
    for (int index = 0; index < this.purchasedItems.size(); index++) {

      SalesLineItem currentSalesLineItem = purchasedItems.get(index);
      UPC productUPC = currentSalesLineItem.getUPC();

      Item currentItem = productCatalog.getItem(productUPC);
      currentSalesLineItem.setUnitPrice(currentItem.getPrice());
      currentSalesLineItem.setDescription(currentItem.getDescription());

      float currentLineSubtotal = currentItem.getPrice() * currentSalesLineItem.getQuantity();
      currentSalesLineItem.setSubtotal(currentLineSubtotal);

      updateTotal(currentLineSubtotal);

    }
  }

  private void updateTotal(float total) {
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

  public void generateReceipt() {
    this.receipt = new ReceiptBuilder(this).getReceipt();
  }

  public boolean isCashPayment() {
    return this.paymentType.equals("CASH");
  }

  public boolean isCreditPayment() {
    return this.paymentType.equals("CREDIT");
  }

  public String getReceipt() {
    return this.receipt;
  }

  public String getName() {
    return this.name;
  }

  public String getDate() {
    return this.date;
  }

  public ArrayList<SalesLineItem> getPurchasedItems() {
    return this.purchasedItems;
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

  public void setName(String name) {
    this.name = name;
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

  public void addPurchasedItem(SalesLineItem item) {
    this.purchasedItems.add(item);
  }
}