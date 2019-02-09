package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Catalog
{
  //keeps track of UPC and what the Item is
  HashMap<UPC, Item> catalog = new HashMap<>();

  //each item is a String line to be parsed
  private ArrayList<String> items = new ArrayList<>();


  public void parseProducts(File products) throws IOException
  {

    String item;
    int itrOfItems = 0;

    FileReader readFile = new FileReader(products);
    BufferedReader lineBuffer = new BufferedReader(readFile);

    while ( (item= lineBuffer.readLine()) != null ) // split each product to their own line
    {
      items.add(item);
      itrOfItems++;
    }
    readFile.close();
    lineBuffer.close();
    parseItems(items);
  }

  private void parseItems(ArrayList items){
    String[] product;

    // parse each line by spaces
    for (int itrOfItems = 0; itrOfItems < items.size(); itrOfItems++){
      Item item = new Item();
      UPC upc = new UPC();
      product = items.get(itrOfItems).toString().split("  +"); // splits by 2 spaces or more
      upc.setUPC(product[0]);
      item.setUPC(product[0]);
      item.setDescription(product[1]);
      item.setPrice(Float.parseFloat(product[2]));
      catalog.put(upc, item);
    }
  }

  public void printCatalog()
  {
    for (UPC keys : catalog.keySet())
    {
      System.out.println(keys.getUPC() + " "+ catalog.get(keys).getDescription() + " " + catalog.get(keys).getPrice());
    }
  }
}

