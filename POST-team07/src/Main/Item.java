package Main;

/*
Utility class item

*/

public class Item
{
  private String upc;
  private String description;
  private float price;

  public Item()
  {
    this.upc = "";
    this.description = "";
    this.price = 0;
  }

  public String getUPC()
  {
    return this.upc;
  }

  public String getDescription()
  {
    return this.description;
  }

  public float getPrice()
  {
    return this.price;
  }

  public void setUPC(String setUPC)
  {
    upc = setUPC;
  }

  public void setDescription(String setDescription)
  {
    description = setDescription;
  }
}
