package ProductReader;

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

  public Item(String upc, String description, String price) {
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
    String actualNumbers = price;
    // To remove the $ sign from the string
    if(price.startsWith("$"))
    {
      actualNumbers = price.substring(1);
      priceOfItem = Float.parseFloat(actualNumbers);
    }
    else {
      priceOfItem = Float.parseFloat(actualNumbers);
    }
    return priceOfItem;
  }

  @Override
  public String toString() {
    return upc + " " + description + " @ " + price;
  }

}
