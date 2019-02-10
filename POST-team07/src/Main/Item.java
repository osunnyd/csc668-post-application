package Main;

/*
Utility class item

*/

public class Item {
  private String upc;
  private String description;
  private float price;

  public Item() {
    this.upc = "";
    this.description = "";
    this.price = 0;
  }

  public Item( String upc, String description, float price ) {
    this.upc = upc;
    this.description = description;
    this.price = price;
  }

  public String getUPC() {
    return this.upc;
  }

  public String getDescription() {
    return this.description;
  }

  public float getPrice() {
    return this.price;
  }

  public void setUPC( String setUPC ) {
    this.upc = setUPC;
  }

  public void setDescription( String setDescription ) {
    this.description = setDescription;
  }

  public void setPrice ( float setPrice ) {
    this.price = setPrice;
  }
}
