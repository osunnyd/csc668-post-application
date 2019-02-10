package Main;

public class SalesLineItem {
  private UPC upc;
  private int quantity;
  private float unitPrice;
  private String description;

  public SalesLineItem ( String itemUPC, int quantity ) {
    this.upc = new UPC( itemUPC );
    this.quantity = quantity;

  }

  public UPC getUPC() {
    return this.upc;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public float getUnitPrice() {
    return this.unitPrice;
  }

  public String getDescription () {
    return description;
  }

  public void setUpc ( String newUPC ) {
    this.upc.setUPC( newUPC );
  }

  public void setQuantity ( int quantity ) {
    this.quantity = quantity;
  }

  public void setDescription ( String description ) {
    this.description = description;
  }

  public void setUnitPrice( float price ) {
    this.unitPrice = price;
  }
}
