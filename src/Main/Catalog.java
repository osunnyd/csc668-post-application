package Main;

/*
Sunny Wong and Omar Alaniz
*/

import java.util.HashMap;
import java.util.ArrayList;

public class Catalog {

  HashMap<UPC, Item> catalog = new HashMap<>();

  private ArrayList<String> items = new ArrayList<>();

  IProductReader productReader;

  public Catalog(String productString) {
    

  }

  public void setUpCatalogHashM(){
    productReader.getProductList();
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

// public void parseProducts(File products) throws IOException {

// String item;
// int itrOfItems = 0;

// FileReader readFile = new FileReader(products);
// BufferedReader lineBuffer = new BufferedReader(readFile);

// while ((item = lineBuffer.readLine()) != null) { // split each product to
// their own line
// items.add(item);
// itrOfItems++;
// }

// readFile.close();
// lineBuffer.close();

// parseItems(items);
// }

// private void parseItems(ArrayList items) {
// String[] product;

// // parse each line by spaces
// for (int itrOfItems = 0; itrOfItems < items.size(); itrOfItems++) {

// product = items.get(itrOfItems).toString().split(" +"); // splits by 2 spaces
// or more

// String productUPC = product[0];
// String productDescription = product[1];
// float productPrice = Float.parseFloat(product[2]);

// UPC upc = new UPC(productUPC);
// Item item = new Item(productUPC, productDescription, productPrice);

// catalog.put(upc, item);
// }
// }
