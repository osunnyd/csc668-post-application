package ProductReader;

import Requests.Http.Get;
import Requests.StoreRequests.ProductRequest;
import com.google.gson.Gson;

import java.io.IOException;

/*
Sunny Wong and Omar Alaniz
*/

public class RestProductReader extends IProductReader
{
  Item[] items;
  public RestProductReader(String URI) throws IOException
  {
    super(URI);
    // Makes API call
    String result = new ProductRequest(URI).getProducts();
    read(result);

  }

  @Override
  public void read(String productString) throws IOException
  {
    Gson jsonToItems = new Gson();

    // Creates objects from Json
    items = jsonToItems.fromJson(productString, Item[].class);


  }

  @Override
  public Item[] getProductList()
  {
    return items;
  }
}
