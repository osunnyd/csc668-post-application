package Main;

/*
Sunny
Utility class item
*/

public class Item {
  private String upc;
  private String description;
  private String price;
  float priceOfItem;

  public Item() {
    this.upc = "";
    this.description = "";
    this.price = "";

  }

 /* public Item(String upc, String description, float price) {
    this.upc = upc;
    this.description = description;
    this.price = price;
  }*/

  public String getUPC() {
    return this.upc;
  }

  public String getDescription() {
    return this.description;
  }

  public float getPrice() {
    // To remove the $ sign from the string
    String actualNumbers = price.substring(1);
    priceOfItem = Float.parseFloat(actualNumbers);
    return priceOfItem;
  }

}
