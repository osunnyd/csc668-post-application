package Main;

public class SalesLineItem {
  private String upc;
  private int quantity;
  private double unitPrice;

  public SalesLineItem(String upc, int quantity, double unitPrice){
    this.upc = upc;
    this.quantity = quantity;
    this.unitPrice = unitPrice;

  }

  public String getUpc() {
    return this.upc;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public void setUnitPrice( double price ) {
    this.unitPrice = price;
  }
}
