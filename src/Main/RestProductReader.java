package Main;

import Requests.Http.Get;
import com.google.gson.Gson;

import java.io.IOException;

public class RestProductReader extends IProductReader
{
  RestProductReader(String endpoint) throws IOException
  {
    read(endpoint);
  }


  public Item[] read(String endpoint) throws IOException
  {
    String listOfProducts =  new Get(endpoint).execute();
    Gson jsonToItems = new Gson();

    // Creates objects from Json
    Item[] items = jsonToItems.fromJson(listOfProducts, Item[].class);



    return items;
  }
}
