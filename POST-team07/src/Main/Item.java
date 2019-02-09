package Main;

/*




*/

public class Item {
  private String upc;
  private String description;
  private double price;

  public Item (String upc, String description, double price){
    this.upc = upc;
    this.description = description;
    this.price = price;

  }
  public String getUpc(){
    return this.upc;
  }

  public String getDescription(){
    return this.description;
  }

  public double getPrice(){
    return this.price;
  }
}
