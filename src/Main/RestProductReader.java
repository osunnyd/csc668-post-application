package Main;

import Requests.Http.Get;
import com.google.gson.Gson;

import java.io.IOException;

public class RestProductReader extends IProductReader
{
  Item[] items;
  public RestProductReader(String productString)
  {
    super(productString);
    if(check()){read(file);}
  }

  @Override
  public void read(String endpoint) throws IOException
  {
    String listOfProducts =  new Get(endpoint).execute();
    Gson jsonToItems = new Gson();

    // Creates objects from Json
    items = jsonToItems.fromJson(listOfProducts, Item[].class);


  }

  @Override
  public Item[] getProductList()
  {
    return items;
  }
}
