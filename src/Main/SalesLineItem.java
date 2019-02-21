package Main;

/*
    Robert Quinones, Tommy Tran

    Holds UPC, QTY Pairs from transactions, then adds more relevant
    data to make receipt generation simpler
*/
import ProductReader.UPC;

public class SalesLineItem {
  private UPC upc;
  private int quantity;
  private float unitPrice;
  private float subtotal;
  private String description;

  public SalesLineItem(String itemUPC, int quantity) {
    this.upc = new UPC(itemUPC);
    this.quantity = quantity;

  }

  public SalesLineItem(String itemUPC, String description, int quantity, float unitPrice, float subtotal) {
    this.upc = new UPC(itemUPC);
    this.description = description;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.subtotal = subtotal;
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

  public String getDescription() {
    return description;
  }

  public float getSubtotal() {
    return subtotal;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setUnitPrice(float price) {
    this.unitPrice = price;
  }

  public void setSubtotal(float subtotal) {
    this.subtotal = subtotal;
  }
}
