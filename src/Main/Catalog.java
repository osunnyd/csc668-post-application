package Main;

/*
Sunny Wong and Omar Alaniz
*/

import java.util.HashMap;
import java.util.ArrayList;

public class Catalog {

  private HashMap<UPC, Item> catalog = new HashMap<>();
 
  private Item[] item;

  FileProductReader fileProductReader;
  RestProductReader restProductReader;

  public Catalog(String productString) {
    fileProductReader = new FileProductReader(productString);
    restProductReader = new RestProductReader(productString);
  }


  public void setUpCatalogHashM()
  { 
    item = fileProductReader.getProductList();
    
    for (int i = 0; i < item.length;i++){}
  }

  private void parseItems(ArrayList items) {
    String[] product;

    // parse each line by spaces
    for (int itrOfItems = 0; itrOfItems < items.size(); itrOfItems++) {

      product = items.get(itrOfItems).toString().split("  +"); // splits by 2 spaces or more

      String productUPC = product[0];
      String productDescription = product[1];
      String productPrice = (product[2]);

      UPC upc = new UPC(productUPC);
      Item item = new Item(productUPC, productDescription, productPrice);

      catalog.put(upc, item);
    }

  }

  public Item getItem(UPC upc) {

    Item itemToReturn = new Item();

    if (catalog.containsKey(upc)) {
      itemToReturn = catalog.get(upc);

    } else {
      System.out.println("Item UPC: " + upc.getUPC() + " Not Found.\n");
    }

    return itemToReturn;
  }
}
