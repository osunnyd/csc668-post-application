package Main;

public class SalesLineItem {
  private String upc;
  private int quantity;
  private double unitPrice;

  public SalesLineItem ( String upc, int quantity ) {
    this.upc = upc;
    this.quantity = quantity;

  }

  public String getUPC() {
    return this.upc;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public void setUpc ( String upc ) {
    this.upc = upc;
  }

  public void setQuantity ( int quantity ) {
    this.quantity = quantity;
  }

  public void setUnitPrice( double price ) {
    this.unitPrice = price;
  }
}
