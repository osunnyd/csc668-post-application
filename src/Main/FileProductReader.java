package Main;

import Requests.Http.Get;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class FileProductReader extends IProductReader
{
  public ArrayList<String> items = new ArrayList<>();
  Item[] itemsForCatalog;

  public FileProductReader(String productString) throws IOException
  {
    super(productString);
    if(check()){read(productString);}
  }


  @Override
  public Item[] getProductList()
  {
    return itemsForCatalog;
  }

  @Override
  public void read(String file) throws IOException
  {
    String item;

    int itrOfItems = 0;

    FileReader readFile = new FileReader(file);
    BufferedReader lineBuffer = new BufferedReader(readFile);

    while ((item = lineBuffer.readLine()) != null) { // split each product to their own line
      items.add(item);
      itrOfItems++;
    }

    readFile.close();
    lineBuffer.close();

  }

  public void parseItems(ArrayList items) {
    String[] product;
    itemsForCatalog = new Item[items.size()];

    // parse each line by spaces
    for (int itrOfItems = 0; itrOfItems < items.size(); itrOfItems++) {

      product = items.get(itrOfItems).toString().split("  +"); // splits by 2 spaces or more

      String productUPC = product[0];
      String productDescription = product[1];
      String productPrice = product[2];
      Item item = new Item(productUPC, productDescription, productPrice);
      itemsForCatalog[itrOfItems] = item;
    }
  }
}
