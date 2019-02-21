package ProductReader;

import Requests.Http.Get;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

/*
Sunny Wong and Omar Alaniz
*/

public class FileProductReader extends IProductReader
{
  public ArrayList<String> itemsFromFile = new ArrayList<>();
  Item[] items;

  public FileProductReader(String productString) throws IOException
  {
    super(productString);
    if(checkFile()){read(productString);}
  }


  @Override
  public Item[] getProductList()
  {
    return items;
  }

  @Override
  public void read(String fileName) throws IOException
  {
    String item;

    int itrOfItems = 0;

    FileReader readFile = new FileReader(fileName);
    BufferedReader lineBuffer = new BufferedReader(readFile);

    while ((item = lineBuffer.readLine()) != null) { // split each product to their own line
      itemsFromFile.add(item);
      itrOfItems++;
    }

    readFile.close();
    lineBuffer.close();

    parseItems(itemsFromFile);

  }

  public void parseItems(ArrayList itemsFromFile) {
    String[] product;
    items = new Item[itemsFromFile.size()];

    // parse each line by spaces
    for (int itrOfItems = 0; itrOfItems < itemsFromFile.size(); itrOfItems++) {

      product = itemsFromFile.get(itrOfItems).toString().split("  +"); // splits by 2 spaces or more

      String productUPC = product[0];
      String productDescription = product[1];
      String productPrice = product[2];
      Item item = new Item(productUPC, productDescription, productPrice);
      items[itrOfItems] = item;
    }
  }
}
